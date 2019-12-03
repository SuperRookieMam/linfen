package com.dm.linfen.collection.service;

import java.time.ZonedDateTime;
import java.util.List;

import com.dm.kpi.entity.HourAqi;
import com.dm.linfen.collection.dto.HourAqiFetchDto;
import com.dm.linfen.collection.entity.District;

public interface HourAqiExtService {
	List<HourAqi> saveOrUpdate(List<HourAqiFetchDto> datas, ZonedDateTime start, District district);
}
