package com.dm.data.show.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dm.common.converter.AbstractConverter;
import com.dm.data.show.converter.MonthSentimentTypeConverter;
import com.dm.data.show.dto.MonthSentimentTypeDto;
import com.dm.data.show.entity.MonthSentimentType;
import com.dm.kpi.core.controller.BaseIndexController;
import com.dm.kpi.core.service.BaseIndexService;
import com.dm.data.show.service.MonthSentimentTypeService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("monthSentimentTypes")
@Api(tags = {"每月舆情数量"})
public class MonthSentimentTypeController extends BaseIndexController<MonthSentimentType, MonthSentimentTypeDto> {

	@Autowired
	private MonthSentimentTypeConverter monthSentimentTypeConverter;

	@Autowired
	private MonthSentimentTypeService monthSentimentTypeService;

	@Override
	protected AbstractConverter<MonthSentimentType, MonthSentimentTypeDto> getConverter() {
		return monthSentimentTypeConverter;
	}

	@Override
	protected BaseIndexService<MonthSentimentType, MonthSentimentTypeDto> getService() {
		return monthSentimentTypeService;
	}

}