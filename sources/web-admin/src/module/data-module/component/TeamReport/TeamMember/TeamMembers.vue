<!--团队填报-->
<template>
  <div>
    <el-form :inline="true"
             :model="searchObj"
             class="clear-float">
      <el-row>
        <el-col :span="18" v-if="isSearch">
          <el-form-item>
            <el-input size="mini" v-model="searchObj.teamName" placeholder="请输入中文名称" />
          </el-form-item>
        </el-col>
        <el-col :span="3" style="float: right">
          <el-form-item>
            <el-button type="primary"
                       @click="add('teamMember')"
                       :disabled="isAdd==='new'">
              新增
            </el-button>
          </el-form-item>
        </el-col>
      </el-row>
    </el-form>
    <el-table-base
      ref="table"
      :ajax="getUrl()"
      :server-params="searchObj"
      :set-return-data="setReturnData">
      <el-table-column label="团员姓名" prop="memberName" />
      <el-table-column label="手机" prop="mobile" />
      <el-table-column label="身份证号码" prop="carNumber" />
      <el-table-column label="性别" prop="carNumber" :formatter="sexFormater" />
      <el-table-column label="年龄" prop="carNumber" :formatter="ageFormater" />
      <el-table-column label="操作" :min-width="60">
        <template slot-scope="scope">
          <el-button type="text" size="mini" @click="edit(scope.row,'teamMember')">编辑</el-button>
          <el-button type="text" size="mini" @click="delRow(scope.row,AllUrl.trivalEnterprise.teamMembers)">删除</el-button>
        </template>
      </el-table-column>
    </el-table-base>
  </div>
</template>
<script>
  import { Component, Mixins, Prop } from 'vue-property-decorator'
  import BaseTable from '../../.common/BaseTable'
  import ElTableBase from '../../.common/ElTableBase'
  @Component({
    components: {
      ElTableBase
    }
  })
  export default class TeamMembers extends Mixins(BaseTable) {
    @Prop({type: Function})
    setReturnData

    @Prop({type: Function})
    successSave

    @Prop({type: Boolean, default: () => true})
    isSearch

    @Prop({type: String})
    url

    @Prop({default: () => 'new'})
    isAdd

    getUrl () {
      return this.url ? this.url : this.AllUrl.trivalEnterprise.teamMembers
    }

    getCarNum (data) {
      return data.carNumber
    }

    ageFormater (row) {
      var carNum = this.getCarNum(row)
      var aDate = new Date()
      var thisYear = aDate.getFullYear()
      var brith = carNum.substring(6, 10)
      return (thisYear - brith)
    }

    sexFormater (row) {
      var carNum = this.getCarNum(row)
      var sex = carNum.substring(carNum.length - 2, carNum.length - 1)
      if (sex % 2 === 0) {
        return '女'
      } else if (sex % 2 !== 0) {
        return '男'
      } else {
        return '未知'
      }
    }
  }
</script>
