<template xmlns:el-col="http://www.w3.org/1999/html">
  <el-form class="report"
           label-width="80px"
           :model="data"
           ref="form"
           :rules="rules">
    <el-row>
      <el-col :span="12">
        <el-form-item label="名称" prop="name">
          <el-input v-model="data.name" />
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="类型" prop="type">
          <el-select v-model="data.type">
            <el-option value="自然灾害" />
            <el-option value="事故灾难" />
            <el-option value="公共卫生事件" />
            <el-option value="社会安全" />
            <el-option value="其它" />
          </el-select>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row>
      <el-col :span="12">
        <el-form-item label="等级" prop="grade">
          <el-select v-model="data.grade">
            <el-option value="一级" />
            <el-option value="二级" />
            <el-option value="三级" />
          </el-select>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="状态" prop="status">
          <el-radio-group v-model="data.status">
            <el-radio :label="1">启用</el-radio>
            <el-radio :label="0">禁用</el-radio>
          </el-radio-group>
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
      <el-col style="text-align: center">
        <el-button type="primary" @click="submit">确定</el-button>
        <el-button type="danger" @click="cancel">取消</el-button>
      </el-col>
    </el-row>
  </el-form>
</template>

<script>
  import Vue from 'vue'
  import { Component, Prop } from 'vue-property-decorator'
  import vueQuillEditor from 'vue-quill-editor'
  import { namespace } from 'vuex-class'

  Vue.use(vueQuillEditor)

  const planModule = namespace('emergency/plan')

  @Component
  export default class Report extends Vue {
    data = {}

    @Prop({ default: () => 'new' })
    id

    @planModule.Action('save')
    save

    @planModule.Action('update')
    update

    @planModule.Action('load')
    load

    rules = {
      name: [{
        required: true,
        trigger: 'blur',
        message: '请输入名称'
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
      status: [{
        type: 'integer',
        required: true,
        trigger: 'change',
        message: '请选择预案状态'
      }]
    }

    created () {
      if (this.id !== 'new') {
        this.load({ id: this.id }).then(({ data }) => (this.data = data))
      }
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
</style>

<style lang="less">
  .report {

    .ql-editor {
      min-height: 300px;
    }

  }
</style>
