<template>
  <div>
    <el-form :inline="true"
             :model="searchObj"
             class="clear-float">
      <el-row>
        <el-col :span="18" v-if="isSearch">
          <el-form-item>
            <el-input size="mini"
                      v-model="searchObj.description"
                      placeholder="请输入中文名称" />
          </el-form-item>
        </el-col>
        <el-col :span="3" style="float: right">
          <el-form-item>
            <el-button type="primary"
                       @click="add('culturalRelicRent')">
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
      <el-table-column label="文物名称" prop="name" />
      <el-table-column label="编号" prop="no" />
      <el-table-column label="出借单位" prop="lendingUnit" />
      <el-table-column label="出借城市" prop="lendingCode" :formatter="getLendingName" />
      <el-table-column label="租借单位" prop="rentalUnit" />
      <el-table-column label="租借城市" prop="rentalCode" />
      <el-table-column label="开始时间" prop="rentalTime" />
      <el-table-column label="归还时间" prop="returnTime" />
      <el-table-column label="租借状态" prop="rentStatus" />
      <el-table-column label="租借天数" prop="rentDays" />
      <el-table-column label="操作" :min-width="60">
        <template slot-scope="scope">
          <el-button type="text" size="mini" @click="edit(scope.row,'culturalRelicRent')">编辑</el-button>
          <el-button type="text" size="mini" @click="delRow(scope.row,AllUrl.culturalRelicRents)">删除</el-button>
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
  export default class CulturalRelicRent extends Mixins(BaseTable) {
    @Prop({type: Function})
    setReturnData

    @Prop({type: Function})
    successSave

    @Prop({type: Boolean, default: () => true})
    isSearch

    @Prop({type: String})
    url

    getUrl () {
      return this.url ? this.url : this.AllUrl.culturalRelicRents
    }

    getLendingName (row) {
      return this.getRegionName(row.lendingCode)
    }
  }
</script>
