import Vue from 'vue'

export default {
  namespaced: true,
  state: { url: `${CONTEXT_PATH}d/emergency/duties` },
  getters: {},
  mutations: {},
  actions: {
    loadSchedules ({ state: { url } }, params) {
      return Vue.http.get(url, { params: { ...params, draw: 1, size: 1000 } })
    },
    save ({ state: { url } }, data) {
      return Vue.http.post(`${url}/batchSave`, data)
    }
  }

}
