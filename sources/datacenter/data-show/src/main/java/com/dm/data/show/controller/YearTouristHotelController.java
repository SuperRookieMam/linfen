package com.dm.data.show.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dm.common.converter.AbstractConverter;
import com.dm.data.show.converter.YearTouristHotelConverter;
import com.dm.data.show.dto.YearTouristHotelDto;
import com.dm.data.show.entity.YearTouristHotel;
import com.dm.kpi.core.controller.BaseIndexController;
import com.dm.kpi.core.service.BaseIndexService;
import com.dm.data.show.service.YearTouristHotelService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("yearTouristHotels")
@Api(tags = {"每年游客住宿天数 "})
public class YearTouristHotelController extends BaseIndexController<YearTouristHotel, YearTouristHotelDto> {

	@Autowired
	private YearTouristHotelConverter yearTouristHotelConverter;

	@Autowired
	private YearTouristHotelService yearTouristHotelService;

	@Override
	protected AbstractConverter<YearTouristHotel, YearTouristHotelDto> getConverter() {
		return yearTouristHotelConverter;
	}

	@Override
	protected BaseIndexService<YearTouristHotel, YearTouristHotelDto> getService() {
		return yearTouristHotelService;
	}

}