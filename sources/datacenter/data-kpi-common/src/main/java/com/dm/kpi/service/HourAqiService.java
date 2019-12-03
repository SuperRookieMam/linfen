package com.dm.kpi.service;

import com.dm.kpi.core.service.BaseIndexService;
import com.dm.kpi.dto.HourAqiDataDto;
import com.dm.kpi.entity.HourAqi;
import com.dm.kpi.entity.HourWeather;

import java.util.List;

public interface HourAqiService extends BaseIndexService<HourAqi, HourAqiDataDto> {

    List<HourAqi> findHourAqis(Integer num, String districtId);

}
