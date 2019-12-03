package com.dm.data.show.converter;

import org.springframework.stereotype.Component;

import com.dm.kpi.core.converter.AbstractYearDataConverter;
import com.dm.data.show.dto.YearTouristAgeDto;
import com.dm.data.show.entity.YearTouristAge;

@Component
public class YearTouristAgeConverter extends AbstractYearDataConverter<YearTouristAge, YearTouristAgeDto, Long> {

	@Override
	protected YearTouristAgeDto getDto() {
		return new YearTouristAgeDto();
	}

	@Override
	protected YearTouristAgeDto toDtoActual(YearTouristAge model) {
		YearTouristAgeDto dto = super.toDtoActual(model);
    		dto.setName(model.getName());
		return dto;
	}

	@Override
	public YearTouristAge copyProperties(YearTouristAge model, YearTouristAgeDto dto) {
		YearTouristAge model_ = super.copyProperties(model, dto);
		model_.setName(dto.getName());
		return model_;
	}

}