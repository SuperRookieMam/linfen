package com.dm.data.show.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dm.common.converter.AbstractConverter;
import com.dm.data.show.converter.YearIndustryConverter;
import com.dm.data.show.dto.YearIndustryDto;
import com.dm.data.show.entity.YearIndustry;
import com.dm.kpi.core.controller.BaseIndexController;
import com.dm.kpi.core.service.BaseIndexService;
import com.dm.data.show.service.YearIndustryService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("yearIndustrys")
@Api(tags = {"每年旅游产业数量"})
public class YearIndustryController extends BaseIndexController<YearIndustry, YearIndustryDto> {

	@Autowired
	private YearIndustryConverter yearIndustryConverter;

	@Autowired
	private YearIndustryService yearIndustryService;

	@Override
	protected AbstractConverter<YearIndustry, YearIndustryDto> getConverter() {
		return yearIndustryConverter;
	}

	@Override
	protected BaseIndexService<YearIndustry, YearIndustryDto> getService() {
		return yearIndustryService;
	}

}