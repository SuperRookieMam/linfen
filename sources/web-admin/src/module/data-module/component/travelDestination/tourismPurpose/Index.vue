<!--旅游目的地-->
<template>
  <div>
    <el-form
      :inline="true"
      :model="searchObj">
      <el-row>
        <el-col :span="18">
          <el-form-item>
            <el-input size="mini"
                      v-model="searchObj.chineseFullName"
                      placeholder="请输入中文名称" />
          </el-form-item>
          <el-form-item>
            <el-cascader size="mini"
                         v-model="searchObj.area"
                         :options="regions"
                         expand-trigger="hover"
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
      <!-- 资源编码是 no-->
      <el-table-column label="资源编码" prop="no" />
      <el-table-column label="中文全称" prop="chineseFullName" />
      <el-table-column label="目的地类别" prop="destinationCategory" />
      <el-table-column label="所属地区">
        <template slot-scope="scope">{{ scope.row }}</template>
      </el-table-column>
      <el-table-column label="荣誉称号" prop="titleOfHonor" />
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

  const tourismPurposeModule = namespace('data/tourismPurpose')
  @Component({
    components: {
      EleDataTables
    }
  })
  export default class Index extends Mixins(BaseList) {
    searchObj = {
      form: 'tourismPurposes'
    }

    // 区划下拉选的属性配置
    areaProps = {
      children: 'children',
      label: 'name',
      value: 'code'
    }

    @tourismPurposeModule.State('url')
    ajax

    edit (params) {
      this.$router.push({name: 'tourismPurpose', params})
    }

    add () {
      this.$router.push({name: 'tourismPurpose', params: {id: 'new'}})
    }
  }
</script>
