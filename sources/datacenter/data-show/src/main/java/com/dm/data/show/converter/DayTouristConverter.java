package com.dm.data.show.converter;

import org.springframework.stereotype.Component;

import com.dm.kpi.core.converter.AbstractDayDataConverter;
import com.dm.data.show.dto.DayTouristDto;
import com.dm.data.show.entity.DayTourist;

@Component
public class DayTouristConverter extends AbstractDayDataConverter<DayTourist, DayTouristDto, Long> {

	@Override
	protected DayTouristDto getDto() {
		return new DayTouristDto();
	}





}