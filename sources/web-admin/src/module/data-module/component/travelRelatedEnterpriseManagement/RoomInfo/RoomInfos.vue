<!--住宿场所-->
<template>
  <div>
    <el-form :inline="true"
             :model="searchObj"
             class="clear-float">
      <el-row>
        <el-col :span="18" v-if="isSearch">
          <el-form-item>
            <el-input size="mini"
                      v-model="searchObj.chineseFullName"
                      placeholder="请输入中文名称" />
          </el-form-item>
        </el-col>
        <el-col :span="3" style="float: right">
          <el-form-item>
            <el-button
              type="primary"
              @click="add('roomInfo')">
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
      <el-table-column label="房间类型" prop="roomType" />
      <el-table-column label="房间数量" prop="roomNumber" />
      <el-table-column label="所属地区">
        <template slot-scope="scope">
          <div v-if="scope.row">
            {{ getRegionName(scope.row.regionCode) }}
          </div>
        </template>
      </el-table-column>
      <el-table-column label="可预房间" prop="roomNumber" />
      <el-table-column label="正常价格" prop="normalPrice" />
      <el-table-column label="假日价格" prop="holidayPrices" />
      <el-table-column label="正常价格" prop="normalPrice" />
      <el-table-column label="操作" :min-width="60">
        <template slot-scope="scope">
          <el-button type="text" size="mini" @click="edit(scope.row,'roomInfo')">编辑</el-button>
          <el-button type="text" size="mini" @click="delRow(scope.row,AllUrl.trivalEnterprise.roomInfos)">删除</el-button>
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
  export default class RoomInfos extends Mixins(BaseTable) {
    @Prop({type: Function})
    setReturnData

    @Prop({type: Function})
    successSave

    @Prop({type: Boolean, default: () => true})
    isSearch

    @Prop({type: String})
    url

    getUrl () {
      return this.url ? this.url : this.AllUrl.trivalEnterprise.roomInfos
    }
  }
</script>
