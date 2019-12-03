<template>
  <div>
    <el-form :inline="true"
             :model="searchObj"
             class="clear-float">
      <el-row>
        <el-col :span="18" v-if="isSearch">
          <el-form-item>
            <el-input size="mini"
                      v-model="searchObj.area"
                      placeholder="请输入中文名称" />
          </el-form-item>
        </el-col>
        <el-col :span="3" style="float: right">
          <el-form-item>
            <el-button type="primary"
                       @click="add('senicReception')">
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
      :set-return-data="setReturndata">
      <el-table-column label="日期" prop="year">
        <template slot-scope="scope">
          {{ scope.row.year + '-' + scope.row.month + '-' + scope.row.day }}
        </template>
      </el-table-column>
      <el-table-column label="小时" prop="houre" />
      <el-table-column label="景区" prop="scenic" />
      <el-table-column label="收入" prop="number" />
      <el-table-column label="操作" :min-width="60">
        <template slot-scope="scope">
          <el-button type="text" size="mini" @click="edit(scope.row,'senicReception')">编辑</el-button>
          <el-button type="text" size="mini" @click="delRow(scope.row,AllUrl.trivalEnterprise.senicReceptions)">删除</el-button>
        </template>
      </el-table-column>
    </el-table-base>
  </div>
</template>
<script>
  import { Component, Mixins, Prop} from 'vue-property-decorator'
  import BaseTable from '../../.common/BaseTable'
  import ElTableBase from '../../.common/ElTableBase'
  @Component({
    components: {
      ElTableBase
    }
  })
  export default class SenicReceptions extends Mixins(BaseTable) {
    @Prop({type: Function})
    setReturnData

    @Prop({type: Function})
    successSave

    @Prop({type: Boolean, default: () => true})
    isSearch

    @Prop({type: String})
    url

    getUrl () {
      return this.url ? this.url : this.AllUrl.trivalEnterprise.senicReceptions
    }
  }
</script>
