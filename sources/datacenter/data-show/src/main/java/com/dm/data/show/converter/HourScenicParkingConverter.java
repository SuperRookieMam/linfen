package com.dm.data.show.converter;

import org.springframework.stereotype.Component;

import com.dm.kpi.core.converter.AbstractHourDataConverter;
import com.dm.data.show.dto.HourScenicParkingDto;
import com.dm.data.show.entity.HourScenicParking;

@Component
public class HourScenicParkingConverter extends AbstractHourDataConverter<HourScenicParking, HourScenicParkingDto, Long> {

	@Override
	protected HourScenicParkingDto getDto() {
		return new HourScenicParkingDto();
	}

	@Override
	protected HourScenicParkingDto toDtoActual(HourScenicParking model) {
		HourScenicParkingDto dto = super.toDtoActual(model);
    		dto.setName(model.getName());
		return dto;
	}

	@Override
	public HourScenicParking copyProperties(HourScenicParking model, HourScenicParkingDto dto) {
		HourScenicParking model_ = super.copyProperties(model, dto);
		model_.setName(dto.getName());
		return model_;
	}

}