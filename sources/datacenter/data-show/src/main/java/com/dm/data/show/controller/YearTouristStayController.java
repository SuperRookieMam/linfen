package com.dm.data.show.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dm.common.converter.AbstractConverter;
import com.dm.data.show.converter.YearTouristStayConverter;
import com.dm.data.show.dto.YearTouristStayDto;
import com.dm.data.show.entity.YearTouristStay;
import com.dm.kpi.core.controller.BaseIndexController;
import com.dm.kpi.core.service.BaseIndexService;
import com.dm.data.show.service.YearTouristStayService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("yearTouristStays")
@Api(tags = {"每年游客停留时长 "})
public class YearTouristStayController extends BaseIndexController<YearTouristStay, YearTouristStayDto> {

	@Autowired
	private YearTouristStayConverter yearTouristStayConverter;

	@Autowired
	private YearTouristStayService yearTouristStayService;

	@Override
	protected AbstractConverter<YearTouristStay, YearTouristStayDto> getConverter() {
		return yearTouristStayConverter;
	}

	@Override
	protected BaseIndexService<YearTouristStay, YearTouristStayDto> getService() {
		return yearTouristStayService;
	}

}