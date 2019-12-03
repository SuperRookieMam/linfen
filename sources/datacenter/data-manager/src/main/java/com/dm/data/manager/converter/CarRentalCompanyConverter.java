package com.dm.data.manager.converter;

import com.dm.data.manager.dto.CarRentalCompanyDto;
import com.dm.data.manager.entity.Car;
import com.dm.data.manager.entity.CarRentalCompany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CarRentalCompanyConverter extends AbstractBaseConverter<CarRentalCompany, CarRentalCompanyDto> {

    @Autowired
    private ImageConverter imageConverter;
    @Autowired
    private VideoConverter videoConverter;
    @Autowired
    private AudioConverter audioConverter;
    @Autowired
    private VirtualMaterialConverter virtualMaterialConverter;
    @Autowired
    private CarConverter carConverter;

    @Override
    protected CarRentalCompanyDto toDtoActual(CarRentalCompany model) {
        CarRentalCompanyDto dto = super.toDtoActual(model);
        dto.setNo(model.getNo());
        dto.setCars(carConverter.toDto(model.getCars()));
        dto.setRegionCode(model.getRegionCode());

        dto.setId(model.getId());
        dto.setChineseName(model.getChineseName());
        dto.setChineseShortName(model.getChineseShortName());
        dto.setPinyinName(model.getPinyinName());
        dto.setEnglishName(model.getEnglishName());
        dto.setBrand(model.getBrand());
        dto.setLongitude(model.getLongitude());
        dto.setLatitude(model.getLatitude());
        dto.setAddress(model.getAddress());
        dto.setAuthenticationed(model.getAuthenticationed());
        dto.setTitleOfHonor(model.getTitleOfHonor());
        dto.setKeywords(model.getKeywords());
        dto.setLogo(model.getLogo());
        dto.setCompany(model.getCompany());
        dto.setModels(model.getModels());
        dto.setChargeStandard(model.getChargeStandard());
        dto.setIntroduction(model.getIntroduction());
        dto.setFullNameCompanies(model.getFullNameCompanies());
        dto.setBusinessLicenseNo(model.getBusinessLicenseNo());
        dto.setCompanyIndustry(model.getCompanyIndustry());
        dto.setOrganizationCode(model.getOrganizationCode());
        dto.setLicense(model.getLicense());
        dto.setUnifiedSocialCreditCode(model.getUnifiedSocialCreditCode());
        dto.setIndustryCode(model.getIndustryCode());
        dto.setRegistrationAuthority(model.getRegistrationAuthority());
        dto.setAcceptUnit(model.getAcceptUnit());
        dto.setSetUpDate(model.getSetUpDate());
        dto.setApprovalDate(model.getApprovalDate());
        dto.setRevocationDate(model.getRevocationDate());
        dto.setCancellationDate(model.getCancellationDate());
        dto.setValidityPeriod(model.getValidityPeriod());
        dto.setRegisteredCapital(model.getRegisteredCapital());
        dto.setIndustryCategories(model.getIndustryCategories());
        dto.setLegalRepresentative(model.getLegalRepresentative());
        dto.setOperationsManagers(model.getOperationsManagers());
        dto.setEmployeesCount(model.getEmployeesCount());
        dto.setEmergencyContact(model.getEmergencyContact());
        dto.setEmergencyContactPhoneNumber(model.getEmergencyContactPhoneNumber());
        dto.setBusinessScope(model.getBusinessScope());
        dto.setSinaWeibo(model.getSinaWeibo());
        dto.setTencentWeibo(model.getTencentWeibo());
        dto.setWeChatPublicAccount(model.getWeChatPublicAccount());
        dto.setWeChatPublicAccountQrCode(model.getWeChatPublicAccountQrCode());
        dto.setWebsite(model.getWebsite());
        dto.setMicroSite(model.getMicroSite());
        dto.setAndroidAppDownloadUrl(model.getAndroidAppDownloadUrl());
        dto.setIosAppDownloadUrl(model.getIosAppDownloadUrl());
        dto.setComplaints(model.getComplaints());
        dto.setCustomerServiceTelephone(model.getCustomerServiceTelephone());
        dto.setFax(model.getFax());
        dto.setEmail(model.getEmail());
        dto.setBusinessTimes(model.getBusinessTimes());
        dto.setSupportCards(model.getSupportCards());
        dto.setPaymentMethod(model.getPaymentMethod());
//		dto.setGallery(model.getGallery());
        dto.setImages(imageConverter.toDto(model.getImages()));
        dto.setVideos(videoConverter.toDto(model.getVideos()));
        dto.setVirtualMaterials(virtualMaterialConverter.toDto(model.getVirtualMaterials()));
        dto.setAudios(audioConverter.toDto(model.getAudios()));
        /*
         * dto.setGallery(model.getGallery());
         * dto.setVideoLibrary(model.getVideoLibrary());
         * dto.setAudioLibrary(model.getAudioLibrary());
         * dto.setVirtualMaterialLibrary(model.getVirtualMaterialLibrary());
         */
        return dto;
    }

    @Override
    public CarRentalCompany copyProperties(CarRentalCompany model, CarRentalCompanyDto dto) {
        model = super.copyProperties(model, dto);
        model.setNo(dto.getNo());
        model.setRegionCode(dto.getRegionCode());
        model.setChineseName(dto.getChineseName());
        model.setChineseShortName(dto.getChineseShortName());
        model.setPinyinName(dto.getPinyinName());
        model.setEnglishName(dto.getEnglishName());
        model.setBrand(dto.getBrand());
        model.setLongitude(dto.getLongitude());
        model.setLatitude(dto.getLatitude());
        model.setAddress(dto.getAddress());
        model.setAuthenticationed(dto.getAuthenticationed());
        model.setTitleOfHonor(dto.getTitleOfHonor());
        model.setKeywords(dto.getKeywords());
        model.setLogo(dto.getLogo());
        model.setCompany(dto.getCompany());
        model.setModels(dto.getModels());
        model.setChargeStandard(dto.getChargeStandard());
        model.setIntroduction(dto.getIntroduction());
        model.setFullNameCompanies(dto.getFullNameCompanies());
        model.setBusinessLicenseNo(dto.getBusinessLicenseNo());
        model.setCompanyIndustry(dto.getCompanyIndustry());
        model.setOrganizationCode(dto.getOrganizationCode());
        model.setLicense(dto.getLicense());
        model.setUnifiedSocialCreditCode(dto.getUnifiedSocialCreditCode());
        model.setIndustryCode(dto.getIndustryCode());
        model.setRegistrationAuthority(dto.getRegistrationAuthority());
        model.setAcceptUnit(dto.getAcceptUnit());
        model.setSetUpDate(dto.getSetUpDate());
        model.setApprovalDate(dto.getApprovalDate());
        model.setRevocationDate(dto.getRevocationDate());
        model.setCancellationDate(dto.getCancellationDate());
        model.setValidityPeriod(dto.getValidityPeriod());
        model.setRegisteredCapital(dto.getRegisteredCapital());
        model.setIndustryCategories(dto.getIndustryCategories());
        model.setLegalRepresentative(dto.getLegalRepresentative());
        model.setOperationsManagers(dto.getOperationsManagers());
        model.setEmployeesCount(dto.getEmployeesCount());
        model.setEmergencyContact(dto.getEmergencyContact());
        model.setEmergencyContactPhoneNumber(dto.getEmergencyContactPhoneNumber());
        model.setBusinessScope(dto.getBusinessScope());
        model.setSinaWeibo(dto.getSinaWeibo());
        model.setTencentWeibo(dto.getTencentWeibo());
        model.setWeChatPublicAccount(dto.getWeChatPublicAccount());
        model.setWeChatPublicAccountQrCode(dto.getWeChatPublicAccountQrCode());
        model.setWebsite(dto.getWebsite());
        model.setMicroSite(dto.getMicroSite());
        model.setAndroidAppDownloadUrl(dto.getAndroidAppDownloadUrl());
        model.setIosAppDownloadUrl(dto.getIosAppDownloadUrl());
        model.setComplaints(dto.getComplaints());
        model.setCustomerServiceTelephone(dto.getCustomerServiceTelephone());
        model.setFax(dto.getFax());
        model.setEmail(dto.getEmail());
        model.setBusinessTimes(dto.getBusinessTimes());
        model.setSupportCards(dto.getSupportCards());
        model.setPaymentMethod(dto.getPaymentMethod());
        model.setCars(dto.getCars().stream().map(ele -> {
            return carConverter.copyProperties(new Car(), ele);
        }).collect(Collectors.toList()));

//		model.setGallery(dto.getGallery());
//		model.setVideoLibrary(dto.getVideoLibrary());
//		model.setAudioLibrary(dto.getAudioLibrary());
//		model.setVirtualMaterialLibrary(dto.getVirtualMaterialLibrary());
        return model;
    }

    @Override
    protected CarRentalCompanyDto getDto() {
        return new CarRentalCompanyDto();
    }
}
