package com.dm.data.show.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dm.common.converter.AbstractConverter;
import com.dm.data.show.converter.YearTouristConsumeConverter;
import com.dm.data.show.dto.YearTouristConsumeDto;
import com.dm.data.show.entity.YearTouristConsume;
import com.dm.kpi.core.controller.BaseIndexController;
import com.dm.kpi.core.service.BaseIndexService;
import com.dm.data.show.service.YearTouristConsumeService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("yearTouristConsumes")
@Api(tags = {"每年游客消费分析"})
public class YearTouristConsumeController extends BaseIndexController<YearTouristConsume, YearTouristConsumeDto> {

	@Autowired
	private YearTouristConsumeConverter yearTouristConsumeConverter;

	@Autowired
	private YearTouristConsumeService yearTouristConsumeService;

	@Override
	protected AbstractConverter<YearTouristConsume, YearTouristConsumeDto> getConverter() {
		return yearTouristConsumeConverter;
	}

	@Override
	protected BaseIndexService<YearTouristConsume, YearTouristConsumeDto> getService() {
		return yearTouristConsumeService;
	}

}