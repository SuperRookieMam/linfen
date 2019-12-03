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
      <el-col :span="6">
        <el-form-item prop="year" label="年">
          <el-select v-model="value.year" style="width: 80px;">
            <el-option v-for="year in years" :key="year" :value="year">{{ year }}</el-option>
          </el-select>
        </el-form-item>
      </el-col>
      <el-col :span="6">
        <el-form-item prop="month" label="月">
          <el-select v-model="value.month" style="width: 60px;">
            <el-option v-for="month in months" :key="month" :value="month">{{ month }}</el-option>
          </el-select>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row>
      <el-col :span="12">
        <el-form-item prop="name" label="类型">
          <el-select v-model="value.name">
            <el-option value="1个">1个</el-option>
            <el-option value="2个">1个</el-option>
            <el-option value="3个及以上">3个及以上</el-option>
          </el-select>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item prop="value" label="数量">
          <el-input type="number" v-model="value.value" />
        </el-form-item>
      </el-col>
    </el-row>
  </el-form>
</template>
<script>

  import { Component, Mixins } from 'vue-property-decorator'
  import { BaseForm } from './.common'

  @Component
  export default class MonthTouristScenic extends Mixins(BaseForm) {
  }
</script>

<style scoped>

</style>
