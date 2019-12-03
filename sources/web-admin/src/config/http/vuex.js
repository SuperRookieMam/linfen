import Vue from 'vue/types/vue'
// TODO，将请求相关的状态放到此处待实现
export default {
  namespaced: true,
  state: {
    requests: {}
  },
  getters: {
    // 判断现有的ajax请求中，是否有请求正在加载
    pending: ({ requests }) => Object.keys(requests).length > 0,

    request ({ requests }) {
      return ({ hash }) => {
        return Object.values(requests).find(item => item.hash === hash)
      }
    },
    /**
     * 最近的错误
     */
    error: ({ errors }) => errors[0]
  },
  mutations: {
    request ({ requests }, payload) {
      Vue.set(requests, payload.id, payload)
    },
    removeRequest ({ requests }, payload) {
      Vue.delete(requests, payload.id)
    }
  }
}
