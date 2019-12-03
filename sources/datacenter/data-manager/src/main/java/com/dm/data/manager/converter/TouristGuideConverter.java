package com.dm.data.manager.converter;

import com.dm.data.manager.dto.TouristGuideDto;
import com.dm.data.manager.entity.TouristGuide;
import org.springframework.stereotype.Component;

@Component
public class TouristGuideConverter extends AbstractBaseConverter<TouristGuide, TouristGuideDto> {

    @Override
    protected TouristGuideDto toDtoActual(TouristGuide model) {
        TouristGuideDto dto = super.toDtoActual(model);
        dto.setChineseName(model.getChineseName());
        dto.setId(model.getId());
        dto.setPinyin(model.getPinyin());
        dto.setGender(model.getGender());
        dto.setDateOfBirth(model.getDateOfBirth());
        dto.setIdNumber(model.getIdNumber());
        dto.setRecordOfFormalSchooling(model.getRecordOfFormalSchooling());
        dto.setNational(model.getNational());
        dto.setContact(model.getContact());
        dto.setHomeAddress(model.getHomeAddress());
        dto.setServiceLanguage(model.getServiceLanguage());
        dto.setRegionCode(model.getRegionCode());
        dto.setIntroduction(model.getIntroduction());
        dto.setWorkingCondition(model.getWorkingCondition());
        return dto;
    }

    @Override
    public TouristGuide copyProperties(TouristGuide model, TouristGuideDto dto) {
        model = super.copyProperties(model, dto);
        model.setChineseName(dto.getChineseName());
        model.setPinyin(dto.getPinyin());
        model.setGender(dto.getGender());
        model.setDateOfBirth(dto.getDateOfBirth());
        model.setIdNumber(dto.getIdNumber());
        model.setRecordOfFormalSchooling(dto.getRecordOfFormalSchooling());
        model.setNational(dto.getNational());
        model.setContact(dto.getContact());
        model.setHomeAddress(dto.getHomeAddress());
        model.setServiceLanguage(dto.getServiceLanguage());
        model.setRegionCode(dto.getRegionCode());
        model.setIntroduction(dto.getIntroduction());
        model.setWorkingCondition(dto.getWorkingCondition());
        return model;
    }

    @Override
    protected TouristGuideDto getDto() {
        return new TouristGuideDto();
    }
}
