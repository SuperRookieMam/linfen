package com.dm.data.show.converter;

import org.springframework.stereotype.Component;

import com.dm.kpi.core.converter.AbstractYearDataConverter;
import com.dm.data.show.dto.YearMediaDto;
import com.dm.data.show.entity.YearMedia;

@Component
public class YearMediaConverter extends AbstractYearDataConverter<YearMedia, YearMediaDto, Long> {

	@Override
	protected YearMediaDto getDto() {
		return new YearMediaDto();
	}

	@Override
	protected YearMediaDto toDtoActual(YearMedia model) {
		YearMediaDto dto = super.toDtoActual(model);
    		dto.setName(model.getName());
		return dto;
	}

	@Override
	public YearMedia copyProperties(YearMedia model, YearMediaDto dto) {
		YearMedia model_ = super.copyProperties(model, dto);
		model_.setName(dto.getName());
		return model_;
	}

}