<!--旅游大巴班次信息-->
<template>
  <div>
    <el-form size="mini"
             :inline="true"
             :model="searchObj"
             class="clear-float">
      <el-row :gutter="20">
        <el-col :span="3" style="float: right">
          <el-button type="primary"
                     @click="add('tourBusService')">
            新增
          </el-button>
        </el-col>
      </el-row>
    </el-form>
    <el-table-base
      ref="table"
      :ajax="getUrl()"
      :server-params="searchObj"
      :set-return-data="setReturnData">
      <el-table-column label="车牌号" prop="plateNo" />
      <el-table-column label="出发时间" prop="departureTime" />
      <el-table-column label="达到时间" prop="arrivalTime" />
      <el-table-column label="操作" :min-width="60">
        <template slot-scope="scope">
          <el-button type="text" size="mini" @click="edit(scope.row,'tourBusService')">编辑</el-button>
          <el-button type="text" size="mini" @click="delRow(scope.row,AllUrl.trivalEnterprise.tourBusServices)">删除</el-button>
        </template>
      </el-table-column>
    </el-table-base>
  </div>
</template>
<script>
  import { Component, Mixins, Prop } from 'vue-property-decorator'
  import BaseTable from '../../.common/BaseTable'
  import ElTableBase from '../../.common/ElTableBase'
  @Component({
    components: {
      ElTableBase
    }
  })
  export default class Index extends Mixins(BaseTable) {
    @Prop({type: Function})
    setReturnData

    @Prop({type: Function})
    successSave

    @Prop({type: Boolean, default: () => true})
    isSearch

    @Prop({type: String})
    url

    getUrl () {
      return this.url ? this.url : this.AllUrl.trivalEnterprise.tourBusServices
    }
  }
</script>
