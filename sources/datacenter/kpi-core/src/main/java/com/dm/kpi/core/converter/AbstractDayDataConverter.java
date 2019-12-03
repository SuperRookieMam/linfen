package com.dm.kpi.core.converter;

import java.time.ZoneId;
import java.util.Objects;

import com.dm.kpi.core.dto.AbstractDayDataDto;
import com.dm.kpi.core.entity.AbstractDayData;


public abstract class AbstractDayDataConverter<M extends AbstractDayData<V>, DTO extends AbstractDayDataDto<V>, V extends Number>
		extends BaseIndexConverter<M, DTO, V> {

	@Override
	public M copyProperties(M model, DTO dto) {
		model = super.copyProperties(model, dto);
		if (!Objects.isNull(dto.getCurrentDate())) {
			model.setCurrentDate(dto.getCurrentDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
		}
		return model;
	}

	@Override
	protected DTO toDtoActual(M model) {
		DTO dto = super.toDtoActual(model);
		if (!Objects.isNull(model.getCurrentDate())) {
			dto.setCurrentDate(model.getCurrentDate().atStartOfDay(ZoneId.systemDefault()));
		}
		return dto;
	}

	@Override
	protected abstract DTO getDto();

}
