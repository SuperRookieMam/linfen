package com.dm.data.show.converter;

import org.springframework.stereotype.Component;

import com.dm.data.show.dto.NowGuideDto;
import com.dm.data.show.entity.NowGuide;
import com.dm.kpi.core.converter.BaseIndexConverter;

@Component
public class NowGuideConverter extends BaseIndexConverter<NowGuide, NowGuideDto, Long> {

	@Override
	protected NowGuideDto getDto() {
		return new NowGuideDto();
	}

	@Override
	protected NowGuideDto toDtoActual(NowGuide model) {
		NowGuideDto dto = super.toDtoActual(model);
    		dto.setName(model.getName());
		return dto;
	}

	@Override
	public NowGuide copyProperties(NowGuide model, NowGuideDto dto) {
		NowGuide model_ = super.copyProperties(model, dto);
		model_.setName(dto.getName());
		return model_;
	}

}