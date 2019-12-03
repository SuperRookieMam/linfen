package com.dm.data.show.converter;

import org.springframework.stereotype.Component;

import com.dm.kpi.core.converter.AbstractYearDataConverter;
import com.dm.data.show.dto.YearTouristInDto;
import com.dm.data.show.entity.YearTouristIn;

@Component
public class YearTouristInConverter extends AbstractYearDataConverter<YearTouristIn, YearTouristInDto, Long> {

	@Override
	protected YearTouristInDto getDto() {
		return new YearTouristInDto();
	}

	@Override
	protected YearTouristInDto toDtoActual(YearTouristIn model) {
		YearTouristInDto dto = super.toDtoActual(model);
    		dto.setName(model.getName());
		return dto;
	}

	@Override
	public YearTouristIn copyProperties(YearTouristIn model, YearTouristInDto dto) {
		YearTouristIn model_ = super.copyProperties(model, dto);
		model_.setName(dto.getName());
		return model_;
	}

}