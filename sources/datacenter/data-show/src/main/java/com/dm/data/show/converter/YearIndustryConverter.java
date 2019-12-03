package com.dm.data.show.converter;

import org.springframework.stereotype.Component;

import com.dm.kpi.core.converter.AbstractYearDataConverter;
import com.dm.data.show.dto.YearIndustryDto;
import com.dm.data.show.entity.YearIndustry;

@Component
public class YearIndustryConverter extends AbstractYearDataConverter<YearIndustry, YearIndustryDto, Long> {

	@Override
	protected YearIndustryDto getDto() {
		return new YearIndustryDto();
	}

	@Override
	protected YearIndustryDto toDtoActual(YearIndustry model) {
		YearIndustryDto dto = super.toDtoActual(model);
    		dto.setName(model.getName());
		return dto;
	}

	@Override
	public YearIndustry copyProperties(YearIndustry model, YearIndustryDto dto) {
		YearIndustry model_ = super.copyProperties(model, dto);
		model_.setName(dto.getName());
		return model_;
	}

}