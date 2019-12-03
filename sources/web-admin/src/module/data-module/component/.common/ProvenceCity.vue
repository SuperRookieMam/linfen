<template>
  <div>
    <el-cascader v-model="valueStr"
                 expand-trigger="hover"
                 :options="userRegionTree"
                 :props="areaProps"/>
  </div>
</template>
<script>
  import Vue from 'vue'
  import { Component, Prop } from 'vue-property-decorator'
  import { namespace } from 'vuex-class'

  const regionModule = namespace('data/region')

  @Component({
    components: {
    },
    watch: {
      valueStr: {
        immediate:true,
        handler: function (value) {
           if (value !== '') {
             let val = value + ''
             val = value.substring(0,value.indexOf('0'))
             this.value.province = '山西省'
             this.value.regionCode = value
             for (let i = 0; i < this.userRegionTree.length; i++) {
               if ((this.userRegionTree[i].code+'') === value) {
                 this.value.city = this.userRegionTree[i].name
                 this.value.area = '市辖区'
                 return
               } else if ((this.userRegionTree[i].code+'').startsWith(val)) {
                 this.value.city = this.userRegionTree[i].name
                 if (this.userRegionTree[i].children) {
                   for (let j = 0; j <this.userRegionTree[i].children.length ; j++) {
                    if (this.userRegionTree[i].children[j].code === value) {
                      this.value.area = this.userRegionTree[i].children[j].name
                      return
                    }
                   }
                 } else {
                   this.value.city = this.userRegionTree[i].name
                   this.value.area = '市辖区'
                   return
                 }
               }
             }
           }
        }
      },
      value: {
        immediate:true,
        handler: function (value) {
          if (value.regionCode) {
            this.valueStr = value.regionCode
          }
        }
      }
    }
  })
  export default class ProvenceCity extends Vue {
    @Prop({type:Object, default: () => {}})
    value

    @regionModule.Action('loadRegions')
    loadRegions

    @regionModule.Getter('userRegionTree')
    userRegionTree

    valueStr = ''

    areaProps = {
      children: 'children',
      label: 'name',
      value: 'code',
      checkStrictly: true,
      expandTrigger: 'hover',
      emitPath: false
    }
  }
</script>
