package com.dm.data.show.converter;

import org.springframework.stereotype.Component;

import com.dm.kpi.core.converter.AbstractYearDataConverter;
import com.dm.data.show.dto.YearTouristHolidayTypeDto;
import com.dm.data.show.entity.YearTouristHolidayType;

@Component
public class YearTouristHolidayTypeConverter extends AbstractYearDataConverter<YearTouristHolidayType, YearTouristHolidayTypeDto, Long> {

	@Override
	protected YearTouristHolidayTypeDto getDto() {
		return new YearTouristHolidayTypeDto();
	}

	@Override
	protected YearTouristHolidayTypeDto toDtoActual(YearTouristHolidayType model) {
		YearTouristHolidayTypeDto dto = super.toDtoActual(model);
    		dto.setName(model.getName());
		return dto;
	}

	@Override
	public YearTouristHolidayType copyProperties(YearTouristHolidayType model, YearTouristHolidayTypeDto dto) {
		YearTouristHolidayType model_ = super.copyProperties(model, dto);
		model_.setName(dto.getName());
		return model_;
	}

}