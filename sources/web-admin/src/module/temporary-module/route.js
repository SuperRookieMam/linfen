export default [{
  path: '/temporary',
  component: () => import('@/components/templates/LeftTemplate'),
  children: [{
    name: 'accesss',
    path: 'accesss',
    component: () => import('./component/Accesss')
  }]
}]
