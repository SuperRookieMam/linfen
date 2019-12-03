package com.dm.data.show.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dm.common.converter.AbstractConverter;
import com.dm.data.show.converter.MonthTouristConverter;
import com.dm.data.show.dto.MonthTouristDto;
import com.dm.data.show.entity.MonthTourist;
import com.dm.kpi.core.controller.BaseIndexController;
import com.dm.kpi.core.service.BaseIndexService;
import com.dm.data.show.service.MonthTouristService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("monthTourists")
@Api(tags = {"每月游客数量"})
public class MonthTouristController extends BaseIndexController<MonthTourist, MonthTouristDto> {

	@Autowired
	private MonthTouristConverter monthTouristConverter;

	@Autowired
	private MonthTouristService monthTouristService;

	@Override
	protected AbstractConverter<MonthTourist, MonthTouristDto> getConverter() {
		return monthTouristConverter;
	}

	@Override
	protected BaseIndexService<MonthTourist, MonthTouristDto> getService() {
		return monthTouristService;
	}

}