package com.dm.data.show.converter;

import org.springframework.stereotype.Component;

import com.dm.kpi.core.converter.AbstractYearDataConverter;
import com.dm.data.show.dto.YearCityDto;
import com.dm.data.show.entity.YearCity;

@Component
public class YearCityConverter extends AbstractYearDataConverter<YearCity, YearCityDto, Long> {

	@Override
	protected YearCityDto getDto() {
		return new YearCityDto();
	}

	@Override
	protected YearCityDto toDtoActual(YearCity model) {
		YearCityDto dto = super.toDtoActual(model);
    		dto.setName(model.getName());
		return dto;
	}

	@Override
	public YearCity copyProperties(YearCity model, YearCityDto dto) {
		YearCity model_ = super.copyProperties(model, dto);
		model_.setName(dto.getName());
		return model_;
	}

}