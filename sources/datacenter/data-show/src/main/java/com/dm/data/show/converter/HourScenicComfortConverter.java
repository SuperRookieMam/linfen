package com.dm.data.show.converter;

import org.springframework.stereotype.Component;

import com.dm.data.show.dto.HourScenicComfortDto;
import com.dm.data.show.entity.HourScenicComfort;
import com.dm.kpi.core.converter.AbstractHourDataConverter;

@Component
public class HourScenicComfortConverter extends AbstractHourDataConverter<HourScenicComfort, HourScenicComfortDto, Float> {

	@Override
	protected HourScenicComfortDto getDto() {
		return new HourScenicComfortDto();
	}

	@Override
	protected HourScenicComfortDto toDtoActual(HourScenicComfort model) {
		HourScenicComfortDto dto = super.toDtoActual(model);
    		dto.setName(model.getName());
		return dto;
	}

	@Override
	public HourScenicComfort copyProperties(HourScenicComfort model, HourScenicComfortDto dto) {
		HourScenicComfort model_ = super.copyProperties(model, dto);
		model_.setName(dto.getName());
		return model_;
	}

}