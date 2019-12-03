export default [{
  path: '/emergencies',
  component: () => import('@/components/templates/LeftTemplate'),
  children: [{
    name: 'events',
    path: 'events',
    component: () => import('./component/Events')
  }, {
    name: 'event',
    path: 'events/:id',
    props: true,
    component: () => import('./component/Event')
  }, {
    name: 'duties',
    path: 'duties',
    component: () => import('./component/Duties')
  }, {
    name: 'reports',
    path: 'reports',
    component: () => import('./component/Reports')
  }, {
    name: 'report',
    path: 'reports/:id',
    props: true,
    component: () => import('./component/Report')
  }, {
    name: 'plans',
    path: 'plans',
    component: () => import('./component/Plans')
  }, {
    name: 'plan',
    path: 'plans/:id',
    props: true,
    component: () => import('./component/Plan')
  }, {
    name: 'keyWords',
    path: 'keyWords',
    component: () => import('./component/KeyWords')
  }, {
    name: 'keyWord',
    path: 'keyWord/:id',
    props: true,
    component: () => import('./component/KeyWord')
  }]
}]
