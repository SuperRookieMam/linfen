<!--旅游活动-->
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
                <el-form-item label="活动类型" prop="theActivityType">
                  <el-input
                    v-model="data.theActivityType"
                    :disabled="readonly"
                    maxlength="50" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="活动日期" prop="eventDate">
                  <el-input
                    v-model="data.eventDate"
                    :disabled="readonly"
                    maxlength="50" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="活动时间" prop="theActivityTime">
                  <el-input
                    v-model="data.theActivityTime"
                    :disabled="readonly"
                    maxlength="50" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="主办者/单位" prop="organizersUnit">
                  <el-input
                    v-model="data.organizersUnit"
                    :disabled="readonly"
                    maxlength="50" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="组织结构" prop="theStructureOfTheOrganization">
                  <el-input
                    v-model="data.theStructureOfTheOrganization"
                    :disabled="readonly"
                    maxlength="50" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="活动地址" prop="activitiesAddress">
                  <el-input
                    v-model="data.activitiesAddress"
                    :disabled="readonly"
                    maxlength="200" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="所在地区" prop="regionCode">
                  <el-cascader v-model="regionCode"
                               :options="regions"
                               :disabled="readonly"
                               :props="areaProps"
                               change-on-select />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="相关景区" prop="relatedToTheScenicSpot">
                  <el-input
                    v-model="data.relatedToTheScenicSpot"
                    :disabled="readonly"
                    maxlength="200" />
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
                <el-form-item label="关键字" prop="keywords">
                  <el-input
                    v-model="data.keywords"
                    :disabled="readonly"
                    maxlength="200" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="活动概况" prop="activities">
                  <el-input v-model="data.activities" :disabled="readonly" />
                </el-form-item>
              </el-col>
            </el-row>
          </el-tab-pane>

          <el-tab-pane label="公共服务信息">
            <el-row>
              <el-col :span="12">
                <el-form-item label="票价信息" prop="theTicketInformation">
                  <el-input
                    v-model="data.theTicketInformation"
                    :disabled="readonly"
                    maxlength="200" />
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
                <el-form-item label="官方网站/网址" label-width="141px" prop="officialWebsite">
                  <el-input
                    v-model="data.officialWebsite"
                    :disabled="readonly"
                    maxlength="200" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="咨询电话" prop="consultingTheTelephone">
                  <el-input
                    v-model="data.consultingTheTelephone"
                    :disabled="readonly"
                    maxlength="20" />
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
  import BaseForm from '../../.common/BaseForm'
  import { Component, Prop, Mixins } from 'vue-property-decorator'
  import { namespace } from 'vuex-class'
  import ImgSource from '../../.common/ImgResource'
  import AudioResource from '../../.common/audioResource'
  import VideoResource from '../../.common/videoResource'
  import VirtualMaterial from '../../.common/virtualMaterial'
  import * as myRules from '../../../commonjs/rule'

  const touristActivityModule = namespace('data/touristActivity')
  const regionModule = namespace('data/region')
  @Component({
    components: {
      ImgSource,
      AudioResource,
      VideoResource,
      VirtualMaterial
    }
  })
  export default class TouristActivity extends Mixins(BaseForm) {
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

        chineseName: [{
          required: true,
          message: '中文名称不能为空',
          trigger: 'blur'
        }],
        theActivityType: [{
          required: true,
          message: '活动类型不能为空',
          trigger: 'blur'
        }],
        eventDate: [{
          required: true,
          message: '活动日期不能为空',
          trigger: 'blur'
        }],
        theActivityTime: [{
          required: true,
          message: '活动时间不能为空',
          trigger: 'blur'
        }],
        organizersUnit: [{
          required: true,
          message: '主办者/单位不能为空',
          trigger: 'blur'
        }],
        theStructureOfTheOrganization: [{
          required: true,
          message: '组织结构不能为空',
          trigger: 'blur'
        }],
        activitiesAddress: [{
          required: true,
          message: '活动地址不能为空',
          trigger: 'blur'
        }],
        area: [{
          required: true,
          message: '所在地区不能为空',
          trigger: 'blur'
        }],
        consultingTheTelephone: [
          {
            validator: myRules.validatPhone,
            msg: '咨询电话格式不对',
            trigger: 'blur'
          }
        ]
      }
    }

    @touristActivityModule.Action('save')
    saveData

    @touristActivityModule.Action('get')
    getData

    @touristActivityModule.Action('update')
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
