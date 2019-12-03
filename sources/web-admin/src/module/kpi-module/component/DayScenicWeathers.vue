<template>
  <div>
    <el-row>
      <el-col :span="24">
        <el-form inline>
          <el-form-item>
            <el-input v-model="searchObj.keywords"
                      placeholder="请输入查询关键字" />
          </el-form-item>
          <el-form-item class="pull-right">
            <el-button type="primary" @click="add">新增</el-button>
          </el-form-item>
        </el-form>
      </el-col>
    </el-row>
    <el-row>
      <el-col :span="24">
        <ele-data-tables ref="list"
                         :server-params="searchObj"
                         :ajax="ajax">
          <el-table-column prop="regionName" label="区域" sortable="custom" />
          <el-table-column prop="currentDate" label="时间" sortable="custom">
            <template v-slot="{row:{currentDate}}">{{ toLocalDate(currentDate) }}</template>
          </el-table-column>
          <el-table-column prop="name" label="景区名称" sortable="custom" />
          <el-table-column prop="hight" label="最高温度" sortable="custom" />
          <el-table-column prop="low" label="最低温度" sortable="custom" />
          <el-table-column prop="type" label="天气情况" sortable="custom" />
          <el-table-column prop="wind" label="风向" sortable="custom" />
          <!--          <el-table-column prop="value" label="值" sortable="custom"/>-->
          <el-table-column label="操作">
            <template v-slot="{row}">
              <a href="javascript:void(0)" @click="edit(row)">编辑</a>
              <a href="javascript:void(0)" @click="delRow(row)">删除</a>
            </template>
          </el-table-column>
        </ele-data-tables>
      </el-col>
    </el-row>

    <el-dialog v-if="visible" :visible.sync="visible" title="指标编辑">
      <day-scenic-weather v-model="selectedRow" />
      <template slot="footer">
        <el-button @click="visible = false">取消</el-button>
        <el-button type="primary" @click="saveData">确定</el-button>
      </template>
    </el-dialog>
  </div>
</template>

<script>
  import { Mixins, Component } from 'vue-property-decorator'
  import BaseList from './.common/BaseList'
  import DayScenicWeather from './DayScenicWeather'

  @Component({
    components: { DayScenicWeather }
  })
  export default class DayScenicWeathers extends Mixins(BaseList) {
    get baseModule () { return 'kpi/dayScenicWeather' }
  }
</script>

<style scoped>

</style>
