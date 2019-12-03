package com.dm.kpi.core.converter;

import com.dm.kpi.core.dto.AbstractMonthDataDto;
import com.dm.kpi.core.entity.AbstractMonthData;

public abstract class AbstractMonthDataConverter<M extends AbstractMonthData<V>, DTO extends AbstractMonthDataDto<V>, V extends Number>
		extends BaseIndexConverter<M, DTO, V> {

	@Override
	public M copyProperties(M model, DTO dto) {
		model = super.copyProperties(model, dto);
		model.setYear(dto.getYear());
		model.setMonth(dto.getMonth());
		return model;
	}

	@Override
	protected DTO toDtoActual(M model) {
		DTO dto = super.toDtoActual(model);
		dto.setYear(model.getYear());
		dto.setMonth(model.getMonth());
		return dto;
	}

	@Override
	protected abstract DTO getDto();

}
