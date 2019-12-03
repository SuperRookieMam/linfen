<!--大巴司机-->
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
              @click="save('busDriver')"
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
                <el-form-item label="中文姓名" prop="chineseName">
                  <el-input v-model="data.chineseName" :disabled="readonly" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="拼音" prop="pinyin">
                  <el-input v-model="data.pinyin" :disabled="readonly" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="英文姓名" prop="theEnglishName">
                  <el-input v-model="data.theEnglishName" :disabled="readonly" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <!--<el-form-item label="性别" prop="gender" >
                  <el-input size='mini' v-model="data.gender" :disabled="readonly" />
                </el-form-item>-->
                <el-form-item label="性别" prop="gender">
                  <el-select v-model="data.gender" :disabled="readonly" placeholder="性别">
                    <el-option v-for="item in genders"
                               :key="item.value"
                               :label="item.label"
                               :value="item.value" />
                  </el-select>
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="出生日期" prop="dateOfBirth">
                  <el-date-picker
                    v-model="data.dateOfBirth"
                    :disabled="readonly"
                    type="date"
                    placeholder="选择日期" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="身份证号" prop="idNumber">
                  <el-input v-model="data.idNumber" :disabled="readonly" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="学历" prop="recordOfFormalSchooling">
                  <el-select v-model="data.recordOfFormalSchooling" :disabled="readonly" placeholder="学历">
                    <el-option v-for="item in recordOfFormalSchoolings"
                               :key="item.value"
                               :label="item.label"
                               :value="item.value" />
                  </el-select>
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="民族" prop="national">
                  <el-input v-model="data.national" :disabled="readonly" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="联系方式" prop="contact">
                  <el-input v-model="data.contact" :disabled="readonly" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="家庭住址" prop="homeAddress">
                  <el-input v-model="data.homeAddress" :disabled="readonly" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="所在地区" prop="regionCode">
                  <el-cascader v-model="data.regionCode"
                               expand-trigger="hover"
                               :options="userRegionTree"
                               :props="areaProps"
                               :disabled="readonly"
                               change-on-select />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="职称" prop="theTitle">
                  <el-input v-model="data.theTitle" :disabled="readonly" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="驾龄" prop="beenDriving">
                  <el-input v-model="data.beenDriving" type="number" :disabled="readonly" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="驾驶证号码" prop="driverLicenseNumber">
                  <el-input v-model="data.driverLicenseNumber" :disabled="readonly" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="服务语种" prop="serviceLanguage">
                  <el-select v-model="data.serviceLanguage" :disabled="readonly" placeholder="服务语种">
                    <el-option v-for="item in serviceLanguages"
                               :key="item.value"
                               :label="item.label"
                               :value="item.value" />
                  </el-select>
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="服务范围" prop="serviceScope">
                  <el-input v-model="data.serviceScope" :disabled="readonly" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="简介" prop="introduction">
                  <edit v-model="data.introduction" />
                </el-form-item>
              </el-col>
            </el-row>
          </el-tab-pane>

          <el-tab-pane label="工作情况">
            <el-row>
              <el-col :span="12">
                <el-form-item label="工作情况" prop="workingCondition">
                  <edit v-model="data.workingCondition" />
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
  import * as myrules from '../../../commonjs/rule'

  @Component({
    components: {}
  })
  export default class BusDriver extends Mixins(BaseTable) {
    @Prop({default: () => 'new'})
    id

    getUrl () {
      return this.AllUrl.trivalEnterprise.busDrivers
    }

    serviceLanguages = [{
      value: '汉语（普通话)',
      label: '汉语（普通话）'
    }, {
      value: '英语',
      label: '英语'
    }, {
      value: '德语',
      label: '德语'
    }, {
      value: '法语',
      label: '法语'
    }, {
      value: '俄语',
      label: '俄语'
    }, {
      value: '西班牙语',
      label: '西班牙语'
    }, {
      value: '日语',
      label: '日语'
    }, {
      value: '阿拉伯语',
      label: '阿拉伯语'
    }, {
      value: '韩语（朝鲜语)',
      label: '韩语（朝鲜语)'
    }, {
      value: '葡萄牙语',
      label: '葡萄牙语'
    }, {
      value: '其他',
      label: '其他'
    }]

    genders = [{
      value: '男',
      label: '男'
    }, {
      value: '女',
      label: '女'
    }, {
      value: '未知',
      label: '未知'
    }]

    recordOfFormalSchoolings = [{
      value: '小学',
      label: '小学'
    }, {
      value: '初中',
      label: '初中'
    }, {
      value: '高中',
      label: '高中'
    }, {
      value: '大学专科',
      label: '大学专科'
    }, {
      value: '大学本科',
      label: '大学本科'
    }, {
      value: '硕士',
      label: '硕士'
    }, {
      value: '博士',
      label: '博士'
    }]

    genders = [{
      value: '男',
      label: '男'
    }, {
      value: '女',
      label: '女'
    }, {
      value: '未知',
      label: '未知'
    }]

    recordOfFormalSchoolings = [{
      value: '小学',
      label: '小学'
    }, {
      value: '初中',
      label: '初中'
    }, {
      value: '高中',
      label: '高中'
    }, {
      value: '大学专科',
      label: '大学专科'
    }, {
      value: '大学本科',
      label: '大学本科'
    }, {
      value: '硕士',
      label: '硕士'
    }, {
      value: '博士',
      label: '博士'
    }]

    get rules () {
      return {
        regionCode: [{
          required: true,
          message: '所在区域不能为空',
          trigger: 'blur'
        }],
        chineseName: [{
          required: true,
          message: '中文姓名不能为空',
          trigger: 'blur'
        }, {
          validator: myrules.validatLength,
          maxlength: 50,
          msg: '长度不能超过50',
          trigger: 'blur'
        }],
        gender: [{
          required: true,
          message: '性别不能为空',
          trigger: 'blur'
        }, {
          validator: myrules.validatLength,
          maxlength: 50,
          msg: '长度不能超过50',
          trigger: 'blur'
        }],
        national: [{
          required: true,
          message: '民族不能为空',
          trigger: 'blur'
        }, {
          validator: myrules.validatLength,
          maxlength: 50,
          msg: '长度不能超过50',
          trigger: 'blur'
        }],
        theTitle: [{
          required: true,
          message: '职称不能为空',
          trigger: 'blur'
        }, {
          validator: myrules.validatLength,
          maxlength: 50,
          msg: '长度不能超过50',
          trigger: 'blur'
        }],
        beenDriving: [{
          required: true,
          message: '驾龄不能为空',
          trigger: 'blur'
        }, {
          validator: myrules.validatLength,
          maxlength: 50,
          msg: '长度不能超过50',
          trigger: 'blur'
        }],
        workingCondition: [{
          required: true,
          message: '工作情况不能为空',
          trigger: 'blur'
        }, {
          validator: myrules.validatLength,
          maxlength: 50,
          msg: '长度不能超过50',
          trigger: 'blur'
        }],
        idNumber: [{
          required: true,
          message: '工作情况不能为空',
          trigger: 'blur'
        }, {
          validator: myrules.validatLength,
          maxlength: 20,
          msg: '长度不能超过20',
          trigger: 'blur'
        }, {
          validator: myrules.validatCard,
          msg: '身份证格式不对',
          trigger: 'blur'
        }],
        pinyin: [{
          validator: myrules.validatLength,
          maxlength: 50,
          msg: '长度不能超过50',
          trigger: 'blur'
        }],
// 英文名字
        theEnglishName: [{
          validator: myrules.validatLength,
          maxlength: 100,
          msg: '长度不能超过100',
          trigger: 'blur'
        }],
// 出生日期
        dateOfBirth: [{
          required: true,
          message: '类型不能为空',
          trigger: 'blur'
        }],
// 接触
        contact: [{
          validator: myrules.validatLength,
          maxlength: 200,
          msg: '长度不能超过200',
          trigger: 'blur'
        }],
// 家庭住址
        homeAddress: [{
          validator: myrules.validatLength,
          maxlength: 200,
          msg: '长度不能超过200',
          trigger: 'blur'
        }],
// 地区
        area: [{
          validator: myrules.validatLength,
          maxlength: 200,
          msg: '长度不能超过200',
          trigger: 'blur'
        }],
// 驱动器许可号
        driverLicenseNumber: [{
          validator: myrules.validatLength,
          maxlength: 200,
          msg: '长度不能超过200',
          trigger: 'blur'
        }],
// 服务语言
        serviceLanguage: [{
          validator: myrules.validatLength,
          maxlength: 200,
          msg: '长度不能超过200',
          trigger: 'blur'
        }],
// 服务镜
        serviceScope: [{
          validator: myrules.validatLength,
          maxlength: 200,
          msg: '长度不能超过200',
          trigger: 'blur'
        }]
      }
    }
  }
</script>
