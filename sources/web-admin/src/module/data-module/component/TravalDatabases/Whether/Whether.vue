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
                <scenic-select v-model="data.scenic" :disabled="readonly" />
              </el-form-item>
            </el-col>
          </el-row>

          <el-row>
            <el-col :span="12">
              <el-form-item label="最高气温" prop="temperatureMax">
                <el-input v-model="data.temperatureMax" :disabled="readonly" />
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="最低气温" prop="temperatureMin">
                <el-input v-model="data.temperatureMin" :disabled="readonly" />
              </el-form-item>
            </el-col>
          </el-row>

          <el-row>
            <el-col :span="12">
              <el-form-item label="天气" prop="whether">
                <el-input v-model="data.whether" :disabled="readonly" />
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="风力" prop="windPower">
                <el-input v-model="data.windPower" :disabled="readonly" />
              </el-form-item>
            </el-col>
          </el-row>

          <el-row>
            <el-col :span="12">
              <el-form-item label="空气指数" prop="airQuality">
                <el-input v-model="data.airQuality" :disabled="readonly" />
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="降水量" prop="precipitation">
                <el-input v-model="data.precipitation" :disabled="readonly" />
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
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
  import ScenicSelect from '../../.common/ScenicSelect'
  @Component({
    components: {
      ScenicSelect
    }
  })
  export default class Whether extends Mixins(BaseTable) {
    @Prop({default: () => 'new'})
    id

    formName = 'form'

    currentHtml = 'form'

    getUrl () {
      return this.AllUrl.trivalEnterprise.whethers
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
        temperatureMax: [{
          required: true,
          message: '不能为空',
          trigger: 'blur'
        }],
// 等级
        temperatureMin: [{
          required: true,
          message: '不能为空',
          trigger: 'blur'
        }],
// 家庭住址
        whether: [{
          required: true,
          message: '不能为空',
          trigger: 'blur'
        }],
// 驱动器许可号
        windPower: [{
          required: true,
          message: '不能为空',
          trigger: 'blur'
        }],
// 服务语言
        airQuality: [{
          required: true,
          message: '不能为空',
          trigger: 'blur'
        }],
// 服务语言
        precipitation: [{
          required: true,
          message: '不能为空',
          trigger: 'blur'
        }]
      }
    }
  }
</script>
