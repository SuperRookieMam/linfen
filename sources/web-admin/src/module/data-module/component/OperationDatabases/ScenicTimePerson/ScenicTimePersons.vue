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
            <el-button
              type="primary"
              @click="add('scenicTimePerson')">
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
      <el-table-column label="日期" prop="year">
        <template slot-scope="scope">
          {{ scope.row.year + '-' + scope.row.month + '-' + scope.row.day }}
        </template>
      </el-table-column>
      <el-table-column label="小时" prop="houre" />
      <el-table-column label="景区" prop="scenic" />
      <el-table-column label="人数" prop="number" />
      <el-table-column label="性别" prop="sex" />
      <el-table-column label="当前游客量" prop="nowPeopleNum" />
      <el-table-column label="游客接待总量" prop="receiveNum" />
      <el-table-column label="操作" :min-width="60">
        <template slot-scope="scope">
          <el-button type="text" size="mini" @click="edit(scope.row, 'scenicTimePerson')">编辑</el-button>
          <el-button type="text" size="mini" @click="delRow(scope.row,AllUrl.trivalEnterprise.scenicTimePersons)">删除</el-button>
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
  export default class ScenicTimePersons extends Mixins(BaseTable) {
    @Prop({type: Function})
    setReturnData

    @Prop({type: Function})
    successSave

    @Prop({type: Boolean, default: () => true})
    isSearch

    @Prop({type: String})
    url

    getUrl () {
      return this.url ? this.url : this.AllUrl.trivalEnterprise.scenicTimePersons
    }
  }
</script>
