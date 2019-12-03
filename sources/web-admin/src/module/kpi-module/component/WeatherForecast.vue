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
        <el-form-item prop="predictDate" label="数据日期">
          <el-date-picker v-model="value.predictDate" style="width: 100%;" />
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
        <el-form-item prop="temp" label="温度">
          <el-input type="text" v-model="value.temp" />
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
      <!--      <el-col :span="12">-->
      <!--        <el-form-item prop="value" label="数量">-->
      <!--          <el-input type="number" v-model="value.value"/>-->
      <!--        </el-form-item>-->
      <!--      </el-col>-->
    </el-row>
  </el-form>
</template>
<script>

  import { Component, Mixins } from 'vue-property-decorator'
  import { BaseForm } from './.common'

  @Component
  export default class WeatherForecast extends Mixins(BaseForm) {
  }
</script>

<style scoped>

</style>
