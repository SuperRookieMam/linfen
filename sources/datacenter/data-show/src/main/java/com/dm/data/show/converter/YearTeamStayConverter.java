package com.dm.data.show.converter;

import org.springframework.stereotype.Component;

import com.dm.kpi.core.converter.AbstractYearDataConverter;
import com.dm.data.show.dto.YearTeamStayDto;
import com.dm.data.show.entity.YearTeamStay;

@Component
public class YearTeamStayConverter extends AbstractYearDataConverter<YearTeamStay, YearTeamStayDto, Long> {

	@Override
	protected YearTeamStayDto getDto() {
		return new YearTeamStayDto();
	}

	@Override
	protected YearTeamStayDto toDtoActual(YearTeamStay model) {
		YearTeamStayDto dto = super.toDtoActual(model);
    		dto.setName(model.getName());
		return dto;
	}

	@Override
	public YearTeamStay copyProperties(YearTeamStay model, YearTeamStayDto dto) {
		YearTeamStay model_ = super.copyProperties(model, dto);
		model_.setName(dto.getName());
		return model_;
	}

}