package com.dm.data.show.converter.temporary;

import org.springframework.stereotype.Component;

import com.dm.data.show.dto.temporary.OperatorCityDto;
import com.dm.data.show.entity.temporary.OperatorCity;
import com.dm.kpi.core.converter.AbstractDayDataConverter;

@Component
public class OperatorCityConverter extends AbstractDayDataConverter<OperatorCity, OperatorCityDto, Integer> {

	@Override
	protected OperatorCityDto getDto() {
		return new OperatorCityDto();
	}

	@Override
	protected OperatorCityDto toDtoActual(OperatorCity model) {
		OperatorCityDto dto = super.toDtoActual(model);
    	dto.setName(model.getName());
		dto.setCityName(model.getCityName());
		return dto;
	}

	@Override
	public OperatorCity copyProperties(OperatorCity model, OperatorCityDto dto) {
		OperatorCity model_ = super.copyProperties(model, dto);
		model_.setName(dto.getName());
		model_.setCityName(dto.getCityName());
		return model_;
	}

}