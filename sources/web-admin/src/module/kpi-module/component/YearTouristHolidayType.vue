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
        <el-form-item prop="name" label="节假日">
          <el-select v-model="value.name">
            <el-option value="春节">春节</el-option>
            <el-option value="元旦">元旦</el-option>
            <el-option value="清明节">清明节</el-option>
            <el-option value="劳动节">劳动节</el-option>
            <el-option value="端午节">端午节</el-option>
            <el-option value="中秋节">中秋节</el-option>
            <el-option value="国庆节">国庆节</el-option>
          </el-select>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item prop="value" label="人数">
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
  export default class YearTouristHolidayType extends Mixins(BaseForm) {
  }
</script>

<style scoped>

</style>
