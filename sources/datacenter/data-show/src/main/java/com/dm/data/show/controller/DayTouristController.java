package com.dm.data.show.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dm.common.converter.AbstractConverter;
import com.dm.data.show.converter.DayTouristConverter;
import com.dm.data.show.dto.DayTouristDto;
import com.dm.data.show.entity.DayTourist;
import com.dm.kpi.core.controller.BaseIndexController;
import com.dm.kpi.core.service.BaseIndexService;
import com.dm.data.show.service.DayTouristService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("dayTourists")
@Api(tags = {"每日游客数量"})
public class DayTouristController extends BaseIndexController<DayTourist, DayTouristDto> {

	@Autowired
	private DayTouristConverter dayTouristConverter;

	@Autowired
	private DayTouristService dayTouristService;

	@Override
	protected AbstractConverter<DayTourist, DayTouristDto> getConverter() {
		return dayTouristConverter;
	}

	@Override
	protected BaseIndexService<DayTourist, DayTouristDto> getService() {
		return dayTouristService;
	}

}