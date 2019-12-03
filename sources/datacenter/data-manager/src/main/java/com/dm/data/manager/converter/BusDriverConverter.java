package com.dm.data.manager.converter;

import com.dm.data.manager.dto.BusDriverDto;
import com.dm.data.manager.entity.BusDriver;
import org.springframework.stereotype.Component;

@Component
public class BusDriverConverter extends AbstractBaseConverter<BusDriver, BusDriverDto> {

    @Override
    protected BusDriverDto toDtoActual(BusDriver model) {
        BusDriverDto dto = super.toDtoActual(model);
        dto.setChineseName(model.getChineseName());
        dto.setPinyin(model.getPinyin());
        dto.setTheEnglishName(model.getTheEnglishName());
        dto.setGender(model.getGender());
        dto.setId(model.getId());
        dto.setDateOfBirth(model.getDateOfBirth());
        dto.setIdNumber(model.getIdNumber());
        dto.setRecordOfFormalSchooling(model.getRecordOfFormalSchooling());
        dto.setNational(model.getNational());
        dto.setContact(model.getContact());
        dto.setHomeAddress(model.getHomeAddress());
        dto.setRegionCode(model.getRegionCode());
        dto.setTheTitle(model.getTheTitle());
        dto.setBeenDriving(model.getBeenDriving());
        dto.setDriverLicenseNumber(model.getDriverLicenseNumber());
        dto.setServiceLanguage(model.getServiceLanguage());
        dto.setServiceScope(model.getServiceScope());
        dto.setIntroduction(model.getIntroduction());
        dto.setWorkingCondition(model.getWorkingCondition());
        return dto;
    }

    @Override
    public BusDriver copyProperties(BusDriver model, BusDriverDto dto) {
        model = super.copyProperties(model, dto);
        model.setChineseName(dto.getChineseName());
        model.setPinyin(dto.getPinyin());
        model.setTheEnglishName(dto.getTheEnglishName());
        model.setGender(dto.getGender());
        model.setDateOfBirth(dto.getDateOfBirth());
        model.setIdNumber(dto.getIdNumber());
        model.setRecordOfFormalSchooling(dto.getRecordOfFormalSchooling());
        model.setNational(dto.getNational());
        model.setContact(dto.getContact());
        model.setHomeAddress(dto.getHomeAddress());
        model.setRegionCode(dto.getRegionCode());
        model.setTheTitle(dto.getTheTitle());
        model.setBeenDriving(dto.getBeenDriving());
        model.setDriverLicenseNumber(dto.getDriverLicenseNumber());
        model.setServiceLanguage(dto.getServiceLanguage());
        model.setServiceScope(dto.getServiceScope());
        model.setIntroduction(dto.getIntroduction());
        model.setWorkingCondition(dto.getWorkingCondition());
        return model;
    }

    @Override
    protected BusDriverDto getDto() {
        return new BusDriverDto();
    }
}
