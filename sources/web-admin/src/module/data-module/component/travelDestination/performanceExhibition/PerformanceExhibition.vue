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
                <el-form-item label="中文名称" prop="chineseName">
                  <el-input
                    v-model="data.chineseName"
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
                <el-form-item label="英文名称" prop="englishName">
                  <el-input
                    v-model="data.englishName"
                    :disabled="readonly"
                    maxlength="100" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="会展类型" prop="exhibitionType">
                  <el-input
                    v-model="data.exhibitionType"
                    :disabled="readonly"
                    maxlength="50" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="票价" prop="price">
                  <el-input
                    v-model="data.price"
                    :disabled="readonly"
                    maxlength="20" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="票价说明" prop="ticketPricesThat">
                  <edit v-model="data.ticketPricesThat" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="售票时间" prop="theTicketTime">
                  <el-input
                    v-model="data.theTicketTime"
                    :disabled="readonly"
                    maxlength="50" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="售票地点" prop="theTicketPlace">
                  <el-input
                    v-model="data.theTicketPlace"
                    :disabled="readonly"
                    maxlength="200" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="展览开始日期" prop="exhibitionStartDate">
                  <el-input
                    v-model="data.exhibitionStartDate"
                    :disabled="readonly"
                    maxlength="50" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="展览结束日期" prop="theExhibitionEndDate">
                  <el-input
                    v-model="data.theExhibitionEndDate"
                    :disabled="readonly"
                    maxlength="50" />
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="12">
                <el-form-item label="所属景区" prop="belongsToTheScenicSpot">
                  <el-input
                    v-model="data.belongsToTheScenicSpot"
                    :disabled="readonly"
                    maxlength="200" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="会展地址" prop="exhibitionAddress">
                  <el-input
                    v-model="data.exhibitionAddress"
                    :disabled="readonly"
                    maxlength="200" />
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="12">
                <el-form-item label="主办单位" prop="theOrganizer">
                  <el-input
                    v-model="data.theOrganizer"
                    :disabled="readonly"
                    maxlength="200" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="承办单位" prop="toUndertakeUnit">
                  <el-input
                    v-model="data.toUndertakeUnit"
                    :disabled="readonly"
                    maxlength="200" />
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="12">
                <el-form-item label="展览范围" prop="exhibitionRange">
                  <el-input
                    v-model="data.exhibitionRange"
                    :disabled="readonly"
                    maxlength="200" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="展会规模" prop="theExhibitionScale">
                  <el-input
                    v-model="data.theExhibitionScale"
                    :disabled="readonly"
                    maxlength="200" />
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="12">
                <el-form-item label="展会简介" prop="theExhibitionProfile">
                  <el-input v-model="data.theExhibitionProfile" :disabled="readonly" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="会展介绍" prop="conventionAndExhibitionToIntroduce">
                  <el-input v-model="data.conventionAndExhibitionToIntroduce" :disabled="readonly" />
                </el-form-item>
              </el-col>
            </el-row>
          </el-tab-pane>
          <el-tab-pane label="公共服务信息">
            <el-row>
              <el-col :span="12">
                <el-form-item label="官方网站" prop="officialWebsite">
                  <el-input
                    v-model="data.officialWebsite"
                    :disabled="readonly"
                    maxlength="200" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="联系人" prop="TheContact">
                  <el-input
                    v-model="data.theContact"
                    :disabled="readonly"
                    maxlength="50" />
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="12">
                <el-form-item label="联系方式" prop="contact">
                  <el-input
                    v-model="data.contact"
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
                <el-form-item label="邮箱" prop="email">
                  <el-input
                    v-model="data.email"
                    :disabled="readonly"
                    maxlength="50" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="周边信息" prop="surroundingInformation">
                  <edit v-model="data.surroundingInformation" />
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="12">
                <el-form-item label="交通指南信息" prop="trafficGuideInformation">
                  <edit v-model="data.trafficGuideInformation" />
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
  import Vue from 'vue'
  import { Component, Prop } from 'vue-property-decorator'
  import { namespace } from 'vuex-class'
  import ImgSource from '../../.common/ImgResource'
  import AudioResource from '../../.common/audioResource'
  import VideoResource from '../../.common/videoResource'
  import VirtualMaterial from '../../.common/virtualMaterial'
  import * as myRules from '../../../commonjs/rule'

  const performanceExhibitionModule = namespace('data/performanceExhibition')
  @Component({
    components: {
      ImgSource,
      AudioResource,
      VideoResource,
      VirtualMaterial
    }
  })
  export default class PerformanceExhibition extends Vue {
    @Prop({default: () => 'new'})
    id

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
          validator: myRules.validatPostcode,
          msg: '邮政编码格式不对',
          trigger: 'blur'
        }],
        email: [{
          validator: myRules.validatEmail,
          msg: 'email格式不对',
          trigger: 'blur'
        }]

      }
    }

    @performanceExhibitionModule.Action('save')
    saveData

    @performanceExhibitionModule.Action('get')
    getData

    @performanceExhibitionModule.Action('update')
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
