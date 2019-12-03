package com.dm.data.show.converter;

import org.springframework.stereotype.Component;

import com.dm.kpi.core.converter.AbstractYearDataConverter;
import com.dm.data.show.dto.YearTouristTrafficDto;
import com.dm.data.show.entity.YearTouristTraffic;

@Component
public class YearTouristTrafficConverter extends AbstractYearDataConverter<YearTouristTraffic, YearTouristTrafficDto, Long> {

	@Override
	protected YearTouristTrafficDto getDto() {
		return new YearTouristTrafficDto();
	}

	@Override
	protected YearTouristTrafficDto toDtoActual(YearTouristTraffic model) {
		YearTouristTrafficDto dto = super.toDtoActual(model);
    		dto.setName(model.getName());
		return dto;
	}

	@Override
	public YearTouristTraffic copyProperties(YearTouristTraffic model, YearTouristTrafficDto dto) {
		YearTouristTraffic model_ = super.copyProperties(model, dto);
		model_.setName(dto.getName());
		return model_;
	}

}