<template>
  <div class="imgResource img">
    <el-container>
      <el-header>
        <!--<div class="title"></div>-->
          <div type="primary" size="mini">
            <!--文件上传控件-->
            <vue-uploader :url="url"
                          :http="http"
                          @item-success="itemSuccess"
                          :auto-upload="true" />
        </div>
      </el-header>
      <el-main>
        <div class="mainWap">
          <div class="imgWap"
               :disabled="disabled"
               v-for="(fileItem,index) in newFiles"
               :style="{backgroundImage: `url(${previewUrl}${fileItem.id})`}"
               :key="index">
            <div class="bgs" />
            <div class="operateWap">
              <div class="delete" @click="remove(index)"><i class="el-icon-delete" /></div>
            </div>
          </div>
          <div class="noData" v-show="!value.length"></div>
        </div>
      </el-main>
    </el-container>
  </div>
</template>

<script>
  import Vue from 'vue'
  // import 'es6-promise-polyfill'
  import VueUploader from 'vue2-uploader'
  import { Component, Prop, Watch } from 'vue-property-decorator'
  import http from '../../http'
  import { namespace } from 'vuex-class'

  const imageModule = namespace('data/image')

  @Component({
    components: {
      VueUploader
    }
  })
  export default class ManyPicUp extends Vue {
    /**
     * v-model绑定的值，详情参见v-model实现
     */
    @Prop({type: Array, default: () => []})
    value

    @Prop({type: Function})
    successReturn

    /**
     * 这个属性用于声明控件是否可编辑
     */
    @Prop({type: Boolean, default: () => false})
    disabled

    /**
     * 已上传，但未确认的文件列表，注意，这个是文件列表
     */
    newFiles = []

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
    previewUrl = `${CONTEXT_PATH}d/data/files/thumbnails/`
    /**
     * 保存图像信息
     */
    @imageModule.Action('save')
    save

    /**
     * 移除指定索引的项目
     * @param index
     */
    remove (index) {
      this.newFiles.splice(index, 1)
      this.$emit('input', this.newFiles)
    }

    /**
     * 当每个文件上传成功之后，将文件添加到待确认列表中
     * @param item
     * @param data
     */
    itemSuccess (item, data) {
      let da = data.data
      if (this.successReturn) {
         da =this.successReturn(da[0])
      }
      this.newFiles = this.newFiles.concat(da[0])
      this.$emit('input', this.newFiles)
    }

    @Watch('value')
    setnewFiles (value) {
      this.newFiles = value
    }

  }
</script>

<style lang="less">
  .imgResource {

  .el-container {
    width: 100%;
    border: 1px solid #ebebeb;
    border-radius: 3px;

  .el-header {
    background: rgba(252, 252, 255, 0.7);
    height: 50px !important;
    display: flex;
    justify-content: flex-start;
    align-items: center;
    border-bottom: 1px solid #ebebeb;
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
  .title {
    width: 60px;
    height: 100%;
    line-height: 50px;
    font-size: 18px;
    font-weight: bolder;
  }
  }

  .el-main {
    color: #333;
    text-align: center;
    min-height: 5px;

  .mainWap {
    width: 100%;
    height: 100%;
    display: flex;
    justify-content: flex-start;
    flex-wrap: wrap;

  .imgWap {
    width: 120px;
    height: 120px;
    border-radius: 3px;
    border: 1px solid #c0ccda;
    background-repeat: no-repeat;
    background-size: 100% 100%;
    margin: 0 15px 15px 0;
    z-index: 10;
    position: relative;

  .bgs {
    position: absolute;
    left: 0;
    top: 0;
    width: 100%;
    height: 100%;
    z-index: -1;
    opacity: 0.6;
    background: black;
    display: none;
  }

  .operateWap {
    position: absolute;
    left: 0;
    top: 0;
    width: 100%;
    height: 100%;
    display: none;

  .delete {
    width: 25px;
    height: 25px;
    margin: 0 auto;
    transform: translateY(150%);

  i {
    font-size: 25px;
    color: white;
  }

  }

  .update {
    width: 25px;
    height: 25px;
    float: right;
    margin-top: 35%;
    margin-right: 15%;

  i {
    font-size: 25px;
    color: white;
  }

  }
  }
  }

  .imgWap:hover .bgs {
    display: block;
  }

  .imgWap:hover .operateWap {
    display: block;
  }

  }
  }
  }

  .uploadBtn {

  .el-form-item__content {
    margin-left: 0 !important;

  .vue-uploader {
    display: inline-block;
    width: 100%;
    height: 35px;
    position: relative;
    margin-top: 15px;

  .vue-uploader-icon {
    display: inline-block;
    position: absolute;
    left: 0;
    top: 0;
    padding: 0 12px 0 12px;
    z-index: 0;
    color: #fff;
    background-color: #409EFF;
    border-color: #409EFF;
    border-radius: 5px;
    line-height: 32px;
  }

  input {
    position: absolute;
    left: 0;
    top: 0;
    z-index: 10;
    opacity: 0;
  }

  }
  }
  }

  .noData {
    width: 100%;
    display: flex;
    justify-content: center;
    font-size: 15px;
    color: #666666;
  }

  }
</style>
