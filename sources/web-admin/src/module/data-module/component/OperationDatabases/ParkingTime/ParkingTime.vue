<template>
  <div>
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
            @click="save('parkingTime')"
            size="mini"
            v-if="!readonly">
            保存
          </el-button>
        </el-col>
      </el-row>
      <el-tabs>
        <el-tab-pane label="基础信息" name="base">
          <el-row>
            <el-col :span="6">
              <el-form-item label="年" prop="year">
                <el-input type="number" v-model="data.year" />
              </el-form-item>
            </el-col>
            <el-col :span="6">
              <el-form-item label="月" prop="month">
                <el-input type="number" v-model="data.month" />
              </el-form-item>
            </el-col>
          </el-row>

          <el-row>
            <el-col :span="6">
              <el-form-item label="日" prop="day">
                <el-input type="number" v-model="data.day" />
              </el-form-item>
            </el-col>
            <el-col :span="6">
              <el-form-item label="小时" prop="houre">
                <el-input v-model="data.houre" />
              </el-form-item>
            </el-col>
          </el-row>

          <el-row>
            <el-col :span="6">
              <el-form-item label="省" prop="province">
                <el-input v-model="data.province" />
              </el-form-item>
            </el-col>
            <el-col :span="6">
              <el-form-item label="市" prop="city">
                <el-input v-model="data.city" />
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="6">
              <el-form-item label="区" prop="area">
                <el-input v-model="data.area" />
              </el-form-item>
            </el-col>
            <el-col :span="6">
              <el-form-item label="景区" prop="scenic">
                <scenic-select v-model="data.scenic" :disabled="readonly" />
              </el-form-item>
            </el-col>
          </el-row>

          <el-row>
            <el-col :span="12">
              <el-form-item label="停车总数" prop="totalNumber">
                <el-input v-model="data.totalNumber" />
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
              <el-form-item label="使用量" prop="useNumber">
                <el-input v-model="data.useNumber" />
              </el-form-item>
            </el-col>
          </el-row>
        </el-tab-pane>
      </el-tabs>
    </el-form>
  </div>
</template>
<script>
  import { Component, Prop, Mixins } from 'vue-property-decorator'
  import BaseTable from '../../.common/BaseTable'
  import ScenicSelect from '../../.common/ScenicSelect'
  @Component({
    components: {
      ScenicSelect
    }
  })
  export default class ParkingTime extends Mixins(BaseTable) {
    @Prop({default: () => 'new'})
    id

    formName = 'form'

    currentHtml = 'form'

    getUrl () {
      return this.AllUrl.trivalEnterprise.parkingTimes
    }
  }
</script>
