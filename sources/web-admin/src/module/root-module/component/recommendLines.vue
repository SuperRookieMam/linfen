<template>
  <div class="sentiments">
    <el-row>
      <el-col>
        <el-form inline>
          <el-form-item>
            <el-input placeholder="请输入查询关键字" />
          </el-form-item>
          <!--          <el-form-item>-->
          <!--            <el-button type="primary">新增</el-button>-->
          <!--          </el-form-item>-->
          <el-form-item style="float: right">
            <router-link class="el-button el-button--primary" :to="{name:'recommendLine',params:{id:'new'}}">
              新增
            </router-link>
          </el-form-item>
        </el-form>
      </el-col>
    </el-row>
    <ele-datatables :ajax="ajax"
                    ref="list"
                    pagination-layout="total, sizes, prev, pager, next, jumper"
                    :server-params="searchObj">
      <el-table-column label="id" prop="id" />
      <el-table-column label="推荐路线名" prop="name" />
      <el-table-column label="线路类型" prop="routesId" />
      <el-table-column label="目的地类型" prop="routesId" />
      <el-table-column label="线路天数" prop="routesId" />
      <el-table-column label="景区" prop="scenicIds" />
      <el-table-column label="状态" prop="status" :formatter="statusFormat" />
      <el-table-column label="推荐等级" prop="priority" :formatter="rankFormat" />
      <el-table-column label="操作">
        <template v-slot="{row}">
          <a href="javascript:void(0)" @click="edit(row)">编辑</a>
          <a href="javascript:void(0)" @click="del(row)">删除</a>
        </template>
      </el-table-column>
    </ele-datatables>
  </div>
</template>
<script>
  import Vue from 'vue'
  import { Component } from 'vue-property-decorator'
  import EleDatatables from 'element-datatables'
  import { namespace } from 'vuex-class'

  const recommendLineModule = namespace('root')
  @Component({
    components: {
      EleDatatables
    }
  })
  export default class recommendLines extends Vue {
    @recommendLineModule.Action('delete')
    delById

    @recommendLineModule.State('url')
    ajax

    searchObj=[]

    edit ({ id }) {
      this.$router.push({ name: 'recommendLine', params: { id } })
    }

    del ({ id }) {
      this.delById({ id }).then(() => {
        this.$refs.table.reloadData()
      })
    }

    statusFormat (row) {
      if (row.status === false) {
        return '禁用'
      } else {
        return '启用'
      }
    }

    rankFormat (row) {
      if (row.priority === 0) {
        return '低'
      } else if (row.priority === 1) {
        return '中'
      } else {
        return '高'
      }
    }
  }
</script>
<style lang="less"></style>
