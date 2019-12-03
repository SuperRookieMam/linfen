import axios from 'axios'
import Qs from 'qs'
import Vue from 'vue'
import { StringUtils } from '@/utils'

const loginInstance = axios.create()

let token = {}
const storedToken = sessionStorage.getItem('token')
if (storedToken) {
  token = JSON.parse(storedToken)
}

export default {
  namespaced: true,
  state: {
    url: {
      currentUser: `${CONTEXT_PATH}u/users/current`,
      login: `${CONTEXT_PATH}p/login`,
      token: '/oauth/token',
      authorityMenus: `${CONTEXT_PATH}p/menuAuthorities/current`
    },
    token: token,
    currentUser: {},
    menus: []
  },
  mutations: {
    token: (state, token) => (state.token = token),
    menus: (state, menus) => (state.menus = menus),
    currentUser: (state, data) => (state.currentUser = data)
  },
  getters: {
    token ({ token: { token_type: tokenType, access_token: accessToken } }) {
      if (StringUtils.isNotEmpty(tokenType) && StringUtils.isNotEmpty(accessToken)) {
        return `${tokenType} ${accessToken}`
      } else {
        return null
      }
    },
    menuTree ({ menus }, { menuMap }) {
      const result = []
      menus.forEach(menu => {
        let parent
        if (menu.parent) {
          parent = menuMap[menu.parent.id]
        }
        if (parent) {
          if (!parent.children) {
            parent.children = []
          }
          parent.children.push(menu)
        } else {
          result.push(menu)
        }
      })
      return result
    },
    menuMap ({ menus }) {
      return menus.reduce((acc, cur) => {
        acc[cur.id] = cur
        return acc
      }, {})
    }
  },
  actions: {
    login ({ commit, state: { url: { login } } }, params) {
      return loginInstance.get(login, { params })
    },
    token ({ commit, state: { url: { token } } }, data) {
      // 登录请求
      // 登录需要一个单独的axios实例，登录请求不能被401拦截或者被跳转
      return loginInstance.post(token, data, {
        transformRequest: data => Qs.stringify(data)
      }).then(rsp => {
        const { data } = rsp
        sessionStorage.setItem('token', JSON.stringify(data))
        commit('token', data)
        return rsp
      })
    },
    loadMenus ({ commit, state: { url: { authorityMenus } } }) {
      return Vue.http.get(authorityMenus).then(({ data }) => {
        commit('menus', data)
        return data
      })
    },
    loadCurrentUser ({ commit, state: { url: { currentUser } } }) {
      return Vue.http.get(currentUser).then(({ data }) => {
        commit('currentUser', data)
        return data
      })
    }
  }
}
