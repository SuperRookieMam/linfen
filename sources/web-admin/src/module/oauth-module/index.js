import routes from './route'
import storeModule from './vuex'

export default {
  install (Vue, { store, router }) {
    router.addRoutes(routes)
    store.registerModule('oauth', storeModule)
  }
}
