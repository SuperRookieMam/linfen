<!--监控管理-->
<template>
  <div>
    <el-form :inline="true"
             :model="searchObj"
             class="clear-float">
      <el-row>
        <el-col :span="18">
          <el-form-item>
            <el-input size="mini"
                      v-model="searchObj.monitorName"
                      placeholder="请输入中文名称" />
          </el-form-item>
        </el-col>
        <el-col :span="3" style="float: right">
          <el-form-item>
            <el-button type="primary"
                       @click="add('monitorManager')">
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
      <el-table-column label="资源编码" prop="no" />
      <el-table-column label="监控名称" prop="monitorName" />
      <el-table-column label="监控编号" prop="roomNumber" />
      <el-table-column label="所属地区">
        <template slot-scope="scope">{{ getRegionName(scope.row.regionCode) }}</template>
      </el-table-column>
      <el-table-column label="所属景区" prop="scenic" />
      <el-table-column label="状态" prop="run">
        <template slot-scope="scope">
          {{ scope.row.run ? '开启' : '关闭' }}
        </template>
      </el-table-column>
      <el-table-column label="操作" :min-width="60">
        <template slot-scope="scope">
          <el-button type="text" size="mini" @click="edit(scope.row,'monitorManager')">编辑</el-button>
          <el-button type="text" size="mini" @click="delRow(scope.row,AllUrl.trivalEnterprise.monitorManagers)">删除</el-button>
        </template>
      </el-table-column>
    </el-table-base>
  </div>
</template>
<script>
  import { Component, Mixins, Prop } from 'vue-property-decorator'
  import BaseTable from '../.common/BaseTable'
  import ElTableBase from '../.common/ElTableBase'
  @Component({
    components: {
      ElTableBase
    }
  })
  export default class MonitorManagers extends Mixins(BaseTable) {
    @Prop({type: Function})
    setReturnData

    @Prop({type: Function})
    successSave

    @Prop({type: Boolean, default: () => true})
    isSearch

    @Prop({type: String})
    url

    getUrl () {
      return this.url ? this.url : this.AllUrl.trivalEnterprise.monitorManagers
    }
  }
</script>
