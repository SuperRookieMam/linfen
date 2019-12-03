package com.dm.data.manager.converter;

import com.dm.data.manager.dto.TravelAgencyDto;
import com.dm.data.manager.entity.TravelAgentcy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TravelAgencyConverter extends AbstractBaseConverter<TravelAgentcy, TravelAgencyDto> {
    @Autowired
    private ImageConverter imageConverter;
    @Autowired
    private VideoConverter videoConverter;
    @Autowired
    private AudioConverter audioConverter;
    @Autowired
    private VirtualMaterialConverter virtualMaterialConverter;

    @Override
    protected TravelAgencyDto toDtoActual(TravelAgentcy model) {
        TravelAgencyDto dto = super.toDtoActual(model);
        dto.setNo(model.getNo());
        dto.setScore(model.getScore());
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
        dto.setLevel(model.getLevel());
        dto.setBusiness(model.getBusiness());
        dto.setServiceLanguage(model.getServiceLanguage());
        dto.setTitleOfHonor(model.getTitleOfHonor());
        dto.setKeywords(model.getKeywords());
        dto.setLabel(model.getLabel());
        dto.setTheTravelAgencyLogo(model.getTheTravelAgencyLogo());
        dto.setIntroduction(model.getIntroduction());
        dto.setSetUpTheDate(model.getSetUpTheDate());
        dto.setIndustrialAndCommercialRegistrationName(model.getIndustrialAndCommercialRegistrationName());
        dto.setBusinessLicenseNumber(model.getBusinessLicenseNumber());
        dto.setOrganizationCode(model.getOrganizationCode());
        dto.setUnifiedSocialCreditCode(model.getUnifiedSocialCreditCode());
        dto.setLegalRepresentative(model.getLegalRepresentative());
        dto.setTheTravelContract(model.getTheTravelContract());
        dto.setDepositAmount(model.getDepositAmount());
        dto.setEmergencyContact(model.getEmergencyContact());
        dto.setEmergencyContactPhoneNumber(model.getEmergencyContactPhoneNumber());
        dto.setByTravelGroup(model.getByTravelGroup());
        dto.setTheBusinessScope(model.getTheBusinessScope());
        dto.setTheTravelAgencyBureauChief(model.getTheTravelAgencyBureauChief());
        dto.setTravelAgencyServiceOutlets(model.getTravelAgencyServiceOutlets());
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
        dto.setReservationPhone(model.getReservationPhone());
        dto.setCustomerServiceTelephone(model.getCustomerServiceTelephone());
        dto.setFax(model.getFax());
        dto.setEmail(model.getEmail());
        dto.setBusinessHours(model.getBusinessHours());
        dto.setSupportOfCard(model.getSupportOfCard());
        dto.setMethodOfPayment(model.getMethodOfPayment());
        dto.setGuidesPersonnelIntroduction(model.getGuidesPersonnelIntroduction());
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
        dto.setHotIndex(model.getHotIndex());
        return dto;
    }

    @Override
    public TravelAgentcy copyProperties(TravelAgentcy model, TravelAgencyDto dto) {
        model = super.copyProperties(model, dto);
        model.setNo(dto.getNo());
        model.setRegionCode(dto.getRegionCode());
        model.setScore(dto.getScore());
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
        model.setBusiness(dto.getBusiness());
        model.setServiceLanguage(dto.getServiceLanguage());
        model.setTitleOfHonor(dto.getTitleOfHonor());
        model.setKeywords(dto.getKeywords());
        model.setLabel(dto.getLabel());
        model.setTheTravelAgencyLogo(dto.getTheTravelAgencyLogo());
        model.setIntroduction(dto.getIntroduction());
        model.setSetUpTheDate(dto.getSetUpTheDate());
        model.setIndustrialAndCommercialRegistrationName(dto.getIndustrialAndCommercialRegistrationName());
        model.setBusinessLicenseNumber(dto.getBusinessLicenseNumber());
        model.setOrganizationCode(dto.getOrganizationCode());
        model.setUnifiedSocialCreditCode(dto.getUnifiedSocialCreditCode());
        model.setLegalRepresentative(dto.getLegalRepresentative());
        model.setTheTravelContract(dto.getTheTravelContract());
        model.setDepositAmount(dto.getDepositAmount());
        model.setEmergencyContact(dto.getEmergencyContact());
        model.setEmergencyContactPhoneNumber(dto.getEmergencyContactPhoneNumber());
        model.setByTravelGroup(dto.getByTravelGroup());
        model.setTheBusinessScope(dto.getTheBusinessScope());
        model.setTheTravelAgencyBureauChief(dto.getTheTravelAgencyBureauChief());
        model.setTravelAgencyServiceOutlets(dto.getTravelAgencyServiceOutlets());
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
        model.setReservationPhone(dto.getReservationPhone());
        model.setCustomerServiceTelephone(dto.getCustomerServiceTelephone());
        model.setFax(dto.getFax());
        model.setEmail(dto.getEmail());
        model.setBusinessHours(dto.getBusinessHours());
        model.setSupportOfCard(dto.getSupportOfCard());
        model.setMethodOfPayment(dto.getMethodOfPayment());
        model.setGuidesPersonnelIntroduction(dto.getGuidesPersonnelIntroduction());
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
    protected TravelAgencyDto getDto() {
        return new TravelAgencyDto();
    }
}
