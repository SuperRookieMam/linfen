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
        <el-form-item prop="complaintNumber" label="投诉量">
          <el-input type="text" v-model="value.complaintNumber" />
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item prop="acceptanceNumber" label="受理量">
          <el-input type="text" v-model="value.acceptanceNumber" />
        </el-form-item>
      </el-col>
    </el-row>
  </el-form>
</template>
<script>

  import { Component, Mixins } from 'vue-property-decorator'
  import { BaseForm } from './.common'

  @Component
  export default class YearScenicComAcc extends Mixins(BaseForm) {
  }
</script>

<style scoped>

</style>
