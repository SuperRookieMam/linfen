<template>
  <el-container>
    <el-main>
      <el-form inline />
      <ele-data-tables ref="list"
                       :server-params="searchObj"
                       :ajax="ajax">
        <!--        <el-table-column prop="regionName" label="区域" sortable="custom" />-->
        <el-table-column prop="name" label="景区名称" sortable="custom" />
        <el-table-column prop="type" label="类型" sortable="custom" />
        <el-table-column prop="value" label="人数" sortable="custom" />
        <el-table-column prop="currentDate" :formatter="$dateTimeFormatter" label="时间" />
        <!--        <el-table-column label="创建时间" prop="createTime" :formatter="$dateTimeFormatter" />-->
        <!--        <el-table-column label="更新时间" prop="updateTime" :formatter="$dateTimeFormatter" />-->
      </ele-data-tables>
    </el-main>
  </el-container>
</template>

<script>
  import Vue from 'vue'
  import { Component } from 'vue-property-decorator'

  @Component
  export default class Access extends Vue {
    searchObj = {
      sort: 'currentDate,desc'
    }

    ajax = `${CONTEXT_PATH}d/kpi/accesss`
  }
</script>

<style scoped>

</style>
