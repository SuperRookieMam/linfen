<template>
  <div>
    <el-date-picker
      v-model="valueStr"
      type="datetime"
      :format="format"
      :value-format="valueformat"
      placeholder="选择日期时间">
    </el-date-picker>
  </div>
</template>
<script>
  import Vue from 'vue'
  import { Component, Prop } from 'vue-property-decorator'

  @Component({
    components: {
    },
    watch: {
      valueStr: {
        immediate:true,
        handler: function (value) {
          if (value !== null) {
            let arr = value.split('-')
            this.value.year = arr[0]
            this.value.month = arr[1]
            let arr1 = arr[2].split(' ')
            this.value.day=arr1[0]
            this.value.hour = arr1[1]
            this.value.houre = arr1[1]
          }
        }
      },
      value: {
        immediate:true,
        handler: function (value) {
          if (value.year) {
            if (value.houre) {
              this.valueStr = `${value.year}-${value.month}-${value.day} ${value.houre}`
            } else if (value.hour) {
              this.valueStr = `${value.year}-${value.month}-${value.day} ${value.hour}`
            } else {
              this.valueStr = `${value.year}-${value.month}-${value.day} 08`
            }
          }
        }
      }
    }
  })
  export default class DateDayHoure extends Vue {
    @Prop({type:Object, default: () => {}})
    value

    valueStr = '2019-09-11 08'

    @Prop({type: String, default: () => 'yyyy-MM-dd HH'})
    format

    @Prop({type: String, default: () => 'yyyy-MM-dd HH'})
    valueformat
  }
</script>
