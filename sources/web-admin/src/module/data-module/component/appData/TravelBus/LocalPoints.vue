<template>
  <div>
    <el-form :inline="true"
             :model="searchObj"
             class="clear-float">
      <el-row>
        <el-col :span="3" style="float: right">
          <el-form-item>
            <el-button type="primary"
                       @click="add('point')">
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
      <el-table-column label="经度" prop="longitude" />
      <el-table-column label="纬度" prop="latitude" />
      <el-table-column label="时间点" prop="timePoint" />
      <el-table-column label="操作" :min-width="60">
        <template slot-scope="scope">
          <el-button type="text" size="mini" @click="edit(scope.row,'point')">编辑</el-button>
          <el-button type="text" size="mini" @click="delRow(scope.row,AllUrl.localPoint)">删除</el-button>
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
  export default class LocalPoints extends Mixins(BaseTable) {
    @Prop({type: Function})
    setReturnData

    @Prop({type: Function})
    successSave

    @Prop({type: Boolean, default: () => true})
    isSearch

    @Prop({type: String})
    url

    getUrl () {
      return this.url ? this.url : `${this.AllUrl.travelBus}`
    }
  }
</script>

<style scoped>

</style>
