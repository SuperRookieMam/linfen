package com.dm.linfen.converter;

import com.dm.common.converter.AbstractConverter;
import com.dm.linfen.dto.AbstractRegionDto;
import com.dm.linfen.entity.core.AbstractCore;

public abstract class MAbstractBaseConverter<M extends AbstractCore<?>, DTO extends AbstractRegionDto> extends AbstractConverter<M, DTO> {

	protected abstract DTO getDto();

	@Override
	protected DTO toDtoActual(M model) {
		DTO dto = getDto();
		dto.setCreateDate(model.getCreatedDate().orElse(null));
		dto.setCreatedBy(model.getCreatedBy().orElse(null));
		dto.setLastModifiedBy(model.getLastModifiedBy().orElse(null));
		dto.setLastModifiedDate(model.getLastModifiedDate().orElse(null));
		return dto;
	}

	@Override
	public M copyProperties(M model, DTO dto) {
		return model;
	}

}
