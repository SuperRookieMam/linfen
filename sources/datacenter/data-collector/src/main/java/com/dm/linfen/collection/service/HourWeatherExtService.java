package com.dm.linfen.collection.service;

import com.dm.linfen.collection.dto.HourWeatherFetchDto;
import com.dm.linfen.collection.entity.District;

import java.time.ZonedDateTime;
import java.util.List;

public interface HourWeatherExtService {
	void saveOrUpdate(List<HourWeatherFetchDto> datas, ZonedDateTime start, District district);
}
