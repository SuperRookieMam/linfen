package com.dm.kpi.controller;

import com.dm.common.converter.AbstractConverter;
import com.dm.kpi.converter.DayWeatherConverter;
import com.dm.kpi.core.controller.BaseIndexController;
import com.dm.kpi.core.service.BaseIndexService;
import com.dm.kpi.dto.DayWeatherDto;
import com.dm.kpi.entity.DayWeather;
import com.dm.kpi.entity.HourAqi;
import com.dm.kpi.entity.HourWeather;
import com.dm.kpi.service.DayWeatherService;
import com.dm.kpi.service.HourAqiService;
import com.dm.kpi.service.HourWeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Copyright (c) 2019 江苏云智网络科技股份有限公司版权所有
 *
 * @author: 李轲
 * @Date: 2019-09-05 18:00:59
 * @Description:
 * @History
 */
@RestController
@RequestMapping("dayWeathers")
public class DayWeatherController extends BaseIndexController<DayWeather, DayWeatherDto> {

    private final static  Integer NUM=12;

    @Autowired
    private DayWeatherService dayWeatherService;

    @Autowired
    private HourWeatherService hwService;

    @Autowired
    private HourAqiService aqiService;

    @Autowired
    private DayWeatherConverter dayWeatherConverter;

    @Override
    protected AbstractConverter<DayWeather, DayWeatherDto> getConverter() {
        return dayWeatherConverter;
    }

    @Override
    protected BaseIndexService<DayWeather, DayWeatherDto> getService() {
        return dayWeatherService;
    }

    /**
     * 返回未来天气列表
     *
     * @param today
     * @param districtId
     * @return
     */
    @GetMapping("/dayWeather")
    public List<DayWeatherDto> findDayWeather(
            @RequestParam(value = "startTime", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate today,
            @RequestParam("districtId") String districtId) {
        List<DayWeather> models = dayWeatherService.findByDistrictIdAndDate(districtId, today);
        return dayWeatherConverter.toDto(models);
    }

    /**
     * 返回当天天气信息详情
     *
     * @param today
     * @param districtId
     * @return
     */
    @GetMapping("/todayWeather")
    public Map<String, Object> findToDayWeather(
            @RequestParam("districtId") String districtId) {
        Map<String, Object> map = new HashMap<>(16);
        List<DayWeather> dayWeathers = dayWeatherService.findByDistrictIdAndDate(districtId, LocalDate.now());
        List<HourAqi> hourAqis = aqiService.findHourAqis(NUM, districtId);
        List<HourWeather> hourWeathers = hwService.findHourWeathers(NUM, districtId);
        if(!CollectionUtils.isEmpty(dayWeathers)){
            map.put("dayWeather",dayWeathers.get(0));
        }
        if(!CollectionUtils.isEmpty(hourAqis)){
            map.put("hourAqi",hourAqis.get(0));
        }
        if(!CollectionUtils.isEmpty(hourWeathers)){
            map.put("hourWeather",hourWeathers.get(0));
        }
        return map;
    }
}


