<template>
  <div>
    <el-row>
      <el-col :span="24">
        <el-form inline>
          <el-form-item>
            <el-input v-model="searchObj.keywords"
                      placeholder="请输入查询关键字" />
          </el-form-item>
          <el-form-item class="pull-right">
            <el-button type="primary" @click="add">新增</el-button>
          </el-form-item>
        </el-form>
      </el-col>
    </el-row>
    <el-row>
      <el-col :span="24">
        <ele-data-tables ref="list"
                         :server-params="searchObj"
                         :ajax="ajax">
          <el-table-column prop="ScenicName" label="景区名" sortable="custom" />
          <el-table-column label="时间">
            <template v-slot="{row:{year,month}}">{{ year }}/{{ month }}</template>
          </el-table-column>
          <el-table-column prop="name" label="当前价格" sortable="custom" />
          <el-table-column prop="name1" label="周价格走势" sortable="custom" />
          <el-table-column prop="name2" label="当前评分" sortable="custom" />
          <el-table-column prop="name3" label="评价评分" sortable="custom" />
          <!-- <el-table-column prop="value" label="人数" sortable="custom" /> -->
          <el-table-column label="操作">
            <template v-slot="{row}">
              <a href="javascript:void(0)" @click="edit(row)">编辑</a>
              <a href="javascript:void(0)" @click="delRow(row)">删除</a>
            </template>
          </el-table-column>
        </ele-data-tables>
      </el-col>
    </el-row>

    <el-dialog v-if="visible" :visible.sync="visible" title="指标编辑">
      <month-scenic-price-rate v-model="selectedRow" />
      <template slot="footer">
        <el-button @click="visible = false">取消</el-button>
        <el-button type="primary" @click="saveData">确定</el-button>
      </template>
    </el-dialog>
  </div>
</template>

<script>
  import { Mixins, Component } from 'vue-property-decorator'
  import BaseList from './.common/BaseList'
  import MonthScenicPriceRate from './MonthScenicPriceRate'

  @Component({
    components: { MonthScenicPriceRate }
  })
  export default class MonthScenicPriceRates extends Mixins(BaseList) {
    get baseModule () { return 'kpi/monthScenicPriceRate' }
  }
</script>

<style scoped>

</style>
