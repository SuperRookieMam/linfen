import Vue from 'vue'

const CTX = CONTEXT_PATH + 'd/data'
export default {
  namespaced: true,
  state: {
    url: `${CTX}`
  },
  actions: {
    saveAndRef ({ state }, params) {
      const url = `${state.url}/${params.jumpName}/${params.pid}/${params.refname}/${params.fieldname}`
      return Vue.http.post(url, params)
    }
  }
}
