<!--图片库-->
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
              @click="save('imageDatabase')"
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
                <el-form-item label="图片标题" prop="pictureCaptions">
                  <el-input v-model="data.pictureCaptions" :disabled="readonly" />
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
                <el-form-item label="图片格式" prop="imageFormat">
                  <el-input v-model="data.imageFormat" :disabled="readonly" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="文件大小" prop="theFileSize">
                  <el-input v-model="data.theFileSize" :disabled="readonly" />
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
                <el-form-item label="是否源文件" prop="ifTheSourceFile">
                  <el-input v-model="data.ifTheSourceFile" :disabled="readonly" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="所属资源" prop="subordinateToTheResource">
                  <el-input v-model="data.subordinateToTheResource" :disabled="readonly" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="描述" prop="describe">
                  <!--<el-input size='mini' v-model="data.describe" :disabled="readonly" />-->
                  <edit v-model="data.describe" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="版权所有" prop="allRightsReserved">
                  <!--<el-input size='mini' v-model="data.allRightsReserved" :disabled="readonly" />-->
                  <edit v-model="data.allRightsReserved" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="版权说明" prop="copyright">
                  <!--<el-input size='mini' v-model="data.copyright" :disabled="readonly" />-->
                  <edit v-model="data.copyright" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="精选图片" prop="copyright">
                  <el-switch
                    :disabled="readonly"
                    v-model="data.show"
                    active-text="推荐显示"
                    inactive-text="取消显示" />
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="12">
                <el-form-item label="图片预览" prop="copyright">
                  <one-pic-up v-model="data.file" :disabled="readonly" />
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
  // import * as myrules from '../../../commonjs/rule'
  import OnePicUp from '../../.common/OnePicUp'

  @Component({
    components: {
      OnePicUp
    }
  })
  export default class ImageDatabase extends Mixins(BaseTable) {
    @Prop({ default: () => 'new' })
    id

    getUrl () {
      return this.AllUrl.trivalEnterprise.images
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
      // return {
      //   pictureCaptions: [{
      //     required: true,
      //     message: '图片标题不能为空',
      //     trigger: 'blur'
      //   }, {
      //     validator: myrules.validatLength,
      //     maxlength: 50,
      //     msg: '长度不能超过50',
      //     trigger: 'blur'
      //   }],
      //   type: [{
      //     required: true,
      //     message: '类型不能为空',
      //     trigger: 'blur'
      //   }],
      //   source: [{
      //     required: true,
      //     message: '来源不能为空',
      //     trigger: 'blur'
      //   }, {
      //     validator: myrules.validatLength,
      //     maxlength: 200,
      //     msg: '长度不能超过200',
      //     trigger: 'blur'
      //   }],
      //   imageFormat: [{
      //     validator: myrules.validatLength,
      //     maxlength: 200,
      //     msg: '长度不能超过200',
      //     trigger: 'blur'
      //   }],
      //   ifTheSourceFile: [{
      //     validator: myrules.validatLength,
      //     maxlength: 20,
      //     msg: '长度不能超过20',
      //     trigger: 'blur'
      //   }],
      //   subordinateToTheResource: [{
      //     required: true,
      //     message: '所属资源不能为空',
      //     trigger: 'blur'
      //   }, {
      //     validator: myrules.validatLength,
      //     maxlength: 20,
      //     msg: '长度不能超过20',
      //     trigger: 'blur'
      //   }],
      //   describe: [{
      //     required: true,
      //     message: '描述不能为空',
      //     trigger: 'blur'
      //   }],
      //   allRightsReserved: [{
      //     required: true,
      //     message: '版权所有不能为空',
      //     trigger: 'blur'
      //   }]
      // }
      return {}
    }
  }
</script>
