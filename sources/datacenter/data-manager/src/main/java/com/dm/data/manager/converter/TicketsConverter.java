package com.dm.data.manager.converter;

import com.dm.data.manager.dto.TicketsDto;
import com.dm.data.manager.entity.Tickets;
import org.springframework.stereotype.Component;

@Component
public class TicketsConverter extends AbstractBaseConverter<Tickets, TicketsDto> {

    @Override
    protected TicketsDto toDtoActual(Tickets model) {
        TicketsDto dto = super.toDtoActual(model);
        dto.setId(model.getId());
        dto.setCurrentDate(model.getCurrentDate());
        dto.setRegionCode(model.getRegionCode());
        dto.setScenic(model.getScenic());
        dto.setPrice(model.getPrice());
        dto.setOldPrice(model.getOldPrice());
        dto.setScore(model.getScore());
        dto.setAvgScore(model.getAvgScore());
        return dto;
    }

    @Override
    public Tickets copyProperties(Tickets model, TicketsDto dto) {
        model = super.copyProperties(model, dto);
        model.setCurrentDate(dto.getCurrentDate());
        model.setRegionCode(dto.getRegionCode());
        model.setScenic(dto.getScenic());
        model.setPrice(dto.getPrice());
        model.setOldPrice(dto.getOldPrice());
        model.setScore(dto.getScore());
        model.setAvgScore(dto.getAvgScore());
        return model;
    }

    @Override
    protected TicketsDto getDto() {
        return new TicketsDto();
    }
}
