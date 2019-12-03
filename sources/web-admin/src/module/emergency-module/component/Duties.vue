<template>
  <div>
    <el-form>
      <el-row>
        <el-col :span="12">
          <el-form-item>
            <el-date-picker v-model="currentDate" type="month" placeholder="选择月" />
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item>
            <el-button style="float: right;" type="primary" @click="add">批量设置</el-button>
          </el-form-item>
        </el-col>
      </el-row>
    </el-form>
    <el-calendar v-model="currentDate" :first-day-of-week="7">
      <template v-slot:dateCell="{date,data}">
        <div style="height: 100%" @click="edit(date)">
          <div>{{ date | toMonthDate }}</div>
          <div>早班: {{ getData(date)['morningWorkerName'] }}</div>
          <div>中班: {{ getData(date)['noonWorkerName'] }}</div>
          <div>晚班: {{ getData(date)['nightWorkerName'] }}</div>
        </div>
      </template>
    </el-calendar>
    <el-dialog :visible.sync="visible" title="排班设置">
      <el-form ref="form"
               label-width="120px"
               :model="currentData"
               :rules="rules">
        <el-row v-if="currentData.createTime">
          <el-col>
            <el-form-item label="日期">
              <el-date-picker readonly style="width: 100%;" v-model="currentData.createTime" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row v-if="!currentData.createTime">
          <el-col :span="12">
            <el-form-item label="开始时间" prop="startDate">
              <el-date-picker style="width: 100%;" v-model="currentData.startDate" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="结束时间" prop="endDate">
              <el-date-picker style="width: 100%;" v-model="currentData.endDate" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="12">
            <el-form-item label="早班">
              <el-input v-model="currentData.morningWorkerName" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="联系电话"
                          prop="morningWorkerTelephone"
                          :rules="currentData.morningWorkerName===''?[{required: false}]:[{required: true,
                                                                                           message: '联系电话不能为空',
                                                                                           trigger: 'blur'
                          }, {
                            type: 'string',
                            len: 11,
                            message: '请输入合法的手机号'
                          }]">
              <el-input v-model="currentData.morningWorkerTelephone" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="12">
            <el-form-item label="中班">
              <el-input v-model="currentData.noonWorkerName" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="联系电话"
                          prop="noonWorkerTelephone"
                          :rules="currentData.noonWorkerName===''?[{required: false}]:[{required: true,
                                                                                        message: '联系电话不能为空',
                                                                                        trigger: 'blur'
                          }, {
                            type: 'string',
                            len: 11,
                            message: '请输入合法的手机号'
                          }]">
              <el-input v-model="currentData.noonWorkerTelephone" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="12">
            <el-form-item label="晚班">
              <el-input v-model="currentData.nightWorkerName" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="联系电话"
                          prop="nightWorkerTelephone"
                          :rules="currentData.nightWorkerName===''?[{required:false}]:[{required: true,
                                                                                        message: '联系电话不能为空',
                                                                                        trigger: 'blur'
                          }, {
                            type: 'string',
                            len: 11,
                            message: '请输入合法的手机号'
                          }]">
              <el-input v-model="currentData.nightWorkerTelephone" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="12">
            <el-form-item label="指挥部门电话">
              <el-input v-model="currentData.headquarterTelephone" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="管理部门电话">
              <el-input v-model="currentData.managerDepartmentTelephone" />
            </el-form-item>
          </el-col>
        </el-row>
      </el-form>
      <template v-slot:footer>
        <el-row>
          <el-col>
            <el-button type="primary" @click="submit">确定</el-button>
            <el-button type="danger" @click="visible=false">取消</el-button>
          </el-col>
        </el-row>
      </template>
    </el-dialog>
  </div>
</template>

<script>
  import Vue from 'vue'
  import { Component, Watch } from 'vue-property-decorator'
  import dayjs from 'dayjs'
  import { namespace } from 'vuex-class'

  const scheduleSpace = namespace('emergency/duty')
  @Component({
    filters: {
      toMonthDate (value) {
        return `${value.getMonth() + 1} / ${value.getDate()}`
      }
    }
  })
  export default class Duties extends Vue {
    currentDate = new Date()

    visible = false

    currentData = {
      headquarterTelephone: '',
      managerDepartmentTelephone: '',
      morningWorkerName: '',
      morningWorkerTelephone: '',
      noonWorkerName: '',
      noonWorkerTelephone: '',
      nightWorkerName: '',
      nightWorkerTelephone: ''
    }

    dateList = []

    @scheduleSpace.Action('loadSchedules')
    loadSchedules

    @scheduleSpace.Action('save')
    save

    rules = {
      startDate: [{
        required: true,
        trigger: 'change',
        message: '请选择开始时间'
      }],
      endDate: [{
        required: true,
        trigger: 'change',
        message: '请选择结束时间'
      }],
      morningWorkerTelephone: [{
        required: false
      }],
      noonWorkerTelephone: [{
        required: false
      }],
      nightWorkerTelephone: [{
        required: false
      }]
    }

    edit (createTime) {
      const c = this.getData(createTime)
      this.currentData = {
        ...c,
        createTime
      }
      this.visible = true
    }

    getData (date) {
      const result = this.dateList.find(item => new Date(item.createTime).getTime() === date.getTime())
      return result || {}
    }

    @Watch('currentDate', { immediate: true })
    loadData (date) {
      const start = dayjs(`${date.getFullYear()}-${date.getMonth() + 1}-01`)
      const end = start.add(1, 'month').subtract(1, 'day')
      this.loadSchedules({
        startTime: start.format('YYYY-MM-DD'),
        endTime: end.format('YYYY-MM-DD')
      }).then(({ data: { data } }) => (this.dateList = data))
    }

    submit () {
      this.$refs.form.validate().then(() => {
        const d = []
        if (this.currentData.createTime) {
          d.push({
            ...this.currentData,
            createTime: dayjs(this.currentData.createTime).format('YYYY-MM-DD')
          })
        } else {
          let current = dayjs(this.currentData.startDate)
          while (!current.isAfter(this.currentData.endDate)) {
            d.push({
              ...this.currentData,
              createTime: current.format('YYYY-MM-DD')
            })
            current = current.add(1, 'day')
          }
        }
        return this.save(d)
      }).then(() => {
        this.visible = false
        this.loadData(this.currentDate)
      })
    }

    add () {
      this.visible = true
      this.currentData = {
        headquarterTelephone: '',
        managerDepartmentTelephone: '',
        morningWorkerName: '',
        morningWorkerTelephone: '',
        noonWorkerName: '',
        noonWorkerTelephone: '',
        nightWorkerName: '',
        nightWorkerTelephone: ''
      }
    }
  }
</script>

<style scoped>

</style>
