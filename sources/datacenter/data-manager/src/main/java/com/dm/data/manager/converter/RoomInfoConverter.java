package com.dm.data.manager.converter;

import com.dm.data.manager.dto.RoomInfoDto;
import com.dm.data.manager.entity.Image;
import com.dm.data.manager.entity.RoomInfo;
import com.dm.data.manager.entity.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class RoomInfoConverter extends AbstractBaseConverter<RoomInfo, RoomInfoDto> {

    @Autowired
    private ImageConverter imageConverter;
    @Autowired
    private VideoConverter videoConverter;

    @Override
    protected RoomInfoDto toDtoActual(RoomInfo model) {
        RoomInfoDto dto = super.toDtoActual(model);
        dto.setRegionCode(model.getRegionCode());
        dto.setAccommodationId(model.getAccommodationId());
        dto.setCanBookARoom(model.getCanBookARoom());
        dto.setEatDescription(model.getEatDescription());
        dto.setExtraBedPrice(model.getExtraBedPrice());
        dto.setHolidayPrices(model.getHolidayPrices());
        dto.setNormalPrice(model.getNormalPrice());
        dto.setRoomNumber(model.getRoomNumber());
        dto.setRoomType(model.getRoomType());
        dto.setServicesDescribed(model.getServicesDescribed());
        dto.setId(model.getId());
        dto.setImages(imageConverter.toDto(model.getImages()));
        dto.setVideos(videoConverter.toDto(model.getVideos()));
        return dto;
    }

    @Override
    public RoomInfo copyProperties(RoomInfo model, RoomInfoDto dto) {
        model = super.copyProperties(model, dto);
        model.setRegionCode(dto.getRegionCode());
        model.setAccommodationId(dto.getAccommodationId());
        model.setCanBookARoom(dto.getCanBookARoom());
        model.setEatDescription(dto.getEatDescription());
        model.setExtraBedPrice(dto.getExtraBedPrice());
        model.setHolidayPrices(dto.getHolidayPrices());
        model.setNormalPrice(dto.getNormalPrice());
        model.setRoomNumber(dto.getRoomNumber());
        model.setRoomType(dto.getRoomType());
        model.setServicesDescribed(dto.getServicesDescribed());
        model.setImages(dto.getImages().stream().map(ele -> {
            return imageConverter.copyProperties(new Image(), ele);
        }).collect(Collectors.toList()));
        model.setVideos(dto.getVideos().stream().map(ele -> {
            return videoConverter.copyProperties(new Video(), ele);
        }).collect(Collectors.toList()));

        return model;
    }

    @Override
    protected RoomInfoDto getDto() {
        return new RoomInfoDto();
    }
}
