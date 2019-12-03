package com.dm.data.show.converter;

import org.springframework.stereotype.Component;

import com.dm.kpi.core.converter.AbstractYearDataConverter;
import com.dm.data.show.dto.YearTouristScenicDto;
import com.dm.data.show.entity.YearTouristScenic;

@Component
public class YearTouristScenicConverter extends AbstractYearDataConverter<YearTouristScenic, YearTouristScenicDto, Long> {

	@Override
	protected YearTouristScenicDto getDto() {
		return new YearTouristScenicDto();
	}

	@Override
	protected YearTouristScenicDto toDtoActual(YearTouristScenic model) {
		YearTouristScenicDto dto = super.toDtoActual(model);
    		dto.setName(model.getName());
		return dto;
	}

	@Override
	public YearTouristScenic copyProperties(YearTouristScenic model, YearTouristScenicDto dto) {
		YearTouristScenic model_ = super.copyProperties(model, dto);
		model_.setName(dto.getName());
		return model_;
	}

}