<template>
  <el-row class="edit_preview">
    <el-col :space="24" style="display: flex;justify-content: space-around;">
      <div class="details">
        <span class="ql-editor" v-html="value"></span>
      </div>
      <el-button size="mini" class="btns" @click="preview" type="primary" style="margin: 6px 0 0 5px;">预览</el-button>
      <el-button size="mini" class="btns" @click="edit" type="primary" style="margin-top: 6px;">编辑</el-button>
    </el-col>
    <el-dialog
      title="编辑"
      :modal=true
      :before-close="handleClose"
      :visible="editDialogVisible"
      v-if="editDialogVisible"
      center>
      <quill-editor
        v-model="text"
        ref="myQuillEditor"
        :options="editorOption" />
      <!--<div class="wrapper">-->
        <!--<div class="editorElem" ref="editorElem"></div>-->
      <!--</div>-->
      <span slot="footer" class="dialog-footer">
        <el-button @click="editDialogQuit">取 消</el-button>
        <el-button type="primary" @click="editDialogConfirm">确 定</el-button>
      </span>
    </el-dialog>
    <el-dialog
      title="预览"
      :visible="detailDialogVisible"
      v-if="detailDialogVisible"
      :before-close="handleClose"
      width="30%">
      <div v-html="value"></div>
      <span slot="footer" class="dialog-footer">
        <el-button type="primary" @click="detailDialogConfirm">确 定</el-button>
      </span>
    </el-dialog>
  </el-row>
</template>

<script>
  import Vue from 'vue'
  import { Component, Prop, Watch } from 'vue-property-decorator'
  import E from 'wangeditor'

  let editor = ''

  @Component
  export default class edit extends Vue {
    @Prop({default: () => '',required:true})
    value

    editDialogVisible = false
    detailDialogVisible = false

    text=''

    //预览
    preview () {
      this.detailDialogVisible = true
    }

    //编辑
    edit () {
      this.text=this.value
      this.editDialogVisible = true
    }

    handleClose (done) {
      this.editDialogVisible = false
      this.detailDialogVisible = false
    }

    // 富文本编辑取消按钮
    editDialogQuit () {
      this.editDialogVisible = false
    }

    // 富文本编辑确认按钮
    editDialogConfirm () {
      this.editDialogVisible = false
      this.$emit('input', this.text)
    }

    //预览 详情 取消按钮
    detailDialogQuit () {
      this.detailDialogVisible = false
    }

    // 预览 详情确认按钮
    detailDialogConfirm () {
      this.detailDialogVisible = false
    }

    editorOption = {
      // some quill options
    }

    created (){
      this.text=this.value
    }

  }
</script>

<style lang="less">
  .ql-container {
    min-height: 200px;
    max-height: 500px;
    overflow: auto;

  .ql-editor {
    min-height: 200px;
  }
  }
  .edit_preview {
  .editorElem {
    height: 300px;
  }

  .el-dialog {
    min-width: 750px !important;
  }

  .w-e-text-container {
    height: 282px !important;
  }

  .details {
    width: 80%;
    height: 28px;
    border: 1px solid #dcdfe6;
    border-radius: 3px;
    line-height: 28px !important;

  span {
    display: inline-block;
    width: 100%;
    height: 100%;
    overflow: hidden;
    white-space: nowrap;
    text-overflow: ellipsis;
  }

  }
  .btns {
    width: 56px;
    height: 28px;
    margin: 0px 0px 0px 5px !important;
  }
  }

</style>
