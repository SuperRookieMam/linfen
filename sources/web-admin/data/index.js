// 使用mockjs模拟数据，mockjs的相关文档请参考 http://mockjs.com/
import Mock from 'mockjs'
import authorityMenus from './d/authorities/menus'
// import touristRoutess from './d/data/touristRoutes'
// import tourismPurposes from './d/data/tourismPurpose'
// import tourismPurpose from './d/data/tourismPurpose/1'
// import touristRoutes from './d/data/touristRoutes/1'
// import financialNets from './d/data/financialNet'
// import financialNet from './d/data/financialNet/1'
// import touristAttractions from './d/data/touristAttraction'
// import touristAttraction from './d/data/touristAttraction/1'
// import travelAgentFields from './d/data/travelAgentFields'
// import travelAgentField from './d/data/travelAgentFields/1'
// import tourGuides from './d/data/tourGuiders'
// import tourGuide from './d/data/tourGuiders/1'
// import airportInformations from './d/data/airportInformations'
// import airportInformation from './d/data/airportInformations/1'
//
// // const CTX = `${CONTEXT_PATH}d/data`
// Mock.mock('/element-seed/d/data/touristRoutes', options => {
//   return touristRoutes
// })
//
// // 旅游目的地模拟数据
// Mock.mock(/^\/element-seed\/d\/data\/tourismPurpose\/\d/, options => {
//   return tourismPurpose
// })
// // 旅游目的地模拟列表
// Mock.mock(/^\/element-seed\/d\/data\/tourismPurpose/, options => {
//   return tourismPurposes
// })
//
// // 旅游线路模拟数据
// Mock.mock(/^\/element-seed\/d\/data\/touristRoute\/\d/, options => {
//   return touristRoutes
// })
//
// // 旅游线路模拟列表
// Mock.mock(/^\/element-seed\/d\/data\/touristRoute/, options => {
//   return touristRoutess
// })
// // 旅游线路模拟数据
// Mock.mock(/^\/element-seed\/d\/data\/financialNet\/\d/, options => {
//   return financialNet
// })
// // 金融网点模拟列表
// Mock.mock(/^\/element-seed\/d\/data\/financialNet/, options => {
//   return financialNets
// })
// // 旅游景区模拟数据
// Mock.mock(/^\/element-seed\/d\/data\/touristAttraction\/\d/, options => {
//   return touristAttraction
// })
// // 旅游景区模拟列表
// Mock.mock(/^\/element-seed\/d\/data\/touristAttraction/, options => {
//   return touristAttractions
// })
// // 旅游企业模拟数据
// Mock.mock(/^\/element-seed\/d\/data\/travelAgentField\/\d/, options => {
//   return travelAgentField
// })
// // 旅游企业模拟列表
// Mock.mock(/^\/element-seed\/d\/data\/travelAgentField/, options => {
//   return travelAgentFields
// })
// // 旅游人员导游模拟数据
// Mock.mock(/^\/element-seed\/d\/data\/tourGuide\/\d/, options => {
//   return tourGuide
// })
// // 旅游人员导游模拟列表
// Mock.mock(/^\/element-seed\/d\/data\/tourGuide/, options => {
//   return tourGuides
// })
// // 旅游交通航空模拟数据
// Mock.mock(/^\/element-seed\/d\/data\/airportInformation\/\d/, options => {
//   return airportInformation
// })
// // 旅游交通航空游模拟列表
// Mock.mock(/^\/element-seed\/d\/data\/airportInformation/, options => {
//   return airportInformations
// })

//
Mock.mock('/element-seed/d/menuAuthorities/menus', ({ url }) => {
  return authorityMenus
})

// Mock.mock('/element-seed/d/authorities/currentUser', options => {
//   return {
//     'id': 1,
//     'username': 'admin',
//     'fullname': '系统管理员',
//     'roles': [{
//       'authority': 'ROLE_ADMIN', 'id': 1
//     }]
//   }
// })
