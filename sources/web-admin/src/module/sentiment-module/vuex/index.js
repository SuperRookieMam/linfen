import Vue from 'vue'

export default {
  namespaced: true,
  state: {
    url: `${CONTEXT_PATH}d/emergency/sentiments`
  },
  getters: {},
  mutations: {},
  actions: {
    load ({ state: { url } }, { id }) {
      return Vue.http.get(`${url}/${id}`)
    },
    delete ({ state: { url } }, { id }) {
      return Vue.http.delete(`${url}/${id}`)
    },
    save ({ state: { url } }, data) {
      return Vue.http.post(url, data)
    },
    update ({ state: { url } }, data) {
      return Vue.http.put(`${url}/${data.id}`, data)
    }
  }
}
