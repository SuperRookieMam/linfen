export default [{
  name: 'login',
  path: '/login',
  props: route => ({ ...route.query }),
  component: () => import('./component/Login')
}]
