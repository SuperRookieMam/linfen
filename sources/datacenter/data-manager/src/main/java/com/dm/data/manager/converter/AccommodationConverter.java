package com.dm.data.manager.converter;

import com.dm.data.manager.dto.AccommodationDto;
import com.dm.data.manager.entity.Accommodation;
import com.dm.data.manager.entity.ParkingLot;
import com.dm.data.manager.entity.RoomInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class AccommodationConverter extends AbstractBaseConverter<Accommodation, AccommodationDto> {
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
    private RoomInfoConverter roomInfoConverter;

    @Override
    protected AccommodationDto toDtoActual(Accommodation model) {
        AccommodationDto dto = super.toDtoActual(model);
        dto.setNo(model.getNo());
        dto.setContactUser(model.getContactUser());
        dto.setId(model.getId());
        dto.setRegionCode(model.getRegionCode());
        dto.setChineseFullName(model.getChineseFullName());
        dto.setChineseShortName(model.getChineseShortName());
        dto.setPinyinName(model.getPinyinName());
        dto.setEnglishName(model.getEnglishName());
        dto.setLongitude(model.getLongitude());
        dto.setLatitude(model.getLatitude());
        dto.setAddress(model.getAddress());
        dto.setType(model.getType());
        dto.setLevel(model.getLevel());
        dto.setProvideCuisines(model.getProvideCuisines());
        dto.setCorporateLogo(model.getCorporateLogo());
        dto.setKeywords(model.getKeywords());
        dto.setLabel(model.getLabel());
        dto.setIntroduction(model.getIntroduction());
        dto.setTheRoomType(model.getTheRoomType());
        dto.setTheRoomNumber(model.getTheRoomNumber());
        dto.setCanBookARoom(model.getCanBookARoom());
        dto.setTheNormalPrice(model.getTheNormalPrice());
        dto.setHolidayPrices(model.getHolidayPrices());
        dto.setExtraBedPrice(model.getExtraBedPrice());
        dto.setServicesDescribed(model.getServicesDescribed());
        dto.setFoodAndBeverageShow(model.getFoodAndBeverageShow());
        dto.setSetUpTheDate(model.getSetUpTheDate());
        dto.setIndustrialAndCommercialRegistrationName(model.getIndustrialAndCommercialRegistrationName());
        dto.setBusinessLicenseNumber(model.getBusinessLicenseNumber());
        dto.setOrganizationCode(model.getOrganizationCode());
        dto.setUnifiedSocialCreditCode(model.getUnifiedSocialCreditCode());
        dto.setLegalRepresentative(model.getLegalRepresentative());
        dto.setOperationsManagers(model.getOperationsManagers());
        dto.setChainOperationSituation(model.getChainOperationSituation());
        dto.setSubordinateToTheIndustry(model.getSubordinateToTheIndustry());
        dto.setManagementGroup(model.getManagementGroup());
        dto.setModeOfTransport(model.getModeOfTransport());
        dto.setTrafficDescription(model.getTrafficDescription());
        dto.setWeibo(model.getWeibo());
        dto.setTencentWeibo(model.getTencentWeibo());
        dto.setWeChatPublicAccount(model.getWeChatPublicAccount());
        dto.setWeChatPublicAccountQrCode(model.getWeChatPublicAccountQrCode());
        dto.setTheWebsiteAddress(model.getTheWebsiteAddress());
        dto.setMicroSite(model.getMicroSite());
        dto.setAndroidAppDownloadUrl(model.getAndroidAppDownloadUrl());
        dto.setIosAppDownloadUrl(model.getIosAppDownloadUrl());
        dto.setTheOpeningTime(model.getTheOpeningTime());
        dto.setTheLastTimeToDecorate(model.getTheLastTimeToDecorate());
        dto.setTheTotalNumberOfRooms(model.getTheTotalNumberOfRooms());
        dto.setTotalBeds(model.getTotalBeds());
        dto.setComplaints(model.getComplaints());
        dto.setOnlineComplaintsAddress(model.getOnlineComplaintsAddress());
        dto.setConsultingTheTelephone(model.getConsultingTheTelephone());
        dto.setFax(model.getFax());
        dto.setEmail(model.getEmail());
        dto.setSupportOfCard(model.getSupportOfCard());
        dto.setMethodOfPayment(model.getMethodOfPayment());
        dto.setSlogan(model.getSlogan());
        dto.setSurroundingInformation(model.getSurroundingInformation());
        dto.setMeetingFacilitiesAndServices(model.getMeetingFacilitiesAndServices());
        dto.setCateringFacilitiesAndServices(model.getCateringFacilitiesAndServices());
        dto.setEntertainmentFacilitiesAndServices(model.getEntertainmentFacilitiesAndServices());
        dto.setBusinessFacilitiesAndServices(model.getBusinessFacilitiesAndServices());
        dto.setScored(model.getScored());
        dto.setMinPrice(model.getMinPrice());
        dto.setParkingLots(parkingLotConverter.toDto(model.getParkingLots()));
        dto.setImages(imageConverter.toDto(model.getImages()));
        dto.setVideos(videoConverter.toDto(model.getVideos()));
        dto.setVirtualMaterials(virtualMaterialConverter.toDto(model.getVirtualMaterials()));
        dto.setAudios(audioConverter.toDto(model.getAudios()));
        dto.setRoomInfos(roomInfoConverter.toDto(model.getRoomInfos()));
        dto.setHotIndex(model.getHotIndex());
        return dto;
    }

    @Override
    public Accommodation copyProperties(Accommodation model, AccommodationDto dto) {
        model = super.copyProperties(model, dto);
        model.setNo(dto.getNo());
        model.setRegionCode(dto.getRegionCode());
        model.setChineseFullName(dto.getChineseFullName());
        model.setChineseShortName(dto.getChineseShortName());
        model.setPinyinName(dto.getPinyinName());
        model.setEnglishName(dto.getEnglishName());
        model.setLongitude(dto.getLongitude());
        model.setLatitude(dto.getLatitude());
        model.setAddress(dto.getAddress());
        model.setType(dto.getType());
        model.setLevel(dto.getLevel());
        model.setProvideCuisines(dto.getProvideCuisines());
        model.setCorporateLogo(dto.getCorporateLogo());
        model.setKeywords(dto.getKeywords());
        model.setLabel(dto.getLabel());
        model.setIntroduction(dto.getIntroduction());
        model.setTheRoomType(dto.getTheRoomType());
        model.setTheRoomNumber(dto.getTheRoomNumber());
        model.setCanBookARoom(dto.getCanBookARoom());
        model.setTheNormalPrice(dto.getTheNormalPrice());
        model.setContactUser(dto.getContactUser());
        model.setHolidayPrices(dto.getHolidayPrices());
        model.setExtraBedPrice(dto.getExtraBedPrice());
        model.setServicesDescribed(dto.getServicesDescribed());
        model.setFoodAndBeverageShow(dto.getFoodAndBeverageShow());
        model.setSetUpTheDate(dto.getSetUpTheDate());
        model.setIndustrialAndCommercialRegistrationName(dto.getIndustrialAndCommercialRegistrationName());
        model.setBusinessLicenseNumber(dto.getBusinessLicenseNumber());
        model.setOrganizationCode(dto.getOrganizationCode());
        model.setUnifiedSocialCreditCode(dto.getUnifiedSocialCreditCode());
        model.setLegalRepresentative(dto.getLegalRepresentative());
        model.setOperationsManagers(dto.getOperationsManagers());
        model.setChainOperationSituation(dto.getChainOperationSituation());
        model.setSubordinateToTheIndustry(dto.getSubordinateToTheIndustry());
        model.setManagementGroup(dto.getManagementGroup());
        model.setModeOfTransport(dto.getModeOfTransport());
        model.setTrafficDescription(dto.getTrafficDescription());
        model.setWeibo(dto.getWeibo());
        model.setTencentWeibo(dto.getTencentWeibo());
        model.setWeChatPublicAccount(dto.getWeChatPublicAccount());
        model.setWeChatPublicAccountQrCode(dto.getWeChatPublicAccountQrCode());
        model.setTheWebsiteAddress(dto.getTheWebsiteAddress());
        model.setMicroSite(dto.getMicroSite());
        model.setAndroidAppDownloadUrl(dto.getAndroidAppDownloadUrl());
        model.setIosAppDownloadUrl(dto.getIosAppDownloadUrl());
        model.setTheOpeningTime(dto.getTheOpeningTime());
        model.setTheLastTimeToDecorate(dto.getTheLastTimeToDecorate());
        model.setTheTotalNumberOfRooms(dto.getTheTotalNumberOfRooms());
        model.setTotalBeds(dto.getTotalBeds());
        model.setComplaints(dto.getComplaints());
        model.setOnlineComplaintsAddress(dto.getOnlineComplaintsAddress());
        model.setConsultingTheTelephone(dto.getConsultingTheTelephone());
        model.setFax(dto.getFax());
        model.setEmail(dto.getEmail());
        model.setSupportOfCard(dto.getSupportOfCard());
        model.setMethodOfPayment(dto.getMethodOfPayment());
        model.setSlogan(dto.getSlogan());
        model.setScored(dto.getScored());
        model.setMinPrice(dto.getMinPrice());
        model.setSurroundingInformation(dto.getSurroundingInformation());
        model.setMeetingFacilitiesAndServices(dto.getMeetingFacilitiesAndServices());
        model.setCateringFacilitiesAndServices(dto.getCateringFacilitiesAndServices());
        model.setEntertainmentFacilitiesAndServices(dto.getEntertainmentFacilitiesAndServices());
        model.setBusinessFacilitiesAndServices(dto.getBusinessFacilitiesAndServices());
        model.setParkingLots(dto.getParkingLots().stream().map(ele -> {
            return parkingLotConverter.copyProperties(new ParkingLot(), ele);
        }).collect(Collectors.toList()));
        model.setRoomInfos(dto.getRoomInfos().stream().map(ele -> {
            return roomInfoConverter.copyProperties(new RoomInfo(), ele);
        }).collect(Collectors.toList()));
        model.setHotIndex(dto.getHotIndex());
        return model;
    }

    @Override
    protected AccommodationDto getDto() {
        return new AccommodationDto();
    }

}
