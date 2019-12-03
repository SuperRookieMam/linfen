<template>
  <el-form class="sentiment"
           label-width="80px"
           :model="data"
           ref="form">
    <el-row>
      <el-col :span="12">
        <el-form-item label="标题">
          <el-input v-model="data.title" />
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="作者">
          <el-input v-model="data.authorName" />
        </el-form-item>
      </el-col>
    </el-row>
    <el-row>
      <el-col :span="12">
        <el-form-item label="浏览数">
          <el-input type="number" v-model.number="data.viewCount" />
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="发布时间">
          <el-date-picker style="width: 100%" type="datetime" v-model="data.createTime" />
        </el-form-item>
      </el-col>
    </el-row>
    <el-row>
      <el-col :span="12">
        <el-form-item label="网络来源">
          <el-select v-model="data.source">
            <el-option value="新浪微博" />
            <el-option value="微信" />
            <el-option value="今日头条" />
            <el-option value="百度贴吧" />
            <el-option value="新浪博客" />
          </el-select>
        </el-form-item>
      </el-col>

      <el-col :span="12">
        <el-form-item label="媒体类型">
          <el-select v-model="data.mediaType">
            <el-option value="微博" />
            <el-option value="网站" />
            <el-option value="微信" />
            <el-option value="客户端" />
            <el-option value="新闻" />
            <el-option value="论坛" />
            <el-option value="博客" />
            <el-option value="政务" />
            <el-option value="报刊" />
            <el-option value="视频" />
          </el-select>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row>
      <!--      <el-col :span="12">-->
      <!--        <el-form-item label="原始来源">-->
      <!--          <el-input v-model="data.orignSource" />-->
      <!--        </el-form-item>-->
      <!--      </el-col>-->
      <el-col :span="12">
        <el-form-item label="声量走势">
          <el-select v-model="data.volume">
            <el-option value="0" label="非敏感" />
            <el-option value="1" label="敏感" />
          </el-select>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="情感类型">
          <el-select v-model="data.sentimentType">
            <el-option value="1" label="正面" />
            <el-option value="0" label="中性" />
            <el-option value="-1" label="负面" />
          </el-select>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row>
      <el-col :span="12">
        <el-form-item label="来源省份">
          <el-select v-model="data.province" filterable>
            <el-option
              v-for="item in regionTree"
              :key="item.name"
              :label="item.name"
              :value="item.name" />
          </el-select>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row>
      <el-col>
        <el-form-item label="文章正文">
          <quill-editor v-model="data.content" />
        </el-form-item>
      </el-col>
    </el-row>
    <el-row>
      <el-col style="text-align: center">
        <el-button type="primary" @click="submit">保存</el-button>
        <el-button type="danger" @click="submit">取消</el-button>
      </el-col>
    </el-row>
  </el-form>
</template>
<script>
  import Vue from 'vue'
  import vueQuillEditor from 'vue-quill-editor'
  import { Component, Prop } from 'vue-property-decorator'
  import { namespace } from 'vuex-class'

  Vue.use(vueQuillEditor)

  const regionModule = namespace('data/region')
  const sentimentModule = namespace('sentiment')
  @Component
  export default class Sentiment extends Vue {
    data = {}

    @Prop({ default: () => 'new' })
    id

    @sentimentModule.Action('save')
    save

    @sentimentModule.Action('update')
    update

    @sentimentModule.Action('load')
    load

    @regionModule.Getter('regionTree')
    regionTree

    @regionModule.Action('loadRegions')
    loadRegions

    created () {
      if (this.id !== 'new') {
        this.load({ id: this.id }).then(({ data }) => (this.data = data))
      }
      this.loadRegions()
    }

    submit () {
      this.$refs.form.validate().then(() => {
        if (this.id === 'new') {
          return this.save(this.data)
        } else {
          return this.update(this.data)
        }
      }).then(() => {
        this.$router.go(-1)
      })
    }
  }
</script>
<style>
  @import "~quill/dist/quill.core.css";
  @import "~quill/dist/quill.snow.css";
  @import "~quill/dist/quill.bubble.css";
</style>
<style lang="less">
  .sentiment {
    .ql-editor {
      min-height: 200px;
    }
  }
</style>
