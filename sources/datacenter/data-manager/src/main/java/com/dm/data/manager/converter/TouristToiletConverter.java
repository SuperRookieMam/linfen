package com.dm.data.manager.converter;

import com.dm.data.manager.dto.TouristToiletDto;
import com.dm.data.manager.entity.TouristToilet;
import org.springframework.stereotype.Component;

@Component
public class TouristToiletConverter extends AbstractBaseConverter<TouristToilet, TouristToiletDto> {

    @Override
    protected TouristToiletDto toDtoActual(TouristToilet model) {
        TouristToiletDto dto = super.toDtoActual(model);
        dto.setNo(model.getNo());
        dto.setRegionCode(model.getRegionCode());
        dto.setLatitude(model.getLatitude());
        dto.setLongitude(model.getLongitude());
        dto.setId(model.getId());
        dto.setFullname(model.getFullname());
        dto.setShortName(model.getShortName());
        dto.setPinYin(model.getPinYin());
        dto.setEnglishName(model.getEnglishName());
        dto.setRegion(model.getRegion());
        dto.setLocation(model.getLocation());
        dto.setAddress(model.getAddress());
        dto.setTouristToiletGrade(model.getTouristToiletGrade());
        dto.setPoliceStationPhone(model.getPoliceStationPhone());
        dto.setCharges(model.getCharges());
        dto.setRelatedScenics(model.getRelatedScenics());
        dto.setHotIndex(model.getHotIndex());
        return dto;
    }

    @Override
    public TouristToilet copyProperties(TouristToilet model, TouristToiletDto dto) {
        model = super.copyProperties(model, dto);
        model.setNo(dto.getNo());
        model.setRegionCode(dto.getRegionCode());

        model.setFullname(dto.getFullname());
        model.setShortName(dto.getShortName());
        model.setPinYin(dto.getPinYin());
        model.setEnglishName(dto.getEnglishName());
        model.setRegion(dto.getRegion());
        model.setLatitude(dto.getLatitude());
        model.setLongitude(dto.getLongitude());
        model.setLocation(dto.getLocation());
        model.setAddress(dto.getAddress());
        model.setTouristToiletGrade(dto.getTouristToiletGrade());
        model.setPoliceStationPhone(dto.getPoliceStationPhone());
        model.setCharges(dto.getCharges());
        model.setRelatedScenics(dto.getRelatedScenics());
        model.setHotIndex(dto.getHotIndex());
        return model;
    }

    @Override
    protected TouristToiletDto getDto() {
        return new TouristToiletDto();
    }
}
