package com.dm.kpi.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dm.common.converter.AbstractConverter;
import com.dm.kpi.converter.DayHealthIndexConverter;
import com.dm.kpi.core.controller.BaseIndexController;
import com.dm.kpi.core.service.BaseIndexService;
import com.dm.kpi.dto.DayHealthIndexDto;
import com.dm.kpi.entity.DayHealthIndex;
import com.dm.kpi.service.DayHealthIndexService;

/**
 * Copyright (c) 2019 江苏云智网络科技股份有限公司版权所有
 * @author: 李轲
 * @Date: 2019-09-09 09:53:31
 * @Description: 
 * @History 
 */
@RestController
@RequestMapping("dayHealthIndexs")
public class DayHealthIndexController extends BaseIndexController<DayHealthIndex, DayHealthIndexDto> {
	
	@Autowired
	private DayHealthIndexConverter dayHealthIndexConverter;
	
	@Autowired
	private DayHealthIndexService dayHealthIndexService;

	@Override
	protected AbstractConverter<DayHealthIndex, DayHealthIndexDto> getConverter() {
		return dayHealthIndexConverter;
	}

	@Override
	protected BaseIndexService<DayHealthIndex, DayHealthIndexDto> getService() {
		return dayHealthIndexService;
	}

	/**
     * 返回当天人体舒适度指数
     *
     * @param today      查询时间
     * @param districtId 区域id
     * @return
     */
    @GetMapping("/healthIndex")
    public DayHealthIndex findTodayHealthIndex(
            @RequestParam(value = "startTime", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate today,
            @RequestParam("districtId") String districtId) {
        return dayHealthIndexService.findByCurrentDateAndDistrictId(today, districtId);
    }
}


