package com.dm.data.manager.converter;

import com.dm.data.manager.dto.TouristConsultDto;
import com.dm.data.manager.entity.TouristConsult;
import com.dm.file.converter.FileInfoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TouristConsultConverter extends AbstractBaseConverter<TouristConsult, TouristConsultDto> {
    @Autowired
    private FileInfoConverter fileInfoConverter;

    @Override
    protected TouristConsultDto toDtoActual(TouristConsult model) {
        TouristConsultDto dto = super.toDtoActual(model);
        dto.setDescription(model.getDescription());
        dto.setHtml(model.getHtml());
        dto.setId(model.getId());
        dto.setSource(model.getSource());
        dto.setTitile(model.getTitile());
        dto.setImgs(fileInfoConverter.toDto(model.getImgs()));
        dto.setType(model.getType());
        dto.setRegionCode(model.getRegionCode());
        dto.setCreatUser(model.getCreatUser());
        dto.setCreatTime(model.getCreatTime());
        return dto;
    }

    @Override
    public TouristConsult copyProperties(TouristConsult model, TouristConsultDto dto) {
        model = super.copyProperties(model, dto);
        model.setCreatTime(dto.getCreatTime());
        model.setDescription(dto.getDescription());
        model.setHtml(dto.getHtml());
        model.setSource(dto.getSource());
        model.setTitile(dto.getTitile());
        model.setType(dto.getType());
        model.setRegionCode(dto.getRegionCode());
        model.setCreatUser(dto.getCreatUser());
        return model;
    }

    @Override
    protected TouristConsultDto getDto() {
        return new TouristConsultDto();
    }
}
