<template>
  <el-container>
    <el-main>
      <ele-data-tables :ajax="ajax"
                       ref="list"
                       pagination-layout="total, sizes, prev, pager, next, jumper"
                       :server-params="searchObj">
        <el-table-column label="应用名称" prop="name" />
      </ele-data-tables>
    </el-main>
  </el-container>
</template>

<script>
  import Vue from 'vue'
  import { Component } from 'vue-property-decorator'
  import EleDataTables from 'element-datatables'

  @Component({
    components: {
      EleDataTables
    }
  })
  export default class Apps extends Vue {

  }
</script>

<style scoped>

</style>
