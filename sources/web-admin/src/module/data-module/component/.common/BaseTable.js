import Vue from 'vue'
import { Component } from 'vue-property-decorator'
import { namespace } from 'vuex-class'

const baseModel = namespace('data/baseModel')
const regionModule = namespace('data/region')
const urlModel = namespace('data/urlModel')
@Component({
  inject: ['reload']
})
export default class BaseTable extends Vue {
  @baseModel.Action('get')
  gets

  @baseModel.Action('post')
  post

  @baseModel.Action('put')
  put

  @baseModel.Action('del')
  del

  @baseModel.Mutation('currentFunction')
  currentSuccessSave

  @baseModel.Getter('currentFunction')
  currentFunctionSave

  @regionModule.Action('loadRegions')
  loadRegions

  @regionModule.Getter('userRegionTree')
  userRegionTree

  @regionModule.Getter('getRegion')
  getRegion

  @urlModel.Getter('AllUrl')
  AllUrl

  searchObj = {size: 10}

  data = {}

  list = []

  currentPage1 = 1

  totalRow = 0

  activeName = 'base'

  // timeout = null

  readonly = true

  areaProps = {
    children: 'children',
    label: 'name',
    value: 'code',
    checkStrictly: true,
    expandTrigger: 'hover',
    emitPath: false
  }
  add (forRoute) {
    this.edit({id: 'new'}, forRoute)
  }

  edit (params,forRoute) {
    let m = {}
    m[forRoute] =this.successSave ? this.successSave : null
    this.currentSuccessSave(m)
    this.$router.push({name: forRoute, params: params})
  }

  getFormData () {
    if (this.id === 'new') {
      return this.data
    }else {
      return this.gets({url: `${this.getUrl()}/${this.id}`}).then(resoult => {
        this.data = resoult.data
      }).catch(e => {
        console.error('从服务器获取数据时出错', e)
      })
    }
  }

  save (routeName) {
    this.$refs['form'].validate((valid) => {
      if (valid) {
        if (this.id === 'new') {
          this.post({url: this.getUrl(), params: this.data}).then(ele => {
            this.data = ele.data
            if (this.currentFunctionSave[routeName]){
              let success = this.currentFunctionSave[routeName]
              success(this.data)
            }
            this.$message('新增成功', '友情提示')
            this.$router.go(-1)
          })
        } else {
          this.put({url: `${this.getUrl()}/${this.id}`, params: this.data}).then(ele => {
            this.data = ele
            this.$message('修改成功', '友情提示')
            this.$router.go(-1)
          })
        }
      } else {
        this.$message('亲爱的小伙伴，你还有必填项没有填哦，要不在检查检查','友情提示')
        return false
      }
    })
  }

  saveRef () {
    this.put({url: `${this.getUrl()}/${this.id}`, params: this.data}).then(ele => {
      this.data = ele
      if (this.replaceRoute) {
        this.replaceRoute()
      } else {
        this.$router.go(-1)
      }
    })
  }
  getRegionName (regionCode) {
    let region = this.getRegion(regionCode)
    return region ? region['name'] : ''
  }
  goBack () {
    this.$router.go(-1)
  }

  created () {
   if (this.id) {
      this.getFormData()
      this.readonly = this.id !== 'new' ? true : false
    }else {
     this.loadRegions()
   }

  }

  delRow (row,dUrl) {
    this.$confirm('此操作将永久删除该条记录，是否继续?', '删除记录', {
      confirmButtonText: '确定',
      cancelButtonText: '取消',
      type: 'warning'
    }).then(() => {
      this.del({url: `${dUrl}/${row.id}`}).catch(el =>{
        this.$message('此数据被引用不能删除，请到对应的地方删除','友情提示')
      })
    }).then(() => {
      this.reload()
    }).catch(e => {
    })
  }

}
