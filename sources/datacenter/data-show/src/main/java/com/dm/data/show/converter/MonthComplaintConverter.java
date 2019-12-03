package com.dm.data.show.converter;

import org.springframework.stereotype.Component;

import com.dm.kpi.core.converter.AbstractMonthDataConverter;
import com.dm.data.show.dto.MonthComplaintDto;
import com.dm.data.show.entity.MonthComplaint;

@Component
public class MonthComplaintConverter extends AbstractMonthDataConverter<MonthComplaint, MonthComplaintDto, Long> {

	@Override
	public MonthComplaint copyProperties(MonthComplaint model, MonthComplaintDto dto) {
		MonthComplaint model_ = super.copyProperties(model, dto);
		model_.setName(dto.getName());
		return model_;
	}

	@Override
	protected MonthComplaintDto toDtoActual(MonthComplaint model) {
		MonthComplaintDto dto = super.toDtoActual(model);
		dto.setName(model.getName());
		return dto;
	}

	@Override
	protected MonthComplaintDto getDto() {
		return new MonthComplaintDto();
	}

	

}
