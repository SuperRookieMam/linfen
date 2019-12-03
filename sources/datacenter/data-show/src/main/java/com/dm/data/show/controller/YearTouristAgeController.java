package com.dm.data.show.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dm.common.converter.AbstractConverter;
import com.dm.data.show.converter.YearTouristAgeConverter;
import com.dm.data.show.dto.YearTouristAgeDto;
import com.dm.data.show.entity.YearTouristAge;
import com.dm.kpi.core.controller.BaseIndexController;
import com.dm.kpi.core.service.BaseIndexService;
import com.dm.data.show.service.YearTouristAgeService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("yearTouristAges")
@Api(tags = {"每年游客年龄"})
public class YearTouristAgeController extends BaseIndexController<YearTouristAge, YearTouristAgeDto> {

	@Autowired
	private YearTouristAgeConverter yearTouristAgeConverter;

	@Autowired
	private YearTouristAgeService yearTouristAgeService;

	@Override
	protected AbstractConverter<YearTouristAge, YearTouristAgeDto> getConverter() {
		return yearTouristAgeConverter;
	}

	@Override
	protected BaseIndexService<YearTouristAge, YearTouristAgeDto> getService() {
		return yearTouristAgeService;
	}

}