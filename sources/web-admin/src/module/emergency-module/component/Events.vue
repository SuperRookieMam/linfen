<template>
  <div class="reports">
    <el-form inline>
      <el-form-item>
        <el-input placeholder="请输入关键字" />
      </el-form-item>
      <el-form-item style="float: right">
        <el-button type="primary" @click="$router.push({name:'event',params:{id:'new'}})">新增</el-button>
      </el-form-item>
    </el-form>
    <el-datatables :ajax="ajax" ref="table">
      <el-table-column label="名称" prop="title" />
      <el-table-column label="来源" prop="source" />
      <el-table-column label="事发地" prop="geographical" />
      <el-table-column label="事件时间" prop="reportTime">
        <template slot-scope="scope">
          <span>{{ scope.row.reportTime|dateFormat }}</span>
        </template>
      </el-table-column>
      <el-table-column label="处理状态" prop="status">
        <template v-slot="{row:{status}}">
          {{ status===1?'已处理':'未处理' }}
        </template>
      </el-table-column>
      <el-table-column label="事件等级" prop="grade">
        <template v-slot="{row:{grade}}">
          {{ ['','Ⅰ级','Ⅱ级','Ⅲ级','Ⅳ级'][grade] }}
        </template>
      </el-table-column>
      <el-table-column label="事件类型" prop="type" />
      <el-table-column label="操作">
        <template v-slot="{row}">
          <router-link :to="{name:'event',params:{id:row.id}}">编辑</router-link>
          <a href="javascript:void(0)" @click="del(row)">删除</a>
        </template>
      </el-table-column>
    </el-datatables>
  </div>
</template>

<script>
  import Vue from 'vue'
  import { Component } from 'vue-property-decorator'
  import ElDatatables from 'element-datatables'
  import { namespace } from 'vuex-class'
  import Template from '../../kpi-module/component/.common/Template'

  const eventModule = namespace('emergency/event')
  @Component({
    components: {
      Template,
      ElDatatables
    }
  })
  export default class Events extends Vue {
    @eventModule.State('url')
    ajax

    @eventModule.Action('delete')
    delById

    del ({ id }) {
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
