package com.dm.data.show.converter;

import org.springframework.stereotype.Component;

import com.dm.kpi.core.converter.AbstractYearDataConverter;
import com.dm.data.show.dto.YearRegionDto;
import com.dm.data.show.entity.YearRegion;

@Component
public class YearRegionConverter extends AbstractYearDataConverter<YearRegion, YearRegionDto, Long> {

	@Override
	protected YearRegionDto getDto() {
		return new YearRegionDto();
	}

	@Override
	protected YearRegionDto toDtoActual(YearRegion model) {
		YearRegionDto dto = super.toDtoActual(model);
    		dto.setName(model.getName());
		return dto;
	}

	@Override
	public YearRegion copyProperties(YearRegion model, YearRegionDto dto) {
		YearRegion model_ = super.copyProperties(model, dto);
		model_.setName(dto.getName());
		return model_;
	}

}