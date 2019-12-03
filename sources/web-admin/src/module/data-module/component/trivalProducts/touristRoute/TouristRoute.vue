<!--旅游线路-->
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
              @click="save('touristRoute')"
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
                <el-form-item label="线路编号" prop="no">
                  <el-input
                    v-model="data.no"
                    :disabled="readonly"
                    maxlength="50" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="线路名称" prop="name">
                  <el-input
                    v-model="data.name"
                    :disabled="readonly"
                    maxlength="50" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="线路类型" prop="type">
                  <el-select v-model="data.type" placeholder="请选择">
                    <el-option label="自由行" value="自由行" />
                    <el-option label="跟团游" value="跟团游" />
                  </el-select>
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="目的地" prop="target">
                  <el-input
                    v-model="data.target"
                    :disabled="readonly"
                    maxlength="200" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="目的地类型" prop="targetType">
                  <el-input
                    v-model="data.targetType"
                    :disabled="readonly"
                    maxlength="50" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="线路天数" prop="days">
                  <el-select v-model="data.days"
                             placeholder="请选择"
                             :disabled="readonly">
                    <el-option
                      v-for="item in options"
                      :key="item.value"
                      :label="item.label"
                      :value="item.value" />
                  </el-select>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="12">
                <el-form-item label="价格" prop="price">
                  <el-input
                    type="number"
                    v-model="data.price"
                    :disabled="readonly"
                    maxlength="50" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="电话" prop="phone">
                  <el-input
                    v-model="data.phone"
                    :disabled="readonly"
                    type="number"
                    maxlength="50" />
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="12">
                <el-form-item label="出行方式" prop="wayType">
                  <el-input
                    v-model="data.wayType"
                    :disabled="readonly"
                    maxlength="50" />
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="12">
                <el-form-item label="线路介绍" prop="description">
                  <edit v-model="data.description" />
                </el-form-item>
              </el-col>
            </el-row>
          </el-tab-pane>
          <el-tab-pane label="途经点" name="points" v-if="id!=='new'">
            <path-points
              :url="AllUrl.trivalEnterprise.touristRoutes+'/'+data.id"
              :set-return-data="pointsReturndata"
              :success-save="pointsSuccessSave"
              :is-search="false" />
          </el-tab-pane>
          <el-tab-pane label="多媒体信息">
            <el-row>
              <el-col :span="24">
                <img-source v-model="data.images" :disabled="readonly" />
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
  import videoResource from '../../.common/videoResource'
  import PathPoints from './PathPoints'

  @Component({
    components: {
      ImgSource,
      videoResource,
      PathPoints
    }
  })
  export default class TouristRoute extends Mixins(BaseTable) {
    @Prop({ default: () => 'new' })
    id

    pointsReturndata (returnData) {
      return returnData.pathPoints
    }

    pointsSuccessSave (returnData) {
      this.data.pathPoints.push(returnData)
      this.saveRef()
    }

    replaceRoute () {
      this.getFormData()
    }

    options = [{
      value: '1天',
      label: '1天'
    }, {
      value: '2天',
      label: '2天'
    }, {
      value: '3天及以上',
      label: '3天及以上'
    }]

    getUrl () {
      return this.AllUrl.trivalEnterprise.touristRoutes
    }

    get rules () {
      return {
        regionCode: [{
          required: true,
          message: '所在区域不能为空',
          trigger: 'blur'
        }],
        no: [{
          required: true,
          message: '线路编号不能为空',
          trigger: 'blur'
        }],
        name: [{
          required: true,
          message: '线路名称不能为空',
          trigger: 'blur'
        }],
        target: [{
          required: true,
          message: '目的地不能为空',
          trigger: 'blur'
        }],
        days: [{
          required: true,
          message: '线路天数不能为空',
          trigger: 'blur'
        }],
        description: [{
          required: true,
          message: '线路介绍不能为空',
          trigger: 'blur'
        }]
      }
    }
  }
</script>
