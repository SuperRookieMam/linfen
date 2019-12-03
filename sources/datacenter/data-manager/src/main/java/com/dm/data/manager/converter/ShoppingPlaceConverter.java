package com.dm.data.manager.converter;

import com.dm.data.manager.dto.ShoppingPlaceDto;
import com.dm.data.manager.entity.ShoppingPlace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ShoppingPlaceConverter extends AbstractBaseConverter<ShoppingPlace, ShoppingPlaceDto> {
    @Autowired
    private ImageConverter imageConverter;
    @Autowired
    private VideoConverter videoConverter;
    @Autowired
    private AudioConverter audioConverter;
    @Autowired
    private VirtualMaterialConverter virtualMaterialConverter;

    @Override
    protected ShoppingPlaceDto toDtoActual(ShoppingPlace model) {
        ShoppingPlaceDto dto = super.toDtoActual(model);
        dto.setNo(model.getNo());
        dto.setRegionCode(model.getRegionCode());
        dto.setId(model.getId());
        dto.setChineseFullName(model.getChineseFullName());
        dto.setChineseShortName(model.getChineseShortName());
        dto.setPinyinName(model.getPinyinName());
        dto.setEnglishName(model.getEnglishName());
        dto.setLongitude(model.getLongitude());
        dto.setLatitude(model.getLatitude());
        dto.setAddress(model.getAddress());
        dto.setType(model.getType());
        dto.setCorporateLogo(model.getCorporateLogo());
        dto.setKeywords(model.getKeywords());
        dto.setLabel(model.getLabel());
        dto.setHonoraryCertificate(model.getHonoraryCertificate());
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
        dto.setComplaints(model.getComplaints());
        dto.setOnlineComplaintsAddress(model.getOnlineComplaintsAddress());
        dto.setConsultingTheTelephone(model.getConsultingTheTelephone());
        dto.setFax(model.getFax());
        dto.setEmail(model.getEmail());
        dto.setBusinessHours(model.getBusinessHours());
        dto.setABusinessAreaOf(model.getABusinessAreaOf());
        dto.setTheParkingLot(model.getTheParkingLot());
        dto.setAParkingSpace(model.getAParkingSpace());
        dto.setSupportOfCard(model.getSupportOfCard());
        dto.setMethodOfPayment(model.getMethodOfPayment());
        dto.setSurroundingInformation(model.getSurroundingInformation());
        dto.setSpecialGoods(model.getSpecialGoods());
        dto.setHotIndex(model.getHotIndex());
        /*
         * dto.setTheGallery(model.getTheGallery());
         * dto.setVideoLibrary(model.getVideoLibrary());
         * dto.setAudioLibrary(model.getAudioLibrary());
         * dto.setVirtualMaterialLibrary(model.getVirtualMaterialLibrary());
         */
        dto.setImages(imageConverter.toDto(model.getImages()));
        dto.setVideos(videoConverter.toDto(model.getVideos()));
        dto.setVirtualMaterials(virtualMaterialConverter.toDto(model.getVirtualMaterials()));
        dto.setAudios(audioConverter.toDto(model.getAudios()));
        return dto;
    }

    @Override
    public ShoppingPlace copyProperties(ShoppingPlace model, ShoppingPlaceDto dto) {
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
        model.setCorporateLogo(dto.getCorporateLogo());
        model.setKeywords(dto.getKeywords());
        model.setLabel(dto.getLabel());
        model.setHonoraryCertificate(dto.getHonoraryCertificate());
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
        model.setComplaints(dto.getComplaints());
        model.setOnlineComplaintsAddress(dto.getOnlineComplaintsAddress());
        model.setConsultingTheTelephone(dto.getConsultingTheTelephone());
        model.setFax(dto.getFax());
        model.setEmail(dto.getEmail());
        model.setBusinessHours(dto.getBusinessHours());
        model.setABusinessAreaOf(dto.getABusinessAreaOf());
        model.setTheParkingLot(dto.getTheParkingLot());
        model.setAParkingSpace(dto.getAParkingSpace());
        model.setSupportOfCard(dto.getSupportOfCard());
        model.setMethodOfPayment(dto.getMethodOfPayment());
        model.setSurroundingInformation(dto.getSurroundingInformation());
        model.setSpecialGoods(dto.getSpecialGoods());
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
    protected ShoppingPlaceDto getDto() {
        return new ShoppingPlaceDto();
    }
}
