/**
 * 涉旅数据管理
 */
export default [
  {
    name: 'EnteringBusinesss',
    path: 'EnteringBusinesss',
    props: true,
    component: () => import('../component/OperationDatabases/EnteringBusines/EnteringBusinesss')
  }, {
    name: 'EnteringBusiness',
    path: 'EnteringBusiness/:id',
    props: true,
    component: () => import('../component/OperationDatabases/EnteringBusines/EnteringBusiness')
  }, {
    name: 'EnteringPolices',
    path: 'EnteringPolices',
    props: true,
    component: () => import('../component/OperationDatabases/EnteringPolice/EnteringPolices')
  }, {
    name: 'EnteringPolice',
    path: 'EnteringPolice/:id',
    props: true,
    component: () => import('../component/OperationDatabases/EnteringPolice/EnteringPolice')
  }, {
    name: 'scenicTimePersons',
    path: 'scenicTimePersons',
    props: true,
    component: () => import('../component/OperationDatabases/ScenicTimePerson/ScenicTimePersons')
  }, {
    name: 'scenicTimePerson',
    path: 'scenicTimePerson/:id',
    props: true,
    component: () => import('../component/OperationDatabases/ScenicTimePerson/ScenicTimePerson')
  }, {
    name: 'hotelTimePersons',
    path: 'hotelTimePersons',
    props: true,
    component: () => import('../component/OperationDatabases/HotelTimePerson/HotelTimePersons')
  }, {
    name: 'hotelTimePerson',
    path: 'hotelTimePerson/:id',
    props: true,
    component: () => import('../component/OperationDatabases/HotelTimePerson/HotelTimePerson')
  }, {
    name: 'parkingTimes',
    path: 'parkingTimes',
    props: true,
    component: () => import('../component/OperationDatabases/ParkingTime/ParkingTimes')
  }, {
    name: 'parkingTime',
    path: 'parkingTime/:id',
    props: true,
    component: () => import('../component/OperationDatabases/ParkingTime/ParkingTime')
  }, {
    name: 'senicReceptions',
    path: 'senicReceptions',
    props: true,
    component: () => import('../component/OperationDatabases/SenicReception/SenicReceptions')
  }, {
    name: 'senicReception',
    path: 'senicReception/:id',
    props: true,
    component: () => import('../component/OperationDatabases/SenicReception/SenicReception')
  }, {
    name: 'ConsumptionMsg',
    path: 'ConsumptionMsg/:id',
    props: true,
    component: () => import('../component/OperationDatabases/ConsumptionMsg/ConsumptionMsg')
  }]
