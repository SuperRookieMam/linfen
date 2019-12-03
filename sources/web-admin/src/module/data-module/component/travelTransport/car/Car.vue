<!--车辆信息-->
<template>
  <el-container>
    <el-main>
      <el-form label-width="100px"
               :model="data"
               ref="form"
               size="mini"
               :rules="rules">
        <el-row>
          <el-col :span="24" style="display: flex;justify-content: flex-end;margin-top: 10px;">
            <el-button
              type="primary"
              @click="readonly=false"
              size="mini"
              v-if="readonly">
              编辑
            </el-button>
            <el-button
              type="primary"
              @click="save('car')"
              size="mini"
              v-if="!readonly">
              保存
            </el-button>
            <el-button @click="goBack()" size="mini">取消</el-button>
          </el-col>
        </el-row>
        <el-tabs>
          <el-tab-pane label="车辆信息">
            <el-row>
              <el-col :span="12">
                <el-form-item label="车牌号" prop="plateNo">
                  <el-input v-model="data.plateNo" :disabled="readonly" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="品牌" prop="brand">
                  <el-input v-model="data.brand" :disabled="readonly" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="型号" prop="model">
                  <el-input v-model="data.model" :disabled="readonly" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="准载人数" prop="accurateLoadCount">
                  <el-input v-model="data.accurateLoadCount" :disabled="readonly" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="座位数" prop="seatingCount">
                  <el-input v-model="data.seatingCount" :disabled="readonly" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="颜色" prop="color">
                  <el-input v-model="data.color" :disabled="readonly" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="发动机号" prop="engineNo">
                  <el-input v-model="data.engineNo" :disabled="readonly" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="车架号" prop="vin">
                  <el-input v-model="data.vin" :disabled="readonly" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="车籍地" prop="carThrough">
                  <el-input v-model="data.carThrough" :disabled="readonly" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="登记日期" prop="registryDate">
                  <!--<el-input size='mini' v-model="data.registryDate" :disabled="readonly" />-->
                  <el-date-picker style="width: 100%;"
                                  v-model="data.registryDate"
                                  :disabled="readonly"
                                  type="date" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="业主代表" prop="representativeOwner">
                  <el-input v-model="data.representativeOwner" :disabled="readonly" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="联系人" prop="contactPeople">
                  <el-input v-model="data.contactPeople" :disabled="readonly" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="联系方式" prop="contact">
                  <el-input v-model="data.contact" :disabled="readonly" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="联系地址" prop="contactAddress">
                  <el-input v-model="data.contactAddress" :disabled="readonly" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="安全行驶里程" prop="safeDrivingMileage">
                  <el-input v-model="data.safeDrivingMileage" :disabled="readonly" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="计费标准" prop="chargeStandard">
                  <edit v-model="data.chargeStandard" />
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
  import { Component, Mixins, Prop } from 'vue-property-decorator'

  @Component({
    components: {}
  })
  export default class CarMessage extends Mixins(BaseTable) {
    @Prop({default: () => 'new'})
    id

    getUrl () {
      return `${this.AllUrl.trivalEnterprise.cars}`
    }

    get rules () {
      return {
        regionCode: [{
          required: true,
          message: '所在区域不能为空',
          trigger: 'blur'
        }],
        plateNo: [{
          required: true,
          message: '车牌号不能为空',
          trigger: 'blur'
        }],
        accurateLoadNumber: [{
          required: true,
          message: '准载人数不能为空',
          trigger: 'blur'
        }],
        seating: [{
          required: true,
          message: '座位数不能为空',
          trigger: 'blur'
        }],
        theOwnerRepresentative: [{
          required: true,
          message: '业主代表不能为空',
          trigger: 'blur'
        }],
        theContact: [{
          required: true,
          message: '联系人不能为空',
          trigger: 'blur'
        }],
        chargeStandard: [{
          required: true,
          message: '计费标准不能为空',
          trigger: 'blur'
        }]
      }
    }
  }
</script>
