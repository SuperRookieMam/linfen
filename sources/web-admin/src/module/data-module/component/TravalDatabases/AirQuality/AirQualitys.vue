<template>
  <div>
    <el-form :inline="true"
             :model="searchObj"
             class="clear-float">
      <el-row>
        <el-col :span="18">
          <el-form-item>
            <el-input size="mini"
                      v-model="searchObj.aqi"
                      placeholder="请输入中文名称" />
          </el-form-item>
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
    <el-table :data="list"
              style="width: 100%">
      <el-table-column label="年" prop="year" />
      <el-table-column label="月" prop="month" />
      <el-table-column label="日" prop="day" />
      <el-table-column label="小时" prop="houre" />
      <el-table-column label="景区" prop="scenic" />
      <el-table-column label="指数" prop="aqi" />
      <el-table-column label="等级" prop="leve" />
      <el-table-column label="pm2" prop="pm2" />
      <el-table-column label="pm10" prop="pm10" />
      <el-table-column label="污染度" prop="contaminate" />
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
  </div>
</template>
<script>
  import { Component, Mixins } from 'vue-property-decorator'
  import BaseTable from '../../.common/BaseTable'

  @Component
  export default class AirQualitys extends Mixins(BaseTable) {
    formRoute = 'airQuality'

    currentHtml = 'tables'

    getUrl () {
      return this.AllUrl.trivalEnterprise.airQualitys
    }
  }
</script>
