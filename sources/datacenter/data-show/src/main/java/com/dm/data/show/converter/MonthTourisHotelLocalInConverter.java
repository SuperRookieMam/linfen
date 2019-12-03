package com.dm.data.show.converter;

import org.springframework.stereotype.Component;

import com.dm.kpi.core.converter.AbstractMonthDataConverter;
import com.dm.data.show.dto.MonthTourisHotelLocalInDto;
import com.dm.data.show.entity.MonthTourisHotelLocalIn;

@Component
public class MonthTourisHotelLocalInConverter extends AbstractMonthDataConverter<MonthTourisHotelLocalIn, MonthTourisHotelLocalInDto, Long> {

	@Override
	protected MonthTourisHotelLocalInDto getDto() {
		return new MonthTourisHotelLocalInDto();
	}

	@Override
	protected MonthTourisHotelLocalInDto toDtoActual(MonthTourisHotelLocalIn model) {
		MonthTourisHotelLocalInDto dto = super.toDtoActual(model);
    		dto.setName(model.getName());
		return dto;
	}

	@Override
	public MonthTourisHotelLocalIn copyProperties(MonthTourisHotelLocalIn model, MonthTourisHotelLocalInDto dto) {
		MonthTourisHotelLocalIn model_ = super.copyProperties(model, dto);
		model_.setName(dto.getName());
		return model_;
	}

}