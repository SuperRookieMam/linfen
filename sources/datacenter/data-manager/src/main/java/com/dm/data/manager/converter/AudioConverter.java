package com.dm.data.manager.converter;

import com.dm.data.manager.dto.AudioDto;
import com.dm.data.manager.entity.Audio;
import org.springframework.stereotype.Component;

@Component
public class AudioConverter extends AbstractBaseConverter<Audio, AudioDto> {

    @Override
    protected AudioDto toDtoActual(Audio model) {
        AudioDto dto = super.toDtoActual(model);
        dto.setId(model.getId());
        dto.setAudioTitle(model.getAudioTitle());
        dto.setType(model.getType());
        dto.setSource(model.getSource());
        dto.setAudioFormats(model.getAudioFormats());
        dto.setTheFileSize(model.getTheFileSize());
        dto.setTheAudioTime(model.getTheAudioTime());
        dto.setTheRecordingTime(model.getTheRecordingTime());
        dto.setSubordinateToTheResource(model.getSubordinateToTheResource());
        dto.setDescribe(model.getDescribe());
        dto.setAllRightsReserved(model.getAllRightsReserved());
        dto.setCopyright(model.getCopyright());
        dto.setName(model.getName());
        dto.setFile(model.getFile());
        return dto;
    }

    @Override
    public Audio copyProperties(Audio model, AudioDto dto) {
        model = super.copyProperties(model, dto);
        model.setAudioTitle(dto.getAudioTitle());
        model.setType(dto.getType());
        model.setSource(dto.getSource());
        model.setAudioFormats(dto.getAudioFormats());
        model.setTheFileSize(dto.getTheFileSize());
        model.setTheAudioTime(dto.getTheAudioTime());
        model.setTheRecordingTime(dto.getTheRecordingTime());
        model.setSubordinateToTheResource(dto.getSubordinateToTheResource());
        model.setDescribe(dto.getDescribe());
        model.setAllRightsReserved(dto.getAllRightsReserved());
        model.setCopyright(dto.getCopyright());
        model.setFile(dto.getFile());
        model.setName(dto.getName());
        return model;
    }

    @Override
    protected AudioDto getDto() {
        return new AudioDto();
    }
}
