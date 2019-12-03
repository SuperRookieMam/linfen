/**
 * 旅游产品
 */
export default [{
  // 旅游线路
  name: 'teamReports',
  path: 'teamReports',
  component: () => import('../component/TeamReport/TeamReport/Index')
}, {
  name: 'teamReport',
  path: 'teamReport/:id',
  props: true,
  component: () => import('../component/TeamReport/TeamReport/TeamReport')
}, {
  name: 'teamMember',
  path: 'teamMember/:id',
  props: true,
  component: () => import('../component/TeamReport/TeamMember/TeamMember')
}]
