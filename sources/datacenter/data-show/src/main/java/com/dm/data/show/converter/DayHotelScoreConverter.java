package com.dm.data.show.converter;

import org.springframework.stereotype.Component;

import com.dm.kpi.core.converter.AbstractDayDataConverter;
import com.dm.data.show.dto.DayHotelScoreDto;
import com.dm.data.show.entity.DayHotelScore;

@Component
public class DayHotelScoreConverter extends AbstractDayDataConverter<DayHotelScore, DayHotelScoreDto, Float> {

	@Override
	protected DayHotelScoreDto getDto() {
		return new DayHotelScoreDto();
	}

	@Override
	protected DayHotelScoreDto toDtoActual(DayHotelScore model) {
		DayHotelScoreDto dto = super.toDtoActual(model);
    		dto.setName(model.getName());
		return dto;
	}

	@Override
	public DayHotelScore copyProperties(DayHotelScore model, DayHotelScoreDto dto) {
		DayHotelScore model_ = super.copyProperties(model, dto);
		model_.setName(dto.getName());
		return model_;
	}

}