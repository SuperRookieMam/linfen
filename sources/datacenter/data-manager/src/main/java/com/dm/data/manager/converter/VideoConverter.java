package com.dm.data.manager.converter;

import com.dm.data.manager.dto.VideoDto;
import com.dm.data.manager.entity.Video;
import org.springframework.stereotype.Component;

@Component
public class VideoConverter extends AbstractBaseConverter<Video, VideoDto> {

    @Override
    protected VideoDto toDtoActual(Video model) {
        VideoDto dto = super.toDtoActual(model);
        dto.setId(model.getId());
        dto.setType(model.getType());
        dto.setSource(model.getSource());
        dto.setVideoSpecifications(model.getVideoSpecifications());
        dto.setVideoFormat(model.getVideoFormat());
        dto.setTheFileSize(model.getTheFileSize());
        dto.setTheVideoTime(model.getTheVideoTime());
        dto.setShootingTime(model.getShootingTime());
        dto.setSubordinateToTheResource(model.getSubordinateToTheResource());
        dto.setDescribe(model.getDescribe());
        dto.setAllRightsReserved(model.getAllRightsReserved());
        dto.setCopyright(model.getCopyright());
        dto.setFile(model.getFile());
        dto.setName(model.getName());
        dto.setShow(model.isShow());
        dto.setTitle(model.getTitle());
        return dto;
    }

    @Override
    public Video copyProperties(Video model, VideoDto dto) {
        model = super.copyProperties(model, dto);
        model.setType(dto.getType());
        model.setSource(dto.getSource());
        model.setVideoSpecifications(dto.getVideoSpecifications());
        model.setVideoFormat(dto.getVideoFormat());
        model.setTheFileSize(dto.getTheFileSize());
        model.setTheVideoTime(dto.getTheVideoTime());
        model.setShootingTime(dto.getShootingTime());
        model.setSubordinateToTheResource(dto.getSubordinateToTheResource());
        model.setDescribe(dto.getDescribe());
        model.setAllRightsReserved(dto.getAllRightsReserved());
        model.setCopyright(dto.getCopyright());
        model.setFile(dto.getFile());
        model.setName(dto.getName());
        model.setTitle(dto.getTitle());
        model.setShow(dto.isShow());
        return model;
    }

    @Override
    protected VideoDto getDto() {
        return new VideoDto();
    }
}
