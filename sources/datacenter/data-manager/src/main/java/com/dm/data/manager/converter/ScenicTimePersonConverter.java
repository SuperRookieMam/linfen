package com.dm.data.manager.converter;

import com.dm.data.manager.dto.ScenicTimePersonDto;
import com.dm.data.manager.entity.ScenicTimePerson;
import org.springframework.stereotype.Component;

@Component
public class ScenicTimePersonConverter extends AbstractBaseConverter<ScenicTimePerson, ScenicTimePersonDto> {

    @Override
    protected ScenicTimePersonDto toDtoActual(ScenicTimePerson model) {
        ScenicTimePersonDto dto = super.toDtoActual(model);
        dto.setAgeMax(model.getAgeMax());
        dto.setReceiveNum(model.getReceiveNum());
        dto.setNowPeopleNum(model.getNowPeopleNum());
        dto.setAgeMin(model.getAgeMin());
        dto.setArea(model.getArea());
        dto.setCity(model.getCity());
        dto.setDay(model.getDay());
        dto.setHoure(model.getHoure());
        dto.setId(model.getId());
        dto.setMonth(model.getMonth());
        dto.setNumber(model.getNumber());
        dto.setProvince(model.getProvince());
        dto.setScenic(model.getScenic());
        dto.setSex(model.getSex());
        dto.setYear(model.getYear());
        dto.setRegionCode(model.getRegionCode());
        return dto;
    }

    @Override
    public ScenicTimePerson copyProperties(ScenicTimePerson model, ScenicTimePersonDto dto) {
        model = super.copyProperties(model, dto);
        model.setAgeMax(dto.getAgeMax());
        model.setAgeMin(dto.getAgeMin());
        model.setArea(dto.getArea());
        model.setCity(dto.getCity());
        model.setDay(dto.getDay());
        model.setHoure(dto.getHoure());
        model.setMonth(dto.getMonth());
        model.setNumber(dto.getNumber());
        model.setProvince(dto.getProvince());
        model.setScenic(dto.getScenic());
        model.setSex(dto.getSex());
        model.setYear(dto.getYear());
        model.setRegionCode(dto.getRegionCode());
        model.setReceiveNum(dto.getReceiveNum());
        model.setNowPeopleNum(dto.getNowPeopleNum());
        return model;
    }

    @Override
    protected ScenicTimePersonDto getDto() {
        return new ScenicTimePersonDto();
    }
}
