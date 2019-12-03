import Vue from 'vue'

const CTX = CONTEXT_PATH + 'd/data'

export default {
  namespaced: true,
  state: {
    url: `${CTX}/regions`,
    regions: [{ code: '000000', name: '未知区域' }],
    regionsCity: [{ code: '000000', name: '未知区域' }]
  },
  getters: {
    /**
     * 获取所有区划的树形结构
     * @param regions
     * @returns {*}
     */
    regionTree ({ regions }, { regionTreeMap: { list } }) {
      return list
    },

    /**
     * 构建所有区划的所有完整的treeMap结构,
     * 会占用一些内存，用空间交换时间
     * @param regions
     */
    regionTreeMap ({ regions }) {
      const map = regions.reduce((cur, i) => {
        cur[i.code] = i
        return cur
      }, {})
      const list = []
      regions.forEach(region => {
        let parent
        if (region.parent) {
          parent = map[region.parent.code]
        }
        if (parent) {
          if (!parent.children) {
            parent.children = []
          }
          parent.children.push(region)
        } else {
          list.push(region)
        }
      })
      return { map, list }
    },

    /**
     * 构建所有市的所有完整的treeMap结构,
     * 会占用一些内存，用空间交换时间
     * @param regionsCity
     */
    regionCityTreeMap ({ regionsCity }) {
      const map = regionsCity.reduce((cur, i) => {
        cur[i.code] = i
        return cur
      }, {})
      const list = []
      regionsCity.forEach(region => {
        let parent
        if (!region.parents || region.parents.length === 1) {
          if (region.parent) {
            parent = map[region.parent.code]
          }
          if (parent) {
            if (!parent.children) {
              parent.children = []
            }
            parent.children.push(region)
          } else {
            list.push(region)
          }
        }
      })
      return { map, list }
    },
    /**
     * 获取当前用户的可见区划树形结构
     */
    userRegionTree ({ regions }, { regionTreeMap: { map, list } }, { security: { currentUser: { regionCode = '510903' } } }) {
      const result = map[regionCode]
      if (result) {
        // 如果用户存在regionCode,则只显示指定region的数据
        return [result]
      } else {
        // 否则显示所有的区划
        return list
      }
    },

    /**
     * 获取当前市树形结构
     */
    RegionCityTree ({ regionsCity }, { regionCityTreeMap: { map, list } }) {
      return list
    },

    /**
     * 根据code查找区划
     * @param regions
     * @returns {function(*): *}
     */
    getRegion (state, { regionTreeMap: { map } }) {
      return (regionCode) => map[regionCode]
    },

    /**
     * 获取指定地区的经纬度
     */
    getCoord (state, { getRegion }) {
      return (regionCode) => {
        const result = getRegion(regionCode)
        if (result !== undefined) {
          const { longitude, latitude } = result
          return [longitude, latitude]
        }
        return []
      }
    }
  },
  mutations: {
    regions (state, regions) {
      state.regions = regions
    },
    regionsCity (state, regionsCity) {
      state.regionsCity = [].concat(JSON.parse(JSON.stringify(regionsCity)))// 拷贝数组,注意这行的拷贝方法 转换成json再转换成对象实现对象的深拷贝
    }
  },
  actions: {
    loadRegions ({ commit, state }, params) {
      Vue.http.get(state.url, { params }).then(({ data }) => {
        commit('regions', data)
        commit('regionsCity', data)
      })
    }
  }
}
