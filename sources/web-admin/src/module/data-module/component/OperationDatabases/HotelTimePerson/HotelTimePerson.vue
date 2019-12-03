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
            @click="save('hotelTimePerson')"
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
              <el-form-item label="时间" prop="year">
                <date-day-houre v-model="data" />
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="所在区域" prop="regionCode">
                <provence-city v-model="data" />
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
              <el-form-item label="景区" prop="scenic">
                <scenic-select v-model="data.scenic" :disabled="readonly" />
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="酒店名" prop="hotelName">
                <el-input v-model="data.hotelName" :disabled="readonly" />
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
              <el-form-item label="酒店星级" prop="level">
                <el-input v-model="data.level" :disabled="readonly" />
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="人数" prop="number">
                <el-input v-model="data.number" :disabled="readonly" />
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
              <el-form-item label="性别" prop="sex">
                <el-input v-model="data.sex" :disabled="readonly" />
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="年龄最大" prop="ageMax">
                <el-input v-model="data.ageMax" :disabled="readonly" />
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
              <el-form-item label="年龄最小" prop="ageMin">
                <el-input v-model="data.ageMin" :disabled="readonly" />
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
  import DateDayHoure from '../../.common/DateDayHoure'
  import ProvenceCity from '../../.common/ProvenceCity'
  @Component({
    components: {
      ScenicSelect,
      DateDayHoure,
      ProvenceCity
    }
  })
  export default class HotelTimePerson extends Mixins(BaseTable) {
    @Prop({default: () => 'new'})
    id

    getUrl () {
      return this.AllUrl.trivalEnterprise.hotelTimePersons
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
        province: [{
          required: true,
          message: '不能为空',
          trigger: 'blur'
        }],
        city: [{
          required: true,
          message: '不能为空',
          trigger: 'blur'
        }],
        area: [{
          required: true,
          message: '不能为空',
          trigger: 'blur'
        }],
// 英文名字
        scenic: [{
          required: true,
          message: '不能为空',
          trigger: 'blur'
        }],
// 空气指数
        contry: [{
          required: true,
          message: '不能为空',
          trigger: 'blur'
        }],
// 等级
        number: [{
          required: true,
          message: '不能为空',
          trigger: 'blur'
        }],
// 家庭住址
        sex: [{
          required: true,
          message: '不能为空',
          trigger: 'blur'
        }],
// 驱动器许可号
        age: [{
          required: true,
          message: '不能为空',
          trigger: 'blur'
        }],
// 服务语言
        ageMax: [{
          required: true,
          message: '不能为空',
          trigger: 'blur'
        }],
// 服务语言
        ageMin: [{
          required: true,
          message: '不能为空',
          trigger: 'blur'
        }],
        hotelName: [{
          required: true,
          message: '不能为空',
          trigger: 'blur'
        }],
        level: [{
          required: true,
          message: '不能为空',
          trigger: 'blur'
        }]
      }
    }
  }
</script>
