<template>
  <div>
    <el-form label-width="100px"
             :model="data"
             ref="form"
             size="mini"
             :rules="rules">
      <el-row>
        <el-col :span="24" style="display: flex;justify-content: flex-end;margin-top: 15px;">
          <el-button
            type="primary"
            @click="edit"
            size="mini"
            v-if="readonly">
            编辑
          </el-button>
          <el-button @click="goBack()" size="mini">取消</el-button>
          <el-button
            type="primary"
            @click="save"
            size="mini"
            v-if="!readonly">
            保存
          </el-button>
        </el-col>
      </el-row>
      <el-tabs v-model="activeName">
        <el-tab-pane label="基础信息" name="base">
          <el-row>
            <el-col :span="12">
              <el-form-item label="年" prop="year">
                <el-input type="number" v-model="data.year" :disabled="readonly" />
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="月" prop="month">
                <el-input type="number" v-model="data.month" :disabled="readonly" />
              </el-form-item>
            </el-col>
          </el-row>

          <el-row>
            <el-col :span="12">
              <el-form-item label="日" prop="day">
                <el-input type="number" v-model="data.day" :disabled="readonly" />
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="小时" prop="houre">
                <el-input v-model="data.houre" :disabled="readonly" />
              </el-form-item>
            </el-col>
          </el-row>

          <el-row>
            <el-col :span="12">
              <el-form-item label="省" prop="province">
                <el-input v-model="data.province" :disabled="readonly" />
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="市" prop="city">
                <el-input v-model="data.city" :disabled="readonly" />
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
              <el-form-item label="区" prop="area">
                <el-input v-model="data.area" :disabled="readonly" />
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="景区" prop="scenic">
                <el-input v-model="data.scenic" :disabled="readonly" />
              </el-form-item>
            </el-col>
          </el-row>

          <el-row>
            <el-col :span="12">
              <el-form-item label="空气指数" prop="aqi">
                <el-input v-model="data.aqi" :disabled="readonly" />
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="等级" prop="leve">
                <el-input v-model="data.leve" :disabled="readonly" />
              </el-form-item>
            </el-col>
          </el-row>

          <el-row>
            <el-col :span="12">
              <el-form-item label="pm2" prop="pm2">
                <el-input v-model="data.pm2" :disabled="readonly" />
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="pm10" prop="pm10">
                <el-input v-model="data.pm10" :disabled="readonly" />
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
              <el-form-item label=" 污染度" prop="contaminate">
                <el-input v-model="data.contaminate" :disabled="readonly" />
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="所在区域" prop="regionCode">
                <el-cascader v-model="data.regionCode"
                             expand-trigger="hover"
                             :options="userRegionTree"
                             :props="areaProps"
                             :disabled="readonly"
                             change-on-select />
              </el-form-item>
            </el-col>
          </el-row>
        </el-tab-pane>
      </el-tabs>
    </el-form>
  </div>
</template>
<script>
  import { Component, Prop, Mixins } from 'vue-property-decorator'
  import BaseTable from '../../.common/BaseTable'

  @Component
  export default class AirQuality extends Mixins(BaseTable) {
    @Prop({default: () => 'new'})
    id

    formName = 'form'

    currentHtml = 'form'

    getUrl () {
      return this.AllUrl.trivalEnterprise.airQualitys
    }

    get rules () {
      return {
        regionCode: [{
          required: true,
          message: '所在区域不能为空',
          trigger: 'blur'
        }],
        year: [{
          required: true,
          message: '不能为空',
          trigger: 'blur'
        }],
        month: [{
          required: true,
          message: '不能为空',
          trigger: 'blur'
        }],
        day: [{
          required: true,
          message: '不为空',
          trigger: 'blur'
        }],
        houre: [{
          required: true,
          message: '不能为空',
          trigger: 'blur'
        }],
        province: [{
          required: true,
          message: '不能为空',
          trigger: 'blur'
        }],
        city: [{
          required: true,
          message: '不能为空',
          trigger: 'blur'
        }],
        area: [{
          required: true,
          message: '不能为空',
          trigger: 'blur'
        }],
// 英文名字
        scenic: [{
          required: true,
          message: '不能为空',
          trigger: 'blur'
        }],
// 空气指数
        aqi: [{
          required: true,
          message: '不能为空',
          trigger: 'blur'
        }],
// 等级
        leve: [{
          required: true,
          message: '不能为空',
          trigger: 'blur'
        }],
// 家庭住址
        pm2: [{
          required: true,
          message: '不能为空',
          trigger: 'blur'
        }],
// 驱动器许可号
        pm10: [{
          required: true,
          message: '不能为空',
          trigger: 'blur'
        }],
// 服务语言
        contaminate: [{
          required: true,
          message: '不能为空',
          trigger: 'blur'
        }]
      }
    }
  }
</script>
