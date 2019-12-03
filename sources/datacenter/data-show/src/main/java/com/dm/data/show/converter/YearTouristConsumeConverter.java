package com.dm.data.show.converter;

import org.springframework.stereotype.Component;

import com.dm.kpi.core.converter.AbstractYearDataConverter;
import com.dm.data.show.dto.YearTouristConsumeDto;
import com.dm.data.show.entity.YearTouristConsume;

@Component
public class YearTouristConsumeConverter extends AbstractYearDataConverter<YearTouristConsume, YearTouristConsumeDto, Long> {

	@Override
	protected YearTouristConsumeDto getDto() {
		return new YearTouristConsumeDto();
	}

	@Override
	protected YearTouristConsumeDto toDtoActual(YearTouristConsume model) {
		YearTouristConsumeDto dto = super.toDtoActual(model);
    		dto.setName(model.getName());
		return dto;
	}

	@Override
	public YearTouristConsume copyProperties(YearTouristConsume model, YearTouristConsumeDto dto) {
		YearTouristConsume model_ = super.copyProperties(model, dto);
		model_.setName(dto.getName());
		return model_;
	}

}