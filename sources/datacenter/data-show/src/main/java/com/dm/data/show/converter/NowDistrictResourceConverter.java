package com.dm.data.show.converter;

import org.springframework.stereotype.Component;

import com.dm.data.show.dto.NowDistrictResourceDto;
import com.dm.data.show.entity.NowDistrictResource;
import com.dm.kpi.core.converter.BaseIndexConverter;

@Component
public class NowDistrictResourceConverter extends BaseIndexConverter<NowDistrictResource, NowDistrictResourceDto, Long> {

	@Override
	protected NowDistrictResourceDto getDto() {
		return new NowDistrictResourceDto();
	}

	@Override
	protected NowDistrictResourceDto toDtoActual(NowDistrictResource model) {
		NowDistrictResourceDto dto = super.toDtoActual(model);
    		dto.setName(model.getName());
		return dto;
	}

	@Override
	public NowDistrictResource copyProperties(NowDistrictResource model, NowDistrictResourceDto dto) {
		NowDistrictResource model_ = super.copyProperties(model, dto);
		model_.setName(dto.getName());
		return model_;
	}

}