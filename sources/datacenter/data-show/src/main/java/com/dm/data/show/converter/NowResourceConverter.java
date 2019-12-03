package com.dm.data.show.converter;

import org.springframework.stereotype.Component;

import com.dm.data.show.dto.NowResourceDto;
import com.dm.data.show.entity.NowResource;
import com.dm.kpi.core.converter.BaseIndexConverter;

@Component
public class NowResourceConverter extends BaseIndexConverter<NowResource, NowResourceDto, Long> {

	@Override
	protected NowResourceDto getDto() {
		return new NowResourceDto();
	}

	@Override
	protected NowResourceDto toDtoActual(NowResource model) {
		NowResourceDto dto = super.toDtoActual(model);
    		dto.setName(model.getName());
		return dto;
	}

	@Override
	public NowResource copyProperties(NowResource model, NowResourceDto dto) {
		NowResource model_ = super.copyProperties(model, dto);
		model_.setName(dto.getName());
		return model_;
	}

}