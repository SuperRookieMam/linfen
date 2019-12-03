package com.dm.data.show.converter;

import org.springframework.stereotype.Component;

import com.dm.kpi.core.converter.AbstractYearDataConverter;
import com.dm.data.show.dto.YearKeywordDto;
import com.dm.data.show.entity.YearKeyword;

@Component
public class YearKeywordConverter extends AbstractYearDataConverter<YearKeyword, YearKeywordDto, Long> {

	@Override
	protected YearKeywordDto getDto() {
		return new YearKeywordDto();
	}

	@Override
	protected YearKeywordDto toDtoActual(YearKeyword model) {
		YearKeywordDto dto = super.toDtoActual(model);
    		dto.setName(model.getName());
		dto.setIsBad(model.getIsBad());
		return dto;
	}

	@Override
	public YearKeyword copyProperties(YearKeyword model, YearKeywordDto dto) {
		YearKeyword model_ = super.copyProperties(model, dto);
		model_.setName(dto.getName());
		model_.setIsBad(dto.getIsBad());
		return model_;
	}

}