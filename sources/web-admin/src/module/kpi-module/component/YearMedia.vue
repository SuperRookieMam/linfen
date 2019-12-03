<template>
  <el-form :model="value" label-width="80px">
    <el-row>
      <el-col :span="12">
        <el-form-item prop="name" label="来源">
          <el-input type="text" v-model="value.name" />
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
  export default class YearMedia extends Mixins(BaseForm) {
  }
</script>

<style scoped>

</style>
