package com.dm.data.manager.converter;

import com.dm.data.manager.dto.EntertainmentVenuesDto;
import com.dm.data.manager.entity.EntertainmentVenues;
import com.dm.data.manager.entity.ParkingLot;
import com.dm.data.manager.entity.TouristToilet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class EntertainmentVenuesConverter extends AbstractBaseConverter<EntertainmentVenues, EntertainmentVenuesDto> {
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
    protected EntertainmentVenuesDto toDtoActual(EntertainmentVenues model) {
        EntertainmentVenuesDto dto = super.toDtoActual(model);
        dto.setNo(model.getNo());

        dto.setRegionCode(model.getRegionCode());

        dto.setId(model.getId());
        dto.setChineseShortName(model.getChineseShortName());
        dto.setPinyinName(model.getPinyinName());
        dto.setEnglishName(model.getEnglishName());
        dto.setChineseFullName(model.getChineseFullName());
        // dto.setArea(model.getArea());
        dto.setLongitude(model.getLongitude());
        dto.setLatitude(model.getLatitude());
        dto.setAddress(model.getAddress());
        dto.setType(model.getType());
        dto.setCorporateLogo(model.getCorporateLogo());
        dto.setKeywords(model.getKeywords());
        dto.setHonoraryCertificate(model.getHonoraryCertificate());
        dto.setLabel(model.getLabel());
        dto.setIntroduction(model.getIntroduction());
        dto.setRegistrationDate(model.getRegistrationDate());
        dto.setIndustrialAndCommercialRegistrationName(model.getIndustrialAndCommercialRegistrationName());
        dto.setBusinessLicenseNumber(model.getBusinessLicenseNumber());
        dto.setCompanyOfIndustryAndCommerce(model.getCompanyOfIndustryAndCommerce());
        dto.setOrganizationCode(model.getOrganizationCode());
        dto.setUnifiedSocialCreditCode(model.getUnifiedSocialCreditCode());
        dto.setEmployeesCount(model.getEmployeesCount());
        dto.setLegalRepresentative(model.getLegalRepresentative());
        dto.setOperationsManagers(model.getOperationsManagers());
        dto.setEmergencyContact(model.getEmergencyContact());
        dto.setEmergencyContactPhoneNumber(model.getEmergencyContactPhoneNumber());
        dto.setChainOperationSituation(model.getChainOperationSituation());
        dto.setBrand(model.getBrand());
        dto.setManagementOfTheCompanyName(model.getManagementOfTheCompanyName());
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
        dto.setBusinessHours(model.getBusinessHours());
        dto.setDueToThePhone(model.getDueToThePhone());
        dto.setConsultingTheTelephone(model.getConsultingTheTelephone());
        dto.setComplaints(model.getComplaints());
        dto.setOnlineComplaintsAddress(model.getOnlineComplaintsAddress());
        dto.setFax(model.getFax());
        dto.setEmail(model.getEmail());
        dto.setPerCapitaConsumption(model.getPerCapitaConsumption());
        dto.setAParkingSpace(model.getAParkingSpace());
        dto.setSupportOfCard(model.getSupportOfCard());
        dto.setMethodOfPayment(model.getMethodOfPayment());
        dto.setSurroundingInformation(model.getSurroundingInformation());
        dto.setImages(imageConverter.toDto(model.getImages()));
        dto.setVideos(videoConverter.toDto(model.getVideos()));
        dto.setVirtualMaterials(virtualMaterialConverter.toDto(model.getVirtualMaterials()));
        dto.setAudios(audioConverter.toDto(model.getAudios()));
        dto.setTouristToilets(touristToiletConverter.toDto(model.getTouristToilets()));
        dto.setParkingLots(parkingLotConverter.toDto(model.getParkingLots()));
        /*
         * dto.setTheGallery(model.getTheGallery());
         * dto.setVideoLibrary(model.getVideoLibrary());
         * dto.setAudioLibrary(model.getAudioLibrary());
         * dto.setVirtualMaterialLibrary(model.getVirtualMaterialLibrary());
         */
        dto.setHotIndex(model.getHotIndex());
        return dto;
    }

    @Override
    public EntertainmentVenues copyProperties(EntertainmentVenues model, EntertainmentVenuesDto dto) {
        model = super.copyProperties(model, dto);
        model.setNo(dto.getNo());
        model.setRegionCode(dto.getRegionCode());

        model.setChineseShortName(dto.getChineseShortName());
        model.setPinyinName(dto.getPinyinName());
        model.setEnglishName(dto.getEnglishName());
        // model.setArea(dto.getArea());
        model.setLongitude(dto.getLongitude());
        model.setLatitude(dto.getLatitude());
        model.setAddress(dto.getAddress());
        model.setType(dto.getType());
        model.setChineseFullName(dto.getChineseFullName());
        model.setCorporateLogo(dto.getCorporateLogo());
        model.setKeywords(dto.getKeywords());
        model.setHonoraryCertificate(dto.getHonoraryCertificate());
        model.setLabel(dto.getLabel());
        model.setIntroduction(dto.getIntroduction());
        model.setRegistrationDate(dto.getRegistrationDate());
        model.setIndustrialAndCommercialRegistrationName(dto.getIndustrialAndCommercialRegistrationName());
        model.setBusinessLicenseNumber(dto.getBusinessLicenseNumber());
        model.setCompanyOfIndustryAndCommerce(dto.getCompanyOfIndustryAndCommerce());
        model.setOrganizationCode(dto.getOrganizationCode());
        model.setUnifiedSocialCreditCode(dto.getUnifiedSocialCreditCode());
        model.setEmployeesCount(dto.getEmployeesCount());
        model.setLegalRepresentative(dto.getLegalRepresentative());
        model.setOperationsManagers(dto.getOperationsManagers());
        model.setEmergencyContact(dto.getEmergencyContact());
        model.setEmergencyContactPhoneNumber(dto.getEmergencyContactPhoneNumber());
        model.setChainOperationSituation(dto.getChainOperationSituation());
        model.setBrand(dto.getBrand());
        model.setManagementOfTheCompanyName(dto.getManagementOfTheCompanyName());
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
        model.setBusinessHours(dto.getBusinessHours());
        model.setDueToThePhone(dto.getDueToThePhone());
        model.setConsultingTheTelephone(dto.getConsultingTheTelephone());
        model.setComplaints(dto.getComplaints());
        model.setOnlineComplaintsAddress(dto.getOnlineComplaintsAddress());
        model.setFax(dto.getFax());
        model.setEmail(dto.getEmail());
        model.setPerCapitaConsumption(dto.getPerCapitaConsumption());
        model.setAParkingSpace(dto.getAParkingSpace());
        model.setSupportOfCard(dto.getSupportOfCard());
        model.setMethodOfPayment(dto.getMethodOfPayment());
        model.setSurroundingInformation(dto.getSurroundingInformation());
        model.setParkingLots(dto.getParkingLots().stream().map(ele -> {
            return parkingLotConverter.copyProperties(new ParkingLot(), ele);
        }).collect(Collectors.toList()));
        model.setTouristToilets(dto.getTouristToilets().stream().map(ele -> {
            return touristToiletConverter.copyProperties(new TouristToilet(), ele);
        }).collect(Collectors.toList()));
        model.setHotIndex(dto.getHotIndex());
        /*
         * model.setTheGallery(dto.getTheGallery());
         * model.setVideoLibrary(dto.getVideoLibrary());
         * model.setAudioLibrary(dto.getAudioLibrary());
         * model.setVirtualMaterialLibrary(dto.getVirtualMaterialLibrary());
         */
        return model;
    }

    @Override
    protected EntertainmentVenuesDto getDto() {
        return new EntertainmentVenuesDto();
    }
}
