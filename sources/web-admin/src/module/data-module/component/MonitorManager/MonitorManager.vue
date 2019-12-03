<template>
  <div>
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
            @click="save('monitorManager')"
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
              <el-form-item label="监控名称" prop="monitorName">
                <el-input v-model="data.monitorName" />
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="监控编号" prop="roomNumber">
                <el-input v-model="data.roomNumber" />
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
              <el-form-item label="摄像头地址" prop="cameraUrl">
                <el-input v-model="data.cameraUrl" />
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="拉流地址" prop="monitorPullUrl">
                <el-input v-model="data.monitorPullUrl" />
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="6">
              <el-form-item label="经度" prop="longitude">
                <el-input v-model="data.longitude" />
              </el-form-item>
            </el-col>
            <el-col :span="6">
              <el-form-item label="纬度" prop="latitude">
                <el-input v-model="data.latitude" />
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="所属景区" prop="scenic">
                <scenic-select v-model="data.scenic" :disabled="readonly" />
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
            <el-col :span="12">
              <el-form-item label="运行状态" prop="run">
                <el-switch
                  @change="turnOnOff"
                  v-model="data.run"
                  active-text="开启"
                  inactive-text="关闭"
                  :disabled="id === 'new'" />
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
              <el-form-item label="分辨率宽度" prop="width">
                <el-input type="number" v-model="data.width" />
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="分辨率高度" prop="height">
                <el-input type="number" v-model="data.height" />
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
              <el-form-item label="模式" prop="transformType">
                <el-select v-model="data.transformType" placeholder="请选择">
                  <el-option label="复制模式(CUP使用极低)" value="copy" />
                  <el-option label="转码模式(CUP使用较高)" value="transform" />
                </el-select>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
              <el-form-item label="视频">
                <vedio-play
                  v-if="data.monitorPullUrl&&data.run&&data.roomNumber"
                  :url="data.monitorPullUrl"
                  :room-number="data.roomNumber" />
              </el-form-item>
            </el-col>
          </el-row>
        </el-tab-pane>
      </el-tabs>
    </el-form>
  </div>
</template>
<script>
  import { Component, Mixins, Prop } from 'vue-property-decorator'
  import BaseTable from '../.common/BaseTable'
  import OnePicUp from '../.common/OnePicUp'
  import VedioPlay from '../.common/VedioPlay'
  import ScenicSelect from '../.common/ScenicSelect'

  @Component({
    components: {
      OnePicUp,
      VedioPlay,
      ScenicSelect
    }
  })
  export default class MonitorManager extends Mixins(BaseTable) {
    @Prop({default: () => 'new'})
    id

    dialogVisible = false

    turnOnOff () {
      this.put({url: `${this.getUrl()}/${this.id}`, params: this.data}).then(ele => {
        if (this.data.run) {
          this.gets({url: `${this.AllUrl.trivalEnterprise.monitorManagers}/transferStreamLocal/${this.id}`}).then(resoult => {
            this.$message('开启成功', '友情提示')
          })
        } else {
          this.gets({url: `${this.AllUrl.trivalEnterprise.monitorManagers}/turnOff/${this.id}`}).then(resoult => {
            this.$message('关闭成功', '友情提示')
          })
        }
      })
    }

    getUrl () {
      return this.AllUrl.trivalEnterprise.monitorManagers
    }

    get rules () {
      return {}
    }
  }
</script>
