package com.dm.data.show.converter;

import org.springframework.stereotype.Component;

import com.dm.kpi.core.converter.AbstractYearDataConverter;
import com.dm.data.show.dto.YearFeelingDto;
import com.dm.data.show.entity.YearFeeling;

@Component
public class YearFeelingConverter extends AbstractYearDataConverter<YearFeeling, YearFeelingDto, Float> {

	@Override
	protected YearFeelingDto getDto() {
		return new YearFeelingDto();
	}





}