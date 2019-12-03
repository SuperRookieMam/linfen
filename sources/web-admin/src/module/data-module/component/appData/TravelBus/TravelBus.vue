<!--团队填报-->
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
              @click="save('travelBus1')"
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
                <el-form-item label="行程时间" prop="dayTime">
                  <el-date-picker style="width: 100%;"
                                  v-model="data.dayTime"
                                  :disabled="readonly"
                                  value-format="yyyy-MM-dd" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="导游名字" prop="guiderName">
                  <el-select v-model="data.guiderName"
                             placeholder="请选择"
                             @change="getGuider"
                             :disabled="readonly">
                    <el-option
                      v-for="item in guiders"
                      :key="item.value"
                      :label="item.label"
                      :value="item.value" />
                  </el-select>
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="导游电话" prop="guiderTell">
                  <el-input v-model="data.guiderTell" :disabled="readonly" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="车牌号" prop="carNum">
                  <el-select v-model="data.carNum"
                             placeholder="请选择"
                             @change="getDriver"
                             :disabled="readonly">
                    <el-option
                      v-for="item in busDrivers"
                      :key="item.value"
                      :label="item.label"
                      :value="item.value" />
                  </el-select>
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="司机电话" prop="guiderTell">
                  <el-input v-model="data.driverTel" :disabled="readonly" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="司机姓名" prop="guiderTell">
                  <el-input v-model="data.driverName" :disabled="readonly" />
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="12">
                <el-form-item label="团队人数" prop="teamPeopleNum">
                  <el-input type="number" v-model="data.teamPeopleNum" :disabled="readonly" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="团队" prop="state">
                  <el-select v-model="data.teamId"
                             placeholder="请选择"
                             :disabled="readonly"
                             @change="getTeamId">
                    <el-option
                      v-for="item in teamDatas"
                      :key="item.value"
                      :label="item.label"
                      :value="item.value" />
                  </el-select>
                </el-form-item>
              </el-col>
            </el-row>
            <local-points
              :url="AllUrl.travelBus+'/'+data.id"
              :set-return-data="localPointsReturndata"
              :success-save="localPointsSuccessSave"
              :is-search="false"
              :is-add="id" />
          </el-tab-pane>
          <!--<el-tab-pane label="导游" name="teamReportTourGuid" v-if="id!=='new'" />-->

          <!--<el-tab-pane label="旅行社" name="teamReportTravelAgentField" v-if="id!=='new'" />-->

          <!--<el-tab-pane label="大巴" name="teamReportTourBus" v-if="id!=='new'" />-->

          <!--<el-tab-pane label="大巴司机" name="teamReportBusDriver" v-if="id!=='new'" />-->
        </el-tabs>
      </el-form>
    </el-main>
  </el-container>
</template>
<script>
  import BaseTable from '../../.common/BaseTable'
  import { Component, Prop, Mixins } from 'vue-property-decorator'
  import LocalPoints from './LocalPoints'

  @Component({
    components: {
      LocalPoints
    }
  })
  export default class TravelBus1 extends Mixins(BaseTable) {
    @Prop({ default: () => 'new' })
    id

    guiders = []

    guidersData = []

    busDrivers = []

    busDriversData = []

    teamDatas = []

    rules = {}

    data = {
      guiderTell: '',
      driverTel: '',
      carNum: '',
      teamId: '',
      teamName: '',
      dayTime: ''
    }

    localPointsReturndata (returnData) {
      return returnData.points
    }

    localPointsSuccessSave (returnData) {
      this.data.points.push(returnData)
      this.saveRef()
    }

    replaceRoute () {
      this.getFormData()
    }

    getUrl () {
      return this.AllUrl.travelBus
    }

    created () {
      const url = this.AllUrl.trivalEnterprise.tourGuides
      this.gets({
        url: url,
        params: {
          api: 1232131,
          params: ''
        }
      }).then(resoult => {
        this.guidersData = resoult.data
        for (var t in resoult.data) {
          const map = new Map()
          map.value = resoult.data[t].id
          map.label = resoult.data[t].chineseName
          map.tel = resoult.data[t].contact
          this.guiders.push(map)
        }
      })
      const urlDriver = this.AllUrl.trivalEnterprise.tourBuses
      this.gets({
        url: urlDriver,
        params: {
          api: 1232131,
          params: ''
        }
      }).then(resoult => {
        this.busDriversData = resoult.data
        for (var t in resoult.data) {
          const map = new Map()
          map.value = resoult.data[t].id
          map.label = resoult.data[t].plateNo
          this.busDrivers.push(map)
        }
      })
      this.gets({
        url: this.AllUrl.trivalEnterprise.teamReports,
        params: {
          api: 1232131,
          params: ''
        }
      }).then(resoult => {
        for (var t in resoult.data) {
          const map = new Map()
          map.value = resoult.data[t].id
          map.label = resoult.data[t].teamName
          this.teamDatas.push(map)
        }
      })
    }

    getGuider (t) {
      for (var m in this.guidersData) {
        if (this.guidersData[m].id === t) {
          this.data.guiderTell = this.guidersData[m].contact
          this.data.guiderName = this.guidersData[m].chineseName
        }
      }
    }

    getDriver (t) {
      for (var m in this.busDriversData) {
        if (this.busDriversData[m].id === t) {
          this.data.driverTel = this.busDriversData[m].contact
          this.data.carNum = this.busDriversData[m].plateNo
          this.data.driverName = this.busDriversData[m].contactPeople
        }
      }
    }

    getTeamId (val) {
      if (this.data.dayTime === null || this.data.dayTime === undefined || this.data.dayTime === '') {
        this.$alert('请先选择行程日期', '错误', {
          confirmButtonText: '确定',
          callback: action => {
            this.$message({
              type: 'info',
              message: `action: ${action}`
            })
          }
        })
        this.data.teamId = ''
        return
      }
      const url = this.AllUrl.travelBus + '/findByTeamIdAndTime/' + val + '/' + this.data.dayTime
      this.gets({ url: url }).then(resoult => {
        if (!resoult.data.flag) {
          for (var t in this.teamDatas) {
            if (val === this.teamDatas[t].value) {
              this.data.teamId = this.teamDatas[t].value
              this.data.teamName = this.teamDatas[t].label
            }
          }
        } else {
          if (resoult.data.data.id === this.data.id) {
            return
          }
          this.$alert('团队已被其他电子行程绑定', '错误', {
            confirmButtonText: '确定',
            callback: action => {
              this.$message({
                type: 'info',
                message: `action: ${action}`
              })
            }
          })
          this.data.teamId = null
          this.data.teamName = null
        }
      })
    }

    save (routeName) {
      this.$refs.form.validate((valid) => {
        if (valid) {
          if (this.id === 'new') {
            this.post({
              url: this.getUrl(),
              params: this.data
            }).then(ele => {
              this.data = ele.data
              this.$message('新增成功', '友情提示')
              if (this.currentFunctionSave[routeName]) {
                this.currentFunctionSave[routeName](this.data)
              }
              this.readonly = true
            })
          } else {
            this.put({
              url: `${this.getUrl()}/${this.id}`,
              params: this.data
            }).then(ele => {
              this.data = ele.data
              this.readonly = true
              this.$message('修改成功', '友情提示')
            })
          }
        } else {
          this.$message('亲爱的小伙伴，你还有必填项没有填哦，要不在检查检查', '友情提示')
          return false
        }
      })
    }
  }
</script>
