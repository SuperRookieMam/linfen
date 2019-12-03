package com.dm.data.app.converter;

import com.dm.common.converter.AbstractConverter;
import com.dm.data.app.dto.LocalPointDto;
import com.dm.data.app.entity.LocalPoint;
import org.springframework.stereotype.Component;

@Component
public class LocalPointConverter extends AbstractConverter<LocalPoint, LocalPointDto> {
    @Override
    protected LocalPointDto toDtoActual(LocalPoint model) {
        LocalPointDto dto=new LocalPointDto();
        dto.setLatitude(model.getLatitude());
        dto.setId(model.getId());
        dto.setLongitude(model.getLongitude());
        dto.setTimePoint(model.getTimePoint());
        return dto;
    }

    @Override
    public LocalPoint copyProperties(LocalPoint model, LocalPointDto dto) {
        model.setLatitude(dto.getLatitude());
        model.setLongitude(dto.getLongitude());
        model.setTimePoint(dto.getTimePoint());
        return model;
    }
}
