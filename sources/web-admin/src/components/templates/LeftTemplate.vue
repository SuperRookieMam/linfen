<template>
  <el-container style="height: 100%" class="app left-template">
    <el-header class="header"
               style="display: flex; align-items: center; justify-content: space-between;">
      临汾智慧旅游平台
      <el-tabs v-model="activeName">
        <el-tab-pane v-for="(item, index) in Object.keys(menus)"
                     :key="index"
                     :label="item"
                     :name="item" />
      </el-tabs>
    </el-header>
    <el-container style="overflow-y: auto">
      <el-aside class="aside"
                :width="collapse?'65px':'200px'">
        <a class="btn-collapse" @click="collapse=!collapse">
          <i class="el-icon-s-fold" v-if="!collapse" />
          <i class="el-icon-s-unfold" v-if="collapse" />
        </a>

        <el-menu background-color="#304156"
                 text-color="#FFFFFF"
                 :collapse="collapse"
                 style="border-right: none">
          <menu-item v-for="menu in menus[activeName]" :key="menu.id" :item="menu" />
        </el-menu>
      </el-aside>
      <el-main style="padding: 0px;">
        <el-scrollbar style="height: 100%;width: 100%;"
                      wrap-class="content-wrapper">
          <router-view v-if="reloading" />
        </el-scrollbar>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
  import Vue from 'vue'
  import { Component } from 'vue-property-decorator'
  import { namespace } from 'vuex-class'
  import MenuItem from '../theme/MenuItem'

  const securityModule = namespace('security')
  @Component({
    components: { MenuItem },
    provide () {
      return {
        reload: this.reload
      }
    }
  })
  export default class LeftTemplate extends Vue {
    collapse = false

    @securityModule.Action('loadMenus')
    loadMenus

    @securityModule.Getter('menuTree')
    menuTree

    @securityModule.Action('loadCurrentUser')
    loadCurrentUser

    activeName = 'home'

    reloading = true

    // 改变原菜单 把第一层菜单拿出来
    get menus () {
      const menus = {}
      this.menuTree.forEach(menu => {
        if (!menu.children) {
          menus[menu.name] = [menu]
        } else {
          menus[menu.name] = [...menu.children]
        }
      })
      console.log(menus)
      return menus
    }

    reload () {
      this.reloading = false
      this.$nextTick(() => {
        this.reloading = true
      })
    }

    created () {
      this.loadCurrentUser()
      this.loadMenus()
    }
  }
</script>

<style lang="less">
  html, body {
    height: 100%;
  }
</style>
<style lang="less" scoped>
  .app.left-template {
    .btn-collapse {
      display: block;
      text-align: center;
      font-size: 24px;
    }

    .header, aside {
      background: #304156;
      color: #d9d9d9;
    }

    .header {
      border-bottom: solid 1px #9c9c9c;
    }

  }
</style>
<style lang="less">
  .content-wrapper {
    overflow-x: hidden;

    .el-scrollbar__view {
      padding: 20px;
    }
  }

  .header {
    .el-tabs__item.is-active {
      color: #fff;
    }

    .el-tabs__item:hover {
      color: #fff;
    }

    .el-tabs__item {
      color: #fff;
    }

    .el-tabs__active-bar {
      background-color: #fff;
    }

    .el-tabs-bar {
      background-color: rgb(175, 35, 35);
    }

    .el-tabs__nav-wrap::after {
      display: none;
    }
  }
</style>
