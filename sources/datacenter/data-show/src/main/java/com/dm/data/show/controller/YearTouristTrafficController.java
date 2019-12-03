package com.dm.data.show.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dm.common.converter.AbstractConverter;
import com.dm.data.show.converter.YearTouristTrafficConverter;
import com.dm.data.show.dto.YearTouristTrafficDto;
import com.dm.data.show.entity.YearTouristTraffic;
import com.dm.kpi.core.controller.BaseIndexController;
import com.dm.kpi.core.service.BaseIndexService;
import com.dm.data.show.service.YearTouristTrafficService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("yearTouristTraffics")
@Api(tags = {"每年游客交通工具 "})
public class YearTouristTrafficController extends BaseIndexController<YearTouristTraffic, YearTouristTrafficDto> {

	@Autowired
	private YearTouristTrafficConverter yearTouristTrafficConverter;

	@Autowired
	private YearTouristTrafficService yearTouristTrafficService;

	@Override
	protected AbstractConverter<YearTouristTraffic, YearTouristTrafficDto> getConverter() {
		return yearTouristTrafficConverter;
	}

	@Override
	protected BaseIndexService<YearTouristTraffic, YearTouristTrafficDto> getService() {
		return yearTouristTrafficService;
	}

}