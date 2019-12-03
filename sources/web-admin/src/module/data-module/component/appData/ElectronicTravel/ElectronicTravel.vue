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
              @click="save('electronicTravel')"
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
                <el-form-item label="行程名字" prop="teamName">
                  <el-input v-model="data.travelName" :disabled="readonly" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="开始时间" prop="travelStart">
                  <el-date-picker
                    style="width: 100%;"
                    v-model="data.travelStart"
                    :disabled="readonly"
                    value-format="yyyy-MM-dd" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="结束时间" prop="travelEnd">
                  <el-date-picker
                    style="width: 100%;"
                    v-model="data.travelEnd"
                    :disabled="readonly"
                    value-format="yyyy-MM-dd" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="导游姓名" prop="state">
                  <el-select v-model="data.guiderName"
                             placeholder="请选择"
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
                <el-form-item label="团队人数" prop="teamNumbers">
                  <el-input v-model="data.peopleNum" :disabled="readonly" type="number" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="所属团队" prop="state">
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
            <el-row>
              <el-col :span="12">
                <el-form-item label="简介" prop="label">
                  <el-input v-model="data.label" :disabled="readonly" />
                </el-form-item>
              </el-col>
            </el-row>
            <trips
              v-if="id != 'new'"
              :url="AllUrl.electronicTravel+'/'+data.id"
              :set-return-data="tripsReturndata"
              :success-save="tripsSuccessSave"
              :is-search="false" />
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
  import Trips from './Trips'
  import qrCodeEditor from '../../.common/QrCodeEditor'

  @Component({
    components: {
      Trips,
      qrCodeEditor
    }
  })
  export default class ElectronicTravel extends Mixins(BaseTable) {
    @Prop({ default: () => 'new' })
    id

    guiders = []

    data = {
      teamId: '',
      teamName: ''
    }

    teamDatas = []

    tripsReturndata (returnData) {
      return returnData.trips
    }

    tripsSuccessSave (returnData) {
      this.data.trips.push(returnData)
      this.saveRef()
    }

    getUrl () {
      return this.AllUrl.electronicTravel
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
        for (var t in resoult.data) {
          const map = new Map()
          map.value = resoult.data[t].chineseName
          map.label = resoult.data[t].chineseName
          this.guiders.push(map)
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

    getTeamId (val) {
      const url = this.AllUrl.electronicTravel + '/findByTeamId/' + val
      this.gets({ url: url }).then(resoult => {
        if (!resoult.data.flag) {
          for (var t in this.teamDatas) {
            if (val === this.teamDatas[t].val) {
              this.data.teamId = this.teamDatas[t].id
              this.data.teamName = this.teamDatas[t].teamName
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
  }
</script>
