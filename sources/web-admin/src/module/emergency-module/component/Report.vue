<template>
  <div class="report">
    <el-form :model="data"
             label-width="8em"
             ref="form"
             :rules="rules">
      <el-row>
        <el-col :span="12">
          <el-form-item label="标题:" prop="title">
            <el-input v-model="data.title" :disabled="true" />
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="企业:" prop="enterprise">
            <el-input v-model="data.enterprise" :disabled="true" />
          </el-form-item>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="12">
          <el-form-item label="上报人:" prop="reportMember">
            <el-input v-model="data.reportMember" :disabled="true" />
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="联系方式:" prop="reportTelephone">
            <el-input v-model="data.reportTelephone" :disabled="true" />
          </el-form-item>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="24">
          <el-form-item label="上报内容:" prop="content">
            <el-input v-model="data.content" :disabled="true" />
          </el-form-item>
        </el-col>
      </el-row>
      <el-row>
        <el-col>
          <el-form-item label="图片:" class="img-list">
            <viewer class="previewer" :images="thumbnails" :options="viewerOptions">
              <img v-for="src in thumbnails"
                   :src="src"
                   :key="src"
                   style="height: 60px;width: 60px">
            </viewer>
          </el-form-item>
        </el-col>
      </el-row>

      <el-row>
        <el-col>
          <el-form-item label="视频:">
            <a :href="`${fileUrl}/${video.id}?download`"
               target="_blank"
               v-for="video in data.video"
               :key="video.id"
               :download="video.fileName"> {{ video.filename }} </a>
          </el-form-item>
        </el-col>
      </el-row>

      <el-row>
        <el-col>
          <el-form-item label="音频:">
            <a :href="`${fileUrl}/${voice.id}`"
               target="_blank"
               v-for="voice in data.voice"
               :key="voice.id"> {{ voice.filename }} </a>
          </el-form-item>
        </el-col>
      </el-row>

      <el-row>
        <el-col style="text-align: center">
          <el-button type="primary" @click="toEvent" v-if="data.status!==1">转为应急事件</el-button>
          <el-button type="success" @click="handle" v-if="data.status!==1">标记为处理</el-button>
        </el-col>
      </el-row>
    </el-form>
  </div>
</template>

<script>
  import Vue from 'vue'
  import Viewer from 'v-viewer'
  import { Component, Prop } from 'vue-property-decorator'
  import { namespace } from 'vuex-class'

  Vue.use(Viewer)

  const reportSpace = namespace('emergency/report')
  const eventModule = namespace('emergency/event')
  @Component
  export default class Report extends Vue {
    data = {
      imgs: [],
      video: [],
      voice: []
    }

    fileUrl = `${CONTEXT_PATH}d/emergency/files`

    @reportSpace.Action('load')
    load

    @Prop()
    id

    @reportSpace.Action('update')
    updateReport

    @eventModule.Action('save')
    saveEvent

    created () {
      this.load({ id: this.id }).then(({ data }) => (this.data = data))
    }

    handle () {
      this.updateReport({
        ...this.data,
        status: 1
      }).then(({ data }) => {
        this.$router.go(-1)
      })
    }

    toEvent () {
      // 将事件状态置为已处理
      this.updateReport({
        ...this.data,
        status: 1
      }).then(({ data }) => {
        delete data.id
        data.source = '用户上报'
        data.status = 0
        // 新增一条事件信息
        return this.saveEvent(data)
      }).then(({ data: { id } }) => {
        // 跳转到事件页面
        this.$router.push({
          name: 'event',
          params: { id }
        })
      })
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
      enterprise: [{
        required: true,
        trigger: 'blur',
        message: '请输入企业'
      }],
      reportMember: [{
        required: true,
        trigger: 'blur',
        message: '请输入上报人'
      }],
      reportTelephone: [{
        required: true,
        trigger: 'blur',
        message: '请输入联系方式'
      }],
      content: [{
        required: true,
        trigger: 'blur',
        message: '请输入上报内容'
      }]
    }

    get thumbnails () {
      if (this.data.imgs) {
        return this.data.imgs.map(({ id }) => `${CONTEXT_PATH}d/emergency/files/thumbnails/${id}`)
      } else {
        return []
      }
    }
  }
</script>

<style>
  @import "~viewerjs/dist/viewer.css";
</style>

<style scoped>

</style>
