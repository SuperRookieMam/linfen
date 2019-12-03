package com.dm.kpi.converter;

import org.springframework.stereotype.Component;

import com.dm.kpi.core.converter.AbstractDayDataConverter;
import com.dm.kpi.dto.DayWeatherDto;
import com.dm.kpi.entity.DayWeather;

/**
 * Copyright (c) 2019 江苏云智网络科技股份有限公司版权所有
 * @author: 李轲
 * @Date: 2019-09-05 17:41:08
 * @Description: 
 * @History 
 */
@Component
public class DayWeatherConverter extends AbstractDayDataConverter<DayWeather, DayWeatherDto, Integer> {

	@Override
	protected DayWeatherDto getDto() {
		return new DayWeatherDto();
	}

	@Override
	public DayWeather copyProperties(DayWeather model, DayWeatherDto dto) {
		DayWeather dayWeather = super.copyProperties(model, dto);
		dayWeather.setDistrictId(dto.getDistrictId());
		dayWeather.setFutureDate(dto.getFutureDate());
		dayWeather.setWeather(dto.getWeather());
		dayWeather.setTempMax(dto.getTempMax());
		dayWeather.setTempMin(dto.getTempMin());
		dayWeather.setDayWindDirection(dto.getDayWindDirection());
		dayWeather.setNightWindDirection(dto.getNightWindDirection());
		dayWeather.setWindScale(dto.getWindScale());
		return dayWeather;
	}

	@Override
	protected DayWeatherDto toDtoActual(DayWeather model) {
		DayWeatherDto dto = super.toDtoActual(model);
		dto.setDistrictId(model.getDistrictId());
		dto.setFutureDate(model.getFutureDate());
		dto.setWeather(model.getWeather());
		dto.setTempMax(model.getTempMax());
		dto.setTempMin(model.getTempMin());
		dto.setDayWindDirection(model.getDayWindDirection());
		dto.setNightWindDirection(model.getNightWindDirection());
		dto.setWindScale(model.getWindScale());
		return dto;
	}

	
}


