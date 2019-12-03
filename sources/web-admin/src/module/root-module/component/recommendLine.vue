<template>
  <el-form class="recommendLine" label-width="80px">
    <el-form-item>
      <el-button type="success" @click="submit">确定</el-button>
    </el-form-item>
    <el-row>
      <el-col :span="12">
        <el-form-item label="推荐路线名称">
          <el-input v-model="data.name" />
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="路线">
          <el-input v-model="data.routesId" />
        </el-form-item>
      </el-col>
    </el-row>
    <el-row>
      <el-col :span="12">
        <el-form-item label="景区">
          <el-input v-model="data.scenicIds" />
        </el-form-item>
      </el-col>
    </el-row>
    <el-row>
      <el-col :span="12">
        <el-form-item label="状态">
          <el-select v-model="data.status">
            <el-option :value="true" label="启用" />
            <el-option :value="false" label="禁用" />
          </el-select>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="优先级">
          <el-select v-model="data.priority">
            <el-option :value="0" label="低" />
            <el-option :value="1" label="中" />
            <el-option :value="2" label="高" />
          </el-select>
        </el-form-item>
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

  const recommendLineModule = namespace('root')
  @Component
  export default class recommendLine extends Vue {
    data = {
      id: '',
      name: '',
      routsId: '',
      scenicIds: '',
      status: '',
      priority: ''
    }

    allRoutes=[]

    draw=0

    pageSize=999999

    @Prop({default: () => 'new'})
    id

    @recommendLineModule.Action('save')
    save

    @recommendLineModule.Action('update')
    update

    @recommendLineModule.Action('load')
    getRecommendLine

    @recommendLineModule.Action('getAllRoutes')
    getAllRoutes

    created () {
      if (this.id !== 'new') {
        // 获取用户之后，重置用户的职务信息n
        this.getRecommendLine({id: this.id}).then((data) => {
          this.data = data.data
        })
      }
      this.getRoutes()
    }

    submit () {
      console.log(this.data)
      const p = this.id === 'new' ? this.save(this.data) : this.update(this.data)
      p.then(() => {
        this.$router.go(-1)
      })
    }

    getRoutes () {
      console.log(this)
      this.getAllRoutes({draw: this.draw, pageSize: this.pageSize}).then((data) => {
        console.log(data.data)
        this.allRoutes = data.data
        this.draw++
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
  .recommendLine {
    .ql-editor {
      min-height: 200px;
    }
  }
</style>
