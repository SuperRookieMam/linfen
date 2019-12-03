<template>
  <el-form :model="value" label-width="80px">
    <el-row>
      <el-col :span="12">
        <el-form-item label="地区">
          <el-cascader v-model="value.regionCode"
                       :options="userRegionTree"
                       expand-trigger="hover"
                       :props="areaProps"
                       change-on-select />
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item prop="updatetime" label="数据日期">
          <el-date-picker type="datetime" v-model="value.updatetime" style="width: 100%;" />
        </el-form-item>
      </el-col>
    </el-row>
    <el-row>
      <el-col :span="12">
        <el-form-item prop="condition" label="天气">
          <el-input type="text" v-model="value.condition" />
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item prop="tips" label="提示">
          <el-input type="text" v-model="value.tips" />
        </el-form-item>
      </el-col>
    </el-row>
    <el-row>
      <el-col :span="12">
        <el-form-item prop="temp" label="温度">
          <el-input type="text" v-model="value.temp" />
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item prop="realFeel" label="体感温度">
          <el-input type="text" v-model="value.realFeel" />
        </el-form-item>
      </el-col>
    </el-row>
    <el-row>
      <el-col :span="12">
        <el-form-item prop="sunRise" label="日出时间">
          <el-date-picker type="datetime" v-model="value.sunRise" />
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item prop="sunSet" label="日落时间">
          <el-date-picker type="datetime" v-model="value.sunSet" />
        </el-form-item>
      </el-col>
    </el-row>
    <el-row>
      <el-col :span="12">
        <el-form-item prop="winDir" label="风向">
          <el-input type="text" v-model="value.windDir" />
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item prop="windLevel" label="风级">
          <el-input type="text" v-model="value.windLevel" />
        </el-form-item>
      </el-col>
    </el-row>
    <el-row>
      <el-col :span="12">
        <el-form-item prop="realRain" label="降水量">
          <el-input type="text" v-model="value.realRain" />
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item prop="aqi" label="空气质量">
          <el-input type="text" v-model="value.aqi" />
        </el-form-item>
      </el-col>
    </el-row>
  </el-form>
</template>
<script>

  import { Component, Mixins } from 'vue-property-decorator'
  import { BaseForm } from './.common'

  @Component
  export default class WeatherLiveData extends Mixins(BaseForm) {
  }
</script>

<style scoped>

</style>
