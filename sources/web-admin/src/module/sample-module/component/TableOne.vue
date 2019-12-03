<template>
  <ele-datatables :ajax="ajax">
    <el-table-column label="姓名"
                     prop="name" />
    <el-table-column label="地址"
                     prop="address" />
    <el-table-column label="日期"
                     prop="date" />
  </ele-datatables>
</template>

<script>
  import Vue from 'vue'
  import { Component } from 'vue-property-decorator'
  import EleDatatables from 'element-datatables'
  import { namespace } from 'vuex-class'

  const sampleModule = namespace('sample')

  @Component({
    components: {
      EleDatatables
    }
  })
  export default class TableOne extends Vue {
    ajax = '/table1'

    @sampleModule.State('name')
    name

    @sampleModule.Action('test')
    testAction2

    created () {
      this.testAction2().then(rsp => {
        // console.log(rsp)
      })
    }
  }
</script>

<style scoped>

</style>
