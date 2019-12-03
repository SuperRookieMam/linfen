<template>
  <div>
    <el-form inline>
      <el-form-item>
        <el-input placeholder="请输入关键字" v-model="keywords" />
      </el-form-item>
      <el-form-item style="float: right">
        <el-button type="primary" @click="$router.push({name:'plan',params:{id:'new'}})">新增预案</el-button>
      </el-form-item>
    </el-form>
    <ele-datatables :ajax="ajax" ref="table">
      <el-table-column label="名称" prop="name" />
      <el-table-column label="创建人" prop="createdBy.username" />
      <el-table-column label="类型" prop="type" />
      <el-table-column label="等级" prop="grade" />
      <el-table-column label="创建时间" prop="createdDate">
        <template slot-scope="scope">
          <span>{{ scope.row.createdDate|dateFormat }}</span>
        </template>
      </el-table-column>
      <el-table-column label="更新时间" prop="lastModifiedDate">
        <template slot-scope="scope">
          <span>{{ scope.row.lastModifiedDate|dateFormat }}</span>
        </template>
      </el-table-column>
      <el-table-column label="状态">
        <template v-slot="{row:{status}}">
          {{ status===1?'启用':'禁用' }}
        </template>
      </el-table-column>
      <el-table-column label="操作">
        <template v-slot="{row:{id}}">
          <router-link :to="{name:'plan',params:{id}}">编辑</router-link>
          <a href="javascript:void(0)" @click="del(id)">删除</a>
        </template>
      </el-table-column>
    </ele-datatables>
  </div>
</template>

<script>
  import Vue from 'vue'
  import { Component } from 'vue-property-decorator'
  import EleDatatables from 'element-datatables'
  import { namespace } from 'vuex-class'
  import Template from '../../kpi-module/component/.common/Template'

  const planModule = namespace('emergency/plan')
  @Component({
    components: {
      Template,
      EleDatatables
    }
  })
  export default class Plans extends Vue {
    keywords = ''

    @planModule.State('url')
    ajax

    @planModule.Action('delete')
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
