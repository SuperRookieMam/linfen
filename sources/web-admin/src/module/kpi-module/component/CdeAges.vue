<template>
  <el-container>
    <el-main>
      <el-form :inline="true" :model="searchObj" size="mini">
        <el-row>
          <el-col :span="18">
            <el-form-item>
              <el-input v-model="searchObj.name" placeholder="请输入查询条件" />
            </el-form-item>
            <el-form-item>
              <el-date-picker placeholder="请选择查询时间" v-model="searchObj.currentDate" />
            </el-form-item>
          </el-col>
          <el-col :span="6">
            <el-button class="pull-right"
                       type="primary"
                       size="mini"
                       @click="add">
              新增
            </el-button>
          </el-col>
        </el-row>
      </el-form>
      <ele-data-tables ref="list"
                       :server-params="searchObj"
                       :ajax="ajax">
        <!--<el-table-column prop="id" label="id"/>-->
        <el-table-column prop="regionName" label="区域" sortable="custom" />
        <el-table-column prop="name" label="景区名称" sortable="custom" />
        <el-table-column prop="type" label="性别" sortable="custom" />
        <el-table-column prop="value" label="数量" sortable="custom" />
        <el-table-column prop="currentDate" :formatter="$dateTimeFormatter" label="数据日期" />
        <el-table-column label="创建时间" prop="createTime" :formatter="$dateTimeFormatter" />
        <el-table-column label="更新时间" prop="updateTime" :formatter="$dateTimeFormatter" />
        <el-table-column label="操作" :min-width="60">
          <template slot-scope="scope">
            <el-button type="text" size="small" @click="edit(scope.row)">编辑</el-button>
            <el-button type="text" size="small" @click="delRow(scope.row)">删除</el-button>
          </template>
        </el-table-column>
      </ele-data-tables>

      <el-dialog title="数据编辑" v-if="visible" :visible.sync="visible">
        <cde-age v-model="selectedRow" />
        <div slot="footer">
          <el-button size="mini" @click="visible = false">取消</el-button>
          <el-button size="mini" type="primary" @click="saveData">确定</el-button>
        </div>
      </el-dialog>
    </el-main>
  </el-container>
</template>
<script>

  import { Component, Mixins } from 'vue-property-decorator'
  import { BaseList } from './.common'
  import CdeAge from './CdeAge'

  @Component({
    components: { CdeAge }
  })
  export default class CdeAges extends Mixins(BaseList) {
    get baseModule () { return 'kpi/cdeAge' }
  }
</script>

<style scoped>

</style>
