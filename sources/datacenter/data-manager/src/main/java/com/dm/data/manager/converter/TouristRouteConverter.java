package com.dm.data.manager.converter;

import com.dm.data.manager.dto.TouristRouteDto;
import com.dm.data.manager.entity.Image;
import com.dm.data.manager.entity.PathPoint;
import com.dm.data.manager.entity.TouristRoute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class TouristRouteConverter extends AbstractBaseConverter<TouristRoute, TouristRouteDto> {
    @Autowired
    private ImageConverter imageConverter;

    @Autowired
    private PathPointConverter pathPointConverter;

    @Override
    protected TouristRouteDto toDtoActual(TouristRoute model) {
        TouristRouteDto dto = super.toDtoActual(model);
        dto.setId(model.getId());
        dto.setNo(model.getNo());
        dto.setName(model.getName());
        dto.setType(model.getType());
        dto.setTarget(model.getTarget());
        dto.setTargetType(model.getTargetType());
        dto.setDays(model.getDays());
        dto.setImages(imageConverter.toDto(model.getImages()));
        // dto.setPics(model.getPics());
        dto.setDescription(model.getDescription());
        dto.setPrice(model.getPrice());
        dto.setPhone(model.getPhone());
        dto.setWayType(model.getWayType());
        dto.setPathPoints(pathPointConverter.toDto(model.getPathPoints()));
        return dto;
    }

    @Override
    public TouristRoute copyProperties(TouristRoute model, TouristRouteDto dto) {
        model = super.copyProperties(model, dto);
        model.setNo(dto.getNo());
        model.setName(dto.getName());
        model.setType(dto.getType());
        model.setTarget(dto.getTarget());
        model.setTargetType(dto.getTargetType());
        model.setDays(dto.getDays());
        model.setDescription(dto.getDescription());
        model.setPrice(dto.getPrice());
        model.setPhone(dto.getPhone());
        model.setWayType(dto.getWayType());
        model.setPathPoints(dto.getPathPoints().stream().map(ele -> {
            return pathPointConverter.copyProperties(new PathPoint(), ele);
        }).collect(Collectors.toList()));
        model.setImages(dto.getImages().stream().map(ele -> {
            return imageConverter.copyProperties(new Image(), ele);
        }).collect(Collectors.toList()));
        return model;
    }

    @Override
    protected TouristRouteDto getDto() {
        return new TouristRouteDto();
    }
}
