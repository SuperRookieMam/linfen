package com.dm.data.manager.converter;

import com.dm.data.manager.dto.ScienceAndTechnologyCultureCenterDto;
import com.dm.data.manager.entity.ParkingLot;
import com.dm.data.manager.entity.ScienceAndTechnologyCultureCenter;
import com.dm.data.manager.entity.TouristToilet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ScienceAndTechnologyCultureCenterConverter
        extends AbstractBaseConverter<ScienceAndTechnologyCultureCenter, ScienceAndTechnologyCultureCenterDto> {
    @Autowired
    private ImageConverter imageConverter;
    @Autowired
    private VideoConverter videoConverter;
    @Autowired
    private AudioConverter audioConverter;
    @Autowired
    private VirtualMaterialConverter virtualMaterialConverter;
    @Autowired
    private ParkingLotConverter parkingLotConverter;
    @Autowired
    private TouristToiletConverter touristToiletConverter;

    @Override
    protected ScienceAndTechnologyCultureCenterDto toDtoActual(ScienceAndTechnologyCultureCenter model) {
        ScienceAndTechnologyCultureCenterDto dto = super.toDtoActual(model);
        dto.setNo(model.getNo());
        dto.setRegionCode(model.getRegionCode());
        dto.setId(model.getId());
        dto.setChineseFullName(model.getChineseFullName());
        dto.setChineseShortName(model.getChineseShortName());
        dto.setPinyinName(model.getPinyinName());
        dto.setEnglishName(model.getEnglishName());
        // dto.setArea(model.getArea());
        dto.setLongitude(model.getLongitude());
        dto.setLatitude(model.getLatitude());
        dto.setAddress(model.getAddress());
        dto.setLogo(model.getLogo());
        dto.setKeywords(model.getKeywords());
        dto.setTitleOfHonor(model.getTitleOfHonor());
        dto.setTheConstructionTime(model.getTheConstructionTime());
        dto.setCoversOfArea(model.getCoversOfArea());
        dto.setVenueType(model.getVenueType());
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
        dto.setTravelTips(model.getTravelTips());
        dto.setSuitsTheCrowd(model.getSuitsTheCrowd());
        dto.setSurroundingInformation(model.getSurroundingInformation());
        dto.setTourismActivities(model.getTourismActivities());
        dto.setImages(imageConverter.toDto(model.getImages()));
        dto.setVideos(videoConverter.toDto(model.getVideos()));
        dto.setVirtualMaterials(virtualMaterialConverter.toDto(model.getVirtualMaterials()));
        dto.setAudios(audioConverter.toDto(model.getAudios()));
        /*
         * dto.setTheGallery(model.getTheGallery());
         * dto.setVideoLibrary(model.getVideoLibrary());
         * dto.setAudioLibrary(model.getAudioLibrary());
         * dto.setVirtualMaterialLibrary(model.getVirtualMaterialLibrary());
         */
        dto.setTouristToilets(touristToiletConverter.toDto(model.getTouristToilets()));
        dto.setParkingLots(parkingLotConverter.toDto(model.getParkingLots()));
        return dto;
    }

    @Override
    public ScienceAndTechnologyCultureCenter copyProperties(ScienceAndTechnologyCultureCenter model,
            ScienceAndTechnologyCultureCenterDto dto) {
        model = super.copyProperties(model, dto);
        model.setNo(dto.getNo());
        model.setRegionCode(dto.getRegionCode());

        model.setChineseFullName(dto.getChineseFullName());
        model.setChineseShortName(dto.getChineseShortName());
        model.setPinyinName(dto.getPinyinName());
        model.setEnglishName(dto.getEnglishName());
        // model.setArea(dto.getArea());
        model.setLongitude(dto.getLongitude());
        model.setLatitude(dto.getLatitude());
        model.setAddress(dto.getAddress());
        model.setLogo(dto.getLogo());
        model.setKeywords(dto.getKeywords());
        model.setTitleOfHonor(dto.getTitleOfHonor());
        model.setTheConstructionTime(dto.getTheConstructionTime());
        model.setCoversOfArea(dto.getCoversOfArea());
        model.setVenueType(dto.getVenueType());
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
        model.setTravelTips(dto.getTravelTips());
        model.setSuitsTheCrowd(dto.getSuitsTheCrowd());
        model.setSurroundingInformation(dto.getSurroundingInformation());
        model.setTourismActivities(dto.getTourismActivities());
        model.setTouristToilets(dto.getTouristToilets().stream().map(ele -> {
            return touristToiletConverter.copyProperties(new TouristToilet(), ele);
        }).collect(Collectors.toList()));
        model.setParkingLots(dto.getParkingLots().stream().map(ele -> {
            return parkingLotConverter.copyProperties(new ParkingLot(), ele);
        }).collect(Collectors.toList()));

        /*
         * model.setTheGallery(dto.getTheGallery());
         * model.setVideoLibrary(dto.getVideoLibrary());
         * model.setAudioLibrary(dto.getAudioLibrary());
         * model.setVirtualMaterialLibrary(dto.getVirtualMaterialLibrary());
         */
        /*
         * model.setTourismToilet(dto.getTourismToilet());
         * model.setTheParkingLot(dto.getTheParkingLot());
         */
        return model;
    }

    @Override
    protected ScienceAndTechnologyCultureCenterDto getDto() {
        return new ScienceAndTechnologyCultureCenterDto();
    }
}
