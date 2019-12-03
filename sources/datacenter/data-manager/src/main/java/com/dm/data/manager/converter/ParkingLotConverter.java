package com.dm.data.manager.converter;

import com.dm.data.manager.dto.ParkingLotDto;
import com.dm.data.manager.entity.ParkingLot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ParkingLotConverter extends AbstractBaseConverter<ParkingLot, ParkingLotDto> {
    @Autowired
    private ImageConverter imageConverter;
    @Autowired
    private VideoConverter videoConverter;
    @Autowired
    private AudioConverter audioConverter;
    @Autowired
    private VirtualMaterialConverter virtualMaterialConverter;

    @Override
    protected ParkingLotDto toDtoActual(ParkingLot model) {
        ParkingLotDto dto = super.toDtoActual(model);
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
        dto.setTheCompanyOfAffiliation(model.getTheCompanyOfAffiliation());
        dto.setKeywords(model.getKeywords());
        dto.setServiceFacilities(model.getServiceFacilities());
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
        dto.setTheParkingLotType(model.getTheParkingLotType());
        dto.setCarType(model.getCarType());
        dto.setNumberOfParking(model.getNumberOfParking());
        dto.setBusinessHours(model.getBusinessHours());
        dto.setChargeStandard(model.getChargeStandard());
        dto.setHotIndex(model.getHotIndex());
        return dto;
    }

    @Override
    public ParkingLot copyProperties(ParkingLot model, ParkingLotDto dto) {
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
        model.setTheCompanyOfAffiliation(dto.getTheCompanyOfAffiliation());
        model.setKeywords(dto.getKeywords());
        model.setServiceFacilities(dto.getServiceFacilities());
        model.setRegionCode(dto.getRegionCode());
        /*
         * model.setTheGallery(dto.getTheGallery());
         * model.setVideoLibrary(dto.getVideoLibrary());
         * model.setAudioLibrary(dto.getAudioLibrary());
         * model.setVirtualMaterialLibrary(dto.getVirtualMaterialLibrary());
         */
        model.setTheParkingLotType(dto.getTheParkingLotType());
        model.setCarType(dto.getCarType());
        model.setNumberOfParking(dto.getNumberOfParking());
        model.setBusinessHours(dto.getBusinessHours());
        model.setChargeStandard(dto.getChargeStandard());
        model.setHotIndex(dto.getHotIndex());
        return model;
    }

    @Override
    protected ParkingLotDto getDto() {
        return new ParkingLotDto();
    }
}
