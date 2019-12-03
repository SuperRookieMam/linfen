import Vue from 'vue'
import { Component } from 'vue-property-decorator'
import { namespace } from 'vuex-class'
import http from '@/config/http/tableHttpInstance'
import qs from 'qs'

const regionModule = namespace('data/region')
const aaabbbcc = namespace('security')

@Component
export default class BaseList extends Vue {

  http = http

  _searchArea = []

  @aaabbbcc.Getter('token')
  token

  @regionModule.Getter('userRegionTree')
  regions

  @regionModule.Getter('getRegion')
  getRegion

  getRegionName (regionCode) {
    let region = this.getRegion(regionCode)
    return region ? region['name'] : ''
  }

  get searchArea () {
    return this._searchArea
  }

  set searchArea (areas) {
    if (areas && areas.length > 0) {
      this.searchObj.regionCode = areas[areas.length - 1]
    }
    this._searchArea = areas
  }

  /**
   * 搜索条件
   */
  searchObj = {}

  initUpload (path) {
    return `${CONTEXT_PATH}d/data/${path}?upload=1`
  }

  get downloadUrl () {
    if (USE_SSO) {
      return ''
    } else {
      let searchObj = this.searchObj
      let url = 'http://localhost:8081/' + searchObj.form + '?'
      searchObj['download'] = '12345'
      searchObj['access_token'] = this.token.split(' ')[1]
      url += qs.stringify(searchObj)
      return url
    }

  }
}

