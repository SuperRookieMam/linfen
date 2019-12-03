<!--视频库-->
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
              @click="save('videoDatabase')"
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
                <el-form-item label="视频标题" prop="title">
                  <el-input v-model="data.title" :disabled="readonly" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="类型" prop="type">
                  <el-input v-model="data.type" :disabled="readonly" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="来源" prop="source">
                  <el-input v-model="data.source" :disabled="readonly" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="视频规格" prop="videoSpecifications">
                  <el-input v-model="data.videoSpecifications" :disabled="readonly" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="视频格式" prop="videoFormat">
                  <el-input v-model="data.videoFormat" :disabled="readonly" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="文件大小" prop="theFileSize">
                  <el-input v-model="data.theFileSize" :disabled="readonly" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="视频时长" prop="theVideoTime">
                  <el-input v-model="data.theVideoTime" :disabled="readonly" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="拍摄时间" prop="shootingTime">
                  <el-input v-model="data.shootingTime" :disabled="readonly" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="所属资源" prop="subordinateToTheResource">
                  <el-input v-model="data.subordinateToTheResource" :disabled="readonly" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="描述" prop="describe">
                  <!--<el-input size='mini' v-model="data.describe" :disabled="readonly" />-->
                  <edit v-model="data.describe" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="版权所有" prop="allRightsReserved">
                  <!--<el-input size='mini' v-model="data.allRightsReserved" :disabled="readonly" />-->
                  <edit v-model="data.allRightsReserved" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="版权说明" prop="copyright">
                  <!--<el-input size='mini' v-model="data.copyright" :disabled="readonly" />-->
                  <edit v-model="data.allRightsReserved" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="精选视频" prop="copyright">
                  <el-switch
                    v-model="data.show"
                    active-text="推荐显示"
                    inactive-text="取消显示" />
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="12">
                <el-form-item label="视频预览" prop="copyright">
                  <one-video-up v-model="data.file" :disabled="readonly" />
                </el-form-item>
              </el-col>
            </el-row>
          </el-tab-pane>
        </el-tabs>
      </el-form>
    </el-main>
  </el-container>
</template>
<!--<script src="../../../commonjs/rule.js"></script>-->
<script>
  import BaseTable from '../../.common/BaseTable'
  import { Component, Prop, Mixins } from 'vue-property-decorator'
  import * as myrules from '../../../commonjs/rule'
  import OneVideoUp from '../../.common/OneVideoUp'

  @Component({
    components: {
      OneVideoUp
    }
  })
  export default class VideoDatabase extends Mixins(BaseTable) {
    @Prop({ default: () => 'new' })
    id

    getUrl () {
      return this.AllUrl.trivalEnterprise.videos
    }

    save () {
      this.$refs.form.validate((valid) => {
        if (valid) {
          if (this.id === 'new') {
            this.post({
              url: this.getUrl(),
              params: [this.data]
            }).then(ele => {
              this.data = ele
              this.$router.go(-1)
            })
          } else {
            this.put({
              url: `${this.getUrl()}/${this.id}`,
              params: this.data
            }).then(ele => {
              this.data = ele
              this.$router.go(-1)
            })
          }
        } else {
          return false
        }
      })
    }

    get rules () {
      return {
        type: [{
          required: true,
          message: '类型不能为空',
          trigger: 'blur'
        }, {
          validator: myrules.validatLength,
          maxlength: 200,
          msg: '长度不能超过200',
          trigger: 'blur'
        }],
        source: [{
          required: true,
          message: '类型不能为空',
          trigger: 'blur'
        }, {
          validator: myrules.validatLength,
          maxlength: 200,
          msg: '长度不能超过200',
          trigger: 'blur'
        }],
        videoSpecifications: [{
          validator: myrules.validatLength,
          maxlength: 200,
          msg: '长度不能超过200',
          trigger: 'blur'
        }],
// 录像带
        videoFormat: [{
          validator: myrules.validatLength,
          maxlength: 200,
          msg: '长度不能超过200',
          trigger: 'blur'
        }],
// 文件化
        theFileSize: [{
          validator: myrules.validatLength,
          maxlength: 50,
          msg: '长度不能超过50',
          trigger: 'blur'
        }],
// 视频时代
        theVideoTime: [{
          validator: myrules.validatLength,
          maxlength: 50,
          msg: '长度不能超过50',
          trigger: 'blur'
        }],
// 射击时间
        shootingTime: [{
          required: true,
          message: '类型不能为空',
          trigger: 'blur'
        }, {
          validator: myrules.validatLength,
          maxlength: 20,
          msg: '长度不能超过50',
          trigger: 'blur'
        }]
      }
    }
  }
</script>
