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
        <el-form-item prop="name" label="区县">
          <el-input type="text" v-model="value.name" />
        </el-form-item>
      </el-col>
    </el-row>
    <el-row>
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
  export default class NowDistrictResource extends Mixins(BaseForm) {
  }
</script>

<style scoped>

</style>
