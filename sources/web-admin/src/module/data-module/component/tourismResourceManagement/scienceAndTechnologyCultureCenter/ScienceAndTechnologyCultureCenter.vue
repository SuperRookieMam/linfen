<!--科技文化馆-->
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
                  <el-cascader v-model="data.regionCode"
                               expand-trigger="hover"
                               :options="userRegionTree"
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
                <el-form-item label="地址" prop="address">
                  <el-input
                    v-model="data.address"
                    :disabled="readonly"
                    maxlength="200" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="Logo" prop="logo">
                  <el-input
                    v-model="data.logo"
                    :disabled="readonly"
                    maxlength="200" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="关键字" prop="keywords">
                  <el-input
                    v-model="data.keywords"
                    :disabled="readonly"
                    maxlength="200" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="荣誉称号" prop="titleOfHonor">
                  <el-input
                    v-model="data.titleOfHonor"
                    :disabled="readonly"
                    maxlength="100" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="建设时间" prop="theConstructionTime">
                  <el-input
                    v-model="data.theConstructionTime"
                    :disabled="readonly"
                    maxlength="50" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="占地面积" prop="coversOfArea">
                  <el-input
                    v-model="data.coversOfArea"
                    :disabled="readonly"
                    maxlength="50" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="场馆类型" prop="venueType">
                  <!--<el-input size='mini' v-model="data.venueType" :disabled="readonly"  />-->
                  <el-select v-model="data.venueType" :disabled="readonly" placeholder="场馆类型">
                    <el-option v-for="item in venueTypes"
                               :key="item.value"
                               :label="item.label"
                               :value="item.value" />
                  </el-select>
                </el-form-item>
              </el-col>
            </el-row>
          </el-tab-pane>

          <el-tab-pane label="交通信息">
            <el-row>
              <el-col :span="12">
                <el-form-item label="交通方式" prop="modeOfTransport">
                  <!--<el-input size='mini' v-model="data.modeOfTransport" :disabled="readonly"  />-->
                  <el-select v-model="data.modeOfTransport" :disabled="readonly" placeholder="交通方式">
                    <el-option v-for="item in modeOfTransports"
                               :key="item.value"
                               :label="item.label"
                               :value="item.value" />
                  </el-select>
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="交通描述" prop="trafficDescription">
                  <edit v-model="data.trafficDescription" />
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
                    maxlength="20" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="预订电话" prop="reservationPhone">
                  <el-input
                    v-model="data.reservationPhone"
                    :disabled="readonly"
                    maxlength="200" />
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
                    maxlength="50" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="最大承载量" prop="largestCapacity">
                  <el-input
                    v-model="data.largestCapacity"
                    :disabled="readonly"
                    maxlength="200" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="游览时长" prop="theVisitingTime">
                  <el-input
                    v-model="data.theVisitingTime"
                    :disabled="readonly"
                    maxlength="200" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="总停车位" prop="totalParkingSpaces">
                  <el-input
                    v-model="data.totalParkingSpaces"
                    :disabled="readonly"
                    maxlength="200" />
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
                    maxlength="200" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="支付方式" prop="methodOfPayment">
                  <!--<el-input size='mini' v-model="data.methodOfPayment" :disabled="readonly"  />-->
                  <el-select v-model="data.methodOfPayment" :disabled="readonly" placeholder="支付方式">
                    <el-option v-for="item in methodOfPayments"
                               :key="item.value"
                               :label="item.label"
                               :value="item.value" />
                  </el-select>
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="旅游提示" prop="travelTips">
                  <el-input v-model="data.travelTips" :disabled="readonly" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="适合人群" prop="suitsTheCrowd">
                  <el-input
                    v-model="data.suitsTheCrowd"
                    :disabled="readonly"
                    maxlength="200" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="周边信息" prop="surroundingInformation">
                  <edit v-model="data.surroundingInformation" />
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

          <el-tab-pane label="旅游厕所" name="touristToilets" v-if="id!=='new'">
            <tourist-toilets
              :url="AllUrl.trivalEnterprise.scienceAndTechnologyCultureCenters+'/'+data.id"
              :set-return-data="toiletReturndata"
              :success-save="toiletSuccessSave"
              :is-search="false" />
          </el-tab-pane>
          <el-tab-pane label="停车场" name="parkingLots" v-if="id!=='new'">
            <parking-lots
              :url="AllUrl.trivalEnterprise.scienceAndTechnologyCultureCenters+'/'+data.id"
              :set-return-data="parkingLotsReturndata"
              :success-save="parkingLotsSuccessSave"
              :is-search="false" />
          </el-tab-pane>
        </el-tabs>
      </el-form>
    </el-main>
  </el-container>
</template>
<script>
  import BaseTable from '../../.common/BaseTable'
  import { Component, Prop, Mixins } from 'vue-property-decorator'
  import ImgSource from '../../.common/ImgResource'
  import AudioResource from '../../.common/audioResource'
  import VideoResource from '../../.common/videoResource'
  import VirtualMaterial from '../../.common/virtualMaterial'
  import qrCodeEditor from '../../.common/QrCodeEditor'
  import * as myRules from '../../../commonjs/rule'
  import TouristToilets from '../../publicSource/touristToilet/Index'
  import ParkingLots from '../../publicSource/parkingLot/Index'

  @Component({
    components: {
      ImgSource,
      AudioResource,
      VideoResource,
      VirtualMaterial,
      qrCodeEditor,
      ParkingLots,
      TouristToilets
    }
  })
  export default class ScienceAndTechnologyCultureCenter extends Mixins(BaseTable) {
    @Prop({ default: () => 'new' })
    id

    toiletReturndata (returnData) {
      return returnData.touristToilets
    }

    toiletSuccessSave (returnData) {
      this.data.touristToilets.push(returnData)
      this.saveRef()
    }

    parkingLotsReturndata (returnData) {
      return returnData.parkingLots
    }

    parkingLotsSuccessSave (returnData) {
      this.data.parkingLots.push(returnData)
      this.saveRef()
    }

    getUrl () {
      return this.AllUrl.trivalEnterprise.scienceAndTechnologyCultureCenters
    }

    methodOfPayments = [{
      value: '现金支付',
      label: '现金支付'
    }, {
      value: '银行卡支付',
      label: '银行卡支付'
    }, {
      value: '微信支付',
      label: '微信支付'
    }, {
      value: '支付宝支付',
      label: '支付宝支付'
    }]

    modeOfTransports = [{
      value: '旅游专线',
      label: '旅游专线'
    }, {
      value: '航空',
      label: '航空'
    }, {
      value: '铁路',
      label: '铁路'
    }, {
      value: '公路',
      label: '公路'
    }, {
      value: '水运',
      label: '水运'
    }, {
      value: '公共交通',
      label: '公共交通'
    }, {
      value: '自驾车',
      label: '自驾车'
    }, {
      value: '其他',
      label: '其他'
    }]

    venueTypes = [{
      value: '历史类',
      label: '历史类'
    }, {
      value: '艺术类',
      label: '艺术类'
    }, {
      value: '科学与技术类',
      label: '科学与技术类'
    }, {
      value: '综合类',
      label: '综合类'
    }]

    get rules () {
      return {
        regionCode: [{
          required: true,
          message: '所在区域不能为空',
          trigger: 'blur'
        }],
        chineseFullName: [{
          required: true,
          message: '不能为空',
          trigger: 'blur'
        }],
        longitude: [{
          required: true,
          message: '经度不能为空',
          trigger: 'blur'
        }, {
          validator: myRules.validatLength,
          maxlength: 20,
          msg: '长度不能超过20',
          trigger: 'blur'
        }],
        latitude: [{
          required: true,
          message: '纬度不能为空',
          trigger: 'blur'
        }, {
          validator: myRules.validatLength,
          maxlength: 20,
          msg: '长度不能超过20',
          trigger: 'blur'
        }],
        area: [{
          required: true,
          message: '不能为空',
          trigger: 'blur'
        }],
        address: [{
          required: true,
          message: '不能为空',
          trigger: 'blur'
        }],
        emergencyContactPhoneNumber: [{
          validator: myRules.validatPhone,
          msg: '应急电话格式不对',
          trigger: 'blur'
        }],
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
        }]
      }
    }

    // 区划下拉选的属性配置
    areaProps = {
      children: 'children',
      label: 'name',
      value: 'code'
    }
  }
</script>
