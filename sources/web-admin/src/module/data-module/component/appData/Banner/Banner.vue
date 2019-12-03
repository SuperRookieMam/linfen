<!--团队填报-->
<template>
  <el-container>
    <el-main>
      <el-form label-width="100px"
               :model="data"
               ref="form"
               size="mini">
        <el-row>
          <el-col :span="24" style="display: flex;justify-content: flex-end;margin-top: 15px;">
            <el-button
              type="primary"
              @click="readonly=false"
              size="mini"
              v-if="readonly">
              编辑
            </el-button>
            <el-button @click="goBack()" size="mini">取消</el-button>
            <el-button
              type="primary"
              @click="save('banner')"
              size="mini"
              v-if="!readonly">
              保存
            </el-button>
          </el-col>
        </el-row>
        <el-tabs v-model="activeName">
          <el-tab-pane label="基本" name="base">
            <el-row>
              <el-col :span="12">
                <el-form-item label="名字" prop="name">
                  <el-input v-model="data.name" :disabled="readonly" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="顺序" prop="orderNum">
                  <el-input type="number" v-model="data.orderNum" :disabled="readonly" />
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-form-item label="图片" class="img-list">
                <one-pic-up v-model="data.fileId" />
              </el-form-item>
            </el-row>
          </el-tab-pane>
        </el-tabs>
      </el-form>
    </el-main>
  </el-container>
</template>
<script>
  import BaseTable from '../../.common/BaseTable'
  import { Component, Prop, Mixins } from 'vue-property-decorator'
  import OnePicUp from '../../.common/OnePicUp'

  @Component({
    components: {
      OnePicUp
    }
  })
  export default class Banner extends Mixins(BaseTable) {
    @Prop({default: () => 'new'})
    id

    data = {
      name: '',
      orderNum: ''
    }

    rules = {}

    getUrl () {
      return this.AllUrl.banner
    }
  }
</script>
