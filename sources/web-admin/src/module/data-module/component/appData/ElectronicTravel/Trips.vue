<template>
  <div>
    <el-form :inline="true"
             :model="searchObj"
             class="clear-float">
      <el-row>
        <el-col :span="3" style="float: right">
          <el-form-item>
            <el-button type="primary"
                       @click="add('elTrip')">
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
      <el-table-column label="安排" prop="arrange" />
      <el-table-column label="酒店" prop="hotelName" />
      <el-table-column label="行程时间" prop="tripTime" />
      <el-table-column label="操作" :min-width="60">
        <template slot-scope="scope">
          <el-button type="text" size="mini" @click="edit(scope.row,'elTrip')">编辑</el-button>
          <el-button type="text" size="mini" @click="delRow(scope.row,AllUrl.trip)">删除</el-button>
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
  export default class Trips extends Mixins(BaseTable) {
    @Prop({type: Function})
    setReturnData

    @Prop({type: Function})
    successSave

    @Prop({type: Boolean, default: () => true})
    isSearch

    @Prop({type: String})
    url

    getUrl () {
      return this.url ? this.url : `${this.AllUrl.trip}`
    }
  }
</script>

<style scoped>

</style>
