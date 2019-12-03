package com.dm.data.show.converter;

import org.springframework.stereotype.Component;

import com.dm.kpi.core.converter.AbstractMonthDataConverter;
import com.dm.data.show.dto.MonthTouristTeamSingleDto;
import com.dm.data.show.entity.MonthTouristTeamSingle;

@Component
public class MonthTouristTeamSingleConverter extends AbstractMonthDataConverter<MonthTouristTeamSingle, MonthTouristTeamSingleDto, Long> {

	@Override
	protected MonthTouristTeamSingleDto getDto() {
		return new MonthTouristTeamSingleDto();
	}

	@Override
	protected MonthTouristTeamSingleDto toDtoActual(MonthTouristTeamSingle model) {
		MonthTouristTeamSingleDto dto = super.toDtoActual(model);
    		dto.setName(model.getName());
		return dto;
	}

	@Override
	public MonthTouristTeamSingle copyProperties(MonthTouristTeamSingle model, MonthTouristTeamSingleDto dto) {
		MonthTouristTeamSingle model_ = super.copyProperties(model, dto);
		model_.setName(dto.getName());
		return model_;
	}

}