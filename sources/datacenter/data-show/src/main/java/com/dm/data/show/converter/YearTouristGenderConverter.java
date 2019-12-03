package com.dm.data.show.converter;

import org.springframework.stereotype.Component;

import com.dm.kpi.core.converter.AbstractYearDataConverter;
import com.dm.data.show.dto.YearTouristGenderDto;
import com.dm.data.show.entity.YearTouristGender;

@Component
public class YearTouristGenderConverter extends AbstractYearDataConverter<YearTouristGender, YearTouristGenderDto, Long> {

	@Override
	protected YearTouristGenderDto getDto() {
		return new YearTouristGenderDto();
	}

	@Override
	protected YearTouristGenderDto toDtoActual(YearTouristGender model) {
		YearTouristGenderDto dto = super.toDtoActual(model);
    		dto.setName(model.getName());
		return dto;
	}

	@Override
	public YearTouristGender copyProperties(YearTouristGender model, YearTouristGenderDto dto) {
		YearTouristGender model_ = super.copyProperties(model, dto);
		model_.setName(dto.getName());
		return model_;
	}

}