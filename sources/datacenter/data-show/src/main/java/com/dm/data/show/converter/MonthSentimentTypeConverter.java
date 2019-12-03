package com.dm.data.show.converter;

import org.springframework.stereotype.Component;

import com.dm.kpi.core.converter.AbstractMonthDataConverter;
import com.dm.data.show.dto.MonthSentimentTypeDto;
import com.dm.data.show.entity.MonthSentimentType;

@Component
public class MonthSentimentTypeConverter extends AbstractMonthDataConverter<MonthSentimentType, MonthSentimentTypeDto, Long> {

	@Override
	protected MonthSentimentTypeDto getDto() {
		return new MonthSentimentTypeDto();
	}

	@Override
	protected MonthSentimentTypeDto toDtoActual(MonthSentimentType model) {
		MonthSentimentTypeDto dto = super.toDtoActual(model);
    		dto.setName(model.getName());
		return dto;
	}

	@Override
	public MonthSentimentType copyProperties(MonthSentimentType model, MonthSentimentTypeDto dto) {
		MonthSentimentType model_ = super.copyProperties(model, dto);
		model_.setName(dto.getName());
		return model_;
	}

}