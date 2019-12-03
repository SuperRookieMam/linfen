package com.dm.data.manager.converter;

import com.dm.data.manager.dto.SenicReceptionDto;
import com.dm.data.manager.entity.SenicReception;
import org.springframework.stereotype.Component;

@Component
public class SenicReceptionConverter extends AbstractBaseConverter<SenicReception, SenicReceptionDto> {

    @Override
    protected SenicReceptionDto toDtoActual(SenicReception model) {
        SenicReceptionDto dto = super.toDtoActual(model);
        dto.setArea(model.getArea());
        dto.setCity(model.getCity());
        dto.setDay(model.getDay());
        dto.setHoure(model.getHoure());
        dto.setId(model.getId());
        dto.setMonth(model.getMonth());
        dto.setNumber(model.getNumber());
        dto.setProvince(model.getProvince());
        dto.setScenic(model.getScenic());
        dto.setYear(model.getYear());
        dto.setRegionCode(model.getRegionCode());
        return dto;
    }

    @Override
    public SenicReception copyProperties(SenicReception model, SenicReceptionDto dto) {
        model = super.copyProperties(model, dto);
        model.setArea(dto.getArea());
        model.setCity(dto.getCity());
        model.setDay(dto.getDay());
        model.setHoure(dto.getHoure());
        model.setMonth(dto.getMonth());
        model.setNumber(dto.getNumber());
        model.setProvince(dto.getProvince());
        model.setScenic(dto.getScenic());
        model.setYear(dto.getYear());
        model.setRegionCode(dto.getRegionCode());
        return model;
    }

    @Override
    protected SenicReceptionDto getDto() {
        return new SenicReceptionDto();
    }
}
