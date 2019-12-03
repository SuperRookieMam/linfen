<template>
  <div>
    <el-select :value="value" placeholder="请选择" @input="$emit('input',$event)">
      <el-option
        v-for="item in scenics"
        :key="item.id"
        :label="item.chineseFullName"
        :value="item.chineseFullName" />
    </el-select>
  </div>
</template>
<script>
  import Vue from 'vue'
  import { Component, Prop, Watch} from 'vue-property-decorator'
  import { namespace } from 'vuex-class'

  const urlModel = namespace('data/urlModel')
  const baseModel = namespace('data/baseModel')

  @Component
  export default class ScenicSelect extends Vue {
    @Prop({default: () => ''})
    value

    @urlModel.Getter('AllUrl')
    AllUrl

    @baseModel.Action('get')
    gets

    scenics = []

    created () {
      this.scenics = this.gets({url: this.AllUrl.trivalEnterprise.touristAttractions, params: {api: 1, params: '{}'}}).then(data => {
        this.scenics = data.data
      })
    }
  }
</script>
