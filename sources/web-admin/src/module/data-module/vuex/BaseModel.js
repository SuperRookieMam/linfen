import tableInstance from '../../../config/http/tableHttpInstance'
import qs from 'qs'
export default class BaseModel {
  namespaced = true

  state = {
    currentFunction: {}
  }

  getters = {
    currentFunction: state => state.currentFunction
  }

  mutations = {
    currentFunction (state, params) {
      state.currentFunction = Object.assign({}, state.currentFunction, params)
    }
  }

  actions = {
    get ({commit, state}, {url, params}) {
      if (params) {
        return tableInstance.get(`${url}?` + qs.stringify(params)).then(result => {
          return result
        })
      } else {
        return tableInstance.get(`${url}`).then(result => {
          return result
        })
      }
    },
    post ({ state }, {url, params}) {
      return tableInstance.post(`${url}`, params).then(result => {
        return result
      })
    },
    put ({ state }, { url, params }) {
      return tableInstance.put(`${url}`, params).then(result => {
        return result
      })
    },
    del ({ state }, { url, params }) {
      if (params) {
        return tableInstance.delete(`${url}?` + qs.stringify(params)).then(result => {
          return result
        })
      } else {
        return tableInstance.delete(`${url}`).then(result => {
          return result
        })
      }
    }
  }
}
