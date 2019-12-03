package com.dm.data.show.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dm.common.converter.AbstractConverter;
import com.dm.data.show.converter.YearTouristConverter;
import com.dm.data.show.dto.YearTouristDto;
import com.dm.data.show.entity.YearTourist;
import com.dm.kpi.core.controller.BaseIndexController;
import com.dm.kpi.core.service.BaseIndexService;
import com.dm.data.show.service.YearTouristService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("yearTourists")
@Api(tags = {"每年累计接待游客人数"})
public class YearTouristController extends BaseIndexController<YearTourist, YearTouristDto> {

	@Autowired
	private YearTouristConverter yearTouristConverter;

	@Autowired
	private YearTouristService yearTouristService;

	@Override
	protected AbstractConverter<YearTourist, YearTouristDto> getConverter() {
		return yearTouristConverter;
	}

	@Override
	protected BaseIndexService<YearTourist, YearTouristDto> getService() {
		return yearTouristService;
	}

}