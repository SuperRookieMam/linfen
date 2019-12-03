import Vue from 'vue'
import { Component, Prop } from 'vue-property-decorator'
import { namespace } from 'vuex-class'
// import { StringUtils } from '@/utils'

const regionModule = namespace('data/region')
const scenicModule = namespace('data/ScenicList')

@Component
export default class BaseForm extends Vue {
  @Prop({ default: () => ({}) })
  value

  @regionModule.Getter('codeToArray')
  codeToArray

  /**
   * 区划树形结构
   */
  @regionModule.Getter('userRegionTree')
  userRegionTree

  /**
   * 根据代码获取区划
   */
  @regionModule.Getter('getRegion')
  getRegion

  /**
   * 区划列表
   */
  @regionModule.State('regions')
  regions

  @regionModule.Getter('regionTree')
  regionTree

  @regionModule.Getter('RegionCityTree')
  RegionCityTree

  @scenicModule.Getter('getScenics')
  getScenics

  areaProps = {
    children: 'children',
    label: 'name',
    value: 'code',
    checkStrictly: true,
    expandTrigger: 'hover',
    emitPath: false
  }

  cityProps = {
    children: 'children',
    label: 'name',
    value: 'name',
    checkStrictly: true,
    expandTrigger: 'hover',
    emitPath: false
  }

  ages = [{
    value: '未知'
  }, {
    value: '60岁以上'
  }, {
    value: '41-60岁'
  }, {
    value: '31-40岁'
  }, {
    value: '19-30岁'
  }, {
    value: '0-18岁'
  }, {
  }]

  get scenicProps () {
    return {
      label: 'name',
      value: 'name',
      emitPath: false
    }
  }

  get years () {
    let years = []
    for (let i = new Date().getFullYear(); i >= 2010; i--) {
      years.push(i)
    }
    return years
  }

  get months () {
    let months = []
    for (let i = 1; i <= 12; i++) {
      months.push(i)
    }
    return months
  }
  created () {
    this.$set(this.value, 'regionCode', this.userRegionTree[0].code)
    }
}
