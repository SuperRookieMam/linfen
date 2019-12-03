package com.dm.linfen.emergency.controller.visualization;

import com.dm.linfen.emergency.entity.EnvironmentHour;
import com.dm.linfen.emergency.entity.FutureWeather;
import com.dm.linfen.emergency.entity.HealthIndex;
import com.dm.linfen.emergency.service.WeatherService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

/**
 * @author 温东山
 * @create 2019-07-23 10:09
 **/
@Api("可视化处理接口类")
@RestController
@RequestMapping("weathers")
public class WeatherController {

	@Autowired
	private WeatherService weatherService;

	/**
	 * 返回未来天气列表
	 * 
	 * @param today
	 * @param districtId
	 * @return
	 */
	@GetMapping("/futureWeather")
	public FutureWeather findFutureWeather(
			@RequestParam(value = "startTime", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate today,
			@RequestParam("districtId") String districtId) {
		return weatherService.findFutureWeather(today, districtId);
	}

	/**
	 * 返回当天人体舒适度指数
	 * 
	 * @param today      查询时间
	 * @param districtId 区域id
	 * @return
	 */
	@GetMapping("/healthIndex")
	public HealthIndex findTodayHealthIndex(
			@RequestParam(value = "startTime", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate today,
			@RequestParam("districtId") String districtId) {
		return weatherService.findTodayHealthIndex(today, districtId);
	}

	/**
	 * 各种指标统计
	 * 
	 * @param num        查询未来前多少小时时间
	 * @param districtId 区域id
	 * @return
	 */
	@GetMapping("/indexTrend")
	public List<EnvironmentHour> findIndexTrend(@RequestParam("num") Integer num,
			@RequestParam("districtId") String districtId) {
		return weatherService.findIndexTrend(num, districtId);
	}
}
