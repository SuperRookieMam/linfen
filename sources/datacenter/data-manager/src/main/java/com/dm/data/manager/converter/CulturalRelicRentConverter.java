package com.dm.data.manager.converter;

import com.dm.data.manager.dto.CulturalRelicRentDto;
import com.dm.data.manager.entity.CulturalRelicRent;
import com.dm.file.converter.FileInfoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CulturalRelicRentConverter extends AbstractBaseConverter<CulturalRelicRent, CulturalRelicRentDto> {
    @Autowired
    private FileInfoConverter fileInfoConverter;

    @Override
    protected CulturalRelicRentDto toDtoActual(CulturalRelicRent model) {
        CulturalRelicRentDto dto = super.toDtoActual(model);
        dto.setId(model.getId());
        dto.setNo(model.getNo());
        dto.setRegionCode(model.getRegionCode());
        dto.setNoEnums(model.getNoEnums());
        dto.setName(model.getName());
        dto.setLendingUnit(model.getLendingUnit());
        dto.setRentalUnit(model.getRentalUnit());
        dto.setRentalTime(model.getRentalTime());
        dto.setReturnTime(model.getReturnTime());
        dto.setImgs(fileInfoConverter.toDto(model.getImgs()));
        dto.setRentStatus(model.getRentStatus());
        dto.setDescription(model.getDescription());
        dto.setRentDays(model.getRentDays());
        dto.setLendingCode(model.getLendingCode());
        dto.setRentalCode(model.getRentalCode());
        return dto;
    }

    @Override
    public CulturalRelicRent copyProperties(CulturalRelicRent model, CulturalRelicRentDto dto) {
        model = super.copyProperties(model, dto);
        model.setNo(dto.getNo());
        model.setRegionCode(dto.getRegionCode());
        model.setNoEnums(dto.getNoEnums());
        model.setName(dto.getName());
        model.setLendingUnit(dto.getLendingUnit());
        model.setRentalUnit(dto.getRentalUnit());
        model.setRentalTime(dto.getRentalTime());
        model.setReturnTime(dto.getReturnTime());
        model.setRentStatus(dto.getRentStatus());
        model.setDescription(dto.getDescription());
        model.setRentDays(dto.getRentDays());
        model.setLendingCode(dto.getLendingCode());
        model.setRentalCode(dto.getRentalCode());
        return model;
    }

    @Override
    protected CulturalRelicRentDto getDto() {
        return new CulturalRelicRentDto();
    }
}
