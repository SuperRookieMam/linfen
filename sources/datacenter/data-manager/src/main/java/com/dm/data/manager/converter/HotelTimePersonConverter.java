package com.dm.data.manager.converter;

import com.dm.data.manager.dto.HotelTimePersonDto;
import com.dm.data.manager.entity.HotelTimePerson;
import org.springframework.stereotype.Component;

@Component
public class HotelTimePersonConverter extends AbstractBaseConverter<HotelTimePerson, HotelTimePersonDto> {

    @Override
    protected HotelTimePersonDto toDtoActual(HotelTimePerson model) {
        HotelTimePersonDto dto = super.toDtoActual(model);
        dto.setAgeMax(model.getAgeMax());
        dto.setAgeMin(model.getAgeMin());
        dto.setArea(model.getArea());
        dto.setCity(model.getCity());
        dto.setDay(model.getDay());
        dto.setHotelName(model.getHotelName());
        dto.setHoure(model.getHoure());
        dto.setId(model.getId());
        dto.setLevel(model.getLevel());
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
    public HotelTimePerson copyProperties(HotelTimePerson model, HotelTimePersonDto dto) {
        model = super.copyProperties(model, dto);
        model.setAgeMax(dto.getAgeMax());
        model.setAgeMin(dto.getAgeMin());
        model.setArea(dto.getArea());
        model.setCity(dto.getCity());
        model.setDay(dto.getDay());
        model.setHotelName(dto.getHotelName());
        model.setHoure(dto.getHoure());
        model.setLevel(dto.getLevel());
        model.setMonth(dto.getMonth());
        model.setNumber(dto.getNumber());
        model.setProvince(dto.getProvince());
        model.setScenic(dto.getScenic());
        model.setSex(dto.getSex());
        model.setYear(dto.getYear());
        model.setRegionCode(dto.getRegionCode());
        return model;
    }

    @Override
    protected HotelTimePersonDto getDto() {
        return new HotelTimePersonDto();
    }
}
