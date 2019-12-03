package com.dm.kpi.core.converter;

import com.dm.kpi.core.converter.BaseIndexConverter;
import com.dm.kpi.core.dto.AbstractHourDataDto;
import com.dm.kpi.core.entity.AbstractHourData;

public abstract class AbstractHourDataConverter<M extends AbstractHourData<V>, DTO extends AbstractHourDataDto<V>, V extends Number>
		extends BaseIndexConverter<M, DTO, V> {

	@Override
	public M copyProperties(M model, DTO dto) {
		model = super.copyProperties(model, dto);
		model.setCurrentDate(dto.getCurrentDate());
		return model;
	}

	@Override
	protected DTO toDtoActual(M model) {
		DTO dto = super.toDtoActual(model);
		dto.setCurrentDate(model.getCurrentDate());
		return dto;
	}

	@Override
	protected abstract DTO getDto();

}
