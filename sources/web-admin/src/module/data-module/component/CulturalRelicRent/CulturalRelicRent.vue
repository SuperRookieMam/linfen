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
            @click="save('culturalRelicRent')"
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
              <el-form-item label="文物名称" prop="name">
                <el-input v-model="data.name" :disabled="readonly" />
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="编号" prop="no">
                <el-input v-model="data.no" :disabled="readonly" />
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
              <el-form-item label="出借单位" prop="lendingUnit">
                <el-input v-model="data.lendingUnit" :disabled="readonly" />
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="出借区域" prop="lendingCode">
                <el-cascader v-model="data.lendingCode"
                             expand-trigger="hover"
                             :options="userRegionTree"
                             :props="areaProps"
                             change-on-select
                             :disabled="readonly" />
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
              <el-form-item label="租借单位" prop="rentalUnit">
                <el-input v-model="data.rentalUnit" :disabled="readonly" />
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="租借区域" prop="rentalCode">
                <el-cascader v-model="data.rentalCode"
                             expand-trigger="hover"
                             :options="regionTree"
                             :props="areaProps"
                             change-on-select
                             :disabled="readonly" />
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
              <el-form-item label="开始时间" prop="rentalTime">
                <el-date-picker style="width: 100%;"
                                v-model="data.rentalTime"
                                value-format="yyyy-MM-dd"
                                format="yyyy-MM-dd"
                                @change="getDays"
                                :disabled="readonly" />
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="归还时间" prop="returnTime">
                <el-date-picker style="width: 100%;"
                                v-model="data.returnTime"
                                value-format="yyyy-MM-dd"
                                format="yyyy-MM-dd"
                                @change="getDays"
                                :disabled="readonly" />
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
              <el-form-item label="租借状态" prop="rentStatus">
                <el-select v-model="data.rentStatus" placeholder="请选择" :disabled="readonly">
                  <el-option
                    v-for="item2 in options2"
                    :key="item2.value"
                    :label="item2.label"
                    :value="item2.value" />
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="租借天数" prop="rentDays">
                <el-input v-model="data.rentDays" :disabled="true" />
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
              <el-form-item label="描述" prop="description">
                <el-input v-model="data.description" :disabled="readonly" />
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
              <el-form-item label="图片" prop="imgs">
                <many-pic-up v-model="data.imgs" :disabled="readonly" />
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
  import BaseTable from '../.common/BaseTable'
  import { namespace } from 'vuex-class'
  import ManyPicUp from '../.common/ManyPicUp'

  const regionModule = namespace('data/region')
  @Component({
    components: {
      ManyPicUp
    }
  })
  export default class CulturalRelicRent extends Mixins(BaseTable) {
    @Prop({default: () => 'new'})
    id

    data = {
      imgs: [],
      rentDays: 0
    }

    flagFalse=false

    @regionModule.Getter('regionTree')
    regionTree

    fileUrl = `${CONTEXT_PATH}d/data/files`

    get thumbnails () {
      return this.data.imgs.map(item => `${CONTEXT_PATH}d/data/files/thumbnails/${item.id}`)
    }

    viewerOptions = {
      url: ({src}, b, c) => {
        const id = src.substring(src.lastIndexOf('/'))
        return `${CONTEXT_PATH}d/data/files/${id}`
      }
    }

    imgUploadSuccess (fileItem, {data}) {
      this.data.imgs = [...this.data.imgs, ...data]
    }

    options2 = [{
      value: '租借中',
      label: '租借中'
    }, {
      value: '未租借',
      label: '未租借'
    }, {
      value: '已归还',
      label: '已归还'
    }]

    days=0

    editorOption = {
      // some quill options
    }

    getUrl () {
      return this.AllUrl.culturalRelicRents
    }

    // 失去焦点事件
    onEditorBlur (quill) {
    }

    // 获得焦点事件
    onEditorFocus (quill) {
    }

    onEditorReady (quill) {
      console.log('editor ready!', quill)
    }

    // 内容改变事件
    onEditorChange ({quill, html, text}) {
    }

    rules = {}

    getDays () {
      console.log('执行了change监听')
      if (this.data.rentalTime !== null && this.data.returnTime !== null && this.data.returnTime !== undefined && this.data.rentalTime !== undefined) {
        var days = (new Date(this.data.returnTime).getTime() - new Date(this.data.rentalTime).getTime()) / (1000 * 60 * 60 * 24)
        console.log(this.$set)
        // this.$set(this.data.rentDays, days)

        this.data.rentDays = days
      } else {
        this.data.rentDays = 0
      }
    }
  }
</script>
