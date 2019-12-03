package com.dm.data.show.converter;

import org.springframework.stereotype.Component;

import com.dm.kpi.core.converter.AbstractMonthDataConverter;
import com.dm.data.show.dto.MonthTouristDto;
import com.dm.data.show.entity.MonthTourist;

@Component
public class MonthTouristConverter extends AbstractMonthDataConverter<MonthTourist, MonthTouristDto, Long> {

	@Override
	protected MonthTouristDto getDto() {
		return new MonthTouristDto();
	}





}