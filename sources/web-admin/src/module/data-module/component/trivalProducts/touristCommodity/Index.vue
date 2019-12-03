<!--旅游商品-->
<template>
  <div>
    <el-form :inline="true"
             :model="searchObj"
             class="clear-float">
      <el-row>
        <el-col :span="18" v-if="isSearch">
          <el-form-item>
            <el-input size="mini"
                      v-model="searchObj.fullname"
                      placeholder="请输入中文名称" />
          </el-form-item>
        </el-col>
        <el-col :span="3" style="float: right">
          <el-form-item>
            <el-button type="primary"
                       @click="add('touristCommodity')">
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
      <el-table-column label="中文全称" prop="fullname" />
      <el-table-column label="商品类型" prop="type" />
      <el-table-column label="购物提示" prop="propt" />
      <el-table-column label="推荐购物场所" prop="recommendedShop" />
      <el-table-column label="推荐品牌" prop="recommendedBrand" />
      <el-table-column label="操作" :min-width="60">
        <template slot-scope="scope">
          <el-button type="text" size="mini" @click="edit(scope.row,'touristCommodity')">编辑</el-button>
          <el-button type="text" size="mini" @click="delRow(scope.row,AllUrl.trivalEnterprise.touristCommoditys)">删除</el-button>
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
      return this.url ? this.url : this.AllUrl.trivalEnterprise.touristCommoditys
    }
  }
</script>
