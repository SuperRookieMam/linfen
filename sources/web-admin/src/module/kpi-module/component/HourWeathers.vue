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
          <el-table-column prop="pointName" label="点位名称" sortable="custom" />
          <el-table-column prop="whether" label="天气" sortable="custom" />
          <el-table-column prop="value" label="气温" sortable="custom" />
          <el-table-column prop="windScale" label="风力" sortable="custom" />
          <el-table-column prop="windDirection" label="风向" sortable="custom" />
          <el-table-column prop="precipitation" label="降水量" sortable="custom" />
          <el-table-column prop="rh" label="相对湿度" sortable="custom" />
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
      <weather v-model="selectedRow" />
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
  import Weather from './HourWeather'

  @Component({
    components: { Weather }
  })
  export default class HourWeathers extends Mixins(BaseList) {
    get baseModule () { return 'kpi/hourWeather' }
  }
</script>

<style scoped>

</style>
