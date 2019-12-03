package com.dm.data.manager.converter;

import com.dm.data.manager.dto.ParkingTimeDto;
import com.dm.data.manager.entity.ParkingTime;
import org.springframework.stereotype.Component;

@Component
public class ParkingTimeConverter extends AbstractBaseConverter<ParkingTime, ParkingTimeDto> {

    @Override
    protected ParkingTimeDto toDtoActual(ParkingTime model) {
        ParkingTimeDto dto = super.toDtoActual(model);
        dto.setArea(model.getArea());
        dto.setCity(model.getCity());
        dto.setDay(model.getDay());
        dto.setHoure(model.getHoure());
        dto.setId(model.getId());
        dto.setMonth(model.getMonth());
        dto.setProvince(model.getProvince());
        dto.setScenic(model.getScenic());
        dto.setTotalNumber(model.getTotalNumber());
        dto.setUseNumber(model.getUseNumber());
        dto.setYear(model.getYear());
        dto.setRegionCode(model.getRegionCode());
        return dto;
    }

    @Override
    public ParkingTime copyProperties(ParkingTime model, ParkingTimeDto dto) {
        model = super.copyProperties(model, dto);
        model.setArea(dto.getArea());
        model.setCity(dto.getCity());
        model.setDay(dto.getDay());
        model.setHoure(dto.getHoure());
        model.setMonth(dto.getMonth());
        model.setProvince(dto.getProvince());
        model.setScenic(dto.getScenic());
        model.setTotalNumber(dto.getTotalNumber());
        model.setUseNumber(dto.getUseNumber());
        model.setYear(dto.getYear());
        model.setRegionCode(dto.getRegionCode());
        return model;
    }

    @Override
    protected ParkingTimeDto getDto() {
        return new ParkingTimeDto();
    }
}
