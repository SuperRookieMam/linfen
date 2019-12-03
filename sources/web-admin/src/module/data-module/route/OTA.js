/**
 * OTA数据管理
 */
export default [
  {
    // 天气数据
    name: 'hotelManager',
    path: 'hotelManager/:id',
    props: true,
    component: () => import('../component/OTA/HotelManager/HotelManager')
  }, {
    name: 'hotelManagers',
    path: 'hotelManagers',
    props: true,
    component: () => import('../component/OTA/HotelManager/HotelManagers')
  }, {
    // 天气数据
    name: 'ticket',
    path: 'ticket/:id',
    props: true,
    component: () => import('../component/OTA/Tickets/Tickets')
  }, {
    name: 'tickets',
    path: 'tickets',
    props: true,
    component: () => import('../component/OTA/Tickets/Ticketss')
  }
]
