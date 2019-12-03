package com.dm.linfen.collection.service.impl;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.dm.linfen.collection.util.AirQualityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dm.kpi.entity.HourAqi;
import com.dm.kpi.repository.HourAqiRepository;
import com.dm.linfen.collection.dto.HourAqiFetchDto;
import com.dm.linfen.collection.entity.District;
import com.dm.linfen.collection.service.HourAqiExtService;

@Service
public class HourAqiExtServiceImpl implements HourAqiExtService {

	@Autowired
	private HourAqiRepository hr;

	@Override
	@Transactional
	public List<HourAqi> saveOrUpdate(List<HourAqiFetchDto> datas, ZonedDateTime start, District district) {
		return hr.saveAll(toHourAqiData(datas, start, district));
	}

	private List<HourAqi> toHourAqiData(List<HourAqiFetchDto> datas, final ZonedDateTime start, District district) {
		ZonedDateTime current = start.withMinute(0).withSecond(0).withNano(0);
		int length = datas.size();
		List<HourAqi> results = new ArrayList<>();
		for (int i = 0; i < length; i++) {
			HourAqiFetchDto from = datas.get(i);
			current = current.withHour(from.getTime());
			if (current.getHour() == 0 && i > 0) {
				current = current.plusDays(1);
			}
			HourAqi d = null;
			Optional<HourAqi> optionalD = hr.findByRegionCodeAndPointNameAndCurrentDate(district.getRegionCode(),
					district.getRegionName(), current);
			if (optionalD.isPresent()) {
				d = optionalD.get();
			} else {
				d = new HourAqi();
			}
			if (from.getValue()!= null) {
				d.setGrade(AirQualityUtil.getPm25(from.getValue()));
			}
			d.setCurrentDate(current);
			d.setPCo1h(from.getPCo1h());
			d.setPNo21h(from.getPNo21h());
			d.setPO31h(from.getPO31h());
			d.setPO38h(from.getPO38h());
			d.setPPm101h(from.getPPm101h());
			d.setPPm1024h(from.getPPm1024h());
			d.setPPm251h(from.getPPm251h());
			d.setPPm2524h(from.getPPm1024h());
			d.setPSo21h(from.getPSo21h());
			d.setValue(from.getValue());
			d.setRegionCode(district.getRegionCode());
			d.setRegionName(district.getRegionName());
			d.setPointName(district.getName());
			d.setDistrictId(district.getDistrictId());
			results.add(d);
		}
		return results;
	}

}
