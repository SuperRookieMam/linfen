package com.dm.data.show.converter;

import org.springframework.stereotype.Component;

import com.dm.kpi.core.converter.AbstractDayDataConverter;
import com.dm.data.show.dto.DayScenicDto;
import com.dm.data.show.entity.DayScenic;

@Component
public class DayScenicConverter extends AbstractDayDataConverter<DayScenic, DayScenicDto, Long> {

	@Override
	protected DayScenicDto getDto() {
		return new DayScenicDto();
	}

	@Override
	protected DayScenicDto toDtoActual(DayScenic model) {
		DayScenicDto dto = super.toDtoActual(model);
    		dto.setName(model.getName());
		return dto;
	}

	@Override
	public DayScenic copyProperties(DayScenic model, DayScenicDto dto) {
		DayScenic model_ = super.copyProperties(model, dto);
		model_.setName(dto.getName());
		return model_;
	}

}