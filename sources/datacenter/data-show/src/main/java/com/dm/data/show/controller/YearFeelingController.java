package com.dm.data.show.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dm.common.converter.AbstractConverter;
import com.dm.data.show.converter.YearFeelingConverter;
import com.dm.data.show.dto.YearFeelingDto;
import com.dm.data.show.entity.YearFeeling;
import com.dm.kpi.core.controller.BaseIndexController;
import com.dm.kpi.core.service.BaseIndexService;
import com.dm.data.show.service.YearFeelingService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("yearFeelings")
@Api(tags = {"每年情感分布"})
public class YearFeelingController extends BaseIndexController<YearFeeling, YearFeelingDto> {

	@Autowired
	private YearFeelingConverter yearFeelingConverter;

	@Autowired
	private YearFeelingService yearFeelingService;

	@Override
	protected AbstractConverter<YearFeeling, YearFeelingDto> getConverter() {
		return yearFeelingConverter;
	}

	@Override
	protected BaseIndexService<YearFeeling, YearFeelingDto> getService() {
		return yearFeelingService;
	}

}