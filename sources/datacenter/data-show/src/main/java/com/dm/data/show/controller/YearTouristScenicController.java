package com.dm.data.show.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dm.common.converter.AbstractConverter;
import com.dm.data.show.converter.YearTouristScenicConverter;
import com.dm.data.show.dto.YearTouristScenicDto;
import com.dm.data.show.entity.YearTouristScenic;
import com.dm.kpi.core.controller.BaseIndexController;
import com.dm.kpi.core.service.BaseIndexService;
import com.dm.data.show.service.YearTouristScenicService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("yearTouristScenics")
@Api(tags = {"每年游客浏览景区数量 "})
public class YearTouristScenicController extends BaseIndexController<YearTouristScenic, YearTouristScenicDto> {

	@Autowired
	private YearTouristScenicConverter yearTouristScenicConverter;

	@Autowired
	private YearTouristScenicService yearTouristScenicService;

	@Override
	protected AbstractConverter<YearTouristScenic, YearTouristScenicDto> getConverter() {
		return yearTouristScenicConverter;
	}

	@Override
	protected BaseIndexService<YearTouristScenic, YearTouristScenicDto> getService() {
		return yearTouristScenicService;
	}

}