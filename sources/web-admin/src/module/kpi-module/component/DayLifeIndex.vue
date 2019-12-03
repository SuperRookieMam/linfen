<template>
  <el-form :model="value" label-width="100px" size="mini">
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
        <el-form-item prop="ultravioletRays" label="紫外线指数">
          <el-input type="text" v-model="value.ultravioletRays" />
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item prop="sport" label="运动指数">
          <el-input type="text" v-model="value.sport" />
        </el-form-item>
      </el-col>
    </el-row>
    <el-row>
      <el-col :span="12">
        <el-form-item prop="cold" label="感冒指数">
          <el-input type="text" v-model="value.cold" />
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item prop="carWash" label="洗车指数">
          <el-input type="text" v-model="value.carWash" />
        </el-form-item>
      </el-col>
    </el-row>
    <el-row>
      <el-col :span="12">
        <el-form-item prop="dressing" label="穿衣指数">
          <el-input type="text" v-model="value.dressing" />
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item prop="tour" label="旅行指数">
          <el-input type="text" v-model="value.tour" />
        </el-form-item>
      </el-col>
    </el-row>
    <!--    <el-row>-->
    <!--      <el-col :span="12">-->
    <!--        <el-form-item prop="value" label="数量">-->
    <!--          <el-input type="number" v-model="value.value"/>-->
    <!--        </el-form-item>-->
    <!--      </el-col>-->
    <!--    </el-row>-->
  </el-form>
</template>
<script>

  import { Component, Mixins } from 'vue-property-decorator'
  import { BaseForm } from './.common'

  @Component
  export default class DayLifeIndex extends Mixins(BaseForm) {
  }
</script>

<style scoped>

</style>
