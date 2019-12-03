<!--停车场-->
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
              @click="save('parkingLot')"
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
                <el-form-item label="所属区域" prop="regionCode">
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
                <el-form-item label="所属公司" prop="theCompanyOfAffiliation">
                  <el-input
                    v-model="data.theCompanyOfAffiliation"
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
                    maxlength="50" />
                </el-form-item>
              </el-col>
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
                <el-form-item label="服务设施" prop="serviceFacilities">
                  <el-input
                    v-model="data.serviceFacilities"
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

          <el-tab-pane label="停车场">
            <el-row>
              <el-col :span="12">
                <el-form-item label="停车场类型" prop="theParkingLotType">
                  <!--<el-input size='mini' v-model="data.destinationCategory" :disabled="readonly" />-->
                  <el-select v-model="data.theParkingLotType" placeholder="请选择">
                    <el-option v-for="item in theParkingLotTypes"
                               :key="item.value"
                               :label="item.label"
                               :value="item.value" />
                  </el-select>
                </el-form-item>
              </el-col>

              <el-col :span="12">
                <el-form-item label="停车场类型" prop="carType">
                  <!--<el-input size='mini' v-model="data.destinationCategory" :disabled="readonly" />-->
                  <el-select v-model="data.carType" placeholder="请选择">
                    <el-option v-for="item in carTypes"
                               :key="item.value"
                               :label="item.label"
                               :value="item.value" />
                  </el-select>
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="车位数量" prop="numberOfParking">
                  <el-input
                    v-model="data.numberOfParking"
                    :disabled="readonly"
                    type="number"
                    maxlength="20" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="营业时间" prop="businessHours">
                  <el-input
                    v-model="data.businessHours"
                    :disabled="readonly"
                    maxlength="50" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="收费标准" prop="chargeStandard">
                  <el-input
                    v-model="data.chargeStandard"
                    :disabled="readonly"
                    maxlength="200" />
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
  import ImgSource from '../../.common/ImgResource'
  import AudioResource from '../../.common/audioResource'
  import VideoResource from '../../.common/videoResource'
  import VirtualMaterial from '../../.common/virtualMaterial'

  @Component({
    components: {
      ImgSource,
      AudioResource,
      VideoResource,
      VirtualMaterial
    }
  })
  export default class ParkingLot extends Mixins(BaseTable) {
    @Prop({default: () => 'new'})
    id

    getUrl () {
      return this.AllUrl.trivalEnterprise.parkingLots
    }

    theParkingLotTypes = [{
      value: '室内',
      label: '室内'
    }, {
      value: '室外',
      label: '室外'
    }]

    carTypes = [{
      value: '大车车位',
      label: '大车车位'
    }, {
      value: '中等车位',
      label: '中等车位'
    }, {
      value: '小车车位',
      label: '小车车位'
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
        }],
        area: [{
          required: true,
          message: '所属区域不能为空',
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
        }]
      }
    }
  }
</script>
