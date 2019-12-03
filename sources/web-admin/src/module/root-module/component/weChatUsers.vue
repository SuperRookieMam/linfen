<template>
  <el-container>
    <el-main>
      <div class="sentiments">
        <el-form size="mini"
                 :inline="true"
                 :model="searchObj"
                 class="clear-float">
          <el-row>
            <el-col>
              <el-form-item>
                <el-input
                  v-model="searchObj.search"
                  placeholder="请输入查询关键字" />
              </el-form-item>
            </el-col>
          </el-row>
        </el-form>
        <ele-datatables :ajax="ajax"
                        ref="list"
                        pagination-layout="total, sizes, prev, pager, next, jumper"
                        :server-params="searchObj">
          <el-table-column label="id" prop="id" />
          <el-table-column label="微信名" prop="weChatName" />
          <el-table-column label="openId" prop="openId" />
          <el-table-column label="注册时间" prop="registerTime" />
          <el-table-column label="最后登录时间" prop="lastLoginTime" />
          <el-table-column label="姓名" prop="name" />
          <el-table-column label="性别" prop="sex" :formatter="sexFormat" />
          <el-table-column label="生日" prop="birthday" />
          <el-table-column label="户籍所在地" prop="residence" />
        </ele-datatables>
      </div>
    </el-main>
  </el-container>
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
    @recommendLineModule.State('urlUsers')
    ajax

    searchObj={}

    sexFormat (row) {
      if (row.sex === false) {
        return '男'
      } else if (row.sex === true) {
        return '女'
      } else {
        return '未知'
      }
    }
  }
</script>
<style lang="less"></style>
