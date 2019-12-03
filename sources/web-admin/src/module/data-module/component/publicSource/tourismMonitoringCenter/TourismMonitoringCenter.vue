<!--旅游监控中心-->
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
                <el-form-item label="监控点名称" prop="monitorPointName">
                  <el-input
                    v-model="data.monitorPointName"
                    :disabled="readonly"
                    maxlength="50" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="所属部门" prop="subordinateDepartments">
                  <el-input
                    v-model="data.subordinateDepartments"
                    :disabled="readonly"
                    maxlength="200" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="链接地址" prop="link">
                  <el-input
                    v-model="data.link"
                    :disabled="readonly"
                    maxlength="50" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="端口" prop="port">
                  <el-input
                    v-model="data.port"
                    :disabled="readonly"
                    maxlength="20" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="用户名" prop="username">
                  <el-input
                    v-model="data.username"
                    :disabled="readonly"
                    maxlength="50" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="密码" prop="password">
                  <el-input
                    v-model="data.password"
                    :disabled="readonly"
                    maxlength="50" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
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
                <el-form-item label="序列号" prop="serialNumber">
                  <el-input
                    v-model="data.serialNumber"
                    :disabled="readonly"
                    maxlength="50" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="品牌" prop="brand">
                  <el-input
                    v-model="data.brand"
                    :disabled="readonly"
                    maxlength="200" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="大屏显示" prop="display">
                  <el-input
                    v-model="data.display"
                    :disabled="readonly"
                    maxlength="50" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="播放方式" prop="playWay">
                  <el-input
                    v-model="data.playWay"
                    :disabled="readonly"
                    maxlength="50" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="是否主要视频" prop="whetherTheMainVideo">
                  <el-input
                    v-model="data.whetherTheMainVideo"
                    :disabled="readonly"
                    maxlength="50" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="清晰度" prop="clarity">
                  <el-input
                    v-model="data.clarity"
                    :disabled="readonly"
                    maxlength="50" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="类型" prop="type">
                  <el-input
                    v-model="data.type"
                    :disabled="readonly"
                    maxlength="50" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="视频图片" prop="videoImages">
                  <el-input v-model="data.videoImages" :disabled="readonly" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="简介" prop="introduction">
                  <!--<el-input size='mini' v-model="data.introduction" :disabled="readonly" />-->
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
        </el-tabs>
      </el-form>
    </el-main>
  </el-container>
</template>
<script>
  import BaseTable from '../../.common/BaseTable'
  import { Component, Prop, Mixins } from 'vue-property-decorator'

  @Component
  export default class TourismMonitoringCenter extends Mixins(BaseTable) {
    @Prop({default: () => 'new'})
    id

    formName = 'form'

    currentHtml = 'form'

    getUrl () {
      return this.AllUrl.trivalEnterprise.tourismMonitoringCenters
    }

    get rules () {
      return {
        regionCode: [{
          required: true,
          message: '所在区域不能为空',
          trigger: 'blur'
        }],
        monitorPointName: [{
          required: true,
          message: '监控点名称不能为空',
          trigger: 'blur'
        }],
        subordinateDepartments: [{
          required: true,
          message: '所属部门不能为空',
          trigger: 'blur'
        }],
        link: [{
          required: true,
          message: '链接地址不能为空',
          trigger: 'blur'
        }],
        port: [{
          required: true,
          message: '端口不能为空',
          trigger: 'blur'
        }],
        username: [{
          required: true,
          message: '用户名不能为空',
          trigger: 'blur'
        }],
        password: [{
          required: true,
          message: '密码不能为空',
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
        }]
      }
    }
  }
</script>
