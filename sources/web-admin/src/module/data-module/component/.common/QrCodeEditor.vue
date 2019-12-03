<template>
  <el-row class="qrcodeEdit">
    <el-col :span="24" style="display: flex;justify-content: flex-start;align-items: center">
      <el-input type="text"
                :disabled="disabled"
                show-close=true
                @change="textChange"
                v-model="text" />
      <el-button size="mini" @click="preview">预览</el-button>
    </el-col>
    <el-dialog
      title="二维码预览"
      width="350px"
      :visible.sync="dialogVisible"
      @opened="dialogOpened"
      center>
      <div style="width: 350px;height: 300px;" ref="codeArea"></div>
    </el-dialog>
  </el-row>
</template>
<script>
  import Vue from 'vue'
  import { Component, Prop, Watch } from 'vue-property-decorator'
  import QrCode from 'qrcodejs2'

  @Component
  export default class QrCodeEditor extends Vue {
    @Prop({default: () => ''})
    value

    @Prop({
      default: () => false,
      type: Boolean
    })
    disabled

    dialogVisible = false

    code

    text = ''

    @Watch('value')
    change () {
      this.text = this.value
    }

    preview () {
      if (this.text === undefined || this.text === null || this.text === '') {

      } else {
        this.dialogVisible = true
      }
    }

    dialogOpened () {
      if (this.code === null || this.code === undefined) {
        this.code = new QrCode(this.$refs['codeArea'], {
          text: this.text,
          width: 300,
          height: 300,
          colorDark: '#000000',
          colorLight: '#ffffff',
          correctLevel: QrCode.CorrectLevel.H
        })
      } else {
        this.code.clear()
        this.code.makeCode(this.text)
      }
    }

    textChange () {
      this.$emit('input', this.text)
    }

  }
</script>

<style lang="less">
  .qrcodeEdit {

  .el-input {
    line-height: 28px !important
  }

  }
</style>
