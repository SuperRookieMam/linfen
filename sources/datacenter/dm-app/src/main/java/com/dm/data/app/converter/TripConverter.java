package com.dm.data.app.converter;

import com.dm.common.converter.AbstractConverter;
import com.dm.data.app.dto.TripDto;
import com.dm.data.app.entity.Trip;
import org.springframework.stereotype.Component;

@Component
public class TripConverter extends AbstractConverter<Trip, TripDto> {
    @Override
    protected TripDto toDtoActual(Trip model) {
        TripDto dto=new TripDto();
        dto.setId(model.getId());
        dto.setArrange(model.getArrange());
        dto.setHotelName(model.getHotelName());
        dto.setTripTime(model.getTripTime());
        return dto;
    }

    @Override
    public Trip copyProperties(Trip model, TripDto dto) {
        model.setArrange(dto.getArrange());
        model.setHotelName(dto.getHotelName());
        model.setTripTime(dto.getTripTime());
        return model;
    }
}
