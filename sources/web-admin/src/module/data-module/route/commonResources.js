/**
 * 公共资源
 */
export default [{
  // 旅游厕所
  name: 'touristToilets',
  path: 'touristToilets',
  component: () => import('../component/publicSource/touristToilet/Index')
}, {
  name: 'touristToilet',
  path: 'touristToilet/:id',
  props: true,
  component: () => import('../component/publicSource/touristToilet/TouristToilet')
}, {
  // 停车场
  name: 'parkingLots',
  path: 'parkingLots',
  component: () => import('../component/publicSource/parkingLot/Index')
}, {
  name: 'parkingLot',
  path: 'parkingLots/:id',
  props: true,
  component: () => import('../component/publicSource/parkingLot/ParkingLot')
}, {
  // 旅游监控中心
  name: 'tourismMonitoringCenters',
  path: 'tourismMonitoringCenters',
  component: () => import('../component/publicSource/tourismMonitoringCenter/Index')
}, {
  name: 'tourismMonitoringCenter',
  path: 'tourismMonitoringCenter/:id',
  props: true,
  component: () => import('../component/publicSource/tourismMonitoringCenter/tourismMonitoringCenter')
}]
