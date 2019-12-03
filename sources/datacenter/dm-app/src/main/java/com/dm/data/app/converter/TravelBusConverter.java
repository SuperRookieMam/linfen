package com.dm.data.app.converter;

import com.dm.common.converter.AbstractConverter;
import com.dm.data.app.dto.TravelBusDto;
import com.dm.data.app.entity.TravelBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TravelBusConverter extends AbstractConverter<TravelBus, TravelBusDto> {
    @Autowired
    private LocalPointConverter localPointConverter;
    @Override
    protected TravelBusDto toDtoActual(TravelBus model) {
        TravelBusDto dto=new TravelBusDto();
        dto.setDayTime(model.getDayTime());
        dto.setDriverName(model.getDriverName());
        dto.setDriverTel(model.getDriverTel());
        dto.setId(model.getId());
        dto.setGuiderName(model.getGuiderName());
        dto.setGuiderTell(model.getGuiderTell());
        dto.setTeamName(model.getTeamName());
        dto.setTeamPeopleNum(model.getTeamPeopleNum());
        dto.setCarNum(model.getCarNum());
        dto.setTeamId(model.getTeamId());
        dto.setPoints(localPointConverter.toDto(model.getPoints()));
        return dto;
    }

    @Override
    public TravelBus copyProperties(TravelBus model, TravelBusDto dto) {
        model.setDayTime(dto.getDayTime());
        model.setDriverName(dto.getDriverName());
        model.setCarNum(dto.getCarNum());
        model.setDriverTel(dto.getDriverTel());
        model.setTeamId(dto.getTeamId());
        model.setGuiderName(dto.getGuiderName());
        model.setGuiderTell(dto.getGuiderTell());
        model.setTeamName(dto.getTeamName());
        model.setTeamPeopleNum(dto.getTeamPeopleNum());
        return model;
    }
}
