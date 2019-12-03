import Vue from 'vue'

const CTX = CONTEXT_PATH + 'd/data'

export default {
  namespaced: true,
  state: {
    url: `${CTX}/touristAttractions`,
    scenics: []
  },
  getters: {
    getScenics (state) {
      return state.scenics.reduce((carry, item) => {
        if (typeof item === 'object' && 'chineseFullName' in item) {
          carry.push({name: item.chineseFullName})
        }
        return carry
      }, [])
    }
  },
  mutations: {
    scenicLists (state, scenics) {
      state.scenics = scenics
    }
  },
  actions: {
    loadScenicLists ({ commit, state }) {
      Vue.http.get(`${state.url}?size=10&draw=1`).then(({ data }) => {
        commit('scenicLists', data.data)
      })
    }
  }
}
