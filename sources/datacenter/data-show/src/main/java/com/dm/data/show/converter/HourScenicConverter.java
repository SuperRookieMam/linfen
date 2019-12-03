package com.dm.data.show.converter;

import org.springframework.stereotype.Component;

import com.dm.kpi.core.converter.AbstractHourDataConverter;
import com.dm.data.show.dto.HourScenicDto;
import com.dm.data.show.entity.HourScenic;

@Component
public class HourScenicConverter extends AbstractHourDataConverter<HourScenic, HourScenicDto, Long> {

	@Override
	protected HourScenicDto getDto() {
		return new HourScenicDto();
	}

	@Override
	protected HourScenicDto toDtoActual(HourScenic model) {
		HourScenicDto dto = super.toDtoActual(model);
    		dto.setName(model.getName());
		return dto;
	}

	@Override
	public HourScenic copyProperties(HourScenic model, HourScenicDto dto) {
		HourScenic model_ = super.copyProperties(model, dto);
		model_.setName(dto.getName());
		return model_;
	}

}