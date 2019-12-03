<template>
  <div class="reports">
    <el-form inline>
      <el-form-item>
        <el-input placeholder="请输入关键字" />
      </el-form-item>
    </el-form>
    <el-datatables :ajax="ajax">
      <el-table-column label="标题" prop="title" />
      <el-table-column label="企业" prop="enterprise" />
      <el-table-column label="上报人" prop="reportMember" />
      <el-table-column label="联系方式" prop="reportTelephone" />
      <el-table-column label="状态">
        <template v-slot="{row:{status}}">
          {{ status===1?'已处理':'未处理' }}
        </template>
      </el-table-column>
      <el-table-column label="操作">
        <template v-slot="{row}">
          <router-link :to="{name:'report',params:{id:row.id}}">详情</router-link>
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

  const reportModule = namespace('emergency/report')
  @Component({
    components: {
      Template,
      ElDatatables
    }
  })
  export default class Reports extends Vue {
    @reportModule.State('url')
    ajax
  }
</script>

<style scoped>

</style>
