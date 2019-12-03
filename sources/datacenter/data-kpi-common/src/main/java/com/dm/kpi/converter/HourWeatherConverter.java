package com.dm.kpi.converter;

import com.dm.kpi.core.converter.AbstractHourDataConverter;
import com.dm.kpi.dto.HourWeatherDto;
import com.dm.kpi.entity.HourWeather;
import org.springframework.stereotype.Component;

@Component
public class HourWeatherConverter extends AbstractHourDataConverter<HourWeather, HourWeatherDto, Integer> {

    @Override
    protected HourWeatherDto getDto() {
        return new HourWeatherDto();
    }

    @Override
    public HourWeather copyProperties(HourWeather model, HourWeatherDto dto) {
        HourWeather result = super.copyProperties(model, dto);
        result.setPointName(dto.getPointName());
        result.setPrecipitation(dto.getPrecipitation());
        result.setRegionCode(dto.getRegionCode());
        result.setRegionName(dto.getRegionName());
        result.setTempMax(dto.getTempMax());
        result.setTempMin(dto.getTempMin());
        result.setWhether(dto.getWhether());
        result.setTemperature(dto.getTemperature());
        result.setHumidity(dto.getHumidity());
        result.setPrecipitation(dto.getPrecipitation());
        result.setWindScale(dto.getWindScale());
        result.setWindDirection(dto.getWindDirection());
        result.setDistrictId(dto.getDistrictId());
        return result;
    }

    @Override
    protected HourWeatherDto toDtoActual(HourWeather model) {
        HourWeatherDto result = super.toDtoActual(model);
        result.setPointName(model.getPointName());
        result.setPrecipitation(model.getPrecipitation());
        result.setRegionCode(model.getRegionCode());
        result.setRegionName(model.getRegionName());
        result.setTempMax(model.getTempMax());
        result.setTempMin(model.getTempMin());
        result.setWhether(model.getWhether());
        result.setWindDirection(model.getWindDirection());
        result.setWindScale(model.getWindScale());
        result.setDistrictId(model.getDistrictId());
        result.setTemperature(model.getTemperature());
        result.setHumidity(model.getHumidity());
        result.setPrecipitation(model.getPrecipitation());
        result.setWindScale(model.getWindScale());
        result.setWindDirection(model.getWindDirection());
        return result;
    }

}
