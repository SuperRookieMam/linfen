import Vue from 'vue'
import { Component } from 'vue-property-decorator'
import { namespace } from 'vuex-class'
import { StringUtils } from '@/utils'

const regionModule = namespace('data/region')
@Component
export default class BaseForm extends Vue {

  @regionModule.Getter('userRegionTree')
  regions

  @regionModule.Getter('codeToArray')
  codeToArray

  set regionCode (regionCode) {
    if (regionCode && regionCode.length > 0) {
      let result = regionCode[regionCode.length - 1]
      this.data.regionCode = result
    }
  }

  get regionCode () {
    return this.codeToArray(this.data.regionCode, this.regions)
  }

}
