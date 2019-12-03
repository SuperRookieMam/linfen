package com.dm.data.show.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dm.common.converter.AbstractConverter;
import com.dm.data.show.converter.YearRegionConverter;
import com.dm.data.show.dto.YearRegionDto;
import com.dm.data.show.entity.YearRegion;
import com.dm.kpi.core.controller.BaseIndexController;
import com.dm.kpi.core.service.BaseIndexService;
import com.dm.data.show.service.YearRegionService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("yearRegions")
@Api(tags = {"每年各省旅游人数"})
public class YearRegionController extends BaseIndexController<YearRegion, YearRegionDto> {

	@Autowired
	private YearRegionConverter yearRegionConverter;

	@Autowired
	private YearRegionService yearRegionService;

	@Override
	protected AbstractConverter<YearRegion, YearRegionDto> getConverter() {
		return yearRegionConverter;
	}

	@Override
	protected BaseIndexService<YearRegion, YearRegionDto> getService() {
		return yearRegionService;
	}

}