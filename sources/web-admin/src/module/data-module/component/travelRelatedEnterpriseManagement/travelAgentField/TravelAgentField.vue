<!--旅行社-->
<template>
  <el-container class="travelAgentField">
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
              @click="save('travelAgentField')"
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
                  <el-select v-model="data.type" placeholder="类型" :disabled="readonly">
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
                  <el-select v-model="data.level" placeholder="类型" :disabled="readonly">
                    <el-option v-for="item in levels"
                               :key="item.value"
                               :label="item.label"
                               :value="item.value" />
                  </el-select>
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="经营业务" prop="business">
                  <!--<el-input size='mini' v-model="data.business" :disabled="readonly" />-->
                  <el-select v-model="data.business" placeholder="类型" :disabled="readonly">
                    <el-option v-for="item in businesss"
                               :key="item.value"
                               :label="item.label"
                               :value="item.value" />
                  </el-select>
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="服务语种" prop="serviceLanguage">
                  <!--<el-input size='mini' v-model="data.serviceLanguage" :disabled="readonly" />-->
                  <el-select v-model="data.serviceLanguage" placeholder="服务语种" :disabled="readonly">
                    <el-option v-for="item in serviceLanguages"
                               :key="item.value"
                               :label="item.label"
                               :value="item.value" />
                  </el-select>
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="荣誉称号" prop="titleOfHonor">
                  <el-input v-model="data.titleOfHonor" :disabled="readonly" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="关键字" prop="keywords">
                  <el-input v-model="data.keywords" :disabled="readonly" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="标签" prop="label">
                  <el-input v-model="data.label" :disabled="readonly" />
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
            <el-row>
              <el-col :span="12">
                <el-form-item label="旅行社Logo" prop="theTravelAgencyLogo">
                  <el-input v-model="data.theTravelAgencyLogo" :disabled="readonly" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="评分" prop="score">
                  <el-input v-model="data.score" type="number" :disabled="readonly" />
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="12">
                <el-form-item label="简介" prop="introduction">
                  <edit v-model="data.introduction" :disabled="readonly" />
                </el-form-item>
              </el-col>
            </el-row>
          </el-tab-pane>

          <el-tab-pane label="组织机构信息">
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
                <el-form-item label="旅游合同" prop="theTravelContract">
                  <el-input v-model="data.theTravelContract" :disabled="readonly" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="保证金金额" prop="depositAmount">
                  <el-input v-model="data.depositAmount" :disabled="readonly" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="应急联系人" prop="emergencyContact">
                  <el-input v-model="data.emergencyContact" :disabled="readonly" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="应急联系电话" prop="emergencyContactPhoneNumber">
                  <el-input v-model="data.emergencyContactPhoneNumber" :disabled="readonly" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="所属旅游集团" prop="byTravelGroup">
                  <el-input v-model="data.byTravelGroup" :disabled="readonly" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="业务范围" prop="theBusinessScope">
                  <el-input v-model="data.theBusinessScope" :disabled="readonly" />
                </el-form-item>
              </el-col>
            </el-row>
          </el-tab-pane>

          <el-tab-pane label="旅行社分支机构">
            <el-row>
              <el-col :span="12">
                <el-form-item label="旅行社分社" prop="theTravelAgencyBureauChief">
                  <el-input v-model="data.theTravelAgencyBureauChief" :disabled="readonly" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="旅行社服务网点" prop="travelAgencyServiceOutlets">
                  <el-input v-model="data.travelAgencyServiceOutlets" :disabled="readonly" />
                </el-form-item>
              </el-col>
            </el-row>
          </el-tab-pane>

          <el-tab-pane label="公共服务信息">
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
                <el-form-item label="预订电话" prop="reservationPhone">
                  <el-input v-model="data.reservationPhone" :disabled="readonly" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="客服电话" prop="customerServiceTelephone">
                  <el-input v-model="data.customerServiceTelephone" :disabled="readonly" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="传真" prop="fax">
                  <el-input v-model="data.fax" :disabled="readonly" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="Email" prop="电子邮件">
                  <el-input v-model="data.电子邮件" :disabled="readonly" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="营业时间" prop="businessHours">
                  <el-input v-model="data.businessHours" :disabled="readonly" />
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
                  <el-select v-model="data.methodOfPayment" placeholder="支付方式">
                    <el-option v-for="item in methodOfPayments"
                               :key="item.value"
                               :label="item.label"
                               :value="item.value" />
                  </el-select>
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="导游人员简介" prop="guidesPersonnelIntroduction">
                  <el-input v-model="data.guidesPersonnelIntroduction" :disabled="readonly" />
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
  import BaseTable from '../../.common/BaseTable'
  import { Component, Prop, Mixins } from 'vue-property-decorator'
  import ImgSource from '../../.common/ImgResource'
  import AudioResource from '../../.common/audioResource'
  import VideoResource from '../../.common/videoResource'
  import VirtualMaterial from '../../.common/virtualMaterial'
  import qrCodeEditor from '../../.common/QrCodeEditor'
  import * as myrules from '../../../commonjs/rule'

  @Component({
    components: {
      ImgSource,
      AudioResource,
      VideoResource,
      VirtualMaterial,
      qrCodeEditor
    }
  })
  export default class TravelAgentField extends Mixins(BaseTable) {
    @Prop({default: () => 'new'})
    id

    formName = 'form'

    currentHtml = 'form'

    getUrl () {
      return this.AllUrl.trivalEnterprise.travelAgentFields
    }

    businesss = [{
      value: '国内游',
      label: '国内游'
    }, {
      value: '入境',
      label: '入境'
    }, {
      value: '出境',
      label: '出境'
    }, {
      value: '港台业务',
      label: '港台业务'
    }]

    types = [{
      value: '国内旅行社',
      label: '国内旅行社'
    }, {
      value: '国际旅行社',
      label: '国际旅行社'
    }, {
      value: '赴台旅行社',
      label: '赴台旅行社'
    }]

    levels = [{
      value: '5A旅行社',
      label: '5A旅行社'
    }, {
      value: '4A旅行社',
      label: '4A旅行社'
    }, {
      value: '3A旅行社',
      label: '3A旅行社'
    }, {
      value: '未定级',
      label: '未定级'
    }]

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
          maxlength: 50,
          msg: '长度不能超过50',
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
          msg: '长度不能超过50',
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
        business: [{
          required: true,
          message: '经营业务不能为空',
          trigger: 'blur'
        }, {
          validator: myrules.validatLength,
          maxlength: 200,
          msg: '长度不能超过200',
          trigger: 'blur'
        }],
// 关键词
        keywords: [{
          validator: myrules.validatLength,
          maxlength: 200,
          msg: '长度不能超过200',
          trigger: 'blur'
        }],
// 设定日期
        setUpTheDate: [{
          validator: myrules.validatLength,
          maxlength: 20,
          msg: '长度不能超过50',
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
          msg: '长度不能超过200',
          trigger: 'blur'
        }],
        depositAmount: [{
          validator: myrules.validatLength,
          maxlength: 200,
          msg: '长度不能超过200',
          trigger: 'blur'
        }],
// 紧急接触电话号码
        emergencyContactPhoneNumber: [{
          validator: myrules.validatPhone,
          msg: '电话格式不对',
          trigger: 'blur'
        }],
// 投诉
        complaints: [{
          validator: myrules.validatPhone,
          msg: '电话格式不对',
          trigger: 'blur'
        }],
// 预约电话
        reservationPhone: [{
          validator: myrules.validatPhone,
          msg: '电话格式不对',
          trigger: 'blur'
        }],
// 客户服务电话
        customerServiceTelephone: [{
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
// 商业活动
        businessHours: [{
          validator: myrules.validatLength,
          maxlength: 200,
          msg: '长度不能超过50',
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
