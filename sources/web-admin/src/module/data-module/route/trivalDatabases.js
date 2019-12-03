/**
 * 涉旅数据管理
 */
export default [{
  // 天气数据
  name: 'airQuality',
  path: 'airQuality/:id',
  props: true,
  component: () => import('../component/TravalDatabases/AirQuality/AirQuality')
}, {
  name: 'airQualitys',
  path: 'airQualitys',
  props: true,
  component: () => import('../component/TravalDatabases/AirQuality/AirQualitys')
}, {
  // 天气数据
  name: 'whether',
  path: 'whether/:id',
  props: true,
  component: () => import('../component/TravalDatabases/Whether/Whether')
}, {
  name: 'whethers',
  path: 'whethers',
  props: true,
  component: () => import('../component/TravalDatabases/Whether/Whethers')
}
]
