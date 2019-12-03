package com.dm.kpi.converter;

import org.springframework.stereotype.Component;

import com.dm.kpi.core.converter.AbstractDayDataConverter;
import com.dm.kpi.dto.DayHealthIndexDto;
import com.dm.kpi.entity.DayHealthIndex;

/**
 * Copyright (c) 2019 江苏云智网络科技股份有限公司版权所有
 * @author: 李轲
 * @Date: 2019-09-09 09:39:09
 * @Description: 
 * @History 
 */
@Component
public class DayHealthIndexConverter extends AbstractDayDataConverter<DayHealthIndex, DayHealthIndexDto, Integer> {

	@Override
	protected DayHealthIndexDto getDto() {
		return new DayHealthIndexDto();
	}

	@Override
	public DayHealthIndex copyProperties(DayHealthIndex model, DayHealthIndexDto dto) {
		DayHealthIndex dayHealthIndex = super.copyProperties(model, dto);
		dayHealthIndex.setDistrictId(dto.getDistrictId());
		dayHealthIndex.setInfo(dto.getInfo());
		return dayHealthIndex;
	}

	@Override
	protected DayHealthIndexDto toDtoActual(DayHealthIndex model) {
		DayHealthIndexDto dto = super.toDtoActual(model);
		dto.setDistrictId(model.getDistrictId());
		dto.setInfo(model.getInfo());
		return dto;
	}
	
	

}


