<!--虚拟素材-->
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
                      v-model="searchObj.chineseFullName"
                      placeholder="请输入中文名称" />
          </el-col>
          <el-col :span="4">
            <el-cascader size="mini"
                         v-model="searchObj.area"
                         :options="regions"
                         :props="areaProps"
                         change-on-select />
          </el-col>
          <el-col :span="3" style="float: right">
            <el-button type="primary"
                       @click="add()">
              新增
            </el-button>
          </el-col>
        </el-row>
      </el-form>
      <ele-data-tables :server-params="searchObj"
                       :ajax="ajax">
        <el-table-column label="素材标题" prop="materialTitle" />
        <el-table-column label="类型" prop="type" />
        <el-table-column label="素材分类" prop="theMaterialClassification" />
        <el-table-column label="文件大小" prop="theFileSize" />
        <el-table-column label="拍摄时间" prop="shootingTime" />

        <el-table-column label="操作" :min-width="60">
          <template slot-scope="scope">
            <el-button type="text" size="mini" @click="edit(scope.row)">编辑</el-button>
            <el-button type="text" size="mini" @click="delRow(scope.row)">删除</el-button>
          </template>
        </el-table-column>
      </ele-data-tables>
    </el-main>
  </el-container>
</template>
<script>
  import Vue from 'vue'
  import { Component } from 'vue-property-decorator'
  import EleDataTables from 'element-datatables'

  import { namespace } from 'vuex-class'

  const virtualMaterialModule = namespace('data/virtualMaterial')
  const regionModule = namespace('data/region')
  @Component({
    components: {
      EleDataTables
    }
  })

  export default class Index extends Vue {
    searchObj = {}

    data = {}

    inputVal = ''

    // 区划下拉选的属性配置
    areaProps = {
      children: 'children',
      label: 'name',
      value: 'code'
    }

    @regionModule.Getter('userRegionTree')
    regions

    @virtualMaterialModule.State('url')
    ajax

    edit (params) {
      this.$router.push({name: 'virtualMaterial', params})
    }

    add () {
      this.$router.push({name: 'virtualMaterial', params: {id: 'new'}})
    }
  }
</script>
