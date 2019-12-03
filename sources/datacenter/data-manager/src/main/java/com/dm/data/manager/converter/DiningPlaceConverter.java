package com.dm.data.manager.converter;

import com.dm.data.manager.dto.DiningPlaceDto;
import com.dm.data.manager.entity.DiningPlace;
import com.dm.data.manager.entity.ParkingLot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class DiningPlaceConverter extends AbstractBaseConverter<DiningPlace, DiningPlaceDto> {
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

    @Override
    protected DiningPlaceDto toDtoActual(DiningPlace model) {
        DiningPlaceDto dto = super.toDtoActual(model);
        dto.setNo(model.getNo());
        dto.setScore(model.getScore());
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
        dto.setType(model.getType());
        dto.setLevel(model.getLevel());
        dto.setTheGradeOf(model.getTheGradeOf());
        dto.setTheRestaurantLogo(model.getTheRestaurantLogo());
        dto.setKeywords(model.getKeywords());
        dto.setLabel(model.getLabel());
        dto.setRecommendedDishes(model.getRecommendedDishes());
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
        dto.setBusinessHours(model.getBusinessHours());
        dto.setDueToThePhone(model.getDueToThePhone());
        dto.setConsultingTheTelephone(model.getConsultingTheTelephone());
        dto.setComplaints(model.getComplaints());
        dto.setOnlineComplaintsAddress(model.getOnlineComplaintsAddress());
        dto.setFax(model.getFax());
        dto.setEmail(model.getEmail());
        dto.setAtTheSameTimeRepastNumber(model.getAtTheSameTimeRepastNumber());
        dto.setNumberOfRooms(model.getNumberOfRooms());
        dto.setDishesWith(model.getDishesWith());
        dto.setPerCapitaConsumption(model.getPerCapitaConsumption());
        dto.setSurroundingInformation(model.getSurroundingInformation());
        dto.setSupportOfCard(model.getSupportOfCard());
        dto.setMethodOfPayment(model.getMethodOfPayment());
        dto.setParkingLots(parkingLotConverter.toDto(model.getParkingLots()));
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
        dto.setHotIndex(model.getHotIndex());
        return dto;
    }

    @Override
    public DiningPlace copyProperties(DiningPlace model, DiningPlaceDto dto) {
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
        model.setTheGradeOf(dto.getTheGradeOf());
        model.setTheRestaurantLogo(dto.getTheRestaurantLogo());
        model.setKeywords(dto.getKeywords());
        model.setLabel(dto.getLabel());
        model.setRecommendedDishes(dto.getRecommendedDishes());
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
        model.setBusinessHours(dto.getBusinessHours());
        model.setDueToThePhone(dto.getDueToThePhone());
        model.setConsultingTheTelephone(dto.getConsultingTheTelephone());
        model.setComplaints(dto.getComplaints());
        model.setOnlineComplaintsAddress(dto.getOnlineComplaintsAddress());
        model.setFax(dto.getFax());
        model.setEmail(dto.getEmail());
        model.setAtTheSameTimeRepastNumber(dto.getAtTheSameTimeRepastNumber());
        model.setNumberOfRooms(dto.getNumberOfRooms());
        model.setDishesWith(dto.getDishesWith());
        model.setPerCapitaConsumption(dto.getPerCapitaConsumption());
        model.setSurroundingInformation(dto.getSurroundingInformation());
        model.setSupportOfCard(dto.getSupportOfCard());
        model.setMethodOfPayment(dto.getMethodOfPayment());
        model.setParkingLots(dto.getParkingLots().stream().map(ele -> {
            return parkingLotConverter.copyProperties(new ParkingLot(), ele);
        }).collect(Collectors.toList()));
        model.setScore(dto.getScore());
        model.setHotIndex(dto.getHotIndex());
        return model;
    }

    @Override
    protected DiningPlaceDto getDto() {
        return new DiningPlaceDto();
    }
}
