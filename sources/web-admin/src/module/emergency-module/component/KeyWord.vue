<template xmlns:el-col="http://www.w3.org/1999/html">
  <el-form class="report"
           label-width="80px"
           :model="data"
           ref="form">
    <el-row>
      <el-col :span="12">
        <el-form-item label="热词" prop="keyword">
          <el-input v-model="data.keyword" />
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="类型" prop="type">
          <el-select v-model="data.type">
            <el-option value="正面" />
            <el-option value="负面" />
            <el-option value="中性" />
          </el-select>
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
  import { namespace } from 'vuex-class'

  const keyWordModule = namespace('emergency/keyWord')

  @Component
  export default class Report extends Vue {
    data = {}

    @Prop({ default: () => 'new' })
    id

    @keyWordModule.Action('save')
    save

    @keyWordModule.Action('update')
    update

    @keyWordModule.Action('load')
    load

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
