<!--旅游目的地-->
<template>
  <el-container>
    <el-main>
      <el-form label-width="100px"
               size="mini"
               :model="data"
               ref="form"
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
                  <el-input
                    v-model="data.chineseFullName"
                    :disabled="readonly"
                    maxlength="50" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="中文简称" prop="chineseShortName">
                  <el-input
                    v-model="data.chineseShortName"
                    :disabled="readonly"
                    maxlength="20" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="拼音名称" prop="pinyinName">
                  <el-input
                    v-model="data.pinyinName"
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
                <el-form-item label="关键字" prop="keywords">
                  <el-input
                    v-model="data.keywords"
                    :disabled="readonly"
                    maxlength="50" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="目的地类别" prop="destinationCategory">
                  <!--<el-input size='mini' v-model="data.destinationCategory" :disabled="readonly" />-->
                  <el-select v-model="data.destinationCategory"
                             :disabled="readonly"
                             placeholder="请选择">
                    <el-option label="省级" value="省级" />
                    <el-option label="地级" value="地级" />
                    <el-option label="县级" value="县级" />
                  </el-select>
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="所属地区" prop="regionCode">
                  <el-cascader v-model="regionCode"
                               :options="regions"
                               expand-trigger="hover"
                               :props="areaProps"
                               :disabled="readonly"
                               size="mini"
                               change-on-select />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="下辖行政区域" prop="administerAdministrativeArea">
                  <el-input
                    v-model="data.administerAdministrativeArea"
                    :disabled="readonly"
                    maxlength="200" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="6">
                <el-form-item label="经度" prop="longitude">
                  <el-input
                    type="number"
                    v-model="data.longitude"
                    :disabled="readonly" />
                </el-form-item>
              </el-col>
              <el-col :span="6">
                <el-form-item label="纬度" prop="latitude">
                  <el-input
                    type="number"
                    v-model="data.latitude"
                    :disabled="readonly" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="荣誉称号" prop="titleOfHonor">
                  <el-input
                    v-model="data.titleOfHonor"
                    :disabled="readonly"
                    maxlength="200" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="形象标识" prop="imageIdentification">
                  <el-input
                    v-model="data.imageIdentification"
                    :disabled="readonly"
                    maxlength="200" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="政府驻地" prop="theGovernmentPost">
                  <el-input
                    v-model="data.theGovernmentPost"
                    :disabled="readonly"
                    maxlength="200" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="管理机构名称" prop="managementOrganizationName">
                  <el-input
                    v-model="data.managementOrganizationName"
                    :disabled="readonly"
                    maxlength="50" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="管理机构地址" prop="regulatorsAddress">
                  <el-input
                    v-model="data.regulatorsAddress"
                    :disabled="readonly"
                    maxlength="200" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="管理机构电话" prop="managementAgencyTelephone">
                  <el-input v-model="data.managementAgencyTelephone" :disabled="readonly" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="广告语" prop="ad">
                  <el-input
                    v-model="data.ad"
                    :disabled="readonly"
                    maxlength="200" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="旅游口号" prop="tourismSlogan">
                  <el-input
                    v-model="data.tourismSlogan"
                    :disabled="readonly"
                    maxlength="200" />
                </el-form-item>
              </el-col>
            </el-row>
          </el-tab-pane>

          <el-tab-pane label="目的地简介">
            <el-row>
              <el-col :span="12">
                <el-form-item label="概述" prop="anOverviewOfThe">
                  <edit v-model="data.anOverviewOfThe" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="历史沿革" prop="historicalEvolution">
                  <el-input
                    v-model="data.historicalEvolution"
                    :disabled="readonly"
                    maxlength="200" />
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="12">
                <el-form-item label="气候特点" prop="theClimateCharacteristics">
                  <el-input
                    v-model="data.theClimateCharacteristics"
                    :disabled="readonly"
                    maxlength="200" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="最佳旅游时间" prop="theBestTravelTime">
                  <el-input
                    v-model="data.theBestTravelTime"
                    :disabled="readonly"
                    maxlength="200" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="旅游资源" prop="tourismResources">
                  <el-input
                    v-model="data.tourismResources"
                    :disabled="readonly"
                    maxlength="50" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="交通概况" prop="theTrafficSituation">
                  <el-input v-model="data.theTrafficSituation" :disabled="readonly" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="旅游禁忌" prop="tourismTaboo">
                  <el-input
                    v-model="data.tourismTaboo"
                    :disabled="readonly"
                    maxlength="200" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="资源矿产" prop="mineralResources">
                  <el-input
                    v-model="data.mineralResources"
                    :disabled="readonly"
                    maxlength="200" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="经济发展" prop="theEconomicDevelopment">
                  <el-input
                    v-model="data.theEconomicDevelopment"
                    :disabled="readonly"
                    maxlength="200" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="科教文化" prop="scienceAndEducationCulture">
                  <el-input
                    v-model="data.scienceAndEducationCulture"
                    :disabled="readonly"
                    maxlength="200" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="宗教民俗" prop="religiousFolk">
                  <el-input
                    v-model="data.religiousFolk"
                    :disabled="readonly"
                    maxlength="200" />
                </el-form-item>
              </el-col>
            </el-row>
          </el-tab-pane>

          <el-tab-pane label="公共服务信息">
            <el-row>
              <el-col :span="12">
                <el-form-item label="新浪微博" prop="weibo">
                  <el-input
                    v-model="data.weibo"
                    :disabled="readonly"
                    maxlength="200" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="腾讯微博" prop="tencentWeibo">
                  <el-input
                    v-model="data.tencentWeibo"
                    :disabled="readonly"
                    maxlength="200" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="微信公众号" prop="weChatSubscriptionNumber">
                  <el-input
                    v-model="data.weChatSubscriptionNumber"
                    :disabled="readonly"
                    maxlength="200" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="微信公众账号二维码"
                              label-width="140px"
                              prop="weChatPublicAccountQrCode">
                  <qr-code-editor v-model="data.weChatPublicAccountQrCode" :disabled="readonly" />
                  <!--<el-input size='mini' v-model="data.weChatPublicAccountQrCode" :disabled="readonly" maxlength="200">-->
                  <!--<template slot="append">-->
                  <!--<div @click="createQrcoed(data.weChatPublicAccountQrCode)">二维码</div>-->
                  <!--</template>-->
                  <!--</el-input>-->
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="政务网网址" prop="governmentWebSite">
                  <el-input
                    v-model="data.governmentWebSite"
                    :disabled="readonly"
                    maxlength="200" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="旅游资讯网网址"
                              label-width="140px"
                              prop="touristInformationWebSite">
                  <el-input
                    v-model="data.touristInformationWebSite"
                    :disabled="readonly"
                    maxlength="200" />
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="12">
                <el-form-item label="在线投诉地址" prop="onlineComplaintsAddress">
                  <el-input
                    v-model="data.onlineComplaintsAddress"
                    :disabled="readonly"
                    maxlength="50" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="投诉电话" prop="complaints">
                  <el-input
                    v-model="data.complaints"
                    :disabled="readonly"
                    maxlength="20" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="传真" prop="fax">
                  <el-input
                    v-model="data.fax"
                    :disabled="readonly"
                    maxlength="50" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="邮政编码" prop="zipCode">
                  <el-input
                    v-model="data.zipCode"
                    :disabled="readonly"
                    maxlength="20" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="Email" prop="email">
                  <el-input
                    v-model="data.email"
                    :disabled="readonly"
                    maxlength="20" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="最佳旅游时间" prop="theBestTravelTime">
                  <el-input
                    v-model="data.theBestTravelTime"
                    :disabled="readonly"
                    maxlength="200" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="周边信息" prop="surroundingInformation">
                  <el-input
                    v-model="data.surroundingInformation"
                    :disabled="readonly"
                    maxlength="200" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="旅游咨询中心" prop="tourismInformationCenter">
                  <el-input
                    v-model="data.tourismInformationCenter"
                    :disabled="readonly"
                    maxlength="200" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="旅游集散中心" prop="tourismHub">
                  <el-input
                    v-model="data.tourismHub"
                    :disabled="readonly"
                    maxlength="200" />
                </el-form-item>
              </el-col>
            </el-row>
          </el-tab-pane>
          <el-tab-pane label="多媒体信息">
            <el-row>
              <el-col :span="24">
                <img-source v-model="data.images" :disabled="readonly" />
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="24">
                <video-resource v-model="data.videos" :disabled="readonly" />
              </el-col>
            </el-row>
            <!--<el-row>-->
            <!--<el-col :span="24">-->
            <!--<audio-resource v-model="data.audios" :disabled="readonly" />-->
            <!--</el-col>-->
            <!--</el-row>-->
            <!--<el-row>-->
            <!--<el-col :span="24">-->
            <!--<virtual-material v-model="data.virtualMaterials" :disabled="readonly" />-->
            <!--</el-col>-->
            <!--</el-row>-->
          </el-tab-pane>
        </el-tabs>
      </el-form>
    </el-main>
  </el-container>
</template>
<script>
  import BaseForm from '../../.common/BaseForm'
  import { Component, Prop, Watch, Mixins } from 'vue-property-decorator'
  import { namespace } from 'vuex-class'
  import ImgSource from '../../.common/ImgResource'
  import AudioResource from '../../.common/audioResource'
  import VideoResource from '../../.common/videoResource'
  import VirtualMaterial from '../../.common/virtualMaterial'
  import qrCodeEditor from '../../.common/QrCodeEditor'
  import * as myRules from '../../../commonjs/rule'

  const tourismPurposeModule = namespace('data/tourismPurpose')
  @Component({
    components: {
      ImgSource,
      AudioResource,
      VideoResource,
      VirtualMaterial,
      qrCodeEditor
    }
  })
  export default class TourismPurpose extends Mixins(BaseForm) {
    @Prop({default: () => 'new'})
    id

    data = {}

    // 区划下拉选的属性配置
    areaProps = {
      children: 'children',
      label: 'name',
      value: 'code'
    }

    readonly = true

    get rules () {
      return {
        chineseFullName: [{
          required: true,
          message: '中文全称不能为空',
          trigger: 'blur'
        }],
        destinationCategory: [{
          required: true,
          message: '目的地类别不能为空',
          trigger: 'blur'
        }],
        area: [{
          required: true,
          message: '所属地区不能为空',
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
        touristInformationWebSite: [{
          required: true,
          message: '旅游资讯网网址不能为空',
          trigger: 'blur'
        }],
        fax: [{
          required: true,
          message: '传真不能为空',
          trigger: 'blur'
        }],
        email: [{
          required: true,
          message: 'Email不能为空',
          trigger: 'blur'
        }, {
          validator: myRules.validatEmail,
          msg: 'Email格式不正确',
          trigger: 'blur'
        }],
        complaints: [{
          validator: myRules.validatPhone,
          msg: '投诉电话格式不正确',
          trigger: 'blur'
        }],
        zipCode: [
          {
            validator: myRules.validatPostcode,
            msg: '邮编格式不正确',
            trigger: 'blur'
          }
        ]
      }
    }

    @tourismPurposeModule.Action('save')
    saveData

    @tourismPurposeModule.Action('get')
    getData

    @tourismPurposeModule.Action('update')
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

    @Watch('data.anOverviewOfThe')
    change () {
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
