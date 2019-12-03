package com.dm.data.show.converter;

import org.springframework.stereotype.Component;

import com.dm.kpi.core.converter.AbstractYearDataConverter;
import com.dm.data.show.dto.YearTeamRegionDto;
import com.dm.data.show.entity.YearTeamRegion;

@Component
public class YearTeamRegionConverter extends AbstractYearDataConverter<YearTeamRegion, YearTeamRegionDto, Long> {

	@Override
	protected YearTeamRegionDto getDto() {
		return new YearTeamRegionDto();
	}

	@Override
	protected YearTeamRegionDto toDtoActual(YearTeamRegion model) {
		YearTeamRegionDto dto = super.toDtoActual(model);
    		dto.setName(model.getName());
		return dto;
	}

	@Override
	public YearTeamRegion copyProperties(YearTeamRegion model, YearTeamRegionDto dto) {
		YearTeamRegion model_ = super.copyProperties(model, dto);
		model_.setName(dto.getName());
		return model_;
	}

}