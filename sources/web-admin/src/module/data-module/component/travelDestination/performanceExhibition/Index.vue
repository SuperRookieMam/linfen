<!--旅游组织协会-->
<template>
  <div>
    <el-form :inline="true"
             :model="searchObj"
             class="clear-float">
      <el-row>
        <el-col :span="18">
          <el-form-item>
            <el-input size="mini"
                      v-model="searchObj .chineseName"
                      placeholder="请输入中文名称" />
          </el-form-item>
        </el-col>
        <el-col :span="3" style="float: right">
          <a :href="downloadUrl">下载</a>
          <el-form-item>
            <vue-uploader
              :url="initUpload(searchObj.form)"
              :auto-upload="true"
              :http="http">
              <span>
                数据导入
              </span>
            </vue-uploader>
          </el-form-item>
          <el-form-item>
            <el-button type="primary"
                       @click="add()">
              新增
            </el-button>
          </el-form-item>
        </el-col>
      </el-row>
    </el-form>
    <ele-data-tables :server-params="searchObj"
                     :ajax="ajax">
      <el-table-column label="资源编码" prop="no" />
      <el-table-column label="中文全称" prop="chineseName" />
      <el-table-column label="会展类型" prop="exhibitionType" />
      <el-table-column label="所属景区" prop="belongsToTheScenicSpot" />
      <el-table-column label="展会简介" prop="theExhibitionProfile" />

      <el-table-column label="操作" :min-width="60">
        <template slot-scope="scope">
          <el-button type="text" size="mini" @click="edit(scope.row)">编辑</el-button>
          <el-button type="text" size="mini" @click="delRow(scope.row)">删除</el-button>
        </template>
      </el-table-column>
    </ele-data-tables>
  </div>
</template>
<script>
  import { Component, Mixins } from 'vue-property-decorator'
  import BaseList from '../../.common/BaseList'
  import EleDataTables from 'element-datatables'

  import { namespace } from 'vuex-class'

  const associationModule = namespace('data/performanceExhibition')
  const regionModule = namespace('data/region')
  @Component({
    components: {
      EleDataTables
    }
  })
  export default class Index extends Mixins(BaseList) {
    searchObj = {
      form: 'performanceExhibitions'
    }

    data = {}

    inputVal = ''

    // 区划下拉选的属性配置
    areaProps = {
      children: 'children',
      label: 'name',
      value: 'code'
    }

    @regionModule.Getter('userRegionTree')
    regions

    @associationModule.State('url')
    ajax

    edit (params) {
      this.$router.push({name: 'performanceExhibition', params})
    }

    add () {
      this.$router.push({name: 'performanceExhibition', params: {id: 'new'}})
    }
  }
</script>
