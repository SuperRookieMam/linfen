import store from '../../vuex'
import Router from 'vue-router'

const router = new Router({
  base: CONTEXT_PATH,
  mode: 'history'
})

router.beforeEach((to, from, next) => {
  store.commit('updateRouting', true)
  next()
})
router.afterEach((to, from) => {
  const matched = to.matched[to.matched.length - 1]
  store.commit('updateMatched', matched)
  store.commit('updateRouting', false)
})
export default router
