<template>
  <el-container>
    <el-main>
      <div class="quit" @click="qrcodeState"><i class="el-icon-close"></i></div>
    </el-main>
    <div class="qrcode" id="qrcodes"></div>
  </el-container>
</template>

<script>
  import Vue from 'vue'
  import { Component, Prop } from 'vue-property-decorator'
  import QRcode from 'qrcodejs2'

  @Component
  export default class TourismPurpose extends Vue {
    @Prop({type: String, default: () => '大美智旅'})
    value

    mounted () {
      this.qrcode()
    }

    qrcodeState () {
      this.$emit('qrcodeState', false)
    }

    qrcode () {
      let qrcode = new QRcode('qrcodes', {
        width: 300,
        height: 300, // 高度
        text: this.value, // 二维码内容
        image: '',
        render: 'canvas', // 设置渲染方式（有两种方式 table和canvas，默认是canvas）
        // background: '#f0f',
        // foreground: '#ff0'
      })
    }
  }
</script>

<style scoped lang="less">
  .el-container {
    width: 100%;
    height: 100%;
    position: fixed;
    top: 0;
    left: 0;
    z-index: 50;

  .el-main {
    position: absolute;
    left: 0;
    top: 0;
    width: 100%;
    height: 100%;
    z-index: -1;
    opacity: 0.5;
    background: black;

  .quit {
    position: absolute;
    right: 30px;
    top: 70px;
    width: 40px;
    height: 40px;

  i {
    font-size: 35px;
    color: white;
  }

  }
  }
  .qrcode {
    width: 26%;
    margin-left: 37%;
    height: 35%;
    margin-top: 10%;
    display: flex;
    justify-content: center;
    align-items: center;
  }

  }
</style>
