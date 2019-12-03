<template>
  <div class="imgResource img">
    <div class="onepicup">
      <!--文件上传控件-->
      <vue-uploader :url="url"
                    :http="http"
                    @change="itemChange"
                    @item-success="itemSuccess"
                    :auto-upload="true" />
    </div>
    <div v-if="value && value !== ''">
      <video
        width="600px;"
        controls="controls"
        :src="previewUrl+ value">
        此格式不支持
      </video>
    </div>
  </div>
</template>

<script>
  import Vue from 'vue'
  // import 'es6-promise-polyfill'
  import VueUploader from 'vue2-uploader'
  import { Component, Prop } from 'vue-property-decorator'
  import http from '../../http'
  import { namespace } from 'vuex-class'

  const imageModule = namespace('data/video')

  @Component({
    components: {
      VueUploader
    }
  })
  export default class OneVideoUp extends Vue {
    /**
     * v-model绑定的值，详情参见v-model实现
     */
    @Prop({default: () => []})
    value

    /**
     * 上传中的文件
     */
    uploadFiles = []

    /**
     *  上传使用的http实例，
     */
    http = http

    /**
     * 上传的地址
     */
    url = `${CONTEXT_PATH}d/data/files`

    /**
     * 预览文件的地址
     */
    previewUrl = `${CONTEXT_PATH}d/data/files/`

    /**
     * 已上传，但未确认的文件列表，注意，这个是文件列表
     */
    newFiles = []

    /**
     * 保存图像信息
     */
    @imageModule.Action('save')
    save

    temp = ''

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
     * 当每个文件上传成功之后，将文件添加到待确认列表中
     * @param item
     * @param data
     */
    itemSuccess (item, data) {
      this.$emit('input', data.data[0].id)
    }
  }
</script>
<style lang="less">
  .onepicup {

  .vue-uploader-icon {
    display: inline-block;
    line-height: 1;
    white-space: nowrap;
    cursor: pointer;
    background: #FFF;
    border: 1px solid #DCDFE6;
    color: #606266;
    -webkit-appearance: none;
    text-align: center;
    box-sizing: border-box;
    outline: 0;
    margin: 0;
    -webkit-transition: .1s;
    transition: .1s;
    font-weight: 500;
    -moz-user-select: none;
    padding: 12px 20px;
    font-size: 14px;
    border-radius: 4px;
    color: #FFF;
    background-color: #409EFF;
    border-color: #409EFF;
  }

  }
</style>
