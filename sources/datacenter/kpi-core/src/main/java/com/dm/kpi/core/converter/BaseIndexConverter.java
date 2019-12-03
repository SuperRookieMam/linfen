package com.dm.kpi.core.converter;

import com.dm.common.converter.AbstractConverter;
import com.dm.kpi.core.dto.AbstractBaseIndexDto;
import com.dm.kpi.core.entity.AbstractIndex;

public abstract class BaseIndexConverter<M extends AbstractIndex<V>, DTO extends AbstractBaseIndexDto<V>, V extends Number>
		extends AbstractConverter<M, DTO> {

	@Override
	public M copyProperties(M model, DTO data) {
		model.setRegionCode(data.getRegionCode());
		model.setRegionName(data.getRegionName());
		model.setValue(data.getValue());
		return model;
	}

	@Override
	protected DTO toDtoActual(M model) {
		DTO dto = getDto();
		dto.setCreateTime(model.getCreatedDate().orElse(null));
		dto.setId(model.getId());
		dto.setRegionCode(model.getRegionCode());
		dto.setRegionName(model.getRegionName());
		dto.setUpdateTime(model.getLastModifiedDate().orElse(null));
		dto.setValue(model.getValue());
		dto.setCreateBy(model.getCreatedBy().orElse(null));
		dto.setLastModifiedBy(model.getLastModifiedBy().orElse(null));
		return dto;
	}

	protected abstract DTO getDto();

}
