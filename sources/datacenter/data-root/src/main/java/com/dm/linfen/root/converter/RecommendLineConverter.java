package com.dm.linfen.root.converter;

import com.dm.common.converter.AbstractConverter;
import com.dm.linfen.root.dto.RecommendLineDto;
import com.dm.linfen.root.entity.RecommendLine;
import org.springframework.stereotype.Component;

@Component
public class RecommendLineConverter extends AbstractConverter<RecommendLine, RecommendLineDto> {
    @Override
    protected RecommendLineDto toDtoActual(RecommendLine model) {
        RecommendLineDto dto=new RecommendLineDto();
        dto.setId(model.getId());
        dto.setName(model.getName());
        dto.setStatus(model.getStatus());
        dto.setRoutesId(model.getRoutesId());
        dto.setScenicIds(model.getScenicIds());
        dto.setStatus(model.getStatus());
        dto.setPriority(model.getPriority());
        return dto;
    }

    @Override
    public RecommendLine copyProperties(RecommendLine model, RecommendLineDto dto) {
        model.setId(dto.getId());
        model.setName(dto.getName());
        model.setStatus(dto.getStatus());
        model.setRoutesId(dto.getRoutesId());
        model.setScenicIds(dto.getScenicIds());
        model.setStatus(dto.getStatus());
        model.setPriority(dto.getPriority());
        return model;
    }
}
