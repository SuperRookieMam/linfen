package com.dm.data.show.converter;

import org.springframework.stereotype.Component;

import com.dm.kpi.core.converter.AbstractMonthDataConverter;
import com.dm.data.show.dto.MonthScenicDto;
import com.dm.data.show.entity.MonthScenic;

@Component
public class MonthScenicConverter extends AbstractMonthDataConverter<MonthScenic, MonthScenicDto, Long> {

	@Override
	protected MonthScenicDto getDto() {
		return new MonthScenicDto();
	}

	@Override
	protected MonthScenicDto toDtoActual(MonthScenic model) {
		MonthScenicDto dto = super.toDtoActual(model);
    		dto.setName(model.getName());
		return dto;
	}

	@Override
	public MonthScenic copyProperties(MonthScenic model, MonthScenicDto dto) {
		MonthScenic model_ = super.copyProperties(model, dto);
		model_.setName(dto.getName());
		return model_;
	}

}