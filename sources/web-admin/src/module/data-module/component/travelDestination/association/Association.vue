<!--旅游组织协会-->
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
        <el-tabs>
          <el-tab-pane label="基本信息">
            <el-row>
              <el-col :span="12">
                <el-form-item label="中文全称" prop="chineseFullName">
                  <el-input v-model="data.chineseFullName" :disabled="readonly" maxlength="50" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="中文简称" prop="chineseShortName">
                  <el-input v-model="data.chineseShortName" :disabled="readonly" maxlength="20" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="拼音名称" prop="pinyinName">
                  <el-input v-model="data.pinyinName" :disabled="readonly" maxlength="50" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="英文名称" prop="englishName">
                  <el-input v-model="data.englishName" :disabled="readonly" maxlength="100" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="所在地区" prop="regionCode">
                  <el-cascader v-model="regionCode"
                               :options="regions"
                               :props="areaProps"
                               :disabled="readonly"
                               change-on-select />
                </el-form-item>
              </el-col>
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
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="是否认证" prop="whetherTheCertification">
                  <el-input v-model="data.whetherTheCertification" :disabled="readonly" maxlength="200" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="地址" prop="address">
                  <el-input v-model="data.address" :disabled="readonly" maxlength="200" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="邮政编码" prop="zipCode">
                  <el-input v-model="data.zipCode" :disabled="readonly" maxlength="10" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="机构Logo" prop="agencyLogo">
                  <el-input v-model="data.agencyLogo" :disabled="readonly" maxlength="50" />
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

          <el-tab-pane label="公共服务信息">
            <el-row>
              <el-col :span="12">
                <el-form-item label="新浪微博" prop="weibo">
                  <el-input v-model="data.weibo" :disabled="readonly" maxlength="200" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="腾讯微博" prop="tencentWeibo">
                  <el-input v-model="data.tencentWeibo" :disabled="readonly" maxlength="200" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="微信公众账号" prop="weChatPublicAccount">
                  <el-input v-model="data.weChatPublicAccount" :disabled="readonly" maxlength="200" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="微信公众账号二维码" label-width="139px" prop="weChatPublicAccountQrCode">
                  <qr-code-editor v-model="data.weChatPublicAccountQrCode" :disabled="readonly" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="官方网站" prop="officialWebsite">
                  <el-input v-model="data.officialWebsite" :disabled="readonly" maxlength="200" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="联系人" prop="theContact">
                  <el-input v-model="data.theContact" :disabled="readonly" maxlength="50" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="联系电话" prop="contactPhoneNumber">
                  <el-input v-model="data.contactPhoneNumber" :disabled="readonly" maxlength="20" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="传真" prop="fax">
                  <el-input v-model="data.fax" :disabled="readonly" maxlength="50" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="Email" prop="email">
                  <el-input v-model="data.email" :disabled="readonly" maxlength="50" />
                </el-form-item>
              </el-col>
            </el-row>
          </el-tab-pane>

          <el-tab-pane label="协会信息">
            <el-row>
              <el-col :span="12">
                <el-form-item label="主管部门" prop="theCompetentDepartmentOf">
                  <el-input v-model="data.theCompetentDepartmentOf" :disabled="readonly" maxlength="200" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="负责人" prop="head">
                  <el-input v-model="data.head" :disabled="readonly" maxlength="50" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="成立时间" prop="setUpTheTime">
                  <el-input v-model="data.setUpTheTime" :disabled="readonly" maxlength="50" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="创建人" prop="founder">
                  <el-input v-model="data.founder" :disabled="readonly" maxlength="50" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="创建宗旨" prop="createAPurpose" maxlength="200">
                  <el-input v-model="data.createAPurpose" :disabled="readonly" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="主营项目" prop="theMainProject">
                  <el-input v-model="data.theMainProject" :disabled="readonly" maxlength="200" />
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="12">
                <el-form-item label="信用等级" prop="aCreditRating">
                  <el-input v-model="data.acreditRating" :disabled="readonly" maxlength="200" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="主要职能" prop="theMainFunctionsOf">
                  <el-input v-model="data.theMainFunctionsOf" :disabled="readonly" maxlength="200" />
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="12">
                <el-form-item label="分支机构" prop="branch">
                  <el-input v-model="data.branch" :disabled="readonly" maxlength="200" />
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
  import BaseForm from '../../.common/BaseForm'
  import { Component, Prop, Mixins } from 'vue-property-decorator'
  import { namespace } from 'vuex-class'
  import qrCodeEditor from '../../.common/QrCodeEditor'
  import * as myrules from '../../../commonjs/rule'

  const associationModule = namespace('data/association')
  const regionModule = namespace('data/region')
  @Component({
    components: {
      qrCodeEditor
    }
  })
  export default class Association extends Mixins(BaseForm) {
    @Prop({default: () => 'new'})
    id

    // 区划下拉选的属性配置
    areaProps = {
      children: 'children',
      label: 'name',
      value: 'code'
    }

    @regionModule.Getter('userRegionTree')
    regions

    data = {}

    readonly = true

    get rules () {
      return {

        chineseFullName: [{
          required: true,
          message: '中文全称不能为空',
          trigger: 'blur'
        }],
        area: [{
          required: true,
          message: '所在地区不能为空',
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
        }],
        address: [{
          required: true,
          message: '地址不能为空',
          trigger: 'blur'
        }],
        zipCode: [{
          required: true,
          message: '邮政编码不能为空',
          trigger: 'blur'
        }, {
          validator: myrules.validatPostcode,
          msg: '邮政编码不正确',
          trigger: 'blur'
        }],
        email: [
          {
            validator: myrules.validatEmail,
            msg: 'email格式不对',
            trigger: 'blur'
          }
        ]
      }
    }

    @associationModule.Action('save')
    saveData

    @associationModule.Action('get')
    getData

    @associationModule.Action('update')
    updateData

    save () {
      this.$refs.form.validate(valid => {
        if (valid) {
          if (this.id === 'new') {
            this.saveData(this.data).then(rsp => {
              this.data = rsp
            }).then(() => {
              this.$router.go(-1)
            })
          } else {
            this.updateData({id: this.id, data: this.data}).then(() => {
              this.$router.go(-1)
            })
          }
        } else {
          this.$message({
            message: '数据校验没有通过，请检查输入详情',
            type: 'error'
          })
        }
      })
    }

    edit () {
      this.readonly = false
    }

    goBack () {
      this.$router.go(-1)
    }

    created () {
      if (this.id !== 'new') {
        this.getData({id: this.id}).then(data => (this.data = data))
      } else {
        this.readonly = false
      }
    }
  }
</script>
