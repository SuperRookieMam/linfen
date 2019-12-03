<template xmlns:el-col="http://www.w3.org/1999/html">
  <el-form class="report"
           label-width="80px"
           :model="data"
           ref="form"
           :rules="rules">
    <el-row>
      <el-col :span="12">
        <el-form-item label="名称" prop="title">
          <el-input v-model="data.title" />
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="事件来源">
          <el-input v-model="data.source" />
        </el-form-item>
      </el-col>
    </el-row>
    <el-row>
      <el-col :span="8">
        <el-form-item label="事发地" prop="geographical">
          <el-input v-model="data.geographical" />
        </el-form-item>
      </el-col>
      <el-col :span="4">
        <el-form-item label="经度" prop="geographical">
          <el-input v-model="data.longitude" />
        </el-form-item>
      </el-col>
      <el-col :span="4">
        <el-form-item label="纬度" prop="geographical">
          <el-input v-model="data.latitude" />
        </el-form-item>
      </el-col>
      <el-col :span="8">
        <el-form-item label="事发时间" prop="reportTime">
          <el-date-picker type="datetime" style="width: 100%;" v-model="data.reportTime" />
        </el-form-item>
      </el-col>
    </el-row>
    <el-row>
      <el-col :span="12">
        <el-form-item label="企业" prop="enterprise">
          <el-input v-model="data.enterprise" />
        </el-form-item>
      </el-col>
      <el-col :span="6">
        <el-form-item label="联系人" prop="reportMember">
          <el-input v-model="data.reportMember" />
        </el-form-item>
      </el-col>
      <el-col :span="6">
        <el-form-item label="联系电话" prop="reportTelephone">
          <el-input v-model="data.reportTelephone" />
        </el-form-item>
      </el-col>
    </el-row>
    <el-row>
      <el-col :span="12">
        <el-form-item label="事件类型" prop="type">
          <el-select v-model="data.type">
            <el-option value="景区事件" />
            <el-option value="自然灾害" />
            <el-option value="交通事件" />
            <el-option value="其它事件" />
          </el-select>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="事件等级" prop="grade">
          <el-select v-model="data.grade">
            <el-option :value="1" label="Ⅰ级" />
            <el-option :value="2" label="Ⅱ级" />
            <el-option :value="3" label="Ⅲ级" />
            <el-option :value="4" label="Ⅳ级" />
          </el-select>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="事件预案" prop="plan">
          <el-select v-model="data.plan" value-key="id">
            <el-option v-for="plan in plans"
                       :key="plan.id"
                       :value="plan"
                       :label="plan.name" />
            <!--            <el-option value="预案1" />-->
            <!--            <el-option value="预案2" />-->
            <!--            <el-option value="预案3" />-->
            <!--            <el-option value="预案4" />-->
          </el-select>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="处理状态" prop="status">
          <el-select v-model="data.status">
            <el-option :value="1" label="已处理" />
            <el-option :value="0" label="未处理" />
          </el-select>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="处理结果" prop="handleResult">
          <el-input v-model="data.handleResult" />
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="处理人" prop="handleMember">
          <el-input v-model="data.handleMember" />
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="处理时间" prop="handleTime">
          <el-date-picker type="datetime" v-model="data.handleTime" />
        </el-form-item>
      </el-col>
    </el-row>

    <el-row>
      <el-col :span="24">
        <el-form-item label="内容" prop="content">
          <quill-editor v-model="data.content" />
        </el-form-item>
      </el-col>
    </el-row>
    <el-row>
      <el-col>
        <el-form-item label="图片" prop="imgs">
          <many-pic-up v-model="data.imgs" :disabled="readonly" />
        </el-form-item>
      </el-col>
    </el-row>
    <el-row>
      <el-col>
        <el-form-item label="视频" prop="video">
          <many-pic-up v-model="data.video" :disabled="readonly" />
        </el-form-item>
      </el-col>
    </el-row>
    <el-row>
      <el-col>
        <el-form-item label="音频" prop="voice">
          <many-pic-up v-model="data.voice" :disabled="readonly" />
        </el-form-item>
      </el-col>
    </el-row>
    <el-row>
      <el-col style="text-align: center">
        <el-button type="primary" @click="submit">确定</el-button>
        <el-button type="danger" @click="cancel">取消</el-button>
      </el-col>
    </el-row>
  </el-form>
</template>

<script>
  import Vue from 'vue'
  import Viewer from 'v-viewer'
  import { Component, Prop } from 'vue-property-decorator'
  import vueQuillEditor from 'vue-quill-editor'
  import { namespace } from 'vuex-class'
  import ManyPicUp from '../../data-module/component/.common/ManyPicUp'

  Vue.use(vueQuillEditor)
  Vue.use(Viewer)

  const eventModule = namespace('emergency/event')
  const planModule = namespace('emergency/plan')

  @Component({
    components: {
      ManyPicUp
    }
  })
  export default class Event extends Vue {
    data = {
      imgs: [],
      video: [],
      voice: []
    }

    fileUrl = `${CONTEXT_PATH}d/emergency/files`

    get thumbnails () {
      return this.data.imgs.map(item => `${CONTEXT_PATH}d/emergency/files/thumbnails/${item.id}`)
    }

    viewerOptions = {
      url: ({ src }, b, c) => {
        const id = src.substring(src.lastIndexOf('/'))
        return `${CONTEXT_PATH}d/emergency/files/${id}`
      }
    }

    rules = {
      title: [{
        required: true,
        trigger: 'blur',
        message: '请输入名称'
      }],
      geographical: [{
        required: true,
        trigger: 'blur',
        message: '请输入事发位置'
      }],
      reportTime: [{
        required: true,
        trigger: 'change',
        message: '请选择事发时间'
      }],
      enterprise: [{
        required: true,
        trigger: 'blur',
        message: '请输入企业名字'
      }],
      reportMember: [{
        required: true,
        trigger: 'blur',
        message: '请输入联系人'
      }],
      reportTelephone: [{
        required: true,
        trigger: 'blur',
        message: '请输入联系方式'
      }],
      type: [{
        required: true,
        trigger: 'change',
        message: '请选择预案类型'
      }],
      grade: [{
        required: true,
        trigger: 'change',
        message: '请选择预案等级'
      }],
      plan: [{
        required: true,
        trigger: 'change',
        message: '请选择预案'
      }],
      status: [{
        required: true,
        trigger: 'change',
        message: '请选择预案状态'
      }],
      handleResult: [{
        required: true,
        trigger: 'blur',
        message: '请输入处理结果'
      }],
      handleMember: [{
        required: true,
        trigger: 'blur',
        message: '请输入处理人'
      }],
      handleTime: [{
        required: true,
        trigger: 'change',
        message: '请选择处理时间'
      }]
    }

    @Prop({ default: () => 'new' })
    id

    @eventModule.Action('load')
    load

    @eventModule.Action('save')
    save

    @eventModule.Action('update')
    update

    @planModule.State('plans')
    plans

    @planModule.Action('loadPlans')
    loadPlans

    created () {
      // 加载预案列表
      this.loadPlans()
      if (this.id !== 'new') {
        this.load({ id: this.id }).then(({ data }) => (this.data = data))
      }
    }

    delImg (index) {
      this.data.imgs.splice(index, 1)
    }

    delVideo (index) {
      this.data.video.splice(index, 1)
    }

    delAudio (index) {
      this.data.voice.splice(index, 1)
    }

    imgUploadSuccess (fileItem, { data }) {
      this.data.imgs = [...this.data.imgs, ...data]
    }

    videoUploadSuccess (fileItem, { data }) {
      this.data.video = [...this.data.video, ...data]
    }

    audioUploadSuccess (fileIten, { data }) {
      this.data.voice = [...this.data.voice, ...data]
    }

    preview (index) {
      this.previewVisible = true
      this.previewIndex = index
    }

    submit () {
      this.$refs.form.validate().then(() => {
        if (this.id === 'new') {
          return this.save(this.data)
        } else {
          return this.update({ ...this.data, id: this.id })
        }
      }).then(() => {
        this.$router.go(-1)
      })
    }

    cancel () {
      this.$router.go(-1)
    }
  }
</script>
<style>
  @import "~quill/dist/quill.core.css";
  @import "~quill/dist/quill.snow.css";
  @import "~quill/dist/quill.bubble.css";
  @import "~viewerjs/dist/viewer.css";
</style>
<style lang="less" scoped>
  .img-list {

    .previewer {
      display: inline-block;

      img {
        width: 60px;
        height: 60px;
        margin-right: 5px;
      }
    }

    .vue-uploader {
      height: 60px;
      display: inline-block;
      vertical-align: top;
      font-size: 40px;
    }
  }

  .file-list {
    display: inline-block;

    .file-list-item {
      display: inline-block;
      margin-right: 10px;

      .el-icon-document-delete {
        cursor: pointer;
      }

      .vue-uploader {
        cursor: pointer;
      }
    }
  }
</style>

<style lang="less">
  .report {

    .ql-editor {
      min-height: 300px;
    }

    .vue-uploader {
      display: inline-block;
      cursor: pointer;
    }
  }
</style>
