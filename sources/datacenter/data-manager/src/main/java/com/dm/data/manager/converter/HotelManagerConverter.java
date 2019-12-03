package com.dm.data.manager.converter;

import com.dm.data.manager.dto.HotelManagerDto;
import com.dm.data.manager.entity.HotelManager;
import org.springframework.stereotype.Component;

@Component
public class HotelManagerConverter extends AbstractBaseConverter<HotelManager, HotelManagerDto> {

    @Override
    protected HotelManagerDto toDtoActual(HotelManager model) {
        HotelManagerDto dto = super.toDtoActual(model);
        dto.setId(model.getId());
        dto.setCurrentDate(model.getCurrentDate());
        dto.setRegionCode(model.getRegionCode());
        dto.setHotelName(model.getHotelName());
        dto.setPrice(model.getPrice());
        dto.setOldPrice(model.getOldPrice());
        dto.setScore(model.getScore());
        dto.setAvgScore(model.getAvgScore());
        return dto;
    }

    @Override
    public HotelManager copyProperties(HotelManager model, HotelManagerDto dto) {
        model = super.copyProperties(model, dto);
        model.setCurrentDate(dto.getCurrentDate());
        model.setRegionCode(dto.getRegionCode());
        model.setHotelName(dto.getHotelName());
        model.setPrice(dto.getPrice());
        model.setOldPrice(dto.getOldPrice());
        model.setScore(dto.getScore());
        model.setAvgScore(dto.getAvgScore());
        return model;
    }

    @Override
    protected HotelManagerDto getDto() {
        return new HotelManagerDto();
    }
}
