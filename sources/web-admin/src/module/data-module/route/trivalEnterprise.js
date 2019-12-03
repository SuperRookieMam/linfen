/*
* 涉旅企业管理
* 娱乐场所  没有
* */
export default [{
  // 住宿场所
  name: 'accommodations',
  path: 'accommodations',
  props: true,
  component: () => import('../component/travelRelatedEnterpriseManagement/accommodation/Index')
}, {
  name: 'accommodation',
  path: 'accommodation/:id',
  props: true,
  component: () => import('../component/travelRelatedEnterpriseManagement/accommodation/Accommodation')
}, {
  name: 'roomInfo',
  path: 'roomInfo/:id',
  props: true,
  component: () => import('../component/travelRelatedEnterpriseManagement/RoomInfo/RoomInfo')
}, {
  // 旅行社
  name: 'travelAgentFields',
  path: 'travelAgentFields',
  props: true,
  component: () => import('../component/travelRelatedEnterpriseManagement/travelAgentField/Index')
}, {
  name: 'travelAgentField',
  path: 'travelAgentField/:id',
  props: true,
  component: () => import('../component/travelRelatedEnterpriseManagement/travelAgentField/TravelAgentField')
}, {
  // 餐饮场所
  name: 'diningPlaces',
  path: 'diningPlaces',
  props: true,
  component: () => import('../component/travelRelatedEnterpriseManagement/diningPlace/Index')
}, {
  name: 'diningPlace',
  path: 'diningPlace/:id',
  props: true,
  component: () => import('../component/travelRelatedEnterpriseManagement/diningPlace/DiningPlace')
}, {
  // 购物场所
  name: 'shoppingPlaces',
  path: 'shoppingPlaces',
  props: true,
  component: () => import('../component/travelRelatedEnterpriseManagement/shoppingPlaceWord/ShoppingPlaces')
}, {
  name: 'shoppingPlace',
  path: 'shoppingPlace/:id',
  props: true,
  component: () => import('../component/travelRelatedEnterpriseManagement/shoppingPlaceWord/ShoppingPlace')
}, {
  name: 'entertainmentVenuess',
  path: 'entertainmentVenuess',
  props: true,
  component: () => import('../component/travelRelatedEnterpriseManagement/entertainmentVenues/Index')
}, {
  name: 'entertainmentVenues',
  path: 'entertainmentVenues/:id',
  props: true,
  component: () => import('../component/travelRelatedEnterpriseManagement/entertainmentVenues/entertainmentVenues')
}]
