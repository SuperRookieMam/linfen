package com.dm.data.show.converter;

import org.springframework.stereotype.Component;

import com.dm.kpi.core.converter.AbstractYearDataConverter;
import com.dm.data.show.dto.YearTouristDto;
import com.dm.data.show.entity.YearTourist;

@Component
public class YearTouristConverter extends AbstractYearDataConverter<YearTourist, YearTouristDto, Long> {

	@Override
	protected YearTouristDto getDto() {
		return new YearTouristDto();
	}





}