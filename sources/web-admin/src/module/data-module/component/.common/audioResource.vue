<template>
  <div class="audioResource img">
    <el-container>
      <el-header>
        <div class="title">音频</div>
        <el-button type="primary" size="mini" @click="openDialog" v-if="!disabled">添加音频</el-button>
        <!--<a @click="openDialog" v-if="!disabled">添加文件</a>-->
      </el-header>
      <el-main>
        <div class="mainWap">
          <el-row class="imgWap" v-for="(fileItem,index) in value" :key="index">
            <el-col :span="22">
              <div class="grid-content">{{ fileItem.name }}</div>
            </el-col>
            <el-col :span="2" @click="remove(index)">
              <div class="grid-del "><i class="el-icon-delete" /></div>
            </el-col>
          </el-row>
          <div class="noData" v-show="!value.length">暂无数据</div>
        </div>
      </el-main>
    </el-container>

    <!--这个是资源编辑对话框-->
    <!--这里必需使用v-if,才能触发vue-uploader的组件重置，不然vue-uploader会一直保存其内部状态-->
    <el-dialog title="资源上传" v-if="dialogVisible" :visible.sync="dialogVisible">
      <el-form label-width="100px"
               :model="data"
               ref="form"
               :rules="rules">
        <el-form-item prop="files" class="uploadBtn">
          <!--这里是文件进度条列表-->
          <div v-for="file in uploadFiles">
            {{file.file.name}}
            <el-progress :percentage="file.progress"></el-progress>
          </div>
          <!--文件上传控件-->
          <vue-uploader :url="url"
                        :http="http"
                        @change="itemChange"
                        @item-success="itemSuccess"
                        :auto-upload="true" />
        </el-form-item>
        <el-row>
          <el-col :span="12">
            <el-form-item label="音频标题" prop="audioTitle">
              <el-input v-model="data.audioTitle" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="类型" prop="type">
              <el-input v-model="data.type" />
            </el-form-item>
          </el-col>
        </el-row>

        <el-row>
          <el-col :span="12">
            <el-form-item label="来源" prop="source">
              <el-input v-model="data.source" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="音频格式" prop="audioFormats">
              <el-input v-model="data.audioFormats" />
            </el-form-item>
          </el-col>
        </el-row>

        <el-row>
          <el-col :span="12">
            <el-form-item label="文件大小" prop="theFileSize">
              <el-input v-model="data.theFileSize" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="音频时长" prop="theAudioTime">
              <el-input v-model="data.theAudioTime" />
            </el-form-item>
          </el-col>
        </el-row>

        <el-row>
          <el-col :span="12">
            <el-form-item label="录制时间" prop="theRecordingTime">
              <el-input v-model="data.theRecordingTime" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="所属资源" prop="subordinateToTheResource">
              <el-input v-model="data.subordinateToTheResource" />
            </el-form-item>
          </el-col>
        </el-row>

        <el-row>
          <el-col :span="12">
            <el-form-item label="描述" prop="describe">
              <el-input v-model="data.describe" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="版权所有" prop="allRightsReserved">
              <el-input v-model="data.allRightsReserved" />
            </el-form-item>
          </el-col>
        </el-row>

        <el-row>
          <el-col :span="12">
            <el-form-item label="版权说明" prop="copyright">
              <el-input v-model="data.copyright" />
            </el-form-item>
          </el-col>
        </el-row>

      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="submit">确 定</el-button>
      </div>
    </el-dialog>

  </div>
</template>

<script>
  import Vue from 'vue'
  // import 'es6-promise-polyfill'
  import VueUploader from 'vue2-uploader'
  import { Component, Prop } from 'vue-property-decorator'
  import http from '../../http'
  import { namespace } from 'vuex-class'

  const imageModule = namespace('data/audio')

  @Component({
    components: {
      VueUploader
    }
  })
  export default class audioResource extends Vue {
    /**
     * v-model绑定的值，详情参见v-model实现
     */
    @Prop({type: Array, default: () => []})
    value

    /**
     * 这个属性用于声明控件是否可编辑
     */
    @Prop({type: Boolean, default: () => false})
    disabled

    /**
     * 上传中的文件
     */
    uploadFiles = []

    /**
     * 对话框是否可见
     */
    dialogVisible = false

    /**
     *  上传使用的http实例，
     */
    http = http

    /**
     * 上传的地址
     */
    url = `${CONTEXT_PATH}d/files`

    /**
     * 预览文件的地址
     */
    previewUrl = `${CONTEXT_PATH}d/files/thumbnails/`

    /**
     * 对话框中的表单数据
     * */
    data = {}

    /**
     * 已上传，但未确认的文件列表，注意，这个是文件列表
     */
    newFiles = []

    /**
     * 保存图像信息
     */
    @imageModule.Action('save')
    save

    /**
     * 校验规则，根据情况添加
     */
    get rules () {
      return {
        files: [{
          validator: this.validateFile
        }]
      }
    }

    /**
     * 校验文件是否上传
     * @param rule
     * @param value
     * @param callback
     */
    validateFile (rule, value, callback) {
      if (this.newFiles.length > 0) {
        callback()
      } else {
        callback(new Error('请选择文件并上传'))
      }
    }

    /**
     * 当文件选择内容改变时，更新进度框里面的内容
     */
    itemChange (items) {
      this.uploadFiles = items
    }

    /**
     * 移除指定索引的项目
     * @param index
     */
    remove (index) {
      this.value.splice(index, 1)
    }

    /**
     * 提交保存
     */
    submit () {
      this.$refs['form'].validate(valid => {
        if (valid) {
          // 根据上传的文件内容，重新构建图片库信息数组
          let datas = this.newFiles.map(({id: file}) => ({...this.data, file}))
          // 批量保存图片资源
          this.save(datas).then(datas => {
            // 将新增加的图片资源和原来的图片资源合并，并且通知外部组件，触发v-model更新
            this.$emit('input', [...this.value, ...datas])
            // 关闭文本框
            this.dialogVisible = false
          })
        }
      })
    }

    /**
     * 当每个文件上传成功之后，将文件添加到待确认列表中
     * @param item
     * @param data
     */
    itemSuccess (item, {data}) {
      this.newFiles = this.newFiles.concat(data)
    }

    /**
     * 打开对话框，重置相关数据
     */
    openDialog () {
      this.newFiles = []
      this.uploadFiles = []
      this.data = {}
      this.dialogVisible = true
    }
  }
</script>

<style lang="less">
  .audioResource {
    margin-top: 20px;

  .el-container {
    width: 100%;
    border: 1px solid #ebebeb;
    border-radius: 3px;

  .el-header {
    background: rgba(252, 252, 255, 0.7);
    height: 50px !important;
    display: flex;
    justify-content: flex-start;
    align-items: center;
    border-bottom: 1px solid #ebebeb;

  .title {
    width: 60px;
    height: 100%;
    line-height: 50px;
    font-size: 18px;
    font-weight: bolder;
  }

  .upfile {
    width: 60px;
    height: 35px;
    background: #409eff;
    border-radius: 3px;
    position: relative;
    line-height: 35px;
    text-align: center;
    font-size: 16px;
    color: white;
    margin-left: 20px;
  }

  }

  .el-main {
    color: #333;
    text-align: center;
    min-height: 5px;

  .mainWap {
    width: 100%;
    height: 100%;
    display: flex;
    justify-content: space-between;
    flex-wrap: wrap;

  .imgWap {
    width: 49%;
    height: 35px;
    background: rgba(33, 34, 31, 0.34);
    border-radius: 3px;

  .grid-content {
    border-radius: 4px;
    height: 36px;
    line-height: 36px;
    text-align: left;
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
    font-size: 17px;
    padding-left: 5px;
  }

  .grid-del {
    height: 36px;
    line-height: 45px;

  i {
    font-size: 25px;
  }

  }
  }
  }
  }
  }
  .uploadBtn {

  .el-form-item__content {
    margin-left: 0 !important;

  .vue-uploader {
    display: inline-block;
    width: 100%;
    height: 35px;
    position: relative;
    margin-top: 15px;

  .vue-uploader-icon {
    display: inline-block;
    position: absolute;
    left: 0;
    top: 0;
    padding: 0 12px 0 12px;
    z-index: 0;
    color: #fff;
    background-color: #409EFF;
    border-color: #409EFF;
    border-radius: 5px;
    line-height: 32px;
  }

  input {
    position: absolute;
    left: 0;
    top: 0;
    z-index: 10;
    opacity: 0;
  }

  }
  }
  }
  .noData {
    width: 100%;
    display: flex;
    justify-content: center;
    font-size: 15px;
    color: #666666;
  }

  }
</style>
