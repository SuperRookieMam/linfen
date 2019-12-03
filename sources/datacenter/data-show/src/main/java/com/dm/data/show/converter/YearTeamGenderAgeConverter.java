package com.dm.data.show.converter;

import org.springframework.stereotype.Component;

import com.dm.kpi.core.converter.AbstractYearDataConverter;
import com.dm.data.show.dto.YearTeamGenderAgeDto;
import com.dm.data.show.entity.YearTeamGenderAge;

@Component
public class YearTeamGenderAgeConverter extends AbstractYearDataConverter<YearTeamGenderAge, YearTeamGenderAgeDto, Long> {

	@Override
	protected YearTeamGenderAgeDto getDto() {
		return new YearTeamGenderAgeDto();
	}

	@Override
	protected YearTeamGenderAgeDto toDtoActual(YearTeamGenderAge model) {
		YearTeamGenderAgeDto dto = super.toDtoActual(model);
    		dto.setGender(model.getGender());
		dto.setAge(model.getAge());
		return dto;
	}

	@Override
	public YearTeamGenderAge copyProperties(YearTeamGenderAge model, YearTeamGenderAgeDto dto) {
		YearTeamGenderAge model_ = super.copyProperties(model, dto);
		model_.setGender(dto.getGender());
		model_.setAge(dto.getAge());
		return model_;
	}

}