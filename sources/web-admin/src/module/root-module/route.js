export default [{
  path: '/root',
  component: () => import('@/components/templates/LeftTemplate'),
  children: [{
    name: 'recommendLines',
    path: 'recommendLines',
    component: () => import('./component/recommendLines')
  }, {
    name: 'recommendLine',
    path: 'recommendLine/:id',
    props: true,
    component: () => import('./component/recommendLine')
  }, {
    name: 'weChatUsers',
    path: 'weChatUsers',
    component: () => import('./component/weChatUsers')
  }
  ]
}]
