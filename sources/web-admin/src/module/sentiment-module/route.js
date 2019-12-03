export default [{
  path: '/sentiments',
  component: () => import('@/components/templates/LeftTemplate'),
  children: [{
    name: 'sentiments',
    path: '',
    component: () => import('./component/Sentiments')
  }, {
    name: 'sentiment',
    path: ':id',
    props: true,
    component: () => import('./component/Sentiment')
  }]
}]
