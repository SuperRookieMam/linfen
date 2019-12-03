package com.dm.data.show.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dm.common.converter.AbstractConverter;
import com.dm.data.show.converter.DayHotelScoreConverter;
import com.dm.data.show.dto.DayHotelScoreDto;
import com.dm.data.show.entity.DayHotelScore;
import com.dm.kpi.core.controller.BaseIndexController;
import com.dm.kpi.core.service.BaseIndexService;
import com.dm.data.show.service.DayHotelScoreService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("dayHotelScores")
@Api(tags = {"每日酒店分数"})
public class DayHotelScoreController extends BaseIndexController<DayHotelScore, DayHotelScoreDto> {

	@Autowired
	private DayHotelScoreConverter dayHotelScoreConverter;

	@Autowired
	private DayHotelScoreService dayHotelScoreService;

	@Override
	protected AbstractConverter<DayHotelScore, DayHotelScoreDto> getConverter() {
		return dayHotelScoreConverter;
	}

	@Override
	protected BaseIndexService<DayHotelScore, DayHotelScoreDto> getService() {
		return dayHotelScoreService;
	}

}