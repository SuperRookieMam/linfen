package com.dm.kpi.service;

import java.time.LocalDate;
import java.util.List;

import com.dm.kpi.core.service.BaseIndexService;
import com.dm.kpi.dto.DayWeatherDto;
import com.dm.kpi.entity.DayWeather;


/**
 * @Author: 温东山
 * @Description: 类作用描述
 * @CreateDate: 2019/9/5 0005$ 16:12$
 * @UpdateUser: 温东山
 * @UpdateDate: 2019/9/5 0005$ 16:12$
 * @history: 修改记录
 * @Version: 1.0
 */
public interface DayWeatherService extends BaseIndexService<DayWeather, DayWeatherDto>{

	 void deleteDistrictIdAndCurrentDate(String districtId, LocalDate date);
	 
	 List<DayWeather> findByDistrictIdAndDate(String districtId,LocalDate localDate);
}
