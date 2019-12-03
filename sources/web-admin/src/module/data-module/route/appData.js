/**
 * app数据
 */
export default [{
  // banner
  name: 'banners',
  path: 'banners',
  component: () => import('../component/appData/Banner/Banners')
}, {
  name: 'banner',
  path: 'banner/:id',
  props: true,
  component: () => import('../component/appData/Banner/Banner')
}, {
  // 电子行程
  name: 'electronicTravels',
  path: 'electronicTravels',
  component: () => import('../component/appData/ElectronicTravel/ElectronicTravels')
}, {
  name: 'electronicTravel',
  path: 'electronicTravel/:id',
  props: true,
  component: () => import('../component/appData/ElectronicTravel/ElectronicTravel')
}, {
  // 旅游大巴
  name: 'travelBuss1',
  path: 'travelBuss1',
  component: () => import('../component/appData/TravelBus/TravelBuss')
}, {
  name: 'travelBus1',
  path: 'travelBus1/:id',
  props: true,
  component: () => import('../component/appData/TravelBus/TravelBus')
}, {
  name: 'elTrip',
  path: 'elTrip/:id',
  props: true,
  component: () => import('../component/appData/ElectronicTravel/Trip')
}, {
  name: 'point',
  path: 'point/:id/:rid',
  props: true,
  component: () => import('../component/appData/TravelBus/LocalPoint')
}]
