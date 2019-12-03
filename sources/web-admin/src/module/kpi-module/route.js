export default [{
  name: 'kpi',
  path: '/kpi',
  component: () => import('@/components/templates/LeftTemplate'),
  children: [{
    name: 'dayHotels',
    path: 'dayHotels',
    component: () => import('./component/DayHotels')
  }, {
    name: 'dayLifeIndexs',
    path: 'dayLifeIndexs',
    component: () => import('./component/DayLifeIndexs')
  }, {
    name: 'dayScenics',
    path: 'dayScenics',
    component: () => import('./component/DayScenics')
  }, {
    name: 'hourScenicComforts',
    path: 'hourScenicComforts',
    component: () => import('./component/HourScenicComforts')
  }, {
    name: 'dayScenicWeathers',
    path: 'dayScenicWeathers',
    component: () => import('./component/DayScenicWeathers')
  }, {
    name: 'dayTeams',
    path: 'dayTeams',
    component: () => import('./component/DayTeams')
  }, {
    name: 'dayTeamTourists',
    path: 'dayTeamTourists',
    component: () => import('./component/DayTeamTourists')
  }, {
    name: 'dayTourists',
    path: 'dayTourists',
    component: () => import('./component/DayTourists')
  }, {
    name: 'hourAqis',
    path: 'hourAqis',
    component: () => import('./component/HourAqis')
  }, {
    name: 'hourHumiditys',
    path: 'hourHumiditys',
    component: () => import('./component/HourHumiditys')
  }, {
    name: 'hourPrecipitations',
    path: 'hourPrecipitations',
    component: () => import('./component/HourPrecipitations')
  }, {
    name: 'hourPressures',
    path: 'hourPressures',
    component: () => import('./component/HourPressures')
  }, {
    name: 'hourScenics',
    path: 'hourScenics',
    component: () => import('./component/HourScenics')
  }, {
    name: 'hourScenicAqis',
    path: 'hourScenicAqis',
    component: () => import('./component/HourScenicAqis')
  }, {
    name: 'hourScenicParkings',
    path: 'hourScenicParkings',
    component: () => import('./component/HourScenicParkings')
  }, {
    name: 'hourScenicSentiments',
    path: 'hourScenicSentiments',
    component: () => import('./component/HourScenicSentiments')
  }, {
    name: 'hourSentiments',
    path: 'hourSentiments',
    component: () => import('./component/HourSentiments')
  }, {
    name: 'hourTemperatures',
    path: 'hourTemperatures',
    component: () => import('./component/HourTemperatures')
  }, {
    name: 'hourWinds',
    path: 'hourWinds',
    component: () => import('./component/HourWinds')
  }, {
    name: 'monthCitys',
    path: 'monthCitys',
    component: () => import('./component/MonthCitys')
  }, {
    name: 'monthComplaints',
    path: 'monthComplaints',
    component: () => import('./component/MonthComplaints')
  }, {
    name: 'monthHotelComs',
    path: 'monthHotelComs',
    component: () => import('./component/MonthHotelComs')
  }, {
    name: 'monthTourisHotelLocalIns',
    path: 'monthTourisHotelLocalIns',
    component: () => import('./component/MonthHotelLocalIns')
  }, {
    name: 'monthHotelTypes',
    path: 'monthHotelTypes',
    component: () => import('./component/MonthHotelTypes')
  }, {
    name: 'monthInRegions',
    path: 'monthInRegions',
    component: () => import('./component/MonthInRegions')
  }, {
    name: 'monthRegions',
    path: 'monthRegions',
    component: () => import('./component/MonthRegions')
  }, {
    name: 'monthRegionTouristConsumes',
    path: 'monthRegionTouristConsumes',
    component: () => import('./component/MonthRegionTouristConsumes')
  }, {
    name: 'monthRouteRanks',
    path: 'monthRouteRanks',
    component: () => import('./component/MonthRouteRanks')
  }, {
    name: 'monthScenics',
    path: 'monthScenics',
    component: () => import('./component/MonthScenics')
  }, {
    name: 'monthSentimentKeywords',
    path: 'monthSentimentKeywords',
    component: () => import('./component/MonthSentimentKeywords')
  }, {
    name: 'monthTeamConsumes',
    path: 'monthTeamConsumes',
    component: () => import('./component/MonthTeamConsumes')
  }, {
    name: 'monthTeamIns',
    path: 'monthTeamIns',
    component: () => import('./component/MonthTeamIns')
  }, {
    name: 'monthTeamRegions',
    path: 'monthTeamRegions',
    component: () => import('./component/MonthTeamRegions')
  }, {
    name: 'monthTeamStays',
    path: 'monthTeamStays',
    component: () => import('./component/MonthTeamStays')
  }, {
    name: 'monthTeamTourists',
    path: 'monthTeamTourists',
    component: () => import('./component/MonthTeamTourists')
  }, {
    name: 'monthTeamTypes',
    path: 'monthTeamTypes',
    component: () => import('./component/MonthTeamTypes')
  }, {
    name: 'monthTourists',
    path: 'monthTourists',
    component: () => import('./component/MonthTourists')
  }, {
    name: 'monthTouristAges',
    path: 'monthTouristAges',
    component: () => import('./component/MonthTouristAges')
  }, {
    name: 'yearIndustrys',
    path: 'yearIndustrys',
    component: () => import('./component/YearIndustrys')
  }, {
    name: 'monthTouristCheckIns',
    path: 'monthTouristCheckIns',
    component: () => import('./component/MonthTouristCheckIns')
  }, {
    name: 'yearTouristConsumes',
    path: 'yearTouristConsumes',
    component: () => import('./component/YearTouristConsumes')
  }, {
    name: 'monthTouristGenders',
    path: 'monthTouristGenders',
    component: () => import('./component/MonthTouristGenders')
  }, {
    name: 'monthTouristLocalOuts',
    path: 'monthTouristLocalOuts',
    component: () => import('./component/MonthTouristLocalOuts')
  }, {
    name: 'monthTouristOccupations',
    path: 'monthTouristOccupations',
    component: () => import('./component/MonthTouristOccupations')
  }, {
    name: 'yearTouristTraffics',
    path: 'yearTouristTraffics',
    component: () => import('./component/YearTouristTraffics')
  }, {
    name: 'monthTouristPurposes',
    path: 'monthTouristPurposes',
    component: () => import('./component/MonthTouristPurposes')
  }, {
    name: 'yearTouristScenics',
    path: 'yearTouristScenics',
    component: () => import('./component/yearTouristScenics')
  }, {
    name: 'monthTouristStays',
    path: 'monthTouristStays',
    component: () => import('./component/MonthTouristStays')
  }, {
    name: 'monthTouristTeamSingles',
    path: 'monthTouristTeamSingles',
    component: () => import('./component/MonthTouristTeamSingles')
  }, {
    name: 'monthTouristVisits',
    path: 'monthTouristVisits',
    component: () => import('./component/MonthTouristVisits')
  }, {
    name: 'monthTravelAgencyRanks',
    path: 'monthTravelAgencyRanks',
    component: () => import('./component/MonthTravelAgencyRanks')
  }, {
    name: 'hourWeathers',
    path: 'hourWeathers',
    component: () => import('./component/HourWeathers')
  }, {
    name: 'weatherForecasts',
    path: 'weatherForecasts',
    component: () => import('./component/WeatherForecasts')
  }, {
    name: 'weatherLiveDatas',
    path: 'weatherLiveDatas',
    component: () => import('./component/WeatherLiveDatas')
  }, {
    name: 'yearGuidedGenders',
    path: 'yearGuidedGenders',
    component: () => import('./component/YearGuidedGenders')
  }, {
    name: 'nowGuides',
    path: 'nowGuides',
    component: () => import('./component/NowGuides')
  }, {
    name: 'yearRegions',
    path: 'yearRegions',
    component: () => import('./component/YearRegions')
  }, {
    name: 'yearCitys',
    path: 'yearCitys',
    component: () => import('./component/YearCitys')
  }, {
    name: 'yearResources',
    path: 'yearResources',
    component: () => import('./component/YearResources')
  }, {
    name: 'yearScenics',
    path: 'yearScenics',
    component: () => import('./component/YearScenics')
  }, {
    name: 'yearScenicCityCars',
    path: 'yearScenicCityCars',
    component: () => import('./component/YearScenicCityCars')
  }, {
    name: 'yearScenicComAccs',
    path: 'yearScenicComAccs',
    component: () => import('./component/YearScenicComAccs')
  }, {
    name: 'yearTourists',
    path: 'yearTourists',
    component: () => import('./component/YearTourists')
  }, {
    name: 'yearTouristIns',
    path: 'yearTouristIns',
    component: () => import('./component/YearTouristIns')
  }, {
    name: 'yearTouristAges',
    path: 'yearTouristAges',
    component: () => import('./component/YearTouristAges')
  }, {
    name: 'yearTouristGenders',
    path: 'yearTouristGenders',
    component: () => import('./component/YearTouristGenders')
  }, {
    name: 'yearTouristHolidays',
    path: 'yearTouristHolidays',
    component: () => import('./component/YearTouristHolidays')
  }, {
    name: 'yearTouristHolidayTypes',
    path: 'yearTouristHolidayTypes',
    component: () => import('./component/YearTouristHolidayTypes')
  }, {
    name: 'yearTouristHotels',
    path: 'yearTouristHotels',
    component: () => import('./component/YearTouristHotels')
  }, {
    name: 'yearTouristStays',
    path: 'yearTouristStays',
    component: () => import('./component/YearTouristStays')
  }, {
    name: 'hourNewPublicOpinions',
    path: 'hourNewPublicOpinions',
    component: () => import('./component/HourNewPublicOpinions')
  }, {
    name: 'monthIncomes',
    path: 'monthIncomes',
    component: () => import('./component/MonthIncomes')
  }, {
    name: 'dayHotelPrices',
    path: 'dayHotelPrices',
    component: () => import('./component/DayHotelPrices')
  }, {
    name: 'dayHotelScores',
    path: 'dayHotelScores',
    component: () => import('./component/DayHotelScores')
  }, {
    name: 'monthSentimentTypes',
    path: 'monthSentimentTypes',
    component: () => import('./component/MonthSentimentTypes')
  }, {
    name: 'monthScenicPriceRates',
    path: 'monthScenicPriceRates',
    component: () => import('./component/MonthScenicPriceRates')
  }, {
    name: 'monthTeamBuses',
    path: 'monthTeamBuses',
    component: () => import('./component/MonthTeamBuses')
  }, {
    name: 'quarterLocalReceptions',
    path: 'QuarterLocalReceptions',
    component: () => import('./component/QuarterLocalReceptions')
  }, {
    name: 'yearMedias',
    path: 'yearMedias',
    component: () => import('./component/YearMedias')
  }, {
    name: 'nowDistrictResources',
    path: 'nowDistrictResources',
    component: () => import('./component/NowDistrictResources')
  }, {
    name: 'nowResources',
    path: 'nowResources',
    component: () => import('./component/NowResources')
  }, {
    name: 'yearKeywords',
    path: 'yearKeywords',
    component: () => import('./component/YearKeywords')
  }, {
    name: 'yearCognitionAtlass',
    path: 'yearCognitionAtlass',
    component: () => import('./component/YearCognitionAtlass')
  }, {
    name: 'yearNegKeywords',
    path: 'yearNegKeywords',
    component: () => import('./component/YearNegKeywords')
  }, {
    name: 'yearPublicOpinionRegions',
    path: 'yearPublicOpinionRegions',
    component: () => import('./component/YearPublicOpinionRegions')
  }, {
    name: 'yearTeamGenderAges',
    path: 'yearTeamGenderAges',
    component: () => import('./component/YearTeamGenderAges')
  }, {
    name: 'yearTeamRegions',
    path: 'yearTeamRegions',
    component: () => import('./component/YearTeamRegions')
  }, {
    name: 'yearCognitionAtlass',
    path: 'yearCognitionAtlass',
    component: () => import('./component/YearCognitionAtlass')
  }, {
    name: 'yearTeamStays',
    path: 'yearTeamStays',
    component: () => import('./component/YearTeamStays')
  }]
}]
