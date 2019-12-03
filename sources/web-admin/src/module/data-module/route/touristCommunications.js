/**
 * 旅游交通管理
 */
export default [{
  // 大巴
  name: 'tourBuses',
  path: 'tourBuses',
  component: () => import('../component/travelTransport/tourBus/Index')
}, {
  name: 'tourBus',
  path: 'tourBus/:id',
  props: true,
  component: () => import('../component/travelTransport/tourBus/TourBus')
}, {
  name: 'tourBusService',
  path: 'tourBusService/:id',
  props: true,
  component: () => import('../component/travelTransport/tourBusService/TourBusService')
}, {
  // 汽车租赁
  name: 'carRentals',
  path: 'carRentals',
  component: () => import('../component/travelTransport/carRental/Index')
}, {
  name: 'carRental',
  path: 'carRental/:id',
  props: true,
  component: () => import('../component/travelTransport/carRental/CarRental')
}, {
  // 汽车租赁
  name: 'car',
  path: 'car/:id',
  props: true,
  component: () => import('../component/travelTransport/car/Car')
}]
