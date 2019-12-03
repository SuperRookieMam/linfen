<!--住宿场所-->
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
              @click="readonly=false "
              size="mini"
              v-if="readonly">
              编辑
            </el-button>
            <el-button @click="goBack()" size="mini">取消</el-button>
            <el-button
              type="primary"
              @click="save('accommodation')"
              size="mini"
              v-if="!readonly">
              保存
            </el-button>
          </el-col>
        </el-row>
        <el-tabs v-model="activeName">
          <el-tab-pane label="基本信息" name="base">
            <el-row>
              <el-col :span="12">
                <el-form-item label="中文全称" prop="chineseFullName">
                  <el-input v-model="data.chineseFullName" :disabled="readonly" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="中文简称" prop="chineseShortName">
                  <el-input v-model="data.chineseShortName" :disabled="readonly" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="拼音名称" prop="pinyinName">
                  <el-input v-model="data.pinyinName" :disabled="readonly" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="英文名称" prop="englishName">
                  <el-input v-model="data.englishName" :disabled="readonly" />
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
                <el-form-item label="等级" prop="level">
                  <!--<el-input size='mini' v-model="data.level" :disabled="readonly" />-->
                  <el-select v-model="data.level" :disabled="readonly" placeholder="等级">
                    <el-option v-for="item in levels"
                               :key="item.value"
                               :label="item.label"
                               :value="item.value" />
                  </el-select>
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="提供菜系" prop="provideCuisines">
                  <!-- <el-input size='mini' v-model="data.provideCuisines" :disabled="readonly" />-->
                  <el-select v-model="data.provideCuisines" :disabled="readonly" placeholder="提供菜系">
                    <el-option v-for="item in provideCuisiness"
                               :key="item.value"
                               :label="item.label"
                               :value="item.value" />
                  </el-select>
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="企业Logo" prop="corporateLogo">
                  <el-input v-model="data.corporateLogo" :disabled="readonly" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="关键字" prop="keywords">
                  <el-input v-model="data.keywords" :disabled="readonly" />
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="12">
                <el-form-item label="标签" prop="label">
                  <el-input v-model="data.label" :disabled="readonly" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="评分" prop="scored">
                  <el-input type="number" v-model="data.scored" :disabled="readonly" />
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="12">
                <el-form-item label="最低价格" prop="minPrice">
                  <el-input type="number" v-model="data.minPrice" :disabled="readonly" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="联系人" prop="contactUser">
                  <el-input v-model="data.contactUser" :disabled="readonly" />
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
          <el-tab-pane label="组织机构信息" name="zuzhi">
            <el-row>
              <el-col :span="12">
                <el-form-item label="成立日期" prop="setUpTheDate">
                  <el-input v-model="data.setUpTheDate" :disabled="readonly" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="工商注册全称" prop="industrialAndCommercialRegistrationName">
                  <el-input v-model="data.industrialAndCommercialRegistrationName" :disabled="readonly" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="营业执照号码" prop="businessLicenseNumber">
                  <el-input v-model="data.businessLicenseNumber" :disabled="readonly" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="组织机构代码" prop="organizationCode">
                  <el-input v-model="data.organizationCode" :disabled="readonly" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="统一社会信用代码" label-width="140px" prop="unifiedSocialCreditCode">
                  <el-input v-model="data.unifiedSocialCreditCode" :disabled="readonly" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="法人代表" prop="legalRepresentative">
                  <el-input v-model="data.legalRepresentative" :disabled="readonly" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="经营负责人" prop="operationsManagers">
                  <el-input v-model="data.operationsManagers" :disabled="readonly" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="连锁经营情况" prop="chainOperationSituation">
                  <el-input v-model="data.chainOperationSituation" :disabled="readonly" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="所属行业" prop="subordinateToTheIndustry">
                  <el-input v-model="data.subordinateToTheIndustry" :disabled="readonly" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="管理集团" prop="managementGroup">
                  <el-input v-model="data.managementGroup" :disabled="readonly" />
                </el-form-item>
              </el-col>
            </el-row>
          </el-tab-pane>

          <el-tab-pane label="交通信息" name="traffic">
            <el-row>
              <el-col :span="12">
                <el-form-item label="交通方式" prop="modeOfTransport">
                  <el-input v-model="data.modeOfTransport" :disabled="readonly" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="交通描述" prop="trafficDescription">
                  <edit v-model="data.trafficDescription" />
                </el-form-item>
              </el-col>
            </el-row>
          </el-tab-pane>

          <el-tab-pane label="公共服务信息" name="pablic">
            <el-row>
              <el-col :span="12">
                <el-form-item label="新浪微博" prop="weibo">
                  <el-input v-model="data.weibo" :disabled="readonly" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="腾讯微博" prop="tencentWeibo">
                  <el-input v-model="data.tencentWeibo" :disabled="readonly" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="微信公众账号" prop="weChatPublicAccount">
                  <el-input v-model="data.weChatPublicAccount" :disabled="readonly" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="微信公众账号二维码" label-width="140px" prop="weChatPublicAccountQrCode">
                  <qr-code-editor v-model="data.weChatPublicAccountQrCode" :disabled="readonly" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="官网地址" prop="theWebsiteAddress">
                  <el-input v-model="data.theWebsiteAddress" :disabled="readonly" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="微网站" prop="microSite">
                  <el-input v-model="data.microSite" :disabled="readonly" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="安卓版APP下载地址" label-width="140px" prop="androidAppDownloadUrl">
                  <el-input v-model="data.androidAppDownloadUrl" :disabled="readonly" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="苹果版APP下载地址" label-width="140px" prop="iosAppDownloadUrl">
                  <el-input v-model="data.iosAppDownloadUrl" :disabled="readonly" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="开业时间" prop="theOpeningTime">
                  <el-input v-model="data.theOpeningTime" :disabled="readonly" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="最后一次装修时间" label-width="140px" prop="theLastTimeToDecorate">
                  <el-input v-model="data.theLastTimeToDecorate" :disabled="readonly" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="总客房数" prop="theTotalNumberOfRooms">
                  <el-input v-model="data.theTotalNumberOfRooms" :disabled="readonly" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="总床位数" prop="totalBeds">
                  <el-input v-model="data.totalBeds" :disabled="readonly" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="投诉电话" prop="complaints">
                  <el-input v-model="data.complaints" :disabled="readonly" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="在线投诉地址" prop="onlineComplaintsAddress">
                  <el-input v-model="data.onlineComplaintsAddress" :disabled="readonly" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="咨询电话" prop="consultingTheTelephone">
                  <el-input v-model="data.consultingTheTelephone" :disabled="readonly" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="传真" prop="fax">
                  <el-input v-model="data.fax" :disabled="readonly" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="Email" prop="email">
                  <el-input v-model="data.email" :disabled="readonly" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="支持卡种" prop="supportOfCard">
                  <el-input v-model="data.supportOfCard" :disabled="readonly" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="支付方式" prop="methodOfPayment">
                  <!--<el-input size='mini' v-model="data.methodOfPayment" :disabled="readonly" />-->
                  <el-select v-model="data.methodOfPayment" :disabled="readonly" placeholder="支付方式">
                    <el-option v-for="item in methodOfPayments"
                               :key="item.value"
                               :label="item.label"
                               :value="item.value" />
                  </el-select>
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="宣传语" prop="slogan">
                  <el-input v-model="data.slogan" :disabled="readonly" />
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
                <el-form-item label="会议设施和服务" prop="meetingFacilitiesAndServices">
                  <edit v-model="data.meetingFacilitiesAndServices" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="餐饮设施和服务" prop="cateringFacilitiesAndServices">
                  <edit v-model="data.cateringFacilitiesAndServices" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="娱乐设施和服务" prop="entertainmentFacilitiesAndServices">
                  <edit v-model="data.entertainmentFacilitiesAndServices" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="商务设施和服务" prop="businessFacilitiesAndServices">
                  <edit v-model="data.businessFacilitiesAndServices" />
                </el-form-item>
              </el-col>
            </el-row>
          </el-tab-pane>

          <el-tab-pane label="停车场" name="parking" v-if="id!=='new'">
            <parking-lots
              :url="AllUrl.trivalEnterprise.accommodations+'/'+data.id"
              :set-return-data="parkingLotsReturndata"
              :success-save="parkingLotsSuccessSave"
              :is-search="false" />
          </el-tab-pane>
          <el-tab-pane label="房间信息" name="room" v-if="id!=='new'">
            <room-infos
              :url="AllUrl.trivalEnterprise.accommodations+'/'+data.id"
              :set-return-data="roomInfoReturndata"
              :success-save="roomInfoSuccessSave"
              :is-search="false" />
          </el-tab-pane>

          <el-tab-pane label="多媒体信息" name="media">
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
  import * as myrules from '../../../commonjs/rule'
  import RoomInfos from '../RoomInfo/RoomInfos'
  import parkingLots from '../../publicSource/parkingLot/Index'

  @Component({
    components: {
      ImgSource,
      AudioResource,
      VideoResource,
      VirtualMaterial,
      qrCodeEditor,
      // ReferenceForm
      parkingLots,
      RoomInfos
    }
  })
  export default class Accommodation extends Mixins(BaseTable) {
    @Prop({ default: () => 'new' })
    id

    parkingLotsReturndata (returnData) {
      return returnData.parkingLots
    }

    roomInfoReturndata (returnData) {
      return returnData.roomInfos
    }

    parkingLotsSuccessSave (returnData) {
      this.data.parkingLots.push(returnData)
      this.saveRef()
    }

    roomInfoSuccessSave (returnData) {
      this.data.roomInfos.push(returnData)
      this.saveRef()
    }

    getUrl () {
      return this.AllUrl.trivalEnterprise.accommodations
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

    provideCuisiness = [{
      value: '鲁菜',
      label: '鲁菜'
    }, {
      value: '川菜',
      label: '川菜'
    }, {
      value: '粤菜',
      label: '粤菜'
    }, {
      value: '苏菜',
      label: '苏菜'
    }, {
      value: '浙菜',
      label: '浙菜'
    }, {
      value: '闽菜',
      label: '闽菜'
    }, {
      value: '湘菜',
      label: '湘菜'
    }, {
      value: '徽菜',
      label: '徽菜'
    }, {
      value: '客家菜',
      label: '客家菜'
    }, {
      value: '清真菜',
      label: '清真菜'
    }, {
      value: '外国菜系',
      label: '外国菜系'
    }, {
      value: '其他',
      label: '其他'
    }]

    levels = [{
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

    types = [{
      value: '星级宾馆饭店 ',
      label: '星级宾馆饭店 '
    }, {
      value: '普通宾馆饭店',
      label: '普通宾馆饭店'
    }, {
      value: '经济酒店',
      label: '经济酒店'
    }, {
      value: '主题酒店',
      label: '主题酒店'
    }, {
      value: '家庭宾馆',
      label: '家庭宾馆'
    }, {
      value: '招待所',
      label: '招待所'
    }, {
      value: '度假中心',
      label: '度假中心'
    }, {
      value: '度假村',
      label: '度假村'
    }, {
      value: '青年旅馆',
      label: '青年旅馆'
    }, {
      value: '其他',
      label: '其他'
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
          message: '中文全称不能为空',
          trigger: 'blur'
        }, {
          validator: myrules.validatLength,
          maxlength: 200,
          msg: '长度不能超过200',
          trigger: 'blur'
        }],
        area: [{
          required: true,
          message: '所在区域不能为空',
          trigger: 'blur'
        }, {
          validator: myrules.validatLength,
          maxlength: 200,
          msg: '长度不能超过200',
          trigger: 'blur'
        }],
        longitude: [{
          required: true,
          message: '经度不能为空',
          trigger: 'blur'
        }, {
          validator: myrules.validatLength,
          maxlength: 20,
          msg: '长度不能超过20',
          trigger: 'blur'
        }],
        latitude: [{
          required: true,
          message: '纬度不能为空',
          trigger: 'blur'
        }, {
          validator: myrules.validatLength,
          maxlength: 20,
          msg: '长度不能超过20',
          trigger: 'blur'
        }],
        address: [{
          required: true,
          message: '地址不能为空',
          trigger: 'blur'
        }, {
          validator: myrules.validatLength,
          maxlength: 200,
          msg: '长度不能超过200',
          trigger: 'blur'
        }],
        type: [{
          required: true,
          message: '类型不能为空',
          trigger: 'blur'
        }, {
          validator: myrules.validatLength,
          maxlength: 200,
          msg: '长度不能超过50',
          trigger: 'blur'
        }],
        level: [{
          required: true,
          message: '等级不能为空',
          trigger: 'blur'
        }, {
          validator: myrules.validatLength,
          maxlength: 200,
          msg: '长度不能超过200',
          trigger: 'blur'
        }],
// 地理位置
        geoPosition: [{
          required: true,
          message: '类型不能为空',
          trigger: 'blur'
        }, {
          validator: myrules.validatLength,
          maxlength: 200,
          msg: '长度不能超过200',
          trigger: 'blur'
        }],
// 远洋植物
        provideCuisines: [{
          validator: myrules.validatLength,
          maxlength: 200,
          msg: '长度不能超过200',
          trigger: 'blur'
        }],
// 股份公司
        corporateLogo: [{
          validator: myrules.validatLength,
          maxlength: 200,
          msg: '长度不能超过200',
          trigger: 'blur'
        }],
// 关键词
        keywords: [{
          validator: myrules.validatLength,
          maxlength: 200,
          msg: '长度不能超过20',
          trigger: 'blur'
        }],
// 热型
        theRoomType: [{
          validator: myrules.validatLength,
          maxlength: 200,
          msg: '长度不能超过200',
          trigger: 'blur'
        }],
// 热号
        theRoomNumber: [{
          validator: myrules.validatPhone,
          msg: '电话格式不对',
          trigger: 'blur'
        }],
// 坎布罗卡姆
        canBookARoom: [{
          validator: myrules.validatPhone,
          msg: '电话格式不对',
          trigger: 'blur'
        }],
// 组织代码
        organizationCode: [{
          validator: myrules.validatLength,
          maxlength: 200,
          msg: '长度不能超过200',
          trigger: 'blur'
        }],
// unifiedsocialcreditcode
        unifiedSocialCreditCode: [{
          validator: myrules.validatLength,
          maxlength: 200,
          msg: '长度不能超过200',
          trigger: 'blur'
        }],
// 法定代表人
        legalRepresentative: [{
          validator: myrules.validatLength,
          maxlength: 200,
          msg: '长度不能超过50',
          trigger: 'blur'
        }],
// 运营经理
        operationsManagers: [{
          validator: myrules.validatLength,
          maxlength: 200,
          msg: '长度不能超过200',
          trigger: 'blur'
        }],
// 链式运行情况
        chainOperationSituation: [{
          validator: myrules.validatLength,
          maxlength: 200,
          msg: '长度不能超过50',
          trigger: 'blur'
        }],
// 管理小组
        managementGroup: [{
          validator: myrules.validatLength,
          maxlength: 200,
          msg: '长度不能超过200',
          trigger: 'blur'
        }],
// 运输方式
        modeOfTransport: [{
          validator: myrules.validatLength,
          maxlength: 200,
          msg: '长度不能超过200',
          trigger: 'blur'
        }],
// 投诉
        complaints: [{
          validator: myrules.validatPhone,
          msg: '电话格式不对',
          trigger: 'blur'
        }],
// 咨询电话
        consultingTheTelephone: [{
          validator: myrules.validatPhone,
          msg: '电话格式不对',
          trigger: 'blur'
        }],
// 传真
        fax: [{
          validator: myrules.validatPhone,
          msg: '电话格式不对',
          trigger: 'blur'
        }],
// 电子邮件
        email: [{
          validator: myrules.validatEmail,
          msg: '邮箱格式不对',
          trigger: 'blur'
        }],
// 信用卡支持
        supportOfCard: [{
          validator: myrules.validatLength,
          maxlength: 200,
          msg: '长度不能超过200',
          trigger: 'blur'
        }],
// 付款方式
        methodOfPayment: [{
          validator: myrules.validatLength,
          maxlength: 200,
          msg: '长度不能超过200',
          trigger: 'blur'
        }]
      }
    }
  }
</script>
