package com.dm.data.show.converter;

import org.springframework.stereotype.Component;

import com.dm.kpi.core.converter.AbstractYearDataConverter;
import com.dm.data.show.dto.YearScenicDto;
import com.dm.data.show.entity.YearScenic;

@Component
public class YearScenicConverter extends AbstractYearDataConverter<YearScenic, YearScenicDto, Long> {

	@Override
	protected YearScenicDto getDto() {
		return new YearScenicDto();
	}

	@Override
	protected YearScenicDto toDtoActual(YearScenic model) {
		YearScenicDto dto = super.toDtoActual(model);
    		dto.setName(model.getName());
		return dto;
	}

	@Override
	public YearScenic copyProperties(YearScenic model, YearScenicDto dto) {
		YearScenic model_ = super.copyProperties(model, dto);
		model_.setName(dto.getName());
		return model_;
	}

}