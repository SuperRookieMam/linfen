package com.dm.data.manager.converter;

import com.dm.data.manager.dto.ImageDto;
import com.dm.data.manager.entity.Image;
import org.springframework.stereotype.Component;

@Component
public class ImageConverter extends AbstractBaseConverter<Image, ImageDto> {

    @Override
    protected ImageDto toDtoActual(Image model) {
        ImageDto dto = super.toDtoActual(model);
        dto.setId(model.getId());
        dto.setPictureCaptions(model.getPictureCaptions());
        dto.setType(model.getType());
        dto.setSource(model.getSource());
        dto.setImageFormat(model.getImageFormat());
        dto.setTheFileSize(model.getTheFileSize());
        dto.setShootingTime(model.getShootingTime());
        dto.setIfTheSourceFile(model.getIfTheSourceFile());
        dto.setSubordinateToTheResource(model.getSubordinateToTheResource());
        dto.setDescribe(model.getDescribe());
        dto.setAllRightsReserved(model.getAllRightsReserved());
        dto.setCopyright(model.getCopyright());
        dto.setFile(model.getFile());
        dto.setName(model.getName());
        dto.setShow(model.isShow());
        return dto;
    }

    @Override
    public Image copyProperties(Image model, ImageDto dto) {
        model = super.copyProperties(model, dto);
        model.setPictureCaptions(dto.getPictureCaptions());
        model.setType(dto.getType());
        model.setSource(dto.getSource());
        model.setImageFormat(dto.getImageFormat());
        model.setTheFileSize(dto.getTheFileSize());
        model.setShootingTime(dto.getShootingTime());
        model.setIfTheSourceFile(dto.getIfTheSourceFile());
        model.setSubordinateToTheResource(dto.getSubordinateToTheResource());
        model.setDescribe(dto.getDescribe());
        model.setAllRightsReserved(dto.getAllRightsReserved());
        model.setCopyright(dto.getCopyright());
        model.setFile(dto.getFile());
        model.setName(dto.getName());
        model.setShow(dto.isShow());
        return model;
    }

    @Override
    protected ImageDto getDto() {
        return new ImageDto();
    }
}
