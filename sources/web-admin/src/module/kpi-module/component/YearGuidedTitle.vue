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
        <el-form-item prop="year" label="年份">
          <el-select v-model="value.year">
            <el-option v-for="year in years" :key="year" :value="year">{{ year }}</el-option>
          </el-select>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row>
      <el-col :span="12">
        <el-form-item prop="name" label="职称">
          <el-select v-model="value.name">
            <el-option value="特级">特级</el-option>
            <el-option value="高级">高级</el-option>
            <el-option value="中级">中级</el-option>
            <el-option value="初级">初级</el-option>
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
  export default class YearGuidedTitle extends Mixins(BaseForm) {
  }
</script>

<style scoped>

</style>
