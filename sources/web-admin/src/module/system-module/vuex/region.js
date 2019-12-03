import Vue from 'vue'
// import { StringUtils } from '@/utils'

export default {
  namespaced: true,
  state: {
    url: `${CONTEXT_PATH}u/regions`,
    regions: []
  },
  getters: {
    regionTree ({ regions }, { regionMap }) {
      regions = [...regions]
      const result = []
      regions.forEach(region => {
        let parent
        if (region.parent) {
          parent = regionMap[region.parent.code]
        }
        if (parent) {
          if (!parent.children) {
            parent.children = []
          }
          parent.children.push(region)
        } else {
          result.push(region)
        }
      })
      return result
    },
    regionMap ({ regions }) {
      return regions.reduce((cur, i) => {
        cur[i.code] = i
        return cur
      }, {})
    }
  },
  mutations: {
    regions (state, regions) {
      state.regions = regions
    }
  },
  actions: {
    loadRegions ({ commit, state }) {
      Vue.http.get(state.url, { params: { type: 'tree' } }).then(({ data }) => {
        commit('regions', data)
      })
    }
  }
}
