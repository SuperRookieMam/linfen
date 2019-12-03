package com.dm.data.show.converter.temporary;

import org.springframework.stereotype.Component;

import com.dm.data.show.dto.temporary.ParkingDto;
import com.dm.data.show.entity.temporary.Parking;
import com.dm.kpi.core.converter.AbstractHourDataConverter;

@Component
public class ParkingConverter extends AbstractHourDataConverter<Parking, ParkingDto, Integer> {

	@Override
	protected ParkingDto getDto() {
		return new ParkingDto();
	}

	@Override
	protected ParkingDto toDtoActual(Parking model) {
		ParkingDto dto = super.toDtoActual(model);
    	dto.setName(model.getName());
		dto.setScenicName(model.getScenicName());
		dto.setType(model.getType());
		dto.setDayValue(model.getDayValue());
		return dto;
	}

	@Override
	public Parking copyProperties(Parking model, ParkingDto dto) {
		Parking model_ = super.copyProperties(model, dto);
		model_.setName(dto.getName());
		model_.setScenicName(dto.getScenicName());
		model_.setType(dto.getType());
		model_.setDayValue(dto.getDayValue());
		return model_;
	}

}