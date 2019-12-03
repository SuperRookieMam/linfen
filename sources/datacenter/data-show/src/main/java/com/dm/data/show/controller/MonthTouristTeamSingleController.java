package com.dm.data.show.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dm.common.converter.AbstractConverter;
import com.dm.data.show.converter.MonthTouristTeamSingleConverter;
import com.dm.data.show.dto.MonthTouristTeamSingleDto;
import com.dm.data.show.entity.MonthTouristTeamSingle;
import com.dm.kpi.core.controller.BaseIndexController;
import com.dm.kpi.core.service.BaseIndexService;
import com.dm.data.show.service.MonthTouristTeamSingleService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("monthTouristTeamSingles")
@Api(tags = {"每月团散客走势"})
public class MonthTouristTeamSingleController extends BaseIndexController<MonthTouristTeamSingle, MonthTouristTeamSingleDto> {

	@Autowired
	private MonthTouristTeamSingleConverter monthTouristTeamSingleConverter;

	@Autowired
	private MonthTouristTeamSingleService monthTouristTeamSingleService;

	@Override
	protected AbstractConverter<MonthTouristTeamSingle, MonthTouristTeamSingleDto> getConverter() {
		return monthTouristTeamSingleConverter;
	}

	@Override
	protected BaseIndexService<MonthTouristTeamSingle, MonthTouristTeamSingleDto> getService() {
		return monthTouristTeamSingleService;
	}

}