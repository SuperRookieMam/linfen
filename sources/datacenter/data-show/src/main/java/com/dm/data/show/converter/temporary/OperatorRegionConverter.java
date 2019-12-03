package com.dm.data.show.converter.temporary;

import org.springframework.stereotype.Component;

import com.dm.data.show.dto.temporary.OperatorRegionDto;
import com.dm.data.show.entity.temporary.OperatorRegion;
import com.dm.kpi.core.converter.AbstractDayDataConverter;

@Component
public class OperatorRegionConverter extends AbstractDayDataConverter<OperatorRegion, OperatorRegionDto, Integer> {

	@Override
	protected OperatorRegionDto getDto() {
		return new OperatorRegionDto();
	}

	@Override
	protected OperatorRegionDto toDtoActual(OperatorRegion model) {
		OperatorRegionDto dto = super.toDtoActual(model);
    	dto.setName(model.getName());
		dto.setRegionName(model.getRegionName());
		return dto;
	}

	@Override
	public OperatorRegion copyProperties(OperatorRegion model, OperatorRegionDto dto) {
		OperatorRegion model_ = super.copyProperties(model, dto);
		model_.setName(dto.getName());
		model_.setRegionName(dto.getRegionName());
		return model_;
	}

}