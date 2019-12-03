import Vue from 'vue'
import Qs from 'qs'
import axios from 'axios'

const CTX = CONTEXT_PATH + 'd'
const loginInstance = axios.create()
export default {
  namespaced: true,
  state: {
    url: {
      currentUser: CTX + '/authorities/currentUser',
      authorityMenus: CTX + '/menuAuthorities/menus',
      token: CTX + '/oauth/token',
      logout: CTX + '/logout',
      login: `${CONTEXT_PATH}p/login`
    },
    menus: []
  },
  getters: {
    menus ({ menus }) {
      return menus
    }
  },
  mutations: {
    menus (state, menus) {
      state.menus = menus
    },
    setUser (state, { user }) {
      state.user = user
    }
  },
  actions: {
    loadMenu ({ commit, state }) {
      Vue.http.get(state.url.authorityMenus).then(({ data }) => {
        commit('menus', data)
        return data
      })
    },
    loadUserInfo ({ commit, state }) {
      return Vue.http.get(state.url.currentUser).then(({ data }) => {
        commit('setUser', { user: data })
        return data
      })
    },
    login ({ commit, state }, params) {
      return loginInstance.get(state.url.login, { params })
    },
    token ({ commit, state }, data) {
      // 登录请求
      // 登录需要一个单独的axios实例，登录请求不能被401拦截或者被跳转
      return loginInstance.post(state.url.token, data, {
        transformRequest: data => Qs.stringify(data)
      }).then(rsp => {
        sessionStorage.setItem('token', JSON.stringify(rsp.data))
        commit('setToken', rsp.data)
        return rsp
      })
    }
  }
}
