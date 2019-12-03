package com.dm.data.show.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dm.common.converter.AbstractConverter;
import com.dm.data.show.converter.MonthTourisHotelLocalInConverter;
import com.dm.data.show.dto.MonthTourisHotelLocalInDto;
import com.dm.data.show.entity.MonthTourisHotelLocalIn;
import com.dm.kpi.core.controller.BaseIndexController;
import com.dm.kpi.core.service.BaseIndexService;
import com.dm.data.show.service.MonthTourisHotelLocalInService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("monthTourisHotelLocalIns")
@Api(tags = {"每月国内/入境游客住宿"})
public class MonthTourisHotelLocalInController extends BaseIndexController<MonthTourisHotelLocalIn, MonthTourisHotelLocalInDto> {

	@Autowired
	private MonthTourisHotelLocalInConverter monthTourisHotelLocalInConverter;

	@Autowired
	private MonthTourisHotelLocalInService monthTourisHotelLocalInService;

	@Override
	protected AbstractConverter<MonthTourisHotelLocalIn, MonthTourisHotelLocalInDto> getConverter() {
		return monthTourisHotelLocalInConverter;
	}

	@Override
	protected BaseIndexService<MonthTourisHotelLocalIn, MonthTourisHotelLocalInDto> getService() {
		return monthTourisHotelLocalInService;
	}

}