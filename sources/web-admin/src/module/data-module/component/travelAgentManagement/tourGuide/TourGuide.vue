<!--导游-->
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
              @click="save('tourGuide')"
              size="mini"
              v-if="!readonly">
              保存
            </el-button>
          </el-col>
        </el-row>
        <el-tabs v-model="activeName">
          <el-tab-pane name="base" label="个人基本信息">
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
                <el-form-item label="性别" prop="gender">
                  <el-select v-model="data.gender" :disabled="readonly" placeholder="性别">
                    <el-option v-for="item in genders"
                               :key="item.value"
                               :label="item.label"
                               :value="item.value" />
                  </el-select>
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="出生日期" prop="dateOfBirth">
                  <el-date-picker
                    v-model="data.dateOfBirth"
                    type="date"
                    :disabled="readonly"
                    placeholder="选择日期" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="身份证号" prop="idNumber">
                  <el-input v-model="data.idNumber" :disabled="readonly" />
                </el-form-item>
              </el-col>
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
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="民族" prop="national">
                  <el-input v-model="data.national" :disabled="readonly" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="联系方式" prop="contact">
                  <el-input v-model="data.contact" :disabled="readonly" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="家庭住址" prop="homeAddress">
                  <el-input v-model="data.homeAddress" :disabled="readonly" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="证件照" prop="profilePicture">
                  <el-input v-model="data.profilePicture" :disabled="readonly" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="导游类型" prop="theGuideType">
                  <!--<el-input size='mini' v-model="data.theGuideType" :disabled="readonly" />-->
                  <el-select v-model="data.theGuideType" placeholder="导游类型" :disabled="readonly">
                    <el-option v-for="item in theGuideTypes"
                               :key="item.value"
                               :label="item.label"
                               :value="item.value" />
                  </el-select>
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="导游等级" prop="theGuideRanks">
                  <!--<el-input size='mini' v-model="data.theGuideRanks" :disabled="readonly" />-->
                  <el-select v-model="data.theGuideRanks" :disabled="readonly" placeholder="导游等级">
                    <el-option v-for="item in theGuideRanks"
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
                  <el-select v-model="data.serviceLanguage" :disabled="readonly" placeholder="服务语种">
                    <el-option v-for="item in serviceLanguages"
                               :key="item.value"
                               :label="item.label"
                               :value="item.value" />
                  </el-select>
                </el-form-item>
              </el-col>
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
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="当前团队" prop="nowTeam">
                  <el-input v-model="data.nowTeam" :disabled="readonly" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="头像" class="img-list">
                  <viewer class="previewer" :images="thumbnails" :options="viewerOptions">
                    <img v-for="src in thumbnails"
                         :src="src"
                         :key="src"
                         style="height: 60px;width: 60px"
                         :disabled="readonly">
                  </viewer>
                  <vue-uploader :http="uploader"
                                multiple
                                :url="fileUrl"
                                accept="image/*"
                                @item-success="imgUploadSuccess"
                                auto-upload
                                :disabled="readonly">
                    <el-button style="height: 100%;font-size: 30px;width: 60px;padding: 0px" icon="el-icon-plus" />
                  </vue-uploader>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="12">
                <el-form-item label="导游员简介" prop="introductionTourGuide">
                  <edit v-model="data.introductionTourGuide" />
                </el-form-item>
              </el-col>
            </el-row>
          </el-tab-pane>

          <el-tab-pane name="tourGuid" label="导游详细信息">
            <el-row>
              <el-col :span="12">
                <el-form-item label="导游证号码" prop="legallyNumber">
                  <el-input v-model="data.legallyNumber" :disabled="readonly" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="导游证发证日期" label-width="120px" prop="turnedTheReleaseDate">
                  <el-input v-model="data.turnedTheReleaseDate" :disabled="readonly" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="资格证号" prop="qualificationCardNumber">
                  <el-input v-model="data.qualificationCardNumber" :disabled="readonly" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="资格证发证日期" label-width="120px" prop="certificateIssuanceDate">
                  <el-input v-model="data.certificateIssuanceDate" :disabled="readonly" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="许可证号" prop="license">
                  <el-input v-model="data.license" :disabled="readonly" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="导游IC卡号" prop="theTourGuideIcCardNumber">
                  <el-input v-model="data.theTourGuideIcCardNumber" :disabled="readonly" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="导游卡号" prop="theTourGuideCardNumber">
                  <el-input v-model="data.theTourGuideCardNumber" :disabled="readonly" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="挂靠单位" prop="attachedUnits">
                  <el-input v-model="data.attachedUnits" :disabled="readonly" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="挂靠单位类型" prop="theAffiliatedUnitType">
                  <!--<el-input size='mini' v-model="data.theAffiliatedUnitType" :disabled="readonly" />-->
                  <el-select v-model="data.theAffiliatedUnitType" :disabled="readonly" placeholder="挂靠单位类型">
                    <el-option v-for="item in theAffiliatedUnitType"
                               :key="item.value"
                               :label="item.label"
                               :value="item.value" />
                  </el-select>
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="总分值" prop="totalValue">
                  <el-input v-model="data.totalValue" :disabled="readonly" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="被扣分值" prop="deductionScore">
                  <el-input v-model="data.deductionScore" :disabled="readonly" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="擅长讲解城市" prop="goodAtInterpretationOfTheCity">
                  <edit v-model="data.goodAtInterpretationOfTheCity" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="擅长讲解景区" prop="goodAtInterpretationOfTheScenicSpot">
                  <edit v-model="data.goodAtInterpretationOfTheScenicSpot" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="擅长带团线路" prop="goodAtLineOfTour">
                  <edit v-model="data.goodAtLineOfTour" />
                </el-form-item>
              </el-col>
            </el-row>
          </el-tab-pane>

          <el-tab-pane name="working" label="工作情况">
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
  import VueUploader from 'vue2-uploader'
  import uploader from './uploader'

  @Component({
    components: {
      VueUploader
    }
  })
  export default class TourGuide extends Mixins(BaseTable) {
    @Prop({default: () => 'new'})
    id

    data = {
      headImgs: []
    }

    getUrl () {
      return this.AllUrl.trivalEnterprise.tourGuides
    }

    fileUrl = `${CONTEXT_PATH}d/data/files`

    uploader = uploader

    get thumbnails () {
      return this.data.headImgs.map(item => `${CONTEXT_PATH}d/data/files/thumbnails/${item.id}`)
    }

    viewerOptions = {
      url: ({src}, b, c) => {
        const id = src.substring(src.lastIndexOf('/'))
        return `${CONTEXT_PATH}d/data/files/${id}`
      }
    }

    imgUploadSuccess (fileItem, {data}) {
      this.data.headImgs = [...this.data.headImgs, ...data]
    }

    theGuideTypes = [{
      value: '专职',
      label: '专职'
    }, {
      value: '兼职',
      label: '兼职'
    }]

    theGuideRanks = [{
      value: '初级导游员',
      label: '初级导游员'
    }, {
      value: '中级导游员',
      label: '中级导游员'
    }, {
      value: '高级导游员',
      label: '高级导游员'
    }, {
      value: '特级导游员',
      label: '特级导游员'
    }]

    theAffiliatedUnitType = [{
      value: '型旅行社',
      label: '型旅行社'
    }, {
      value: '导服中心',
      label: '导服中心'
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
        // 中国名字
        chineseName: [{
          required: true,
          message: '类型不能为空',
          trigger: 'blur'
        }, {
          validator: myrules.validatLength,
          maxlength: 50,
          msg: '长度不能超过50',
          trigger: 'blur'
        }],
// 拼音
        pinyin: [{
          required: true,
          message: '类型不能为空',
          trigger: 'blur'
        }, {
          validator: myrules.validatLength,
          maxlength: 50,
          msg: '长度不能超过50',
          trigger: 'blur'
        }],
// 性别
        gender: [{
          required: true,
          message: '类型不能为空',
          trigger: 'blur'
        }, {
          validator: myrules.validatLength,
          maxlength: 50,
          msg: '长度不能超过50',
          trigger: 'blur'
        }],
// 出生日期
        dateOfBirth: [{
          required: true,
          message: '类型不能为空',
          trigger: 'blur'
        }],
// 编号
        idNumber: [{
          required: true,
          message: '类型不能为空',
          trigger: 'blur'
        }, {
          validator: myrules.validatLength,
          maxlength: 20,
          msg: '长度不能超过20',
          trigger: 'blur'
        }],
// 正规学校教育
        recordOfFormalSchooling: [{
          required: true,
          message: '类型不能为空',
          trigger: 'blur'
        }, {
          validator: myrules.validatLength,
          maxlength: 200,
          msg: '长度不能超过200',
          trigger: 'blur'
        }],
// 国家的
        national: [{
          required: true,
          message: '类型不能为空',
          trigger: 'blur'
        }, {
          validator: myrules.validatLength,
          maxlength: 200,
          msg: '长度不能超过200',
          trigger: 'blur'
        }],
// 接触
        contact: [{
          required: true,
          message: '类型不能为空',
          trigger: 'blur'
        }, {
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
// 轮廓结构
        profilePicture: [{
          required: true,
          message: '类型不能为空',
          trigger: 'blur'
        }, {
          validator: myrules.validatLength,
          maxlength: 200,
          msg: '长度不能超过200',
          trigger: 'blur'
        }],
// 导向型
        theGuideType: [{
          required: true,
          message: '类型不能为空',
          trigger: 'blur'
        }, {
          validator: myrules.validatLength,
          maxlength: 200,
          msg: '长度不能超过200',
          trigger: 'blur'
        }],
// 引导者
        theGuideRanks: [{
          required: true,
          message: '类型不能为空',
          trigger: 'blur'
        }, {
          validator: myrules.validatLength,
          maxlength: 200,
          msg: '长度不能超过200',
          trigger: 'blur'
        }],
// 服务语言
        serviceLanguage: [{
          required: true,
          message: '类型不能为空',
          trigger: 'blur'
        }, {
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
// 法定数
        legallyNumber: [{
          required: true,
          message: '类型不能为空',
          trigger: 'blur'
        }, {
          validator: myrules.validatLength,
          maxlength: 200,
          msg: '长度不能超过200',
          trigger: 'blur'
        }],
// 使之适应
        turnedTheReleaseDate: [{
          validator: myrules.validatLength,
          maxlength: 200,
          msg: '长度不能超过200',
          trigger: 'blur'
        }],
// 资格卡号
        qualificationCardNumber: [{
          validator: myrules.validatLength,
          maxlength: 200,
          msg: '长度不能超过200',
          trigger: 'blur'
        }],
// 许可证
        license: [{
          validator: myrules.validatLength,
          maxlength: 200,
          msg: '长度不能超过200',
          trigger: 'blur'
        }],
// thetourguideiccardnumber
        theTourGuideIcCardNumber: [{
          validator: myrules.validatLength,
          maxlength: 200,
          msg: '长度不能超过200',
          trigger: 'blur'
        }],
// thetourguidecardnumber
        theTourGuideCardNumber: [{
          validator: myrules.validatLength,
          maxlength: 200,
          msg: '长度不能超过200',
          trigger: 'blur'
        }],
// 附着单元
        attachedUnits: [{
          required: true,
          message: '类型不能为空',
          trigger: 'blur'
        }, {
          validator: myrules.validatLength,
          maxlength: 200,
          msg: '长度不能超过200',
          trigger: 'blur'
        }],
// 附属单位类型
        theAffiliatedUnitType: [{
          validator: myrules.validatLength,
          maxlength: 200,
          msg: '长度不能超过200',
          trigger: 'blur'
        }],
// 总价值
        totalValue: [{
          validator: myrules.validatLength,
          maxlength: 200,
          msg: '长度不能超过200',
          trigger: 'blur'
        }],
// 演绎分数
        deductionScore: [{
          validator: myrules.validatLength,
          maxlength: 200,
          msg: '长度不能超过200',
          trigger: 'blur'
        }],
// 工作条件
        workingCondition: [{
          validator: myrules.validatLength,
          maxlength: 200,
          msg: '长度不能超过200',
          trigger: 'blur'
        }]
      }
    }
  }
</script>
<style lang="less">
  .el-date-editor.el-input {
    width: 100%;
  }
</style>
