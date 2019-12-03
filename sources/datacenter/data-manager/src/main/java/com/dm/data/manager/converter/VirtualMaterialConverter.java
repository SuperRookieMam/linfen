package com.dm.data.manager.converter;

import com.dm.data.manager.dto.VirtualMaterialDto;
import com.dm.data.manager.entity.VirtualMaterial;
import org.springframework.stereotype.Component;

@Component
public class VirtualMaterialConverter extends AbstractBaseConverter<VirtualMaterial, VirtualMaterialDto> {

    @Override
    protected VirtualMaterialDto toDtoActual(VirtualMaterial model) {
        VirtualMaterialDto dto = super.toDtoActual(model);
        dto.setId(model.getId());
        dto.setMaterialTitle(model.getMaterialTitle());
        dto.setType(model.getType());
        dto.setSource(model.getSource());
        dto.setTheMaterialClassification(model.getTheMaterialClassification());
        dto.setTheFileSize(model.getTheFileSize());
        dto.setShootingTime(model.getShootingTime());
        dto.setSubordinateToTheResource(model.getSubordinateToTheResource());
        dto.setDescribe(model.getDescribe());
        dto.setAllRightsReserved(model.getAllRightsReserved());
        dto.setCopyright(model.getCopyright());
        dto.setFile(model.getFile());
        dto.setName(model.getName());
        return dto;
    }

    @Override
    public VirtualMaterial copyProperties(VirtualMaterial model, VirtualMaterialDto dto) {
        model = super.copyProperties(model, dto);
        model.setMaterialTitle(dto.getMaterialTitle());
        model.setType(dto.getType());
        model.setSource(dto.getSource());
        model.setTheMaterialClassification(dto.getTheMaterialClassification());
        model.setTheFileSize(dto.getTheFileSize());
        model.setShootingTime(dto.getShootingTime());
        model.setSubordinateToTheResource(dto.getSubordinateToTheResource());
        model.setDescribe(dto.getDescribe());
        model.setAllRightsReserved(dto.getAllRightsReserved());
        model.setCopyright(dto.getCopyright());
        model.setFile(dto.getFile());
        model.setName(dto.getName());
        return model;
    }

    @Override
    protected VirtualMaterialDto getDto() {
        return new VirtualMaterialDto();
    }
}
