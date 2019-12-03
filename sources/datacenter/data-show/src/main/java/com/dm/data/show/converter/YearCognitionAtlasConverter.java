package com.dm.data.show.converter;

import org.springframework.stereotype.Component;

import com.dm.kpi.core.converter.AbstractYearDataConverter;
import com.dm.data.show.dto.YearCognitionAtlasDto;
import com.dm.data.show.entity.YearCognitionAtlas;

@Component
public class YearCognitionAtlasConverter extends AbstractYearDataConverter<YearCognitionAtlas, YearCognitionAtlasDto, Long> {

	@Override
	protected YearCognitionAtlasDto getDto() {
		return new YearCognitionAtlasDto();
	}

	@Override
	protected YearCognitionAtlasDto toDtoActual(YearCognitionAtlas model) {
		YearCognitionAtlasDto dto = super.toDtoActual(model);
    		dto.setName(model.getName());
		return dto;
	}

	@Override
	public YearCognitionAtlas copyProperties(YearCognitionAtlas model, YearCognitionAtlasDto dto) {
		YearCognitionAtlas model_ = super.copyProperties(model, dto);
		model_.setName(dto.getName());
		return model_;
	}

}