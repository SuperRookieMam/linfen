import Vue from 'vue'
import Vuex, { Store } from 'vuex'

const CTX = CONTEXT_PATH + 'd'

Vue.use(Vuex) // use必须在创建store实例之前调用

export default new Store({
  state: {
    url: {
      // currentUser: CTX + '/authorities/currentUser',
      authorityMenus: CTX + '/menuAuthorities/menus',
      login: CTX + '/oauth/token',
      logout: CTX + '/logout'
    },
    title: '应用',
    errors: [],
    routing: false, // 当前是否在导航中
    theme: 'left',
    matched: null, // 匹配到的路由
    crumbs: [], // 面包屑
    requests: {}
  },
  getters: {
    /**
     * 确定当前是否有加载进程
     */
    loading: ({ requests }) => Object.keys(requests).length > 0,

    request ({ requests }) {
      return ({ hash }) => {
        return Object.values(requests).find(item => item.hash === hash)
      }
    },
    /**
     * 最近的错误
     */
    error: ({ errors }) => errors[0],
    /**
     * 面包屑
     */
    crumbs (state, { matched }) {
      const menus = state.security.menus

      const findParents = menu => {
        const result = []
        if (menu.parent) {
          let parent = menus.find(({ id }) => id === menu.parent.id)
          while (parent) {
            result.push(parent)
            parent = parent.parent
          }
        }
        return result.reverse()
      }

      if (
        menus &&
        menus.length > 0 &&
        matched !== undefined &&
        matched !== null
      ) {
        return [...findParents(matched), matched]
      } else {
        return []
      }
    },
    /**
     * 计算匹配到的菜单项
     * @param matched
     * 匹配到的路由项目
     * @param menus
     * 所有的菜单列表
     * @returns {*}
     */
    matched ({ matched, security: { menus } }) {
      if (menus !== undefined && menus.length > 0) {
        return menus.find(({ url }) => matched.regex.test(url))
      } else {
        return null
      }
    }
  },
  mutations: {
    updateTitle (state, { title }) {
      if (title) {
        state.title = title
      }
    },
    addError ({ errors }, payload) {
      errors.unshift(payload)
      if (errors.length > 10) {
        errors.pop()
      }
    },
    updateRouting (state, sta) {
      state.routing = sta
    },
    updateMatched (state, matched) {
      state.matched = matched
    },
    request ({ requests }, payload) {
      Vue.set(requests, payload.id, payload)
    },
    removeRequest ({ requests }, payload) {
      Vue.delete(requests, payload.id)
    }
  },
  actions: {},
  modules: {
    // security
  }
})
