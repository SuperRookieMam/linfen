<template>
  <div class="sentiments">
    <el-form inline>
      <el-form-item>
        <el-input placeholder="请输入查询关键字" />
      </el-form-item>
      <!--          <el-form-item>-->
      <!--            <el-button type="primary">新增</el-button>-->
      <!--          </el-form-item>-->
      <el-form-item style="float: right">
        <router-link class="el-button el-button--primary" :to="{name:'sentiment',params:{id:'new'}}">
          新增
        </router-link>
      </el-form-item>
    </el-form>
    <ele-datatables :ajax="ajax" ref="table">
      <el-table-column label="标题" prop="title" />
      <el-table-column label="发布时间">
        <template slot-scope="scope">
          <span>{{ scope.row.createTime|dateFormat }}</span>
        </template>
      </el-table-column>
      <el-table-column label="原始来源" prop="source" />
      <el-table-column label="媒体类型" prop="mediaType" />
      <el-table-column label="声量走势" prop="volume">
        <template v-slot="{row:{volume}}">
          <span v-if="volume==='0'">非敏感</span>
          <span v-if="volume==='1'">敏感</span>
        </template>
      </el-table-column>
      <el-table-column label="情感类型" prop="sentimentType">
        <template v-slot="{row:{sentimentType}}">
          <span v-if="sentimentType==='0'">中性</span>
          <span v-if="sentimentType==='1'">正面</span>
          <span v-if="sentimentType==='-1'">负面</span>
        </template>
      </el-table-column>
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

  const sentimentModule = namespace('sentiment')
  @Component({
    components: {
      EleDatatables
    }
  })
  export default class Sentiments extends Vue {
    @sentimentModule.Action('delete')
    delById

    ajax = `${CONTEXT_PATH}d/emergency/sentiments`

    edit ({ id }) {
      this.$router.push({ name: 'sentiment', params: { id } })
    }

    del ({ id }) {
      this.$confirm('此操作将永久删除该记录, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        return this.delById({ id })
      }).then(() => {
        this.$message({
          type: 'success',
          message: '删除成功!'
        })
        this.$refs.table.reloadData()
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        })
      })
    }
  }
</script>
<style lang="less"></style>
