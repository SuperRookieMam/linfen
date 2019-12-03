import Vue from 'vue'
import { Component } from 'vue-property-decorator'
import { namespace } from 'vuex-class'

const securityModule = namespace('security')
const regionModule = namespace('data/region')
const scenicModule = namespace('data/ScenicList')

@Component
export default class BaseList extends Vue {
  /**
   * 指导编辑对话框是否可见
   * @type {boolean}
   */
  visible = false

  /**
   * 搜索条件
   */
  searchObj = {}

  /**
   * 表示当前选中的行
   * @type {null}
   */
  selectedRow = {}

  @securityModule.State('user')
  currentUser

  @regionModule.Getter('userRegionTree')
  userRegionTree

  @regionModule.Action('loadRegions')
  loadRegions

  @regionModule.Getter('getRegion')
  getRegion

  @scenicModule.Action('loadScenicLists')
  loadScenicLists

  @scenicModule.Getter('scenicLists')
  scenicLists

  add () {
    let now = new Date()
    now.setHours(0)
    now.setMinutes(0)
    now.setSeconds(0)
    now.setMilliseconds(0)
    this.selectedRow = {
      year: now.getFullYear(),
      month: now.getMonth() + 1,
      currentDate: now
    }
    let [{ name, code: regionCode }] = this.userRegionTree
    // this.selectedRow.regionName = name
    // this.selectedRow.regionCode = regionCode
    this.visible = true
  }

  get ajax () {
    let state = this.$store.state
    let modules = this.baseModule.split('/')
    for (let i = 0; i < modules.length; i++) {
      state = state[modules[i]]
    }
    return state['url']
  }

  // 编辑前，生成一个对象的复制
  edit (row) {
    this.selectedRow = { ...row }
    this.visible = true
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

  saveData () {
    let region = this.getRegion(this.selectedRow.regionCode)
    if (region && region.name) {
      this.selectedRow.regionName = region.name
    }
    (() => {
      if (this.selectedRow.id !== undefined) {
        return this.$store.dispatch(`${this.baseModule}/update`, { id: this.selectedRow.id, data: this.selectedRow })
      } else {
        return this.$store.dispatch(`${this.baseModule}/save`, this.selectedRow)
      }
    })().then(() => {
      this.visible = false
      this.$refs['list'].reloadData()
    })
  }

  delRow (row) {
    this.$confirm('此操作将永久删除该条记录，是否继续?', '删除记录', {
      confirmButtonText: '确定',
      cancelButtonText: '取消',
      type: 'warning'
    }).then(() => {
      return this.$store.dispatch(`${this.baseModule}/del`, row)
    }).then(() => {
      this.$refs['list'].reloadData()
    }).catch(e => {})
  }

  created () {
    this.loadRegions()
    this.loadScenicLists()
  }

  toLocalDate (value) {
    try {
      return new Date(value).toLocaleDateString()
    } catch (e) {
      return ''
    }
  }

  toLocalDateTime (value) {
    try {
      return new Date(value).toLocaleString()
    } catch (e) {
      return ''
    }
  }
}
