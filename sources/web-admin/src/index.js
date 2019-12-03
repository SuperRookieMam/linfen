// 引入填充库,解决IE不能显示的问题
// 最新更改，将填充库移动到webpack的entry中，故此这里不再引入
// import '@babel/polyfill'
/* (runtime-only or standalone) has been set in webpack.base.conf with an alias.
 * 引入vue,在webpack.base.conf中通过别名设置使用standalone版本或者runtime-only版本
 * 详细信息请参考 https://vuejs.org/v2/guide/installation.html#Runtime-Compiler-vs-Runtime-only
 */
import Vue from 'vue'
import App from './App.vue'
import VueRouter from 'vue-router'
import ElementUi from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import store from './vuex'
import { httpInstance, router, tableHttpInstance } from './config'
import { AjaxPlugin, EleDateFormater } from './plugins'
import EleDataTables from 'element-datatables'
import filter from './utils/filter'
// 载入模拟数据，在对接后端服务器接口时，取消掉
// import '../data'
import VueQuillEditor from 'vue-quill-editor'
import 'quill/dist/quill.core.css'
import 'quill/dist/quill.snow.css'
import 'quill/dist/quill.bubble.css'
import {
  securityModule,
  // SampleModule,
  SystemModule,
  sentimentModule,
  dataModule,
  // DataviewModule,
  // OpinionModule,
  kpiModule,
  emergencyModule,
  rootModule,
  // DataModule,
  // DataviewModule,
  // OpinionModule,
  // DvmModule,
  // IocEventModule
  // OauthModule,
  temporaryModule
} from './module'

Vue.config.productionTip = false
Vue.use(ElementUi)
Vue.use(EleDataTables, { httpInstance: tableHttpInstance }) // 注入表格实例，并且对表格启用一个全新的http实例
Vue.use(VueRouter)
Vue.use(VueQuillEditor)
Vue.use(AjaxPlugin, httpInstance)
Vue.use(EleDateFormater)
Vue.use(securityModule, {
  store,
  router
})
// Vue.use(SampleModule, { store, router }) // 示例模块
Vue.use(SystemModule, {
  store,
  router
}) // 系统管理模块
Vue.use(sentimentModule, {
  store,
  router
})
Vue.use(emergencyModule, {
  store,
  router
})
Vue.use(kpiModule, {
  store,
  router
})
Vue.use(dataModule, {
  store,
  router
}) // 数据中心模块
Vue.use(rootModule, {
  store,
  router
}) // 寻根管理模块
// Vue.use(DataModule, { store, router }) // 数据中心模块
// Vue.use(DataviewModule, { store, router })
// Vue.use(OpinionModule, { store, router })
// Vue.use(DvmModule, { store, router })
// Vue.use(IocEventModule, { store, router }) // 应急指挥模块
// Vue.use(OauthModule, { store, router })
// temporaryModule
Vue.use(temporaryModule, {
  store,
  router
})

console.log('Created By ldwqh0@outlook.com')

Vue.filter('dateFormat', filter.dateFormat)

/**
 *  一定要使用 render函数创建app,这样就不需要依赖完整的esm，也就是不需要打包vue的编译模块了，
 *  vue的模板编译模块体积打约是25KB左右
 */
new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
