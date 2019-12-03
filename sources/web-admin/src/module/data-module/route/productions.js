/**
 * 旅游产品
 */
export default [{
  // 旅游线路
  name: 'touristRoutes',
  path: 'touristRoutes',
  component: () => import('../component/trivalProducts/touristRoute/Index')
}, {
  name: 'touristRoute',
  path: 'touristRoute/:id',
  props: true,
  component: () => import('../component/trivalProducts/touristRoute/TouristRoute')
}, {
  name: 'touristRoutePathPoint',
  path: 'touristRoutePathPoint/:id/:rid',
  props: true,
  component: () => import('../component/trivalProducts/touristRoute/PathPoint')
}, {
  // 旅游商品
  name: 'touristCommodities',
  path: 'touristCommodities',
  component: () => import('../component/trivalProducts/touristCommodity/Index')
}, {
  name: 'touristCommodity',
  path: 'touristCommodities/:id',
  props: true,
  component: () => import('../component/trivalProducts/touristCommodity/TouristCommodity')
}]
