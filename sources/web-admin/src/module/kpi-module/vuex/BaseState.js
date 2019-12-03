import Vue from 'vue'

export default class BaseState {
  namespaced = true

  state = {
    url: ''
  }

  actions = {
    get ({ state }, params) {
      if (params.id) {
        return Vue.http.get(`${state.url}/${params.id}`, params)
      } else {
        return Vue.http.get(state.url, params)
      }
    },
    save ({ state }, data) {
      return Vue.http.post(state.url, data)
    },
    update ({ state }, { id, data }) {
      return Vue.http.put(`${state.url}/${id}`, data)
    },
    del ({ state }, { id }) {
      return Vue.http.delete(`${state.url}/${id}`)
    }
  }

  constructor ({ url }) {
    this.state.url = url
  }
}
