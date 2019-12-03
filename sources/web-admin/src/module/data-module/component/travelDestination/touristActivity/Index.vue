<!--旅游活动-->
<template>
  <div>
    <el-form :inline="true"
             :model="searchObj"
             class="clear-float">
      <el-row>
        <el-col :span="18">
          <el-form-item>
            <el-input size="mini"
                      v-model="searchObj .chineseFullName"
                      placeholder="请输入中文名称" />
          </el-form-item>
          <el-form-item>
            <el-cascader size="mini"
                         v-model="searchObj.area"
                         :options="regions"
                         :props="areaProps"
                         change-on-select />
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
      <el-table-column label="中文名称" prop="chineseName" />
      <el-table-column label="活动日期" prop="eventDate" />
      <el-table-column label="所属地区">
        <template slot-scope="scope">{{ getRegionName(scope.row.regionCode) }}</template>
      </el-table-column>
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

  const touristActivityModule = namespace('data/touristActivity')
  const regionModule = namespace('data/region')
  @Component({
    components: {
      EleDataTables
    }
  })
  export default class Index extends Mixins(BaseList) {
    searchObj = {
      form: 'touristActivitys'
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

    @touristActivityModule.State('url')
    ajax

    edit (params) {
      this.$router.push({name: 'touristActivity', params})
    }

    add () {
      this.$router.push({name: 'touristActivity', params: {id: 'new'}})
    }
  }
</script>
