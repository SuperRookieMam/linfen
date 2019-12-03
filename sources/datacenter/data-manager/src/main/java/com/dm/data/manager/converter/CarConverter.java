package com.dm.data.manager.converter;

import com.dm.data.manager.dto.CarDto;
import com.dm.data.manager.entity.Car;
import org.springframework.stereotype.Component;

@Component
public class CarConverter extends AbstractBaseConverter<Car, CarDto> {

    @Override
    protected CarDto toDtoActual(Car model) {
        CarDto dto = super.toDtoActual(model);
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
        dto.setRegistryDate(model.getRegistryDate());
        dto.setRepresentativeOwner(model.getRepresentativeOwner());
        dto.setContactPeople(model.getContactPeople());
        dto.setContact(model.getContact());
        dto.setContactAddress(model.getContactAddress());
        dto.setSafeDrivingMileage(model.getSafeDrivingMileage());
        dto.setChargeStandard(model.getChargeStandard());
        return dto;
    }

    @Override
    public Car copyProperties(Car model, CarDto dto) {
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
        model.setRegistryDate(dto.getRegistryDate());
        model.setRepresentativeOwner(dto.getRepresentativeOwner());
        model.setContactPeople(dto.getContactPeople());
        model.setContact(dto.getContact());
        model.setContactAddress(dto.getContactAddress());
        model.setSafeDrivingMileage(dto.getSafeDrivingMileage());
        model.setChargeStandard(dto.getChargeStandard());
        return model;
    }

    @Override
    protected CarDto getDto() {
        return new CarDto();
    }
}
