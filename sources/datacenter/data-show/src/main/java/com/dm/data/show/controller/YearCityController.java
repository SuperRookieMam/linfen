package com.dm.data.show.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dm.common.converter.AbstractConverter;
import com.dm.data.show.converter.YearCityConverter;
import com.dm.data.show.dto.YearCityDto;
import com.dm.data.show.entity.YearCity;
import com.dm.kpi.core.controller.BaseIndexController;
import com.dm.kpi.core.service.BaseIndexService;
import com.dm.data.show.service.YearCityService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("yearCitys")
@Api(tags = {"每年各市旅游人数"})
public class YearCityController extends BaseIndexController<YearCity, YearCityDto> {

	@Autowired
	private YearCityConverter yearCityConverter;

	@Autowired
	private YearCityService yearCityService;

	@Override
	protected AbstractConverter<YearCity, YearCityDto> getConverter() {
		return yearCityConverter;
	}

	@Override
	protected BaseIndexService<YearCity, YearCityDto> getService() {
		return yearCityService;
	}

}