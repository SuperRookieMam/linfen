package com.dm.data.show.converter;

import org.springframework.stereotype.Component;

import com.dm.kpi.core.converter.AbstractYearDataConverter;
import com.dm.data.show.dto.YearTouristStayDto;
import com.dm.data.show.entity.YearTouristStay;

@Component
public class YearTouristStayConverter extends AbstractYearDataConverter<YearTouristStay, YearTouristStayDto, Long> {

	@Override
	protected YearTouristStayDto getDto() {
		return new YearTouristStayDto();
	}

	@Override
	protected YearTouristStayDto toDtoActual(YearTouristStay model) {
		YearTouristStayDto dto = super.toDtoActual(model);
    		dto.setName(model.getName());
		return dto;
	}

	@Override
	public YearTouristStay copyProperties(YearTouristStay model, YearTouristStayDto dto) {
		YearTouristStay model_ = super.copyProperties(model, dto);
		model_.setName(dto.getName());
		return model_;
	}

}