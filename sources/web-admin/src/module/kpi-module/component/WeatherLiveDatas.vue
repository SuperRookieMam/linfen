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
          <el-table-column prop="updatetime" label="日期" sortable="custom">
            <template v-slot="{row:{updatetime}}">{{ toLocalDateTime(updatetime) }}</template>
          </el-table-column>
          <el-table-column prop="condition" label="天气" sortable="custom" />
          <el-table-column prop="humidity" label="湿度" sortable="custom" />
          <el-table-column prop="realFeel" label="体感温度" sortable="custom" />
          <el-table-column prop="sunRise" label="日出时间" sortable="custom">
            <template v-slot="{row:{sunRise}}">{{ toLocalDateTime(sunRise) }}</template>
          </el-table-column>
          <el-table-column prop="sunSet" label="日落时间" sortable="custom">
            <template v-slot="{row:{sunSet}}">{{ toLocalDateTime(sunSet) }}</template>
          </el-table-column>
          <el-table-column prop="temp" label="温度" sortable="custom" />
          <el-table-column prop="tips" label="提示" sortable="custom" />
          <el-table-column prop="windDir" label="风向" sortable="custom" />
          <el-table-column prop="windLevel" label="风级" sortable="custom" />
          <el-table-column prop="realRain" label="降水量" sortable="custom" />
          <el-table-column prop="aqi" label="空气质量" sortable="custom" />
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
      <weather-live-data v-model="selectedRow" />
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
  import WeatherLiveData from './WeatherLiveData'

  @Component({
    components: { WeatherLiveData }
  })
  export default class WeatherLiveDatas extends Mixins(BaseList) {
    get baseModule () { return 'kpi/weatherLiveData' }
  }
</script>

<style scoped>

</style>
