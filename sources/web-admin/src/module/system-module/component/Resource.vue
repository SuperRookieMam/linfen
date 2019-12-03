<template>
  <el-form class="resource"
           size="mini"
           :model="data"
           :rules="rules"
           label-width="120px"
           ref="form">
    <el-row>
      <el-col :span="24">
        <el-form-item label="资源名称" prop="name">
          <el-input v-model="data.name" />
        </el-form-item>
      </el-col>
    </el-row>
    <el-row>
      <el-col :span="24">
        <el-form-item label="资源路径" prop="matcher">
          <el-input v-model="data.matcher" />
        </el-form-item>
      </el-col>
    </el-row>
    <el-row>
      <el-col :span="24">
        <el-form-item label="资源匹配模式" prop="matchType">
          <el-select v-model="data.matchType" placeholder="请选择">
            <el-option value="REGEXP" label="正则表达式" />
            <el-option value="ANT_PATH" label="路径匹配" />
          </el-select>
        </el-form-item>
      </el-col>
    </el-row>

    <el-row>
      <el-col :span="24">
        <el-form-item label="资源所属范围" prop="scope">
          <el-select v-model="data.scope"
                     filterable
                     multiple
                     default-first-option
                     allow-create
                     placeholder="请选择">
            <el-option v-for="scope in scopes"
                       :key="scope"
                       :value="scope" />
          </el-select>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row>
      <el-col :span="24">
        <el-form-item label="描述信息" prop="description">
          <el-input v-model="data.description" type="textarea" />
        </el-form-item>
      </el-col>
    </el-row>
  </el-form>
</template>
<script>
  import Vue from 'vue'
  import { Component, Prop } from 'vue-property-decorator'
  import { namespace } from 'vuex-class'

  const resourceModule = namespace('system/resource')
  @Component
  export default class Resource extends Vue {
    data = {
      matchType: 'ANT_PATH'
    }

    scopes = []

    @Prop({ default: () => 'new' })
    id

    get rules () {
      return {
        matcher: [{
          required: true,
          message: '资源路径不能为空',
          trigger: 'blur'
        }],
        name: [{
          required: true,
          message: '资源名称不能为空',
          trigger: 'blur'
        }]
      }
    }

    @resourceModule.Action('save')
    save

    @resourceModule.Action('get')
    getResource

    @resourceModule.Action('update')
    update

    @resourceModule.Action('listScopes')
    listScopes

    created () {
      if (this.id !== 'new') {
        this.getResource({ id: this.id }).then(({ data }) => (this.data = data))
      }
      this.listScopes().then(({ data }) => (this.scopes = data))
    }

    goBack () {
      this.$router.push({ name: 'resources' })
    }

    submit () {
      return this.$refs.form.validate().then(valid => {
        return this.id === 'new' ? this.save(this.data) : this.update(this.data)
      })
    }
  }
</script>

<style lang="less">
</style>
