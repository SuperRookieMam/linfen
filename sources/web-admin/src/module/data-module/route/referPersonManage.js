/*
涉旅人员管理
领队没有响应的页面
 */
export default [{
  // 导游
  name: 'tourGuides',
  path: 'tourGuides',
  component: () => import('../component/travelAgentManagement/tourGuide/Index')
}, {
  name: 'tourGuide',
  path: 'tourGuide/:id',
  props: true,
  component: () => import('../component/travelAgentManagement/tourGuide/TourGuide')
}, {
  // 大巴司机
  name: 'busDrivers',
  path: 'busDrivers',
  component: () => import('../component/travelAgentManagement/busDriver/Index')
}, {
  name: 'busDriver',
  path: 'busDriver/:id',
  props: true,
  component: () => import('../component/travelAgentManagement/busDriver/BusDriver')
}, {
  // 景区讲解员
  name: 'touristGuides',
  path: 'touristGuides',
  component: () => import('../component/travelAgentManagement/touristGuide/TouristGuids')
}, {
  name: 'touristGuide',
  path: 'touristGuide/:id',
  props: true,
  component: () => import('../component/travelAgentManagement/touristGuide/TouristGuide')
}]
