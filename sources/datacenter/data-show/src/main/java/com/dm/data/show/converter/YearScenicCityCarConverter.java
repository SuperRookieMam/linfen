package com.dm.data.show.converter;

import org.springframework.stereotype.Component;

import com.dm.kpi.core.converter.AbstractYearDataConverter;
import com.dm.data.show.dto.YearScenicCityCarDto;
import com.dm.data.show.entity.YearScenicCityCar;

@Component
public class YearScenicCityCarConverter extends AbstractYearDataConverter<YearScenicCityCar, YearScenicCityCarDto, Long> {

	@Override
	protected YearScenicCityCarDto getDto() {
		return new YearScenicCityCarDto();
	}

	@Override
	protected YearScenicCityCarDto toDtoActual(YearScenicCityCar model) {
		YearScenicCityCarDto dto = super.toDtoActual(model);
    		dto.setName(model.getName());
		dto.setCityName(model.getCityName());
		return dto;
	}

	@Override
	public YearScenicCityCar copyProperties(YearScenicCityCar model, YearScenicCityCarDto dto) {
		YearScenicCityCar model_ = super.copyProperties(model, dto);
		model_.setName(dto.getName());
		model_.setCityName(dto.getCityName());
		return model_;
	}

}