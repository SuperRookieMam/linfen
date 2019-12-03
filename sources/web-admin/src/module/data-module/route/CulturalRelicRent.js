/**
 * 文物租赁
 */
export default [{
  // 文物租赁
  name: 'culturalRelicRents',
  path: 'culturalRelicRents',
  component: () => import('../component/CulturalRelicRent/CulturalRelicRents')
}, {
  name: 'culturalRelicRent',
  path: 'culturalRelicRent/:id',
  props: true,
  component: () => import('../component/CulturalRelicRent/CulturalRelicRent')
}]
