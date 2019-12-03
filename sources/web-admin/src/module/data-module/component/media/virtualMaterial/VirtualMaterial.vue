<!--虚拟素材-->
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
              @click="edit"
              size="mini"
              v-if="readonly">
              编辑
            </el-button>
            <el-button @click="goBack()" size="mini">取消</el-button>
            <el-button
              type="primary"
              @click="save"
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
                <el-form-item label="素材标题" prop="materialTitle">
                  <el-input v-model="data.materialTitle" :disabled="readonly" />
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
                <el-form-item label="素材分类" prop="theMaterialClassification">
                  <el-input v-model="data.theMaterialClassification" :disabled="readonly" />
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
                  <edit v-model="data.copyright" />
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
  import Vue from 'vue'
  import { Component, Prop } from 'vue-property-decorator'
  import { namespace } from 'vuex-class'
  import * as myrules from '../../../commonjs/rule'

  const virtualMaterialModule = namespace('data/virtualMaterial')
  @Component({
    components: {}
  })
  export default class VirtualMaterial extends Vue {
    @Prop({default: () => 'new'})
    id

    data = {}

    readonly = true

    get rules () {
      return {

        materialTitle: [{
          required: true,
          message: '素材标题不能为空',
          trigger: 'blur'
        }, {
          validator: myrules.validatLength,
          maxlength: 50,
          msg: '长度不能超过50',
          trigger: 'blur'
        }],
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
          message: '来源不能为空',
          trigger: 'blur'
        }, {
          validator: myrules.validatLength,
          maxlength: 200,
          msg: '长度不能超过200',
          trigger: 'blur'
        }],
        theMaterialClassification: [{
          required: true,
          message: '素材分类不能为空',
          trigger: 'blur'
        }, {
          validator: myrules.validatLength,
          maxlength: 200,
          msg: '长度不能超过200',
          trigger: 'blur'
        }],
        theFileSize: [{
          validator: myrules.validatLength,
          maxlength: 200,
          msg: '长度不能超过200',
          trigger: 'blur'
        }],
        subordinateToTheResource: [{
          required: true,
          message: '所属资源不能为空',
          trigger: 'blur'
        }],
        allRightsReserved: [{
          required: true,
          message: '版权所有不能为空',
          trigger: 'blur'
        }]
      }
    }

    @virtualMaterialModule.Action('save')
    saveData

    @virtualMaterialModule.Action('get')
    getData

    @virtualMaterialModule.Action('update')
    updateData

    save () {
      this.$refs.form.validate(valid => {
        if (valid) {
          if (this.id === 'new') {
            this.saveData(this.data).then(rsp => {
              this.data = rsp
            })
          } else {
            this.updateData({id: this.id, data: this.data})
          }
        } else {
          this.$message({
            message: '数据校验没有通过，请检查输入详情',
            type: 'error'
          })
        }
      })
    }

    edit () {
      this.readonly = false
    }

    goBack () {
      this.$router.go(-1)
    }

    created () {
      if (this.id !== 'new') {
        this.getData({id: this.id}).then(data => (this.data = data))
      } else {
        this.readonly = false
      }
    }
  }
</script>
