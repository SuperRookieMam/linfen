<!--汽车租赁公司-->
<template>
  <div>
    <el-form
      :inline="true"
      :model="searchObj"
      class="clear-float">
      <el-row>
        <el-col :span="18" v-if="isSearch">
          <el-form-item>
            <el-input
              size="mini"
              v-model="searchObj.chineseName"
              placeholder="请输入中文名称" />
          </el-form-item>
          <el-form-item>
            <el-cascader size="mini"
                         expand-trigger="hover"
                         v-model="searchObj.area"
                         :options="userRegionTree"
                         :props="areaProps"
                         change-on-select />
          </el-form-item>
        </el-col>
        <el-col :span="3" style="float: right">
          <el-form-item>
            <el-button type="primary"
                       @click="add('carRental')">
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
      :ajax="ajax">
      <el-table-column label="资源编码" prop="no" />
      <el-table-column label="中文名称" prop="chineseName" />
      <el-table-column label="所属地区">
        <template slot-scope="scope">{{ getRegionName(scope.row.regionCode) }}</template>
      </el-table-column>
      <el-table-column label="地址" prop="address" />
      <el-table-column label="公司品牌" prop="brand" />
      <el-table-column label="车型" prop="models" />
      <el-table-column label="操作" :min-width="60">
        <template slot-scope="scope">
          <el-button type="text" size="mini" @click="edit(scope.row,'carRental')">编辑</el-button>
          <el-button type="text" size="mini" @click="delRow(scope.row,AllUrl.trivalEnterprise.carRentalEnterpises)">删除</el-button>
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
      return this.url ? this.url : this.AllUrl.trivalEnterprise.carRentalEnterpises
    }
  }
</script>
