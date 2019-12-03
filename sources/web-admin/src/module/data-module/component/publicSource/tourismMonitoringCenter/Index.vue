<!--旅游监控中心-->
<template>
  <el-container>
    <el-main>
      <el-form :inline="true"
               size="mini"
               :model="searchObj"
               class="clear-float">
        <el-row>
          <el-col :span="5" :offset="1">
            <el-input size="mini" v-model="searchObj .chineseFullName" placeholder="请输入中文名称" />
          </el-col>
          <el-col :span="5" :offset="1">
            <el-cascader size="mini"
                         expand-trigger="hover"
                         v-model="searchObj.area"
                         :options="userRegionTree"
                         :props="areaProps"
                         change-on-select />
          </el-col>
          <el-col :span="3" style="float: right">
            <el-form-item>
              <el-button type="primary"
                         @click="add()">
                新增
              </el-button>
            </el-form-item>
          </el-col>
        </el-row>
      </el-form>
      <el-table
        :data="list"
        style="width: 100%">
        <el-table-column label="资源编码" prop="no" />
        <el-table-column label="监控点名称" prop="monitorPointName" />
        <el-table-column label="所属部门" prop="subordinateDepartments" />
        <el-table-column label="所在地区" prop="area" />
        <el-table-column label="地址" prop="address" />
        <el-table-column label="品牌" prop="brand" />

        <el-table-column label="操作" :min-width="60">
          <template slot-scope="scope">
            <el-button type="text" size="mini" @click="edit(scope.row)">编辑</el-button>
            <el-button type="text" size="mini" @click="delRow(scope.row)">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
      <el-pagination
        @current-change="handleCurrentChange"
        :current-page.sync="currentPage1"
        :page-size="10"
        layout="total, prev, pager, next"
        :total="totalRow"
        style="float: right" />
    </el-main>
  </el-container>
</template>
<script>
  import { Component, Mixins } from 'vue-property-decorator'
  import BaseTable from '../../.common/BaseTable'

  @Component
  export default class Index extends Mixins(BaseTable) {
    formRoute = 'tourismMonitoringCenter'

    currentHtml = 'tables'

    getUrl () {
      return this.AllUrl.trivalEnterprise.tourismMonitoringCenters
    }
  }
</script>
