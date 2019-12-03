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
            @click="save('ConsumptionMsg')"
            size="mini"
            v-if="!readonly">
            保存
          </el-button>
        </el-col>
      </el-row>
      <el-tabs v-model="activeName">
        <el-tab-pane label="基础信息" name="base">
          <el-row>
            <el-col :span="12">
              <el-form-item label="消费日期">
                <date-day-houre
                  v-model="data" />
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="详细时间" prop="time">
                <el-date-picker
                  v-model="data.time"
                  type="datetime"
                  placeholder="选择日期时间" />
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
              <el-form-item label="手机号" prop="mobile">
                <el-input v-model="data.mobile" :disabled="readonly" />
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="支付方式" prop="type">
                <el-input v-model="data.type" :disabled="readonly" />
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
              <el-form-item label="所在区域" prop="regionCode">
                <el-cascader v-model="data.regionCode"
                             expand-trigger="hover"
                             :options="userRegionTree"
                             :props="areaProps"
                             :disabled="readonly"
                             change-on-select />
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="商家" prop="business">
                <el-input v-model="data.business" :disabled="readonly" />
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
              <el-form-item label="金额" prop="money">
                <el-input v-model="data.money" :disabled="readonly" />
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
  import DateDayHoure from '../../.common/DateDayHoure'
  @Component({
    components: {
      DateDayHoure
    }
  })
  export default class ConsumptionMsg extends Mixins(BaseTable) {
    @Prop({default: () => 'new'})
    id

    // changeEnvents (val) {
    //   var date = new Date()
    //   this.data.time = val.split(' ')[0] +
    //                     (date.getHours() > 9 ? 'T' + date.getHours() : 'T0' + date.getHours()) +
    //                     (date.getMinutes() > 9 ? ':' + date.getMinutes() : ':0' + date.getMinutes()) +
    //                     (date.getSeconds() > 9 ? ':' + date.getSeconds() : ':0' + date.getSeconds())
    // }

    getUrl () {
      return `${this.AllUrl.trivalEnterprise.consumptionMsgs}`
    }

    get rules () {
      return {
        regionCode: [{
          required: true,
          message: '所在区域不能为空',
          trigger: 'blur'
        }],
        year: [{
          required: true,
          message: '不能为空',
          trigger: 'blur'
        }],
        month: [{
          required: true,
          message: '不能为空',
          trigger: 'blur'
        }],
        day: [{
          required: true,
          message: '不为空',
          trigger: 'blur'
        }],
        houre: [{
          required: true,
          message: '不能为空',
          trigger: 'blur'
        }],
        time: [{
          required: true,
          message: '不能为空',
          trigger: 'blur'
        }],
        type: [{
          required: true,
          message: '不能为空',
          trigger: 'blur'
        }],
        business: [{
          required: true,
          message: '不能为空',
          trigger: 'blur'
        }],
// 英文名字
        money: [{
          required: true,
          message: '不能为空',
          trigger: 'blur'
        }]
      }
    }
  }
</script>
