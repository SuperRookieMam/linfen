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
        <el-form-item prop="currentDate" label="数据日期">
          <el-date-picker v-model="value.currentDate" style="width: 100%;" />
        </el-form-item>
      </el-col>
    </el-row>

    <el-row>
      <el-col :span="12">
        <el-form-item label="点位" prop="pointName">
          <el-input v-model="value.pointName" />
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="天气" prop="whether">
          <el-input v-model="value.whether" />
        </el-form-item>
      </el-col>
    </el-row>
    <el-row>
      <el-col :span="12">
        <el-form-item prop="value" label="温度">
          <el-input type="number" v-model="value.value" />
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item prop="rh" label="相对湿度">
          <el-input v-model="value.rh" />
        </el-form-item>
      </el-col>
    </el-row>

    <el-row>
      <el-col :span="12">
        <el-form-item prop="tempMax" label="最高气温">
          <el-input type="text" v-model="value.tempMax" />
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item prop="tempMin" label="最低气温">
          <el-input type="text" v-model="value.tempMin" />
        </el-form-item>
      </el-col>
    </el-row>
    <el-row>
      <el-col :span="12">
        <el-form-item prop="windDirection" label="风向">
          <el-input type="text" v-model="value.windDirection" />
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item prop="windScale" label="风力">
          <el-input type="text" v-model="value.windScale" />
        </el-form-item>
      </el-col>
    </el-row>
    <el-row>
      <el-col :span="12">
        <el-form-item prop="precipitation" label="降水量">
          <el-input type="text" v-model="value.precipitation" />
        </el-form-item>
      </el-col>
    </el-row>
  </el-form>
</template>
<script>

  import { Component, Mixins } from 'vue-property-decorator'
  import { BaseForm } from './.common'

  @Component
  export default class HourWeather extends Mixins(BaseForm) {
  }
</script>

<style scoped>

</style>
