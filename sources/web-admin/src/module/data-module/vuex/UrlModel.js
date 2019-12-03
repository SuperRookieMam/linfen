
const BaseUrl = CONTEXT_PATH + 'd/data'
const appUrl = CONTEXT_PATH + 'd/app'
export default class BaseModel {
  namespaced = true

  state = {
    AllUrl: {
      trivalEnterprise: { // 旅游企业
        accommodations: `${BaseUrl}/accommodations`,
        parkingLots: `${BaseUrl}/parkingLots`,
        travelAgentFields: `${BaseUrl}/travelAgentFields`,
        diningPlaces: `${BaseUrl}/diningPlaces`,
        shoppingPlaces: `${BaseUrl}/shoppingPlaces`,
        entertainmentVenuess: `${BaseUrl}/entertainmentVenuess`,
        touristToilets: `${BaseUrl}/touristToilets`,
        tourGuides: `${BaseUrl}/tourGuides`,
        busDrivers: `${BaseUrl}/busDrivers`,
        tourBuses: `${BaseUrl}/tourBuses`,
        tourBusServices: `${BaseUrl}/tourBusServices`,
        carRentalEnterpises: `${BaseUrl}/carRentalEnterpises`,
        cars: `${BaseUrl}/cars`,
        tourismMonitoringCenters: `${BaseUrl}/tourismMonitoringCenters`,
        videos: `${BaseUrl}/videos`,
        images: `${BaseUrl}/images`,
        touristRoutes: `${BaseUrl}/touristRoutes`,
        touristCommoditys: `${BaseUrl}/touristCommoditys`,
        teamMembers: `${BaseUrl}/teamMembers`,
        teamReports: `${BaseUrl}/teamReports`,
        airQualitys: `${BaseUrl}/airQualitys`,
        whethers: `${BaseUrl}/whethers`,
        enteringBusiness: `${BaseUrl}/enteringBusinesss`,
        enteringPolices: `${BaseUrl}/enteringPolices`,
        scenicTimePersons: `${BaseUrl}/scenicTimePersons`,
        hotelTimePersons: `${BaseUrl}/hotelTimePersons`,
        parkingTimes: `${BaseUrl}/parkingTimes`,
        senicReceptions: `${BaseUrl}/senicReceptions`,
        consumptionMsgs: `${BaseUrl}/consumptionMsgs`,
        hotelManagers: `${BaseUrl}/hotelManagers`,
        ticketss: `${BaseUrl}/ticketss`,
        touristConsults: `${BaseUrl}/touristConsults`,
        touristAttractions: `${BaseUrl}/touristAttractions`,
        touristGuides: `${BaseUrl}/touristGuides`,
        ruralTourisms: `${BaseUrl}/ruralTourisms`,
        scienceAndTechnologyCultureCenters: `${BaseUrl}/scienceAndTechnologyCultureCenters`,
        roomInfos: `${BaseUrl}/roomInfos`,
        pathPoints: `${BaseUrl}/pathPoints`,
        monitorManagers: `${BaseUrl}/monitorManagers`
      },
      culturalRelicRents: `${BaseUrl}/culturalRelicRents`,
      electronicTravel: `${appUrl}/electronicTravels`,
      trip: `${appUrl}/trips`,
      travelBus: `${appUrl}/appTravelBus`,
      localPoint: `${appUrl}/localPoints`,
      banner: `${appUrl}/banners`
    }
  }

  getters = {
    AllUrl: state => { return state.AllUrl }
  }
}
