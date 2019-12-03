<template>
  <el-form :model="value" label-width="100px">
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
      <el-col :span="8">
        <el-form-item prop="gender" label="性别">
          <el-select v-model="value.gender">
            <el-option value="男">男</el-option>
            <el-option value="女">女</el-option>
            <el-option value="未知">未知</el-option>
          </el-select>
        </el-form-item>
      </el-col>
      <el-col :span="8">
        <el-form-item prop="age" label="年龄段类型">
          <el-select type="text" v-model="value.age">
            <el-option
              v-for="item in ages"
              :key="item.value"
              :label="item.value"
              :value="item.value" />
          </el-select>
        </el-form-item>
      </el-col>

      <el-col :span="8">
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
  export default class YearTeamGenderAge extends Mixins(BaseForm) {
  }
</script>

<style scoped>

</style>
