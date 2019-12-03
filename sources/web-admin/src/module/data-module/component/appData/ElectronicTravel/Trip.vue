<template>
  <el-container>
    <el-main>
      <el-form label-width="100px"
               :model="data"
               ref="form"
               size="mini"
               :rules="rules">
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
              @click="save('elTrip')"
              size="mini"
              v-if="!readonly">
              保存
            </el-button>
          </el-col>
        </el-row>
        <el-tabs>
          <el-tab-pane label="基本信息">
            <el-row>
              <el-col :span="12">
                <el-form-item label="酒店名字" prop="hotelName">
                  <el-input v-model="data.hotelName" :disabled="readonly" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="安排" prop="arrange">
                  <el-input v-model="data.arrange" :disabled="readonly" />
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="12">
                <el-form-item label="开始时间" prop="tripTime">
                  <el-date-picker style="width: 100%;"
                                  v-model="data.tripTime"
                                  :disabled="readonly"
                                  value-format="yyyy-MM-dd"
                                  format="yyyy-MM-dd" />
                </el-form-item>
              </el-col>
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

  @Component({
  })
  export default class Trip extends Mixins(BaseTable) {
    @Prop({default: () => 'new'})
    id

    getrfUrl () {
      return `${this.AllUrl.electronicTravel}`
    }

    getUrl () {
      return `${this.AllUrl.trip}`
    }

    rules = {}
  }
</script>

<style scoped>

</style>
