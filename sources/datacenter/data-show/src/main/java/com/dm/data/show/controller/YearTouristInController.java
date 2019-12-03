package com.dm.data.show.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dm.common.converter.AbstractConverter;
import com.dm.data.show.converter.YearTouristInConverter;
import com.dm.data.show.dto.YearTouristInDto;
import com.dm.data.show.entity.YearTouristIn;
import com.dm.kpi.core.controller.BaseIndexController;
import com.dm.kpi.core.service.BaseIndexService;
import com.dm.data.show.service.YearTouristInService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("yearTouristIns")
@Api(tags = {"每年国外游客人数 "})
public class YearTouristInController extends BaseIndexController<YearTouristIn, YearTouristInDto> {

	@Autowired
	private YearTouristInConverter yearTouristInConverter;

	@Autowired
	private YearTouristInService yearTouristInService;

	@Override
	protected AbstractConverter<YearTouristIn, YearTouristInDto> getConverter() {
		return yearTouristInConverter;
	}

	@Override
	protected BaseIndexService<YearTouristIn, YearTouristInDto> getService() {
		return yearTouristInService;
	}

}