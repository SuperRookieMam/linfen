package com.dm.data.show.converter.temporary;

import org.springframework.stereotype.Component;

import com.dm.data.show.dto.temporary.OperatorGenderDto;
import com.dm.data.show.entity.temporary.OperatorGender;
import com.dm.kpi.core.converter.AbstractDayDataConverter;

@Component
public class OperatorGenderConverter extends AbstractDayDataConverter<OperatorGender, OperatorGenderDto, Integer> {

	@Override
	protected OperatorGenderDto getDto() {
		return new OperatorGenderDto();
	}

	@Override
	protected OperatorGenderDto toDtoActual(OperatorGender model) {
		OperatorGenderDto dto = super.toDtoActual(model);
    	dto.setName(model.getName());
		dto.setType(model.getType());
		return dto;
	}

	@Override
	public OperatorGender copyProperties(OperatorGender model, OperatorGenderDto dto) {
		OperatorGender model_ = super.copyProperties(model, dto);
		model_.setName(dto.getName());
		model_.setType(dto.getType());
		return model_;
	}

}