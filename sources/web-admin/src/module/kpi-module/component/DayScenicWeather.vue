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
        <el-form-item prop="name" label="景区名称">
          <el-input type="text" v-model="value.name" />
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item prop="type" label="天气类型">
          <el-select v-model="value.type"
                     filterable
                     allow-create>
            <el-option value="晴">晴</el-option>
            <el-option value="雨">雨</el-option>
            <el-option value="阴">阴</el-option>
            <el-option value="雷阵雨">雷阵雨</el-option>
          </el-select>
          <!--          <el-input type="text" v-model="value.type"/>-->
        </el-form-item>
      </el-col>
    </el-row>
    <el-row>
      <el-col :span="12">
        <el-form-item prop="hight" label="最高温度">
          <el-input type="text" v-model="value.hight" />
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item prop="low" label="最低温度">
          <el-input type="text" v-model="value.low" />
        </el-form-item>
      </el-col>
    </el-row>
    <el-row>
      <el-col :span="12">
        <el-form-item prop="wind" label="风向">
          <el-input type="text" v-model="value.wind" />
        </el-form-item>
      </el-col>
    </el-row>
  </el-form>
</template>
<script>

  import { Component, Mixins } from 'vue-property-decorator'
  import { BaseForm } from './.common'

  @Component
  export default class DayScenicWeather extends Mixins(BaseForm) {
  }
</script>

<style scoped>

</style>
