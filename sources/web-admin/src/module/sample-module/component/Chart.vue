<template>
  <div>
    <button @click="updateData">更新数据</button>
    <e-charts :options="options"
              :manual-update="false"
              :auto-resize="true"
              style="width: 100%;" />
  </div>
</template>

<script>

  import Vue from 'vue'
  import { Component } from 'vue-property-decorator'
  import ECharts from '@/components/ECharts'
  import 'echarts/lib/chart/line'

  @Component({
    components: { ECharts }
  })
  export default class Chart extends Vue {
    options = {
      xAxis: {
        type: 'category',
        data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
      },
      yAxis: {
        type: 'value'
      },
      series: [{
        data: [820, 932, 901, 934, 1290, 1330, 1320],
        name: 'a',
        type: 'line'
      }]
    }

    i = 0

    updateData () {
      this.i += 10
      this.options = {
        xAxis: {
          type: 'category',
          data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
        },
        yAxis: {
          type: 'value'
        },
        series: [{
          data: [820, 932, 901, 934, 1290, 1330, this.i],
          name: 'a',
          type: 'line'
        }]
      }
    }

    created () {
    }
  }
</script>

<style scoped>

</style>
