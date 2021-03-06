import Vue from 'vue'

export default {
  namespaced: true,
  state: {
    url: `${CONTEXT_PATH}d/emergency/reports`
  },
  getters: {},
  mutations: {},
  actions: {
    load ({ state: { url } }, { id }) {
      return Vue.http.get(`${url}/${id}`)
    },
    update ({ state: { url } }, data) {
      return Vue.http.put(`${url}/${data.id}`, data)
    }
  }
}
