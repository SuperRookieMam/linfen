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
              @click="readonly=false"
              size="mini"
              v-if="readonly">
              编辑
            </el-button>
            <el-button @click="goBack()" size="mini">取消</el-button>
            <el-button
              type="primary"
              @click="save('roomInfo')"
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
                <el-form-item label="房间类型" prop="roomType">
                  <el-select v-model="data.roomType" :disabled="readonly" placeholder="类型">
                    <el-option v-for="item in roomTypes"
                               :key="item.value"
                               :label="item.label"
                               :value="item.value" />
                  </el-select>
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="房间数量" prop="roomNumber">
                  <el-input type="number" v-model="data.roomNumber" :disabled="readonly" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="可预订房间" prop="canBookARoom">
                  <el-input v-model="data.canBookARoom" :disabled="readonly" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="正常价格" prop="normalPrice">
                  <el-input v-model="data.normalPrice" :disabled="readonly" />
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="12">
                <el-form-item label="假日价格" prop="holidayPrices">
                  <el-input v-model="data.holidayPrices" :disabled="readonly" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="加床价" prop="extraBedPrice">
                  <el-input v-model="data.extraBedPrice" :disabled="readonly" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="设施描述" prop="servicesDescribed">
                  <el-input v-model="data.servicesDescribed" :disabled="readonly" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="餐饮说明" prop="eatDescription">
                  <el-input v-model="data.eatDescription" :disabled="readonly" />
                </el-form-item>
              </el-col>
            </el-row>
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

  @Component({
    components: {
      ImgSource,
      AudioResource,
      VideoResource,
      VirtualMaterial,
      qrCodeEditor
    }
  })
  export default class Accommodation extends Mixins(BaseTable) {
    @Prop({default: () => 'new'})
    id

    getUrl () {
      return this.AllUrl.trivalEnterprise.roomInfos
    }

    roomTypes = [{
      value: '商务房间(大床)',
      label: '商务房间(大床)'
    }, {
      value: '豪华客房',
      label: '豪华客房'
    }, {
      value: '豪华商务间',
      label: '豪华商务间'
    }, {
      value: '行政客房',
      label: '行政客房'
    }, {
      value: '豪华商务客房',
      label: '豪华商务客房'
    }, {
      value: '贵宾大使套房',
      label: '贵宾大使套房'
    }]

    get rules () {
      return {}
    }
  }
</script>
