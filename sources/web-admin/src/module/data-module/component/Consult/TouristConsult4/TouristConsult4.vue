<template>
  <div>
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
            @click="save('touristConsult4')"
            size="mini"
            v-if="!readonly">
            保存
          </el-button>
        </el-col>
      </el-row>
      <el-tabs v-model="activeName">
        <el-tab-pane label="基础信息" name="base">
          <el-row>
            <el-col :span="12">
              <el-form-item label="标题" prop="titile">
                <el-input v-model="data.titile" :disabled="readonly" />
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="来源" prop="source">
                <el-input v-model="data.source" :disabled="readonly" />
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
              <el-form-item label="所在区域" prop="regionCode">
                <el-cascader v-model="data.regionCode"
                             expand-trigger="hover"
                             :options="userRegionTree"
                             :props="areaProps"
                             :disabled="readonly"
                             change-on-select />
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="简介" prop="description">
                <el-input v-model="data.description" :disabled="readonly" />
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
              <el-form-item label="创建人" prop="creatUser">
                <el-input v-model="data.creatUser" :disabled="readonly" />
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="类型" prop="type">
                <el-input v-model="data.type" :disabled="readonly" />
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="24">
              <el-form-item label="图片" class="img-list">
                <many-pic-up v-model="data.imgs" :disabled="readonly" />
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col>
              <el-form-item label="html" prop="html">
                <quill-editor
                  v-model="data.html"
                  ref="myQuillEditor"
                  :options="editorOption"
                  @blur="onEditorBlur($event)"
                  @focus="onEditorFocus($event)"
                  @ready="onEditorReady($event)" />
              </el-form-item>
            </el-col>
          </el-row>
        </el-tab-pane>
      </el-tabs>
    </el-form>
  </div>
</template>
<script>
  import { Component, Prop, Mixins } from 'vue-property-decorator'
  import BaseTable from '../../.common/BaseTable'
  // import VueUploader from 'vue2-uploader'
  // import uploader from '../uploader'
  import ManyPicUp from '../../.common/ManyPicUp'
  @Component({
    components: {
      ManyPicUp
    },
    watch: {
      data: {
        immediate: true,
        handler: (data) => {
          data.type = '旅游动态'
        }
      }
    }
  })
  export default class TouristConsult extends Mixins(BaseTable) {
    @Prop({default: () => 'new'})
    id

    editorOption = {
      // some quill options
    }

    data = {
      imgs: []
    }

    fileUrl = `${CONTEXT_PATH}d/data/files`

   // uploader = uploader

    get thumbnails () {
      return this.data.imgs.map(item => `${CONTEXT_PATH}d/data/files/thumbnails/${item.id}`)
    }

    viewerOptions = {
      url: ({ src }, b, c) => {
        const id = src.substring(src.lastIndexOf('/'))
        return `${CONTEXT_PATH}d/data/files/${id}`
      }
    }

    imgUploadSuccess (fileItem, { data }) {
      this.data.imgs = [...this.data.imgs, ...data]
    }

    getUrl () {
      return this.AllUrl.trivalEnterprise.touristConsults
    }

    // 失去焦点事件
    onEditorBlur (quill) {
    }

    // 获得焦点事件
    onEditorFocus (quill) {
    }

    onEditorReady (quill) {
      console.log('editor ready!', quill)
    }

    // 内容改变事件
    onEditorChange ({ quill, html, text }) {
    }

    rules = {}
  }
</script>
