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
          <el-date-picker type="datetime" v-model="value.currentDate" style="width: 100%;" />
        </el-form-item>
      </el-col>
    </el-row>
    <el-row>
      <el-col :span="12">
        <el-form-item prop="name" label="景区名称">
          <el-cascader v-model="value.name"
                       :options="getScenics"
                       expand-trigger="hover"
                       :props="scenicProps"
                       filterable
                       change-on-select />
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item prop="value" label="舒适度">
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
  export default class HourScenicComfort extends Mixins(BaseForm) {
  }
</script>

<style scoped>

</style>
