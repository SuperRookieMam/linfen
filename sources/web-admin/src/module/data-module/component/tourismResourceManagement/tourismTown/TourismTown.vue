<!--旅游城镇-->
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
                <el-form-item label="海拔高低" prop="elevationOfHighAndLow">
                  <el-input
                    v-model="data.elevationOfHighAndLow"
                    :disabled="readonly"
                    type="number"
                    maxlength="100" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="人口" prop="population">
                  <el-input
                    v-model="data.population"
                    :disabled="readonly"
                    maxlength="50" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="面积" prop="areaCount">
                  <el-input
                    v-model="data.areaCount"
                    :disabled="readonly"
                    type="number"
                    maxlength="50" />
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
                <el-form-item label="标签" prop="label">
                  <el-input
                    v-model="data.label"
                    :disabled="readonly"
                    maxlength="200" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="简介" prop="introduction">
                  <edit v-model="data.introduction" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="旅游提示" prop="travelTips">
                  <el-input
                    v-model="data.travelTips"
                    :disabled="readonly"
                    maxlength="200" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="旅游特色" prop="tourismFeatures">
                  <el-input
                    v-model="data.tourismFeatures"
                    :disabled="readonly"
                    maxlength="200" />
                </el-form-item>
              </el-col>
            </el-row>
          </el-tab-pane>

          <el-tab-pane label="交通信息">
            <el-row>
              <el-col :span="12">
                <el-form-item label="交通方式" prop="modeOfTransport">
                  <!--<el-input size='mini' v-model="data.modeOfTransport" :disabled="readonly" />-->
                  <el-select v-model="data.modeOfTransport" :disabled="readonly" placeholder="交通方式">
                    <el-option v-for="item in modeOfTransports"
                               :key="item.value"
                               :label="item.label"
                               :disabled="readonly"
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
                <el-form-item label="官网地址" prop="theWebsiteAddress">
                  <el-input
                    v-model="data.theWebsiteAddress"
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
                <el-form-item label="WAP网址" prop="wAPSite">
                  <el-input
                    v-model="data.wapsite"
                    :disabled="readonly"
                    maxlength="200" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="安卓版APP下载地址" label-width="140px" prop="androidAppDownloadUrl">
                  <el-input
                    v-model="data.androidAppDownloadUrl"
                    :disabled="readonly"
                    maxlength="200" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="苹果版APP下载地址" label-width="140px" prop="iosAppDownloadUrl">
                  <el-input
                    v-model="data.iosAppDownloadUrl"
                    :disabled="readonly"
                    maxlength="200" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="旅游投诉电话" prop="touristComplaintsTelephone">
                  <el-input
                    v-model="data.touristComplaintsTelephone"
                    :disabled="readonly"
                    maxlength="200" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="门票预订电话" prop="ticketReservationPhone">
                  <el-input
                    v-model="data.ticketReservationPhone"
                    :disabled="readonly"
                    maxlength="20" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="客服电话" prop="customerServiceTelephone">
                  <el-input
                    v-model="data.customerServiceTelephone"
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
                    maxlength="20" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="Email" prop="email">
                  <el-input
                    v-model="data.email"
                    :disabled="readonly"
                    maxlength="20" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="开放时间" prop="openTime">
                  <el-input
                    v-model="data.openTime"
                    :disabled="readonly"
                    maxlength="20" />
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
                <el-form-item label="金融网点" prop="financialNetwork">
                  <el-input
                    v-model="data.financialNetwork"
                    :disabled="readonly"
                    maxlength="200" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="建议游玩时间" prop="recommendedPlayTime">
                  <el-input
                    v-model="data.recommendedPlayTime"
                    :disabled="readonly"
                    maxlength="50" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="周边信息" prop="surroundingInformation">
                  <edit v-model="data.surroundingInformation" />
                </el-form-item>
              </el-col>
            </el-row>
          </el-tab-pane>

          <el-tab-pane label="停车场" v-if="id!=='new'">
            <reference-form :pdata="data"
                            refname="TourismTown"
                            fieldname="parkingLots"
                            route-name="tourismTownsParkingLot"
                            jump-name="parkingLots"
                            :table-mesg="parkingLot" />
          </el-tab-pane>

          <el-tab-pane label="多媒体信息">
            <el-row>
              <el-col :span="12">
                <el-form-item label="示意图" prop="schematicDiagram">
                  <el-input v-model="data.schematicDiagram" :disabled="readonly" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="导览图" prop="navigationMap">
                  <el-input v-model="data.navigationMap" :disabled="readonly" />
                </el-form-item>
              </el-col>
            </el-row>

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

          <el-tab-pane label="旅游厕所" v-if="id!=='new'">
            <reference-form :pdata="data"
                            refname="TourismTown"
                            fieldname="tourismToilet"
                            route-name="tourismTownstourismToilet"
                            jump-name="touristToilets"
                            :table-mesg="touristToilet" />
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
  import ReferenceForm from '../../.common/ReferenceForm'

  const tourismTownModule = namespace('data/tourismTown')
  const regionModule = namespace('data/region')
  @Component({
    components: {
      qrCodeEditor,
      ReferenceForm
    }
  })
  export default class TourismTown extends Mixins(BaseForm) {
    @Prop({default: () => 'new'})
    id

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

    data = {}

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

    readonly = true

    get rules () {
      return {

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
        elevationOfHighAndLow: [{
          required: true,
          message: '海拔高低不能为空',
          trigger: 'blur'
        }],
        areaCount: [{
          required: true,
          message: '面积不能为空',
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

    @tourismTownModule.Action('save')
    saveData

    @tourismTownModule.Action('get')
    getData

    @tourismTownModule.Action('update')
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
