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
              @click="save('teamReport')"
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
                <el-form-item label="团队名称" prop="teamName">
                  <el-input v-model="data.teamName" :disabled="readonly" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="开始时间" prop="startTime">
                  <el-date-picker style="width: 100%;" v-model="data.startTime" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="结束时间" prop="endTime">
                  <el-date-picker style="width: 100%;" v-model="data.endTime" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="团队状态" prop="state">
                  <el-select v-model="data.state" :disabled="readonly" placeholder="请选择">
                    <el-option label="未出团" value="未出团" />
                    <el-option label="已出团" value="已出团" />
                    <el-option label="已结束" value="已结束" />
                  </el-select>
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="团队人数" prop="teamNumbers">
                  <el-input v-model="data.teamNumbers" :disabled="readonly" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="车牌号" prop="carnum">
                  <el-input v-model="data.carnum" :disabled="readonly" />
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="12">
                <el-form-item label="旅游社名称" prop="travelAgentcyName">
                  <el-select
                    v-model="data.travelAgentcyName"
                    placeholder="请选择"
                    :disabled="readonly"
                    remote
                    filterable
                    allow-create
                    @change="initMobile">
                    <el-option
                      v-for="item in travelAgentcys"
                      :key="item.id"
                      :label="item.chineseFullName"
                      :value="item.chineseFullName" />
                  </el-select>
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="旅游社电话" prop="travelAgentcyMobile">
                  <el-input v-model="data.travelAgentcyMobile" :disabled="readonly" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="导游名称" filterable prop="guidName">
                  <el-select v-model="data.guidName"
                             placeholder="请选择"
                             :disabled="readonly"
                             remote
                             filterable
                             allow-create
                             @change="changeGuider">
                    <el-option
                      v-for="item in guiders"
                      :key="item.value"
                      :label="item.label"
                      :value="item.value" />
                  </el-select>
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="导游电话" prop="guidMobile">
                  <el-input v-model="data.guidMobile" :disabled="readonly" />
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="12">
                <el-form-item label="司机姓名" prop="driverName">
                  <el-select v-model="data.driverName"
                             placeholder="请选择"
                             @change="getDriver"
                             remote
                             filterable
                             allow-create
                             :disabled="readonly">
                    <el-option
                      v-for="item in busDrivers"
                      :key="item.value"
                      :label="item.label"
                      :value="item.value" />
                  </el-select>
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="司机电话" prop="driverMobile">
                  <el-input v-model="data.driverMobile" :disabled="readonly" />
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
                <el-form-item label="填报景区" prop="scenic">
                  <el-select v-model="data.scenic" placeholder="请选择" :disabled="readonly">
                    <el-option
                      v-for="item in scenics"
                      :key="item.id"
                      :label="item.chineseFullName"
                      :value="item.chineseFullName" />
                  </el-select>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="24">
                <el-form-item label="描述信息">
                  <el-input
                    v-model="data.desc"
                    type="textarea"
                    :disabled="readonly" />
                </el-form-item>
              </el-col>
            </el-row>
            <team-members
              :url="AllUrl.trivalEnterprise.teamReports+'/'+data.id"
              :set-return-data="teamMemberReturndata"
              :success-save="teamMemberSuccessSave"
              :is-search="false"
              :is-add="id" />
          </el-tab-pane>
        </el-tabs>
      </el-form>
    </el-main>
  </el-container>
</template>
<script>
  import BaseTable from '../../.common/BaseTable'
  import { Component, Prop, Mixins } from 'vue-property-decorator'
  import ImgSource from '../../.common/ImgResource'
  import AudioResource from '../../.common/audioResource'
  import VideoResource from '../../.common/videoResource'
  import VirtualMaterial from '../../.common/virtualMaterial'
  import TeamMembers from '../TeamMember/TeamMembers'

  @Component({
    components: {
      ImgSource,
      AudioResource,
      VideoResource,
      VirtualMaterial,
      TeamMembers
    }
  })
  export default class TouristCommodity extends Mixins(BaseTable) {
    @Prop({ default: () => 'new' })
    id

    teamMemberReturndata (returnData) {
      return returnData.members
    }

    teamMemberSuccessSave (returnData) {
      this.data.members.push(returnData)
      this.saveRef()
    }

    scenics = []

    travelAgentcys = []

    guiders = []

    data = {
      travelAgentcyName: '',
      travelAgentcyMobile: '',
      guidMobile: '',
      guidName: '',
      driverMobile: '',
      driverName: ''
    }

    busDrivers = []

    getUrl () {
      return this.AllUrl.trivalEnterprise.teamReports
    }

    initMobile (val) {
      for (let i = 0; i < this.travelAgentcys.length; i++) {
        if (val === this.travelAgentcys[i].chineseFullName) {
          this.data.travelAgentcyMobile = this.travelAgentcys[i].reservationPhone
          this.data.travelAgentcyName = this.travelAgentcys[i].chineseFullName
          console.log(this.data.travelAgentcyName)
          return
        }
      }
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

    created () {
      this.gets({
        url: this.AllUrl.trivalEnterprise.touristAttractions,
        params: {
          api: 1,
          params: '{}'
        }
      }).then(data => {
        this.scenics = data.data
      })
      this.gets({
        url: this.AllUrl.trivalEnterprise.travelAgentFields,
        params: {
          api: 1,
          params: '{}'
        }
      }).then(data => {
        this.travelAgentcys = data.data
      })
      this.gets({
        url: this.AllUrl.trivalEnterprise.tourGuides,
        params: {
          api: 1232131,
          params: ''
        }
      }).then(resoult => {
        for (var t in resoult.data) {
          const map = new Map()
          map.value = resoult.data[t].chineseName
          map.label = resoult.data[t].chineseName
          map.phone = resoult.data[t].contact
          this.guiders.push(map)
        }
      })
      this.gets({
        url: this.AllUrl.trivalEnterprise.busDrivers,
        params: {
          api: 1232131,
          params: ''
        }
      }).then(resoult => {
        this.busDriversData = resoult.data
        for (var t in resoult.data) {
          const map = new Map()
          map.value = resoult.data[t].chineseName
          map.label = resoult.data[t].chineseName
          map.tel = resoult.data[t].contact
          this.busDrivers.push(map)
        }
      })
    }

    changeGuider (val) {
      for (var i in this.guiders) {
        if (val === this.guiders[i].value) {
          this.data.guidName = this.guiders[i].label
          this.data.guidMobile = this.guiders[i].phone
          return
        }
      }
      this.data.guidMobile = ''
    }

    getDriver (t) {
      for (var m in this.busDriversData) {
        if (this.busDriversData[m].chineseName === t) {
          this.data.driverMobile = this.busDriversData[m].contact
          this.data.driverName = this.busDriversData[m].chineseName
          return
        }
      }
      this.data.driverMobile = ''
    }

    get rules () {
      return {
        teamName: [{
          required: true,
          message: '不能为空',
          trigger: 'blur'
        }],
        startTime: [{
          required: true,
          message: '不能为空',
          trigger: 'blur'
        }],
        endTime: [{
          required: true,
          message: '不能为空',
          trigger: 'blur'
        }],
        state: [{
          required: true,
          message: '不能为空',
          trigger: 'blur'
        }],
        regionCode: [{
          required: true,
          message: '不能为空',
          trigger: 'blur'
        }],
        teamNumbers: [{
          required: true,
          message: '不能为空',
          trigger: 'blur'
        }],
        travelAgentcyName: [{
          required: true,
          message: '不能为空',
          trigger: 'blur'
        }],
        travelAgentcyMobile: [{
          required: true,
          message: '不能为空',
          trigger: 'blur'
        }],
        guidName: [{
          required: true,
          message: '不能为空',
          trigger: 'blur'
        }],
        guidMobile: [{
          required: true,
          message: '不能为空',
          trigger: 'blur'
        }],
        driverMobile: [{
          required: true,
          message: '不能为空',
          trigger: 'blur'
        }],
        driverName: [{
          required: true,
          message: '不能为空',
          trigger: 'blur'
        }],
        carnum: [{
          required: true,
          message: '不能为空',
          trigger: 'blur'
        }]
      }
    }
  }
</script>
