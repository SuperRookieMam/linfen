package com.dm.data.manager.converter;

import com.dm.data.manager.dto.TouristAttractionsDto;
import com.dm.data.manager.entity.ParkingLot;
import com.dm.data.manager.entity.TouristAttractions;
import com.dm.data.manager.entity.TouristGuide;
import com.dm.data.manager.entity.TouristToilet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class TouristAttractionsConverter extends AbstractBaseConverter<TouristAttractions, TouristAttractionsDto> {
    @Autowired
    private ImageConverter imageConverter;
    @Autowired
    private VideoConverter videoConverter;
    @Autowired
    private AudioConverter audioConverter;
    @Autowired
    private TouristGuideConverter touristGuideConverter;
    @Autowired
    private TouristToiletConverter touristToiletConverter;
    @Autowired
    private VirtualMaterialConverter virtualMaterialConverter;
    @Autowired
    private ParkingLotConverter parkingLotConverter;

    @Override
    protected TouristAttractionsDto toDtoActual(TouristAttractions model) {
        TouristAttractionsDto dto = super.toDtoActual(model);
        dto.setNo(model.getNo());
        dto.setRegionCode(model.getRegionCode());
        dto.setId(model.getId());
        dto.setChineseFullName(model.getChineseFullName());
        dto.setChineseShortName(model.getChineseShortName());
        dto.setChineseNicknames(model.getChineseNicknames());
        dto.setPinyinName(model.getPinyinName());
        dto.setEnglishName(model.getEnglishName());
        dto.setLongitude(model.getLongitude());
        dto.setLatitude(model.getLatitude());
        dto.setAddress(model.getAddress());
        dto.setTitleOfHonor(model.getTitleOfHonor());
        dto.setAreaLevel(model.getAreaLevel());
        dto.setRatingTime(model.getRatingTime());
        dto.setScenicSpotType(model.getScenicSpotType());
        dto.setScenicManagement(model.getScenicManagement());
        dto.setLogo(model.getLogo());
        dto.setKeywords(model.getKeywords());
        dto.setLabel(model.getLabel());
        dto.setIntroduction(model.getIntroduction());
        dto.setCharacteristic(model.getCharacteristic());
        dto.setType(model.getType());
        dto.setStartStopTime(model.getStartStopTime());
        dto.setPrice(model.getPrice());
        dto.setInstructions(model.getInstructions());
        dto.setBuyingPatterns(model.getBuyingPatterns());
        dto.setModeOfTransport(model.getModeOfTransport());
        dto.setTrafficDescription(model.getTrafficDescription());
        dto.setWeibo(model.getWeibo());
        dto.setTencentWeibo(model.getTencentWeibo());
        dto.setWeChatPublicAccount(model.getWeChatPublicAccount());
        dto.setWeChatPublicAccountQrCode(model.getWeChatPublicAccountQrCode());
        dto.setOfficialWebSite(model.getOfficialWebSite());
        dto.setMicroSite(model.getMicroSite());
        dto.setAndroidAppDownloadUrl(model.getAndroidAppDownloadUrl());
        dto.setIosAppDownloadUrl(model.getIosAppDownloadUrl());
        dto.setComplaints(model.getComplaints());
        dto.setOnlineComplaintsAddress(model.getOnlineComplaintsAddress());
        dto.setRescueTheTelephone(model.getRescueTheTelephone());
        dto.setReservationPhone(model.getReservationPhone());
        dto.setCustomerServiceTelephone(model.getCustomerServiceTelephone());
        dto.setFax(model.getFax());
        dto.setEmail(model.getEmail());
        dto.setOpenTime(model.getOpenTime());
        dto.setLargestCapacity(model.getLargestCapacity());
        dto.setTheVisitingTime(model.getTheVisitingTime());
        dto.setTotalParkingSpaces(model.getTotalParkingSpaces());
        dto.setFinancialNetwork(model.getFinancialNetwork());
        dto.setSupportOfCard(model.getSupportOfCard());
        dto.setMethodOfPayment(model.getMethodOfPayment());
        dto.setRecommendedPlaySeason(model.getRecommendedPlaySeason());
        dto.setPerCapitaConsumption(model.getPerCapitaConsumption());
        dto.setTourismProject(model.getTourismProject());
        dto.setRecommendedTravel(model.getRecommendedTravel());
        dto.setTravelTips(model.getTravelTips());
        dto.setSuitsTheCrowd(model.getSuitsTheCrowd());
        dto.setSurroundingInformation(model.getSurroundingInformation());
        dto.setTourismActivities(model.getTourismActivities());
        dto.setChineseFullName(model.getChineseFullName());
        dto.setChineseShortName(model.getChineseShortName());
        dto.setPinyinName(model.getPinyinName());
        dto.setEnglishName(model.getEnglishName());
        dto.setAddress(model.getAddress());
        dto.setWorkingTime(model.getWorkingTime());
        dto.setConsultingTheTelephone(model.getConsultingTheTelephone());
        dto.setIntroduction(model.getIntroduction());
        dto.setTheServiceContent(model.getTheServiceContent());
        dto.setFacilities(model.getFacilities());
        dto.setTouristGuides(touristGuideConverter.toDto(model.getTouristGuides()));
        dto.setTourismToilet(touristToiletConverter.toDto(model.getTourismToilet()));
        dto.setParkingLots(parkingLotConverter.toDto(model.getParkingLots()));
        dto.setTheScenicSpotDiagram(model.getTheScenicSpotDiagram());
        dto.setTheScenicSpotTourFigure(model.getTheScenicSpotTourFigure());
        dto.setImages(imageConverter.toDto(model.getImages()));
        dto.setVideos(videoConverter.toDto(model.getVideos()));
        dto.setVirtualMaterials(virtualMaterialConverter.toDto(model.getVirtualMaterials()));
        dto.setAudios(audioConverter.toDto(model.getAudios()));
        dto.setHomePic(model.getHomePic());
        dto.setHomeType(model.getHomeType());
        dto.setShow(model.getShow());
        dto.setComfortLeve(model.getComfortLeve());
        dto.setRecommendation(model.getRecommendation());
        dto.setOpeningDay(model.getOpeningDay());
        dto.setContactMobile(model.getContactMobile());
        dto.setContactMan(model.getContactMan());
        dto.setHotIndex(model.getHotIndex());
        /*
         * dto.setTheGallery(model.getTheGallery());
         * dto.setVideoLibrary(model.getVideoLibrary());
         * dto.setAudioLibrary(model.getAudioLibrary());
         * dto.setVirtualMaterialLibrary(model.getVirtualMaterialLibrary());
         */
        dto.setAttractionsBasicInformation(model.getAttractionsBasicInformation());
        return dto;
    }

    @Override
    public TouristAttractions copyProperties(TouristAttractions model, TouristAttractionsDto dto) {
        model = super.copyProperties(model, dto);
        model.setNo(dto.getNo());
        model.setRegionCode(dto.getRegionCode());

        model.setChineseFullName(dto.getChineseFullName());
        model.setChineseShortName(dto.getChineseShortName());
        model.setChineseNicknames(dto.getChineseNicknames());
        model.setPinyinName(dto.getPinyinName());
        model.setEnglishName(dto.getEnglishName());
        // model.setArea(dto.getArea());
        model.setLongitude(dto.getLongitude());
        model.setLatitude(dto.getLatitude());
        model.setAddress(dto.getAddress());
        model.setTitleOfHonor(dto.getTitleOfHonor());
        model.setAreaLevel(dto.getAreaLevel());
        model.setRatingTime(dto.getRatingTime());
        model.setScenicSpotType(dto.getScenicSpotType());
        model.setScenicManagement(dto.getScenicManagement());
        model.setLogo(dto.getLogo());
        model.setKeywords(dto.getKeywords());
        model.setLabel(dto.getLabel());
        model.setIntroduction(dto.getIntroduction());
        model.setCharacteristic(dto.getCharacteristic());
        model.setType(dto.getType());
        model.setStartStopTime(dto.getStartStopTime());
        model.setPrice(dto.getPrice());
        model.setInstructions(dto.getInstructions());
        model.setBuyingPatterns(dto.getBuyingPatterns());
        model.setModeOfTransport(dto.getModeOfTransport());
        model.setTrafficDescription(dto.getTrafficDescription());
        model.setWeibo(dto.getWeibo());
        model.setTencentWeibo(dto.getTencentWeibo());
        model.setWeChatPublicAccount(dto.getWeChatPublicAccount());
        model.setWeChatPublicAccountQrCode(dto.getWeChatPublicAccountQrCode());
        model.setOfficialWebSite(dto.getOfficialWebSite());
        model.setMicroSite(dto.getMicroSite());
        model.setAndroidAppDownloadUrl(dto.getAndroidAppDownloadUrl());
        model.setIosAppDownloadUrl(dto.getIosAppDownloadUrl());
        model.setComplaints(dto.getComplaints());
        model.setOnlineComplaintsAddress(dto.getOnlineComplaintsAddress());
        model.setRescueTheTelephone(dto.getRescueTheTelephone());
        model.setReservationPhone(dto.getReservationPhone());
        model.setCustomerServiceTelephone(dto.getCustomerServiceTelephone());
        model.setFax(dto.getFax());
        model.setEmail(dto.getEmail());
        model.setOpenTime(dto.getOpenTime());
        model.setLargestCapacity(dto.getLargestCapacity());
        model.setTheVisitingTime(dto.getTheVisitingTime());
        model.setTotalParkingSpaces(dto.getTotalParkingSpaces());
        model.setFinancialNetwork(dto.getFinancialNetwork());
        model.setSupportOfCard(dto.getSupportOfCard());
        model.setMethodOfPayment(dto.getMethodOfPayment());
        model.setRecommendedPlaySeason(dto.getRecommendedPlaySeason());
        model.setPerCapitaConsumption(dto.getPerCapitaConsumption());
        model.setTourismProject(dto.getTourismProject());
        model.setRecommendedTravel(dto.getRecommendedTravel());
        model.setTravelTips(dto.getTravelTips());
        model.setSuitsTheCrowd(dto.getSuitsTheCrowd());
        model.setSurroundingInformation(dto.getSurroundingInformation());
        model.setTourismActivities(dto.getTourismActivities());
        model.setChineseFullName(dto.getChineseFullName());
        model.setChineseShortName(dto.getChineseShortName());
        model.setPinyinName(dto.getPinyinName());
        model.setEnglishName(dto.getEnglishName());
        model.setAddress(dto.getAddress());
        model.setWorkingTime(dto.getWorkingTime());
        model.setConsultingTheTelephone(dto.getConsultingTheTelephone());
        model.setIntroduction(dto.getIntroduction());
        model.setTheServiceContent(dto.getTheServiceContent());
        model.setFacilities(dto.getFacilities());
        model.setTheScenicSpotDiagram(dto.getTheScenicSpotDiagram());
        model.setTheScenicSpotTourFigure(dto.getTheScenicSpotTourFigure());
        model.setTouristGuides(dto.getTouristGuides().stream().map(ele -> {
            return touristGuideConverter.copyProperties(new TouristGuide(), ele);
        }).collect(Collectors.toList()));
        model.setTourismToilet(dto.getTourismToilet().stream().map(ele -> {
            return touristToiletConverter.copyProperties(new TouristToilet(), ele);
        }).collect(Collectors.toList()));
        model.setParkingLots(dto.getParkingLots().stream().map(ele -> {
            return parkingLotConverter.copyProperties(new ParkingLot(), ele);
        }).collect(Collectors.toList()));
        model.setHomePic(dto.getHomePic());
        model.setHomeType(dto.getHomeType());
        model.setShow(dto.getShow());
        model.setComfortLeve(dto.getComfortLeve());
        model.setRecommendation(dto.getRecommendation());
        model.setOpeningDay(dto.getOpeningDay());
        model.setContactMobile(dto.getContactMobile());
        model.setContactMan(dto.getContactMan());
        model.setHotIndex(dto.getHotIndex());
        // model.setTouristGuides(dto.getTouristGuides().stream().map( ele -> { return
        // touristGuideConverter.copyProperties(new TouristGuide() ,ele);
        // }).collect(Collectors.toList()));
        /*
         * model.setTheParkingLot(dto.getTheParkingLot());
         * model.setTourismToilet(dto.getTourismToilet());
         * model.setTheScenicAreaTheNarrator(dto.getTheScenicAreaTheNarrator());
         * model.setTheGallery(dto.getTheGallery());
         * model.setVideoLibrary(dto.getVideoLibrary());
         * model.setAudioLibrary(dto.getAudioLibrary());
         * model.setVirtualMaterialLibrary(dto.getVirtualMaterialLibrary());
         */
        model.setAttractionsBasicInformation(dto.getAttractionsBasicInformation());
        return model;
    }

    @Override
    protected TouristAttractionsDto getDto() {
        return new TouristAttractionsDto();
    }
}
