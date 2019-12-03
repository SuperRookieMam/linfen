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
            @click="save('hotelManager')"
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
              <el-form-item label="时间" prop="currentDate">
                <el-date-picker style="width: 100%;"
                                v-model="data.currentDate"
                                type="date"
                                format="yyyy-MM-dd"
                                value-format="yyyy-MM-dd"
                                :disabled="readonly" />
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="昨日价格" prop="oldPrice">
                <el-input type="number" v-model="data.oldPrice" :disabled="readonly" />
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
              <el-form-item label="酒店名" prop="hotelName">
                <el-input v-model="data.hotelName" :disabled="readonly" />
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="价格" prop="price">
                <el-input v-model="data.price" :disabled="readonly" />
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
              <el-form-item label="评分" prop="score">
                <el-input v-model="data.score" :disabled="readonly" />
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="平均评分" prop="avgScore">
                <el-input type="number" v-model="data.avgScore" :disabled="readonly" />
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
  @Component({
    components: {
    }
  })
  export default class HotelManager extends Mixins(BaseTable) {
    @Prop({default: () => 'new'})
    id

    getUrl () {
      return this.AllUrl.trivalEnterprise.hotelManagers
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
        hotelName: [{
          required: true,
          message: '不能为空',
          trigger: 'blur'
        }],
// 空气指数
        price: [{
          required: true,
          message: '不能为空',
          trigger: 'blur'
        }],
// 空气指数
        score: [{
          required: true,
          message: '不能为空',
          trigger: 'blur'
        }]
      }
    }
  }
</script>
