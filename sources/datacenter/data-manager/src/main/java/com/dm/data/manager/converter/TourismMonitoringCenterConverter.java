package com.dm.data.manager.converter;

import com.dm.data.manager.dto.TourismMonitoringCenterDto;
import com.dm.data.manager.entity.TourismMonitoringCenter;
import org.springframework.stereotype.Component;

@Component
public class TourismMonitoringCenterConverter
        extends AbstractBaseConverter<TourismMonitoringCenter, TourismMonitoringCenterDto> {

    @Override
    protected TourismMonitoringCenterDto toDtoActual(TourismMonitoringCenter model) {
        TourismMonitoringCenterDto dto = super.toDtoActual(model);
        dto.setNo(model.getNo());
        dto.setRegionCode(model.getRegionCode());
        dto.setId(model.getId());
        dto.setMonitorPointName(model.getMonitorPointName());
        dto.setSubordinateDepartments(model.getSubordinateDepartments());
        dto.setTheLinkAddress(model.getTheLinkAddress());
        dto.setPort(model.getPort());
        dto.setTheUserName(model.getTheUserName());
        dto.setPassword(model.getPassword());
        dto.setLongitude(model.getLongitude());
        dto.setLatitude(model.getLatitude());
        dto.setAddress(model.getAddress());
        dto.setTheSerialNumber(model.getTheSerialNumber());
        dto.setBrand(model.getBrand());
        dto.setDisplay(model.getDisplay());
        dto.setPlayTheWay(model.getPlayTheWay());
        dto.setWhetherTheMainVideo(model.getWhetherTheMainVideo());
        dto.setClarity(model.getClarity());
        dto.setType(model.getType());
        dto.setVideoImages(model.getVideoImages());
        dto.setIntroduction(model.getIntroduction());
        return dto;
    }

    @Override
    public TourismMonitoringCenter copyProperties(TourismMonitoringCenter model, TourismMonitoringCenterDto dto) {
        model = super.copyProperties(model, dto);
        model.setNo(dto.getNo());
        model.setRegionCode(dto.getRegionCode());

        model.setMonitorPointName(dto.getMonitorPointName());
        model.setSubordinateDepartments(dto.getSubordinateDepartments());
        model.setTheLinkAddress(dto.getTheLinkAddress());
        model.setPort(dto.getPort());
        model.setTheUserName(dto.getTheUserName());
        model.setPassword(dto.getPassword());
        // model.setArea(dto.getArea());
        model.setLongitude(dto.getLongitude());
        model.setLatitude(dto.getLatitude());
        model.setAddress(dto.getAddress());
        model.setTheSerialNumber(dto.getTheSerialNumber());
        model.setBrand(dto.getBrand());
        model.setDisplay(dto.getDisplay());
        model.setPlayTheWay(dto.getPlayTheWay());
        model.setWhetherTheMainVideo(dto.getWhetherTheMainVideo());
        model.setClarity(dto.getClarity());
        model.setType(dto.getType());
        model.setVideoImages(dto.getVideoImages());
        model.setIntroduction(dto.getIntroduction());
        return model;
    }

    @Override
    protected TourismMonitoringCenterDto getDto() {
        return new TourismMonitoringCenterDto();
    }
}
