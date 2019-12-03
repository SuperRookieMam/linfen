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
        <el-form-item prop="year" label="年">
          <el-select v-model="value.year">
            <el-option v-for="year in years" :key="year" :value="year">{{ year }}</el-option>
          </el-select>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row>
      <el-col :span="12">
        <el-form-item prop="name" label="行为">
          <el-select v-model="value.name">
            <el-option value="吃">吃</el-option>
            <el-option value="住">住</el-option>
            <el-option value="行">行</el-option>
            <el-option value="游">游</el-option>
            <el-option value="购">购</el-option>
            <el-option value="娱">娱</el-option>
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
  export default class YearIndustrys extends Mixins(BaseForm) {
  }
</script>

<style scoped>

</style>
