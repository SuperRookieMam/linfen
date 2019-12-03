package com.dm.data.show.converter;

import org.springframework.stereotype.Component;

import com.dm.kpi.core.converter.AbstractYearDataConverter;
import com.dm.data.show.dto.YearComplaintDto;
import com.dm.data.show.entity.YearComplaint;

@Component
public class YearComplaintConverter extends AbstractYearDataConverter<YearComplaint, YearComplaintDto, Long> {

	@Override
	protected YearComplaintDto getDto() {
		return new YearComplaintDto();
	}

	@Override
	protected YearComplaintDto toDtoActual(YearComplaint model) {
		YearComplaintDto dto = super.toDtoActual(model);
    		dto.setName(model.getName());
		return dto;
	}

	@Override
	public YearComplaint copyProperties(YearComplaint model, YearComplaintDto dto) {
		YearComplaint model_ = super.copyProperties(model, dto);
		model_.setName(dto.getName());
		return model_;
	}

}