package com.dm.kpi.converter;

import org.springframework.stereotype.Component;

import com.dm.kpi.core.converter.AbstractHourDataConverter;
import com.dm.kpi.dto.HourAqiDataDto;
import com.dm.kpi.entity.HourAqi;

@Component
public class HourAqiDataConverter extends AbstractHourDataConverter<HourAqi, HourAqiDataDto, Integer> {

	@Override
	protected HourAqiDataDto getDto() {
		return new HourAqiDataDto();
	}

	@Override
	public HourAqi copyProperties(HourAqi model, HourAqiDataDto dto) {
		HourAqi data = super.copyProperties(model, dto);
		data.setICo1h(dto.getICo1h());
		data.setINo21h(dto.getINo21h());
		data.setIO31h(dto.getIO31h());
		data.setIO38h(dto.getIO38h());
		data.setIPm101h(dto.getIPm101h());
		data.setIPm1024h(dto.getIPm1024h());
		data.setIPm251h(dto.getIPm251h());
		data.setIPm2524h(dto.getIPm2524h());
		data.setISo21h(dto.getISo21h());
		data.setPCo1h(dto.getPCo1h());
		data.setPNo21h(dto.getPNo21h());
		data.setPO31h(dto.getPO31h());
		data.setPO38h(dto.getPO38h());
		data.setPPm101h(dto.getPPm101h());
		data.setPPm1024h(dto.getPPm1024h());
		data.setPPm251h(dto.getPPm251h());
		data.setPPm2524h(dto.getPPm2524h());
		data.setPSo21h(dto.getPSo21h());
		data.setPointName(dto.getPointName());
		data.setGrade(dto.getGrade());
		data.setDistrictId(dto.getDistrictId());
		return data;
	}

	@Override
	protected HourAqiDataDto toDtoActual(HourAqi model) {
		HourAqiDataDto data = super.toDtoActual(model);
		data.setICo1h(model.getICo1h());
		data.setINo21h(model.getINo21h());
		data.setIO31h(model.getIO31h());
		data.setIO38h(model.getIO38h());
		data.setIPm101h(model.getIPm101h());
		data.setIPm1024h(model.getIPm1024h());
		data.setIPm251h(model.getIPm251h());
		data.setIPm2524h(model.getIPm2524h());
		data.setISo21h(model.getISo21h());
		data.setPCo1h(model.getPCo1h());
		data.setPNo21h(model.getPNo21h());
		data.setPO31h(model.getPO31h());
		data.setPO38h(model.getPO38h());
		data.setPPm101h(model.getPPm101h());
		data.setPPm1024h(model.getPPm1024h());
		data.setPPm251h(model.getPPm251h());
		data.setPPm2524h(model.getPPm2524h());
		data.setPSo21h(model.getPSo21h());
		data.setPointName(model.getPointName());
		data.setGrade(model.getGrade());
		data.setDistrictId(model.getDistrictId());
		return data;
	}
}
