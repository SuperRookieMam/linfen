package com.dm.data.show.converter.temporary;

import org.springframework.stereotype.Component;

import com.dm.data.show.dto.temporary.AccessDto;
import com.dm.data.show.entity.temporary.Access;
import com.dm.kpi.core.converter.AbstractHourDataConverter;

@Component
public class AccessConverter extends AbstractHourDataConverter<Access, AccessDto, Integer> {

	@Override
	protected AccessDto getDto() {
		return new AccessDto();
	}

	@Override
	protected AccessDto toDtoActual(Access model) {
		AccessDto dto = super.toDtoActual(model);
    	dto.setName(model.getName());
		dto.setType(model.getType());
		dto.setDayValue(model.getDayValue());
		return dto;
	}

	@Override
	public Access copyProperties(Access model, AccessDto dto) {
		Access model_ = super.copyProperties(model, dto);
		model_.setName(dto.getName());
		model_.setType(dto.getType());
		model_.setDayValue(dto.getDayValue());
		return model_;
	}

}