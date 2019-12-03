<template>
  <el-form :model="value" label-width="200px">
    <el-row>
      <el-col :span="8">
        <el-form-item label="地区" label-width="100px">
          <el-cascader v-model="value.regionCode"
                       :options="userRegionTree"
                       expand-trigger="hover"
                       :props="areaProps"
                       change-on-select />
        </el-form-item>
      </el-col>
      <el-col :span="8">
        <el-form-item label="点位名称" prop="pointName" label-width="100px">
          <el-input type="text" v-model="value.pointName" />
        </el-form-item>
      </el-col>
      <el-col :span="8">
        <el-form-item prop="currentDate" label="数据日期" label-width="100px">
          <el-date-picker type="datetime" v-model="value.currentDate" style="width: 100%;" />
        </el-form-item>
      </el-col>
    </el-row>

    <el-row>
      <el-col :span="12">
        <el-form-item label="AQI" prop="value" label-width="100px">
          <el-input type="number" v-model="value.value" />
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="等级" prop="value" label-width="100px">
          <el-select v-model="value.grade">
            <el-option value="优" />
            <el-option value="良" />
            <el-option value="轻度污染" />
            <el-option value="中度污染" />
            <el-option value="重度污染" />
            <el-option value="严重污染  " />
          </el-select>
        </el-form-item>
      </el-col>
    </el-row>

    <el-row>
      <el-col :span="12">
        <el-form-item prop="pso21h">
          <template v-slot:label>
            SO<sub>2</sub>小时平均浓度
          </template>
          <el-input type="number" v-model="value.pSo21h" />
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item prop="iso21h">
          <template v-slot:label>
            SO<sub>2</sub>小时平均分指数
          </template>
          <el-input type="number" v-model="value.iSo21h" />
        </el-form-item>
      </el-col>
    </el-row>

    <el-row>
      <el-col :span="12">
        <el-form-item prop="pso21h">
          <template v-slot:label>
            NO<sub>2</sub>小时平均浓度
          </template>
          <el-input type="number" v-model="value.pNo21h" />
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item prop="iso21h">
          <template v-slot:label>
            NO<sub>2</sub>小时平均分指数
          </template>
          <el-input type="number" v-model="value.iNo21h" />
        </el-form-item>
      </el-col>
    </el-row>

    <el-row>
      <el-col :span="12">
        <el-form-item prop="pso21h">
          <template v-slot:label>
            O<sub>3</sub>小时平均浓度
          </template>
          <el-input type="number" v-model="value.pO31h" />
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item prop="iso21h">
          <template v-slot:label>
            O<sub>3</sub>小时平均分指数
          </template>
          <el-input type="number" v-model="value.iO31h" />
        </el-form-item>
      </el-col>
    </el-row>

    <el-row>
      <el-col :span="12">
        <el-form-item prop="pco1h">
          <template v-slot:label>
            CO小时平均浓度
          </template>
          <el-input type="number" v-model="value.pCo1h" />
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item prop="ico1h">
          <template v-slot:label>
            CO小时平均分指数
          </template>
          <el-input type="number" v-model="value.iCo1h" />
        </el-form-item>
      </el-col>
    </el-row>

    <el-row>
      <el-col :span="12">
        <el-form-item prop="pso21h">
          <template v-slot:label>
            PM10小时平均浓度
          </template>
          <el-input type="number" v-model="value.pPm101h" />
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item prop="iso21h">
          <template v-slot:label>
            PM10小时平均分指数
          </template>
          <el-input type="number" v-model="value.iPm101h" />
        </el-form-item>
      </el-col>
    </el-row>

    <el-row>
      <el-col :span="12">
        <el-form-item prop="pso21h">
          <template v-slot:label>
            PM25小时平均浓度
          </template>
          <el-input type="number" v-model="value.pPm251h" />
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item prop="iso21h">
          <template v-slot:label>
            PM25小时平均分指数
          </template>
          <el-input type="number" v-model="value.iPm251h" />
        </el-form-item>
      </el-col>
    </el-row>

    <el-row>
      <el-col :span="12">
        <el-form-item prop="pso21h">
          <template v-slot:label>
            O<sub>3</sub>8小时滑动平均浓度
          </template>
          <el-input type="number" v-model="value.pO38h" />
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item prop="iso21h">
          <template v-slot:label>
            O<sub>3</sub>8小时滑动平均分指数
          </template>
          <el-input type="number" v-model="value.iO38h" />
        </el-form-item>
      </el-col>
    </el-row>

    <el-row>
      <el-col :span="12">
        <el-form-item prop="pso21h">
          <template v-slot:label>
            PM1024小时滑动平均浓度
          </template>
          <el-input type="number" v-model="value.pPm1024h" />
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item prop="iso21h">
          <template v-slot:label>
            PM1024小时滑动平均分指数
          </template>
          <el-input type="number" v-model="value.iPm1024h" />
        </el-form-item>
      </el-col>
    </el-row>

    <el-row>
      <el-col :span="12">
        <el-form-item prop="ppm2524h">
          <template v-slot:label>
            PM2524小时滑动平均浓度
          </template>
          <el-input type="number" v-model="value.pPm2524h" />
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item prop="ipm2524h">
          <template v-slot:label>
            PM2524小时滑动平均分指数
          </template>
          <el-input type="number" v-model="value.iPm2524h" />
        </el-form-item>
      </el-col>
    </el-row>
  </el-form>
</template>
<script>

  import { Component, Mixins } from 'vue-property-decorator'
  import { BaseForm } from './.common'
  import Template from '../../data-module/component/.common/Template'

  @Component({
    components: { Template }
  })
  export default class HourAqi extends Mixins(BaseForm) {
  }
</script>

<style scoped>

</style>
