package com.dm.kpi.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dm.common.converter.AbstractConverter;
import com.dm.kpi.converter.HourWeatherConverter;
import com.dm.kpi.core.controller.BaseIndexController;
import com.dm.kpi.core.service.BaseIndexService;
import com.dm.kpi.dto.HourWeatherDto;
import com.dm.kpi.entity.HourWeather;
import com.dm.kpi.service.HourWeatherService;

@RestController
@RequestMapping("hourWeathers")
public class HourWeatherController extends BaseIndexController<HourWeather, HourWeatherDto> {

	@Autowired
	private HourWeatherService hwService;

	@Autowired
	private HourWeatherConverter hwConverter;

	@Override
	protected AbstractConverter<HourWeather, HourWeatherDto> getConverter() {
		return hwConverter;
	}

	@Override
	protected BaseIndexService<HourWeather, HourWeatherDto> getService() {
		return hwService;
	}
	
	 /**
     * 各种指标统计
     *
     * @param num        查询未来前多少小时时间
     * @param districtId 区域id
     * @return
     */
    @GetMapping("/hourWeather")
    public List<HourWeatherDto> findHourWeathers(@RequestParam("num") Integer num,
                                              @RequestParam("districtId") String districtId) {
    	List<HourWeather> models = hwService.findHourWeathers(num, districtId);
        return hwConverter.toDto(models);
    }

}
