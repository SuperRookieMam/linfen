package com.dm.data.show.converter;

import org.springframework.stereotype.Component;

import com.dm.kpi.core.converter.AbstractDayDataConverter;
import com.dm.data.show.dto.DayHotelPriceDto;
import com.dm.data.show.entity.DayHotelPrice;

@Component
public class DayHotelPriceConverter extends AbstractDayDataConverter<DayHotelPrice, DayHotelPriceDto, Float> {

	@Override
	protected DayHotelPriceDto getDto() {
		return new DayHotelPriceDto();
	}

	@Override
	protected DayHotelPriceDto toDtoActual(DayHotelPrice model) {
		DayHotelPriceDto dto = super.toDtoActual(model);
    		dto.setName(model.getName());
		return dto;
	}

	@Override
	public DayHotelPrice copyProperties(DayHotelPrice model, DayHotelPriceDto dto) {
		DayHotelPrice model_ = super.copyProperties(model, dto);
		model_.setName(dto.getName());
		return model_;
	}

}