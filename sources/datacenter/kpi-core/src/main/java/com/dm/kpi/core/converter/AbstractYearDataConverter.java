package com.dm.kpi.core.converter;

import com.dm.kpi.core.converter.BaseIndexConverter;
import com.dm.kpi.core.dto.AbstractYearDataDto;
import com.dm.kpi.core.entity.AbstractYearData;

public abstract class AbstractYearDataConverter<M extends AbstractYearData<V>, DTO extends AbstractYearDataDto<V>, V extends Number>
		extends BaseIndexConverter<M, DTO, V> {

	@Override
	public M copyProperties(M model, DTO dto) {
		model = super.copyProperties(model, dto);
		model.setYear(dto.getYear());
		return model;
	}

	@Override
	protected DTO toDtoActual(M model) {
		DTO dto = super.toDtoActual(model);
		dto.setYear(model.getYear());
		return dto;
	}

	@Override
	protected abstract DTO getDto();

}
