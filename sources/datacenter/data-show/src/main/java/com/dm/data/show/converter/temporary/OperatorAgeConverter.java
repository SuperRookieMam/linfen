package com.dm.data.show.converter.temporary;

import org.springframework.stereotype.Component;

import com.dm.data.show.dto.temporary.OperatorAgeDto;
import com.dm.data.show.entity.temporary.OperatorAge;
import com.dm.kpi.core.converter.AbstractDayDataConverter;

@Component
public class OperatorAgeConverter extends AbstractDayDataConverter<OperatorAge, OperatorAgeDto, Integer> {

	@Override
	protected OperatorAgeDto getDto() {
		return new OperatorAgeDto();
	}

	@Override
	protected OperatorAgeDto toDtoActual(OperatorAge model) {
		OperatorAgeDto dto = super.toDtoActual(model);
    	dto.setName(model.getName());
		dto.setType(model.getType());
		return dto;
	}

	@Override
	public OperatorAge copyProperties(OperatorAge model, OperatorAgeDto dto) {
		OperatorAge model_ = super.copyProperties(model, dto);
		model_.setName(dto.getName());
		model_.setType(dto.getType());
		return model_;
	}

}