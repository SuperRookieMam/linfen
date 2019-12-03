package com.dm.data.manager.converter;

import com.dm.data.manager.dto.TourBusServiceDto;
import com.dm.data.manager.entity.TourBusService;
import org.springframework.stereotype.Component;

@Component
public class TourBusServiceConverter extends AbstractBaseConverter<TourBusService, TourBusServiceDto> {

    @Override
    protected TourBusServiceDto toDtoActual(TourBusService model) {
        TourBusServiceDto dto = super.toDtoActual(model);
        dto.setId(model.getId());
        dto.setPlateNo(model.getPlateNo());
        dto.setBrand(model.getBrand());
        dto.setModel(model.getModel());
        dto.setAccurateLoadCount(model.getAccurateLoadCount());
        dto.setSeatingCount(model.getSeatingCount());
        dto.setColor(model.getColor());
        dto.setEngineNo(model.getEngineNo());
        dto.setVin(model.getVin());
        dto.setCarThrough(model.getCarThrough());
        dto.setMainLines(model.getMainLines());
        dto.setDepartureTime(model.getDepartureTime());
        dto.setArrivalTime(model.getArrivalTime());
        dto.setThroughCities(model.getThroughCities());
        dto.setMileage(model.getMileage());
        dto.setTicketNotice(model.getTicketNoties());
        return dto;
    }

    @Override
    public TourBusService copyProperties(TourBusService model, TourBusServiceDto dto) {
        model = super.copyProperties(model, dto);
        model.setPlateNo(dto.getPlateNo());
        model.setBrand(dto.getBrand());
        model.setModel(dto.getModel());
        model.setAccurateLoadCount(dto.getAccurateLoadCount());
        model.setSeatingCount(dto.getSeatingCount());
        model.setColor(dto.getColor());
        model.setEngineNo(dto.getEngineNo());
        model.setVin(dto.getVin());
        model.setCarThrough(dto.getCarThrough());
        model.setMainLines(dto.getMainLines());
        model.setDepartureTime(dto.getDepartureTime());
        model.setArrivalTime(dto.getArrivalTime());
        model.setThroughCities(dto.getThroughCities());
        model.setMileage(dto.getMileage());
        model.setTicketNoties(dto.getTicketNotice());
        return model;
    }

    @Override
    protected TourBusServiceDto getDto() {
        return new TourBusServiceDto();
    }
}
