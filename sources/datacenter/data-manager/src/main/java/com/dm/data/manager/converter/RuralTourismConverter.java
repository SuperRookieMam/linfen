package com.dm.data.manager.converter;

import com.dm.data.manager.dto.RuralTourismDto;
import com.dm.data.manager.entity.ParkingLot;
import com.dm.data.manager.entity.RuralTourism;
import com.dm.data.manager.entity.TouristToilet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class RuralTourismConverter extends AbstractBaseConverter<RuralTourism, RuralTourismDto> {
    @Autowired
    private ImageConverter imageConverter;
    @Autowired
    private VideoConverter videoConverter;
    @Autowired
    private AudioConverter audioConverter;
    @Autowired
    private ParkingLotConverter parkingLotConverter;

    @Autowired
    private VirtualMaterialConverter virtualMaterialConverter;
    @Autowired
    private TouristToiletConverter touristToiletConverter;

    @Override
    protected RuralTourismDto toDtoActual(RuralTourism model) {
        RuralTourismDto dto = super.toDtoActual(model);
        dto.setNo(model.getNo());
        dto.setRegionCode(model.getRegionCode());
        dto.setId(model.getId());
        dto.setChineseFullName(model.getChineseFullName());
        dto.setChineseShortName(model.getChineseShortName());
        dto.setPinyinName(model.getPinyinName());
        dto.setEnglishName(model.getEnglishName());
        dto.setParkingLots(parkingLotConverter.toDto(model.getParkingLots()));
        dto.setLongitude(model.getLongitude());
        dto.setLatitude(model.getLatitude());
        dto.setAddress(model.getAddress());
        dto.setType(model.getType());
        dto.setLevel(model.getLevel());
        dto.setTouristToilets(touristToiletConverter.toDto(model.getTouristToilets()));
        dto.setLogo(model.getLogo());
        dto.setKeywords(model.getKeywords());
        dto.setLabel(model.getLabel());
        dto.setIntroduction(model.getIntroduction());
        dto.setTourismFeatures(model.getTourismFeatures());
        dto.setRegistrationDate(model.getRegistrationDate());
        dto.setIndustrialAndCommercialRegistrationName(model.getIndustrialAndCommercialRegistrationName());
        dto.setBusinessLicenseNumber(model.getBusinessLicenseNumber());
        dto.setCompanyOfIndustryAndCommerce(model.getCompanyOfIndustryAndCommerce());
        dto.setOrganizationCode(model.getOrganizationCode());
        dto.setUnifiedSocialCreditCode(model.getUnifiedSocialCreditCode());
        dto.setOperationsManagers(model.getOperationsManagers());
        dto.setEmployeesCount(model.getEmployeesCount());
        dto.setEmergencyContact(model.getEmergencyContact());
        dto.setEmergencyContactPhoneNumber(model.getEmergencyContactPhoneNumber());
        dto.setModeOfTransport(model.getModeOfTransport());
        dto.setTrafficDescription(model.getTrafficDescription());
        dto.setWeibo(model.getWeibo());
        dto.setTencentWeibo(model.getTencentWeibo());
        dto.setWeChatPublicAccount(model.getWeChatPublicAccount());
        dto.setWeChatPublicAccountQrCode(model.getWeChatPublicAccountQrCode());
        dto.setOfficialWebsite(model.getOfficialWebsite());
        dto.setMicroSite(model.getMicroSite());
        dto.setAndroidAppDownloadUrl(model.getAndroidAppDownloadUrl());
        dto.setIosAppDownloadUrl(model.getIosAppDownloadUrl());
        dto.setConsultingTheTelephone(model.getConsultingTheTelephone());
        dto.setComplaints(model.getComplaints());
        dto.setOnlineComplaintsAddress(model.getOnlineComplaintsAddress());
        dto.setFax(model.getFax());
        dto.setEmail(model.getEmail());
        dto.setRecommendedPlaySeason(model.getRecommendedPlaySeason());
        dto.setSurroundingInformation(model.getSurroundingInformation());
        dto.setAtTheSameTimeRepastNumber(model.getAtTheSameTimeRepastNumber());
        dto.setBusinessHours(model.getBusinessHours());
        dto.setABusinessAreaOf(model.getABusinessAreaOf());
        dto.setPerCapitaConsumption(model.getPerCapitaConsumption());
        dto.setSupportOfCard(model.getSupportOfCard());
        dto.setMethodOfPayment(model.getMethodOfPayment());
        dto.setChineseFullName(model.getChineseFullName());
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
        dto.setChineseFullName(model.getChineseFullName());
        return dto;
    }

    @Override
    public RuralTourism copyProperties(RuralTourism model, RuralTourismDto dto) {
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
        model.setType(dto.getType());
        model.setLevel(dto.getLevel());
        model.setLogo(dto.getLogo());
        model.setKeywords(dto.getKeywords());
        model.setLabel(dto.getLabel());
        model.setIntroduction(dto.getIntroduction());
        model.setTourismFeatures(dto.getTourismFeatures());
        model.setRegistrationDate(dto.getRegistrationDate());
        model.setIndustrialAndCommercialRegistrationName(dto.getIndustrialAndCommercialRegistrationName());
        model.setBusinessLicenseNumber(dto.getBusinessLicenseNumber());
        model.setCompanyOfIndustryAndCommerce(dto.getCompanyOfIndustryAndCommerce());
        model.setOrganizationCode(dto.getOrganizationCode());
        model.setUnifiedSocialCreditCode(dto.getUnifiedSocialCreditCode());
        model.setOperationsManagers(dto.getOperationsManagers());
        model.setEmployeesCount(dto.getEmployeesCount());
        model.setEmergencyContact(dto.getEmergencyContact());
        model.setEmergencyContactPhoneNumber(dto.getEmergencyContactPhoneNumber());
        model.setModeOfTransport(dto.getModeOfTransport());
        model.setTrafficDescription(dto.getTrafficDescription());
        model.setWeibo(dto.getWeibo());
        model.setTencentWeibo(dto.getTencentWeibo());
        model.setWeChatPublicAccount(dto.getWeChatPublicAccount());
        model.setWeChatPublicAccountQrCode(dto.getWeChatPublicAccountQrCode());
        model.setOfficialWebsite(dto.getOfficialWebsite());
        model.setMicroSite(dto.getMicroSite());
        model.setAndroidAppDownloadUrl(dto.getAndroidAppDownloadUrl());
        model.setIosAppDownloadUrl(dto.getIosAppDownloadUrl());
        model.setConsultingTheTelephone(dto.getConsultingTheTelephone());
        model.setComplaints(dto.getComplaints());
        model.setOnlineComplaintsAddress(dto.getOnlineComplaintsAddress());
        model.setFax(dto.getFax());
        model.setEmail(dto.getEmail());
        model.setRecommendedPlaySeason(dto.getRecommendedPlaySeason());
        model.setSurroundingInformation(dto.getSurroundingInformation());
        model.setAtTheSameTimeRepastNumber(dto.getAtTheSameTimeRepastNumber());
        model.setBusinessHours(dto.getBusinessHours());
        model.setABusinessAreaOf(dto.getABusinessAreaOf());
        model.setPerCapitaConsumption(dto.getPerCapitaConsumption());
        model.setSupportOfCard(dto.getSupportOfCard());
        model.setMethodOfPayment(dto.getMethodOfPayment());
        model.setChineseFullName(dto.getChineseFullName());
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
        model.setChineseFullName(dto.getChineseFullName());
        return model;
    }

    @Override
    protected RuralTourismDto getDto() {
        return new RuralTourismDto();
    }
}
