<!--新兴业态-->
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
                <el-form-item label="所在区域" prop="regionCode">
                  <el-cascader v-model="regionCode"
                               expand-trigger="hover"
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
              <!--<el-col :span="12">-->
              <!--<el-form-item label="地理位置" prop="geoPosition" >-->
              <!--<el-input size='mini' v-model="data.geoPosition" :disabled="readonly" />-->
              <!--</el-form-item>-->
              <!--</el-col>-->
            </el-row>
            <!--<el-row>-->
            <!--<el-col :span="12">-->
            <!--<el-form-item label="经度" prop="longitude" >-->
            <!--<el-input type="number" v-model="data.longitude" :disabled="readonly" />-->
            <!--</el-form-item>-->
            <!--</el-col>-->
            <!--<el-col :span="12">-->
            <!--<el-form-item label="纬度" prop="latitude" >-->
            <!--<el-input type="number" v-model="data.latitude" :disabled="readonly" />-->
            <!--</el-form-item>-->
            <!--</el-col>-->
            <!--</el-row>-->
            <el-row>
              <el-col :span="12">
                <el-form-item label="地址" prop="address">
                  <el-input v-model="data.address" :disabled="readonly" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="类型" prop="type">
                  <!--<el-input size='mini' v-model="data.type" :disabled="readonly" />-->
                  <el-select v-model="data.type" :disabled="readonly" placeholder="类型">
                    <el-option v-for="item in types"
                               :key="item.value"
                               :label="item.label"
                               :value="item.value" />
                  </el-select>
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="Logo" prop="logo">
                  <el-input v-model="data.logo" :disabled="readonly" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="关键字" prop="keywords">
                  <el-input
                    v-model="data.keywords"
                    :disabled="readonly"
                    maxlength="200" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="荣誉称号" prop="titleOfHonor">
                  <el-input
                    v-model="data.titleOfHonor"
                    :disabled="readonly"
                    maxlength="150" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="简介" prop="introduction">
                  <edit v-model="data.introduction" />
                </el-form-item>
              </el-col>
            </el-row>
          </el-tab-pane>

          <el-tab-pane label="组织机构数据">
            <el-row>
              <el-col :span="12">
                <el-form-item label="注册日期" prop="registrationDate">
                  <el-input
                    v-model="data.registrationDate"
                    :disabled="readonly"
                    maxlength="50" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="工商注册全称" prop="industrialAndCommercialRegistrationName">
                  <el-input
                    v-model="data.industrialAndCommercialRegistrationName"
                    :disabled="readonly"
                    maxlength="50" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="营业执照号码" prop="businessLicenseNumber">
                  <el-input
                    v-model="data.businessLicenseNumber"
                    :disabled="readonly"
                    maxlength="50" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="企业工商字号" prop="companyOfIndustryAndCommerce">
                  <el-input
                    v-model="data.companyOfIndustryAndCommerce"
                    :disabled="readonly"
                    maxlength="50" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="组织机构代码" prop="organizationCode">
                  <el-input
                    v-model="data.organizationCode"
                    :disabled="readonly"
                    maxlength="50" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="统一社会信用代码" label-width="140px" prop="unifiedSocialCreditCode">
                  <el-input
                    v-model="data.unifiedSocialCreditCode"
                    :disabled="readonly"
                    maxlength="50" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="法人代表" prop="legalRepresentative">
                  <el-input
                    v-model="data.legalRepresentative"
                    :disabled="readonly"
                    maxlength="50" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="经营负责人" prop="operationsManagers">
                  <el-input
                    v-model="data.operationsManagers"
                    :disabled="readonly"
                    maxlength="50" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="应急联系人" prop="emergencyContact">
                  <el-input
                    v-model="data.emergencyContact"
                    :disabled="readonly"
                    maxlength="50" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="应急联系电话" prop="emergencyContactPhoneNumber">
                  <el-input
                    v-model="data.emergencyContactPhoneNumber"
                    :disabled="readonly"
                    maxlength="20" />
                </el-form-item>
              </el-col>
            </el-row>
          </el-tab-pane>

          <el-tab-pane label="交通数据">
            <el-row>
              <el-col :span="12">
                <el-form-item label="交通方式" prop="modeOfTransport">
                  <el-input
                    v-model="data.modeOfTransport"
                    :disabled="readonly"
                    maxlength="50" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="交通描述" prop="trafficDescription">
                  <!-- <el-input size='mini' v-model="data.trafficDescription" :disabled="readonly" maxlength="50" />-->
                  <edit v-model="data.introduction" />
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
                <el-form-item label="微信公众账号" prop="weChatPublicAccount">
                  <el-input
                    v-model="data.weChatPublicAccount"
                    :disabled="readonly"
                    maxlength="200" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="微信公众账号二维码" label-width="140px" prop="weChatPublicAccountQrCode">
                  <qr-code-editor v-model="data.weChatPublicAccountQrCode" :disabled="readonly" maxlength="200" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="官网网站" prop="officialWebSite">
                  <el-input
                    v-model="data.officialWebSite"
                    :disabled="readonly"
                    maxlength="200" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="微网站" prop="microSite">
                  <el-input
                    v-model="data.microSite"
                    :disabled="readonly"
                    maxlength="200" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="安卓版APP下载地址" label-width="140px" prop="androidAppDownloadUrl">
                  <el-input
                    v-model="data.androidAppDownloadUrl"
                    :disabled="readonly"
                    maxlength="200" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="苹果版APP下载地址" label-width="140px" prop="iosAppDownloadUrl">
                  <el-input
                    v-model="data.iosAppDownloadUrl"
                    :disabled="readonly"
                    maxlength="200" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="投诉电话" prop="complaints">
                  <el-input
                    v-model="data.complaints"
                    :disabled="readonly"
                    maxlength="20" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="在线投诉地址" prop="onlineComplaintsAddress">
                  <el-input
                    v-model="data.onlineComplaintsAddress"
                    :disabled="readonly"
                    maxlength="200" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="救援电话" prop="rescueTheTelephone">
                  <el-input
                    v-model="data.rescueTheTelephone"
                    :disabled="readonly"
                    maxlength="200" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="预订电话" prop="reservationPhone">
                  <el-input
                    v-model="data.reservationPhone"
                    :disabled="readonly"
                    maxlength="20" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="客服电话" prop="customerServiceTelephone">
                  <el-input
                    v-model="data.customerServiceTelephone"
                    :disabled="readonly"
                    maxlength="20" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="传真" prop="fax">
                  <el-input
                    v-model="data.fax"
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
                <el-form-item label="开放时间" prop="openTime">
                  <el-input
                    v-model="data.openTime"
                    :disabled="readonly"
                    maxlength="200" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="最大承载量" prop="largestCapacity">
                  <el-input v-model="data.largestCapacity" :disabled="readonly" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="游览时长" prop="theVisitingTime">
                  <el-input
                    v-model="data.theVisitingTime"
                    :disabled="readonly"
                    maxlength="20" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="总停车位" prop="totalParkingSpaces">
                  <el-input
                    v-model="data.totalParkingSpaces"
                    :disabled="readonly"
                    maxlength="20" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="金融网点" prop="financialNetwork">
                  <el-input
                    v-model="data.financialNetwork"
                    :disabled="readonly"
                    maxlength="200" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="支持卡种" prop="supportOfCard">
                  <el-input
                    v-model="data.supportOfCard"
                    :disabled="readonly"
                    maxlength="50" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="支付方式" prop="methodOfPayment">
                  <el-input
                    v-model="data.methodOfPayment"
                    :disabled="readonly"
                    maxlength="50" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="建议游玩季节" prop="recommendedPlaySeason">
                  <el-input
                    v-model="data.recommendedPlaySeason"
                    :disabled="readonly"
                    maxlength="200" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="旅游提示" prop="travelTips">
                  <!--   <el-input size='mini' v-model="data.travelTips" :disabled="readonly" />-->
                  <edit v-model="data.travelTips" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="适合人群" prop="suitsTheCrowd">
                  <el-input
                    v-model="data.suitsTheCrowd"
                    :disabled="readonly"
                    maxlength="200" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="旅游活动" prop="tourismActivities">
                  <el-input
                    v-model="data.tourismActivities"
                    :disabled="readonly"
                    maxlength="200" />
                </el-form-item>
              </el-col>
            </el-row>
          </el-tab-pane>

          <el-tab-pane label="旅游厕所" v-if="id!=='new'">
            <reference-form :pdata="data"
                            refname="EmergingFormats"
                            fieldname="touristToilets"
                            route-name="emergingFormatTourismToilet"
                            jump-name="touristToilets"
                            :table-mesg="touristToilet" />
          </el-tab-pane>

          <el-tab-pane label="停车场" v-if="id!=='new'">
            <reference-form :pdata="data"
                            refname="EmergingFormats"
                            fieldname="parkingLots"
                            route-name="emergingFormatParkingLot"
                            jump-name="parkingLots"
                            :table-mesg="parkingLot" />
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
  import { Component, Prop, Mixins } from 'vue-property-decorator'
  import { namespace } from 'vuex-class'
  import qrCodeEditor from '../../.common/QrCodeEditor'
  import * as myRules from '../../../commonjs/rule'
  import ImgSource from '../../.common/ImgResource'
  import AudioResource from '../../.common/audioResource'
  import VideoResource from '../../.common/videoResource'
  import VirtualMaterial from '../../.common/virtualMaterial'
  import ReferenceForm from '../../.common/ReferenceForm'

  const emergingFormatsModule = namespace('data/emergingFormats')
  const regionModule = namespace('data/region')
  @Component({
    components: {
      ImgSource,
      AudioResource,
      VideoResource,
      VirtualMaterial,
      qrCodeEditor,
      ReferenceForm
    }
  })
  export default class EmergingFormats extends Mixins(BaseForm) {
    @Prop({default: () => 'new'})
    id

    data = {}

    readonly = true

    parkingLot = {
      searchNames: ['chineseFullName', 'theParkingLotType', 'numberOfParking'],
      trMsg: [
        {label: '中文名称', prop: 'chineseFullName'},
        {label: '所在区域', prop: 'areaName'},
        {label: '车位类型', prop: 'carType'},
        {label: '停车场类型', prop: 'theParkingLotType'},
        {label: '车位数量', prop: 'numberOfParking'}
      ]
    }

    touristToilet = {
      searchNames: ['fullname', 'touristToiletGrade'],
      trMsg: [
        {label: '中文名称', prop: 'fullname'},
        {label: '所在区域', prop: 'areaName'},
        {label: '厕所等级', prop: 'touristToiletGrade'},
        {label: '收费标准', prop: 'charges'}
      ]
    }

    types = [{
      value: '高尔夫',
      label: '高尔夫'
    }, {
      value: '滑雪场',
      label: '滑雪场'
    }, {
      value: '马术赛马',
      label: '马术赛马'
    }, {
      value: '其他',
      label: '其他'
    }]

    get rules () {
      return {
        reservationPhone: [{
          validator: myRules.validatPhone,
          msg: '预订电话格式不对',
          trigger: 'blur'
        }],
        customerServiceTelephone: [{
          validator: myRules.validatPhone,
          msg: '客服电话格式不对',
          trigger: 'blur'
        }],
        email: [{
          validator: myRules.validatEmail,
          msg: 'Email格式不对',
          trigger: 'blur'
        }],
        chineseFullName: [{
          required: true,
          message: '中文全称不能为空',
          trigger: 'blur'
        }],
        area: [{
          required: true,
          message: '所在区域不能为空',
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
        type: [{
          required: true,
          message: '类型不能为空',
          trigger: 'blur'
        }]
      }
    }

    @emergingFormatsModule.Action('save')
    saveData

    @emergingFormatsModule.Action('get')
    getData

    @emergingFormatsModule.Action('update')
    updateData

    // 区划下拉选的属性配置
    areaProps = {
      children: 'children',
      label: 'name',
      value: 'code'
    }

    @regionModule.Getter('userRegionTree')
    regions

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
