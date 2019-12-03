/*
* 旅游资源管理
* */
export default [{
  // 旅游景区
  name: 'touristAttractions',
  path: 'touristAttractions',
  component: () => import('../component/tourismResourceManagement/touristAttractions/Index')
}, {
  name: 'touristAttraction',
  path: 'touristAttraction/:id',
  props: true,
  component: () => import('../component/tourismResourceManagement/touristAttractions/TouristAttractions')
}, {
  // 乡村旅游
  name: 'ruralTourisms',
  path: 'ruralTourisms',
  component: () => import('../component/tourismResourceManagement/ruralTourism/Index')
}, {
  name: 'ruralTourism',
  path: 'ruralTourisms/:id',
  props: true,
  component: () => import('../component/tourismResourceManagement/ruralTourism/RuralTourism')
}, {
  // 科技文化馆
  name: 'scienceAndTechnologyCultureCenters',
  path: 'scienceAndTechnologyCultureCenters',
  component: () => import('../component/tourismResourceManagement/scienceAndTechnologyCultureCenter/Index')
}, {
  name: 'scienceAndTechnologyCultureCenter',
  path: 'scienceAndTechnologyCultureCenter/:id',
  props: true,
  component: () => import('../component/tourismResourceManagement/scienceAndTechnologyCultureCenter/ScienceAndTechnologyCultureCenter')
} /* , {//  =================
  name: 'touristAttractionTourist',
  path: 'touristAttractionTourist/:pid/:refname/:fieldname/:id',
  props: true,
  component: () => import('../component/travelAgentManagement/touristGuide/TouristGuide')
}, {
  name: 'touristAttractiontourismToilet',
  path: 'touristAttractiontourismToilet/:pid/:refname/:fieldname/:id',
  props: true,
  component: () => import('../component/publicSource/touristToilet/TouristToilet')
}, {
  name: 'touristAttractionParkingLot',
  path: 'touristAttractionParkingLot/:pid/:refname/:fieldname/:id',
  props: true,
  component: () => import('../component/publicSource/parkingLot/ParkingLot')
}, {
  name: 'ruralTourismsParkingLot',
  path: 'ruralTourisms/:pid/:refname/:fieldname/:id',
  props: true,
  component: () => import('../component/publicSource/parkingLot/ParkingLot')
}, {
  name: 'ruralTourismstourismToilet',
  path: 'ruralTourismstourismToilet/:pid/:refname/:fieldname/:id',
  props: true,
  component: () => import('../component/publicSource/touristToilet/TouristToilet')
}, {
  name: 'touristAttractiontourismToilet',
  path: 'touristAttractions/:pid/:refname/:fieldname/:id',
  props: true,
  component: () => import('../component/publicSource/touristToilet/TouristToilet')
}, {
  // 城镇旅游
  name: 'tourismTowns',
  path: 'tourismTowns',
  component: () => import('../component/tourismResourceManagement/tourismTown/Index')
}, {
  name: 'tourismTownsParkingLot',
  path: 'tourismTowns/:pid/:refname/:fieldname/:id',
  props: true,
  component: () => import('../component/publicSource/parkingLot/ParkingLot')
}, {
  name: 'tourismTownstourismToilet',
  path: 'tourismTowns/:pid/:refname/:fieldname/:id',
  props: true,
  component: () => import('../component/publicSource/touristToilet/TouristToilet')
}, {
  name: 'tourismTown',
  path: 'tourismTowns/:id',
  props: true,
  component: () => import('../component/tourismResourceManagement/tourismTown/TourismTown')
}, {
  // 特色街道
  name: 'qualityStreets',
  path: 'qualityStreets',
  component: () => import('../component/tourismResourceManagement/qualityStreet/Index')
}, {
  name: 'qualityStreetsParkingLot',
  path: 'qualityStreets/:pid/:refname/:fieldname/:id',
  props: true,
  component: () => import('../component/publicSource/parkingLot/ParkingLot')
}, {
  name: 'qualityStreetsToilet',
  path: 'qualityStreets/:pid/:refname/:fieldname/:id',
  props: true,
  component: () => import('../component/publicSource/touristToilet/TouristToilet')
}, {
  name: 'qualityStreet',
  path: 'qualityStreets/:id',
  props: true,
  component: () => import('../component/tourismResourceManagement/qualityStreet/QualityStreet')
}, {
  // 特色场所
  name: 'characteristicTourisms',
  path: 'characteristicTourisms',
  component: () => import('../component/tourismResourceManagement/characteristicTourism/Index')
}, {
  name: 'characteristicTourism',
  path: 'characteristicTourisms/:id',
  props: true,
  component: () => import('../component/tourismResourceManagement/characteristicTourism/CharacteristicTourism')
}, {
  name: 'characteristicTourismParkingLot',
  path: 'characteristicTourisms/:pid/:refname/:fieldname/:id',
  props: true,
  component: () => import('../component/publicSource/parkingLot/ParkingLot')
}, {
  name: 'characteristicTourismToilet',
  path: 'characteristicTourisms/:pid/:refname/:fieldname/:id',
  props: true,
  component: () => import('../component/publicSource/touristToilet/TouristToilet')
}, {
  // 新兴业态
  name: 'emergingFormats',
  path: 'emergingFormats',
  component: () => import('../component/tourismResourceManagement/emergingFormats/Index')
}, {
  name: 'emergingFormat',
  path: 'emergingFormats/:id',
  props: true,
  component: () => import('../component/tourismResourceManagement/emergingFormats/EmergingFormats')
}, {
  name: 'emergingFormatParkingLot',
  path: 'emergingFormats/:pid/:refname/:fieldname/:id',
  props: true,
  component: () => import('../component/publicSource/parkingLot/ParkingLot')
}, {
  name: 'emergingFormatTourismToilet',
  path: 'emergingFormats/:pid/:refname/:fieldname/:id',
  props: true,
  component: () => import('../component/publicSource/touristToilet/TouristToilet')
}, {
  // 公园步道
  name: 'publicTrails',
  path: 'publicTrails',
  component: () => import('../component/tourismResourceManagement/publicTrails/Index')
}, {
  name: 'publicTrail',
  path: 'publicTrails/:id',
  props: true,
  component: () => import('../component/tourismResourceManagement/publicTrails/PublicTrails')
}, {
  name: 'publicTrailParkingLot',
  path: 'publicTrails/:pid/:refname/:fieldname/:id',
  props: true,
  component: () => import('../component/publicSource/parkingLot/ParkingLot')
}, {
  name: 'publicTrailTourismToilet',
  path: 'publicTrails/:pid/:refname/:fieldname/:id',
  props: true,
  component: () => import('../component/publicSource/touristToilet/TouristToilet')
}, {
  name: 'scienceAndTechnologyCultureCenterParkingLot',
  path: 'scienceAndTechnologyCultureCenters/:pid/:refname/:fieldname/:id',
  props: true,
  component: () => import('../component/publicSource/parkingLot/ParkingLot')
}, {
  name: 'scienceAndTechnologyCultureCenterTourismToilet',
  path: 'scienceAndTechnologyCultureCenters/:pid/:refname/:fieldname/:id',
  props: true,
  component: () => import('../component/publicSource/touristToilet/TouristToilet')
} */
]
