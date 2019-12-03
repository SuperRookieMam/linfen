package com.dm.data.show.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dm.common.converter.AbstractConverter;
import com.dm.data.show.converter.YearTeamRegionConverter;
import com.dm.data.show.dto.YearTeamRegionDto;
import com.dm.data.show.entity.YearTeamRegion;
import com.dm.kpi.core.controller.BaseIndexController;
import com.dm.kpi.core.service.BaseIndexService;
import com.dm.data.show.service.YearTeamRegionService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("yearTeamRegions")
@Api(tags = {"每年团队客源地"})
public class YearTeamRegionController extends BaseIndexController<YearTeamRegion, YearTeamRegionDto> {

	@Autowired
	private YearTeamRegionConverter yearTeamRegionConverter;

	@Autowired
	private YearTeamRegionService yearTeamRegionService;

	@Override
	protected AbstractConverter<YearTeamRegion, YearTeamRegionDto> getConverter() {
		return yearTeamRegionConverter;
	}

	@Override
	protected BaseIndexService<YearTeamRegion, YearTeamRegionDto> getService() {
		return yearTeamRegionService;
	}

}