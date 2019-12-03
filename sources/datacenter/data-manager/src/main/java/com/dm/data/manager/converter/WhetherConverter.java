package com.dm.data.manager.converter;

import com.dm.data.manager.dto.WhetherDto;
import com.dm.data.manager.entity.Whether;
import org.springframework.stereotype.Component;

;

@Component
public class WhetherConverter extends AbstractBaseConverter<Whether, WhetherDto> {

    @Override
    protected WhetherDto toDtoActual(Whether model) {
        WhetherDto dto = super.toDtoActual(model);
        dto.setAirQuality(model.getAirQuality());
        dto.setArea(model.getArea());
        dto.setCity(model.getCity());
        dto.setDay(model.getDay());
        dto.setHoure(model.getHoure());
        dto.setId(model.getId());
        dto.setMonth(model.getMonth());
        dto.setPrecipitation(model.getPrecipitation());
        dto.setProvince(model.getProvince());
        dto.setScenic(model.getScenic());
        dto.setTemperatureMax(model.getTemperatureMax());
        dto.setTemperatureMin(model.getTemperatureMin());
        dto.setWhether(model.getWhether());
        dto.setWindPower(model.getWindPower());
        dto.setYear(model.getYear());
        dto.setRegionCode(model.getRegionCode());
        return dto;
    }

    @Override
    public Whether copyProperties(Whether model, WhetherDto dto) {
        model = super.copyProperties(model, dto);
        model.setAirQuality(dto.getAirQuality());
        model.setArea(dto.getArea());
        model.setCity(dto.getCity());
        model.setDay(dto.getDay());
        model.setHoure(dto.getHoure());
        model.setMonth(dto.getMonth());
        model.setPrecipitation(dto.getPrecipitation());
        model.setProvince(dto.getProvince());
        model.setScenic(dto.getScenic());
        model.setTemperatureMax(dto.getTemperatureMax());
        model.setTemperatureMin(dto.getTemperatureMin());
        model.setWhether(dto.getWhether());
        model.setWindPower(dto.getWindPower());
        model.setYear(dto.getYear());
        model.setRegionCode(dto.getRegionCode());
        return model;
    }

    @Override
    protected WhetherDto getDto() {
        return new WhetherDto();
    }
}
