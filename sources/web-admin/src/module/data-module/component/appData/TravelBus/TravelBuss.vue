<!--旅游商品-->
<template>
  <div>
    <el-form :inline="true"
             :model="searchObj"
             class="clear-float">
      <el-row>
        <el-col :span="18" v-if="isSearch">
          <el-form-item>
            <el-input size="mini" v-model="searchObj.fullname" placeholder="请输入中文名称" />
          </el-form-item>
        </el-col>
        <el-col :span="3" style="float: right">
          <el-form-item>
            <el-button type="primary"
                       @click="add('travelBus1')">
              新增
            </el-button>
          </el-form-item>
        </el-col>
      </el-row>
    </el-form>
    <el-table-base
      ref="table"
      :ajax="getUrl()"
      :server-params="searchObj"
      :set-return-data="setReturnData">
      <el-table-column label="行程时间" prop="dayTime" sortable="custom" />
      <el-table-column label="车牌号" prop="carNum" sortable="custom" />
      <el-table-column label="导游名字" prop="guiderName" sortable="custom" />
      <el-table-column label="导游电话" prop="guiderTell" sortable="custom" />
      <el-table-column label="司机名" prop="driverName" sortable="custom" />
      <el-table-column label="司机电话" prop="driverTel" sortable="custom" />
      <el-table-column label="团队名字" prop="teamName" sortable="custom" />
      <el-table-column label="团队人数" prop="teamPeopleNum" sortable="custom" />
      <el-table-column label="操作" :min-width="60">
        <template slot-scope="scope">
          <el-button type="text" size="mini" @click="edit(scope.row,'travelBus1')">编辑</el-button>
          <el-button type="text" size="mini" @click="delRow(scope.row,AllUrl.travelBus)">删除</el-button>
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
  export default class TravelBuss1 extends Mixins(BaseTable) {
    @Prop({type: Function})
    setReturnData

    @Prop({type: Function})
    successSave

    @Prop({type: Boolean, default: () => true})
    isSearch

    @Prop({type: String})
    url

    getUrl () {
      return this.url ? this.url : this.AllUrl.travelBus
    }
  }
</script>
