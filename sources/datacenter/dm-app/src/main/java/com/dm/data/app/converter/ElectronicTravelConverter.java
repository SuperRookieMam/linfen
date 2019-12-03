package com.dm.data.app.converter;

import com.dm.common.converter.AbstractConverter;
import com.dm.data.app.dto.ElectronicTravelDto;
import com.dm.data.app.entity.ElectronicTravel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ElectronicTravelConverter extends AbstractConverter<ElectronicTravel, ElectronicTravelDto> {
    @Autowired
    private TripConverter tripConverter;
    @Override
    protected ElectronicTravelDto toDtoActual(ElectronicTravel model) {
        ElectronicTravelDto dto=new ElectronicTravelDto();
        dto.setGuiderName(model.getGuiderName());
        dto.setLabel(model.getLabel());
        dto.setId(model.getId());
        dto.setPeopleNum(model.getPeopleNum());
        dto.setTravelEnd(model.getTravelEnd());
        dto.setTravelStart(model.getTravelStart());
        dto.setTravelName(model.getTravelName());
        dto.setTeamId(model.getTeamId());
        dto.setTrips(tripConverter.toDto(model.getTrips()));
        dto.setTeamName(model.getTeamName());
        return dto;
    }

    @Override
    public ElectronicTravel copyProperties(ElectronicTravel model, ElectronicTravelDto dto) {
        model.setGuiderName(dto.getGuiderName());
        model.setPeopleNum(dto.getPeopleNum());
        model.setLabel(dto.getLabel());
        model.setTravelEnd(dto.getTravelEnd());
        model.setTravelStart(dto.getTravelStart());
        model.setTravelName(dto.getTravelName());
        model.setTeamId(dto.getTeamId());
        model.setTeamName(dto.getTeamName());
        return model;
    }
}
