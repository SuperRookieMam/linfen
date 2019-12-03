package com.dm.linfen.emergency.service;

import com.dm.linfen.emergency.entity.EnvironmentHour;
import com.dm.linfen.emergency.entity.FutureWeather;
import com.dm.linfen.emergency.entity.HealthIndex;
import java.time.LocalDate;
import java.util.List;

/**
 * @author Administrator
 * @Title: WeatherService
 * @ProjectName datacenter
 * @Description: TODO
 * @date 2019/7/31 003110:09
 */

public interface WeatherService {

	/**
	 * 获取最近几个小时的指标数据
	 * 
	 * @param num
	 * @param districtId
	 * @return
	 */
	List<EnvironmentHour> findIndexTrend(Integer num, String districtId);

	/**
	 * 获取指定天的指数
	 * 
	 * @param today
	 * @param districtId
	 * @return
	 */
	HealthIndex findTodayHealthIndex(LocalDate today, String districtId);

	/**
	 * 获取未来天气的数据
	 * 
	 * @param today
	 * @param districtId
	 * @return
	 */
	FutureWeather findFutureWeather(LocalDate today, String districtId);
}
