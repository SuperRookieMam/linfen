<template>
  <div>
    <el-form inline>
      <el-form-item>
        <el-input placeholder="请输入关键字" v-model="keywords" />
      </el-form-item>
      <el-form-item style="float: right">
        <el-button type="primary" @click="$router.push({name:'keyWord',params:{id:'new'}})">新增</el-button>
      </el-form-item>
    </el-form>
    <ele-datatables :ajax="ajax" ref="table">
      <el-table-column label="热词" prop="keyword" />
      <el-table-column label="类型" prop="type" />
      <el-table-column label="创建时间" prop="createTime" />
      <el-table-column label="操作">
        <template v-slot="{row:{id}}">
          <router-link :to="{name:'keyWord',params:{id}}">编辑</router-link>
          <a href="javascript:void(0)" @click="del(id)">删除</a>
        </template>
      </el-table-column>
    </ele-datatables>
  </div>
</template>

<script>
  import Vue from 'vue'
  import { Component } from 'vue-property-decorator'
  import { namespace } from 'vuex-class'
  import EleDatatables from 'element-datatables'

  const keyWordModule = namespace('emergency/keyWord')
  @Component({
    components: {
      EleDatatables
    }
  })
  export default class KeyWords extends Vue {
    keywords = ''

    @keyWordModule.State('url')
    ajax

    @keyWordModule.Action('delete')
    delById

    del (id) {
      this.$confirm('此操作将永久删除该记录, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        return this.delById({ id })
      }).then(() => {
        this.$message({
          type: 'success',
          message: '删除成功!'
        })
        this.$refs.table.reloadData()
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        })
      })
    }
  }
</script>

<style scoped>

</style>
