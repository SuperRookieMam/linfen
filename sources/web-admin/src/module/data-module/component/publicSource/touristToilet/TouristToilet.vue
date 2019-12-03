<!--旅游厕所-->
<template>
  <el-container>
    <el-main>
      <el-form label-width="100px"
               :model="data"
               ref="form"
               size="mini"
               :rules="rules">
        <el-row>
          <el-col :span="24" style="display: flex;justify-content: flex-end;margin-top: 15px;">
            <el-button
              type="primary"
              @click="readonly=false"
              size="mini"
              v-if="readonly">
              编辑
            </el-button>
            <el-button @click="goBack()" size="mini">取消</el-button>
            <el-button
              type="primary"
              @click="save('touristToilet')"
              size="mini"
              v-if="!readonly">
              保存
            </el-button>
          </el-col>
        </el-row>
        <el-tabs>
          <el-tab-pane label="基本信息">
            <el-row>
              <el-col :span="12">
                <el-form-item label="中文名称" prop="fullname">
                  <el-input
                    v-model="data.fullname"
                    :disabled="readonly"
                    maxlength="50" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="中文简称" prop="shortName">
                  <el-input
                    v-model="data.shortName"
                    :disabled="readonly"
                    maxlength="20" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="拼音名称" prop="pinYin">
                  <el-input
                    v-model="data.pinYin"
                    :disabled="readonly"
                    maxlength="50" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="英文名称" prop="englishName">
                  <el-input
                    v-model="data.englishName"
                    :disabled="readonly"
                    maxlength="100" />
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
              <el-col :span="12">
                <el-form-item label="相关景区" prop="location">
                  <scenic-select v-model="data.location" :disabled="readonly" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="6">
                <el-form-item label="经度" prop="longitude">
                  <el-input type="number" v-model="data.longitude" :disabled="readonly" />
                </el-form-item>
              </el-col>
              <el-col :span="6">
                <el-form-item label="纬度" prop="latitude">
                  <el-input type="number" v-model="data.latitude" :disabled="readonly" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="地址" prop="address">
                  <el-input v-model="data.address" :disabled="readonly" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="厕所等级" prop="touristToiletGrade">
                  <!--<el-input size='mini' v-model="data.destinationCategory" :disabled="readonly" />-->
                  <el-select v-model="data.touristToiletGrade" placeholder="请选择" :disabled="readonly">
                    <el-option v-for="item in options"
                               :key="item.value"
                               :label="item.label"
                               :value="item.value" />
                  </el-select>
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="报警电话" prop="policeStationPhone">
                  <el-input
                    v-model="data.policeStationPhone"
                    :disabled="readonly"
                    maxlength="20" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="收费标准" prop="charges">
                  <el-input
                    v-model="data.charges"
                    :disabled="readonly"
                    maxlength="200" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="相关景区" prop="relatedScenics">
                  <el-input
                    v-model="data.relatedScenics"
                    :disabled="readonly"
                    maxlength="50" />
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="12">
                <el-form-item label="热度" prop="hotIndex">
                  <el-input
                    v-model="data.hotIndex"
                    :disabled="readonly"
                    maxlength="200" />
                </el-form-item>
              </el-col>
            </el-row>
          </el-tab-pane>
        </el-tabs>
      </el-form>
    </el-main>
  </el-container>
</template>
<script>
  import BaseTable from '../../.common/BaseTable'
  import { Component, Prop, Mixins } from 'vue-property-decorator'
  import * as myRules from '../../../commonjs/rule'
  import ScenicSelect from '../../.common/ScenicSelect'
  @Component({
    components: {
      ScenicSelect
    }
  })
  export default class TouristToilet extends Mixins(BaseTable) {
    @Prop({default: () => 'new'})
    id

    formName = 'form'

    currentHtml = 'form'

    getUrl () {
      return this.AllUrl.trivalEnterprise.touristToilets
    }

    options = [{
      value: '五星级',
      label: '五星级'
    }, {
      value: '四星级',
      label: '四星级'
    }, {
      value: '三星级',
      label: '三星级'
    }, {
      value: '二星级',
      label: '二星级'
    }, {
      value: '一星级',
      label: '一星级'
    }, {
      value: '未评定',
      label: '未评定'
    }]

    get rules () {
      return {
        regionCode: [{
          required: true,
          message: '所在区域不能为空',
          trigger: 'blur'
        }],
        fullname: [{
          required: true,
          message: '中文名称不能为空',
          trigger: 'blur'
        }],
        region: [{
          required: true,
          message: '所在区域不能为空',
          trigger: 'blur'
        }],
        location: [{
          required: true,
          message: '经度不能为空',
          trigger: 'blur'
        }],
        policeStationPhone: [{
          validator: myRules.validatPhone,
          msg: '报警电话格式不对',
          trigger: 'blur'
        }],
        longitude: [{
          required: true,
          message: '经度不能为空',
          trigger: 'blur'
        }],
        latitude: [{
          required: true,
          message: '纬度不能为空',
          trigger: 'blur'
        }]
      }
    }
  }
</script>
