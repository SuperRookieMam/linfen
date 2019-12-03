<!--图片库-->
<template>
  <el-container>
    <el-main>
      <el-form :inline="true"
               :model="searchObj"
               class="clear-float">
        <el-row
          :gutter="20"
          style="margin-top: 15px;">
          <el-col :span="4">
            <el-input size="mini"
                      v-model="searchObj.name"
                      placeholder="请输入中文名称" />
          </el-col>
          <el-col :span="3" style="float: right">
            <el-button type="primary"
                       @click="add('imageDatabase')">
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
        <el-table-column label="图片标题" prop="pictureCaptions" />
        <el-table-column label="类型" prop="type" />
        <el-table-column label="图片格式" prop="imageFormat" />
        <el-table-column label="文件大小" prop="theFileSize" />
        <el-table-column label="拍摄时间" prop="shootingTime" />
        <el-table-column label="推荐显示" prop="show">
          <template slot-scope="scope">
            {{ scope.row.show ? '是' : '否' }}
          </template>
        </el-table-column>
        <el-table-column label="操作" :min-width="60">
          <template slot-scope="scope">
            <el-button type="text" size="mini" @click="edit(scope.row, 'imageDatabase')">编辑</el-button>
            <el-button type="text" size="mini" @click="delRow(scope.row,AllUrl.trivalEnterprise.images)">删除</el-button>
          </template>
        </el-table-column>
      </el-table-base>
    </el-main>
  </el-container>
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
      return this.url ? this.url : this.AllUrl.trivalEnterprise.images
    }
  }
</script>
