import routes from './route'
import storeModule from './vuex'
import Edit from './component/.common/edit'
import VueUploader from 'vue2-uploader/src/components'

export default {
  install (Vue, { store, router }) {
    Vue.component('edit', Edit)
    Vue.component('VueUploader', VueUploader)
    router.addRoutes(routes)
    store.registerModule('data', storeModule)
  }
}
