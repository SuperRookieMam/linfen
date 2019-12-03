/**
 * 旅游目的地
 */
export default [{
  // 旅游目的地
  name: 'tourismPurposes',
  path: 'tourismPurposes',
  meta: {
    path: ['首页', '旅游目的地管理']
  },
  component: () => import('../component/travelDestination/tourismPurpose/Index')
}, {
  name: 'tourismPurpose',
  path: 'tourismPurposes/:id',
  props: true,
  component: () => import('../component/travelDestination/tourismPurpose/TourismPurpose')
}, {
  // 旅游组织协会
  name: 'associations',
  path: 'associations',
  component: () => import('../component/travelDestination/association/Index')
}, {
  name: 'association',
  path: 'associations/:id',
  props: true,
  component: () => import('../component/travelDestination/association/Association')
}, {
  // 旅游管理部门
  name: 'tourismManagementDepartments',
  path: 'tourismManagementDepartments',
  component: () => import('../component/travelDestination/tourismManagementDepartment/Index')
}, {
  name: 'tourismManagementDepartment',
  path: 'tourismManagementDepartments/:id',
  props: true,
  component: () => import('../component/travelDestination/tourismManagementDepartment/TourismManagementDepartment')
}, {
  // 旅游活动
  name: 'touristActivitys',
  path: 'touristActivitys',
  component: () => import('../component/travelDestination/touristActivity/Index')
}, {
  name: 'touristActivity',
  path: 'touristActivitys/:id',
  props: true,
  component: () => import('../component/travelDestination/touristActivity/TouristActivity')
}, {
  // 演出会展
  name: 'performanceExhibitions',
  path: 'performanceExhibitions',
  component: () => import('../component/travelDestination/performanceExhibition/Index')
}, {
  name: 'performanceExhibition',
  path: 'performanceExhibitions/:id',
  props: true,
  component: () => import('../component/travelDestination/performanceExhibition/PerformanceExhibition')
}]
