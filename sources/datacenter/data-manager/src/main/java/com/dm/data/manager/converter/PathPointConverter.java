package com.dm.data.manager.converter;

import com.dm.data.manager.dto.PathPointDto;
import com.dm.data.manager.entity.PathPoint;
import org.springframework.stereotype.Component;

@Component
public class PathPointConverter extends AbstractBaseConverter<PathPoint, PathPointDto> {

    @Override
    protected PathPointDto toDtoActual(PathPoint model) {
        PathPointDto dto = super.toDtoActual(model);
        dto.setLatitude(model.getLatitude());
        dto.setLongitude(model.getLongitude());
        dto.setName(model.getName());
        dto.setId(model.getId());
        dto.setRegionCode(model.getRegionCode());
        return dto;
    }

    @Override
    public PathPoint copyProperties(PathPoint model, PathPointDto dto) {
        model = super.copyProperties(model, dto);
        model.setLatitude(dto.getLatitude());
        model.setLongitude(dto.getLongitude());
        model.setName(dto.getName());
        model.setRegionCode(dto.getRegionCode());
        return model;
    }

    @Override
    protected PathPointDto getDto() {
        return new PathPointDto();
    }
}
