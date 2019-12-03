import store from '@/vuex'
import axios from 'axios'
import sha1 from 'crypto-js/sha1'
import router from '../router'
import qs from 'qs'

// 根据请求的必要参数计算请求的sha1值
function sha1Request ({ method, url, data, params }) {
  return sha1(JSON.stringify({ method, url, data, params })).toString()
}

let index = 0
const instance = axios.create()
const findRequest = store.getters.request
instance.interceptors.request.use(config => {
  config.paramsSerializer = (params) => {
    return qs.stringify(params, { arrayFormat: 'repeat' })
  }
  const authorization = store.getters['security/token']
  if (authorization !== null) {
    config.headers.Authorization = authorization
  }
  const cancelTokenSource = axios.CancelToken.source()
  // 设置取消的token和取消的方法
  config.cancelToken = cancelTokenSource.token
  config.cancel = cancelTokenSource.cancel
  config.id = index++
  config.hash = sha1Request(config)
  // 再现有请求池中查找是否有现存的同样的请求
  const existRequest = findRequest(config)
  // 将请求提交到store请求表
  store.commit('request', config)
  // 如果有同样的请求，取消本次请求
  if (existRequest !== undefined) {
    config.cancel({ config })
  }
  return config
}, error => {
  return Promise.reject(error)
})

instance.interceptors.response.use(response => {
  // 收到请求之后，将该请求的信息从请求表中移除
  store.commit('removeRequest', response.config)
  let err = '与服务器交互时出现错误'
  const { status, error } = response
  if (status >= 200 && status < 300) {
    return response
  } else {
    err += `,错误信息=[${error}]`
  }
  console.log(err)
  store.commit('addError', err)
  return Promise.reject(response)
}, error => {
  // 收到请求之后，将该请求的信息从请求表中移除
  // 如果主动取消请求，err中不会有config,而是将config包装在了message中
  store.commit('removeRequest', error.config || error.message.config)
  if (error.response && error.response.status === 401) {
    // 如果检测到了401请求，不在执行后续操作，直接取消所有请求
    const requests = Object.values(store.state.requests)
    for (const request of requests) {
      request.cancel({ config: request })
    }
    const { name, query, params } = router.history.current
    if (name === 'login') {
      // 如果当前页面是login,什么都不做
    } else {
      const redirect = { name, query, params }
      router.replace({ name: 'login', query: { redirect: JSON.stringify(redirect) } })
    }
  } else {
    // 如果是主动取消引发的错误，error.message是一个对象，里面包含了请求相关的信息
    // 如果是主动取消引发的错误，不应该将错误添加到错误列表
    // 所以此处仅处理非主动取消所引发的错误
    if (typeof (error.message) === 'string') {
      // 如果返回的错误有消息体，将服务器消息体添加到错误列表中
      if (error.response) {
        store.commit('addError', error.response.data)
      } else {
        store.commit('addError', error.message)
      }
    }
  }
  return Promise.reject(error)
})
export default instance
