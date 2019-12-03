package com.dm.data.show.converter;

import org.springframework.stereotype.Component;

import com.dm.kpi.core.converter.AbstractYearDataConverter;
import com.dm.data.show.dto.YearTouristHotelDto;
import com.dm.data.show.entity.YearTouristHotel;

@Component
public class YearTouristHotelConverter extends AbstractYearDataConverter<YearTouristHotel, YearTouristHotelDto, Long> {

	@Override
	protected YearTouristHotelDto getDto() {
		return new YearTouristHotelDto();
	}

	@Override
	protected YearTouristHotelDto toDtoActual(YearTouristHotel model) {
		YearTouristHotelDto dto = super.toDtoActual(model);
    		dto.setName(model.getName());
		return dto;
	}

	@Override
	public YearTouristHotel copyProperties(YearTouristHotel model, YearTouristHotelDto dto) {
		YearTouristHotel model_ = super.copyProperties(model, dto);
		model_.setName(dto.getName());
		return model_;
	}

}