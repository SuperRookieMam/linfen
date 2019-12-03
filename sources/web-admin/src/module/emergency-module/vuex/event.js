import Vue from 'vue'

export default {
  namespaced: true,
  state: {
    url: `${CONTEXT_PATH}d/emergency/emergencies`
  },
  getters: {},
  mutations: {},
  actions: {
    save ({ state: { url } }, data) {
      return Vue.http.post(url, data)
    },
    load ({ state: { url } }, { id }) {
      return Vue.http.get(`${url}/${id}`)
    },
    update ({ state: { url } }, data) {
      return Vue.http.put(`${url}/${data.id}`, data)
    },
    delete ({ state: { url } }, { id }) {
      return Vue.http.delete(`${url}/${id}`)
    }
  }
}
