<!--团队人数-->
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
              @click="save('teamMember')"
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
                <el-form-item label="团员名称" prop="memberName">
                  <el-input v-model="data.memberName" :disabled="readonly" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="手机号码" prop="mobile">
                  <el-input v-model="data.mobile" :disabled="readonly" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="身份证号码" prop="carNumber">
                  <el-input v-model="data.carNumber" :disabled="readonly" />
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="所在省市" prop="regionCode">
                  <el-cascader v-model="data.regionCode"
                               expand-trigger="hover"
                               :options="regionTree"
                               :props="areaProps"
                               change-on-select
                               :disabled="readonly" />
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
  import { namespace } from 'vuex-class'

  const regionModule = namespace('data/region')

  @Component({
    components: {}
  })
  export default class TeamMember extends Mixins(BaseTable) {
    @Prop({default: () => 'new'})
    id

    @regionModule.Getter('regionTree')
    regionTree

    getUrl () {
      return this.AllUrl.trivalEnterprise.teamMembers
    }

    get rules () {
      return {
        carNumber: [
          {required: true, message: '请输入身份证ID', trigger: 'blur'},
          {pattern: /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/, message: '您的身份证格式不正确'}
        ],
        mobile: [
          {required: true, message: '请输入手机号', trigger: 'blur'},
          {pattern: /^1[3|4|5|7|8|9][0-9]\d{8}$/, message: '您的手机号格式不正确'}
        ],
        memberName: [{
          required: true,
          message: '不能为空',
          trigger: 'blur'
        }],
        regionCode: [{
          required: true,
          message: '所在区域不能为空',
          trigger: 'blur'
        }]
      }
    }
  }
</script>
