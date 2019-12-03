package com.dm.data.show.converter;

import org.springframework.stereotype.Component;

import com.dm.kpi.core.converter.AbstractYearDataConverter;
import com.dm.data.show.dto.YearTouristHolidayDto;
import com.dm.data.show.entity.YearTouristHoliday;

@Component
public class YearTouristHolidayConverter extends AbstractYearDataConverter<YearTouristHoliday, YearTouristHolidayDto, Long> {

	@Override
	protected YearTouristHolidayDto getDto() {
		return new YearTouristHolidayDto();
	}





}