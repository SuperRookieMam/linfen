package com.dm.data.show.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dm.common.converter.AbstractConverter;
import com.dm.data.show.converter.DayHotelPriceConverter;
import com.dm.data.show.dto.DayHotelPriceDto;
import com.dm.data.show.entity.DayHotelPrice;
import com.dm.kpi.core.controller.BaseIndexController;
import com.dm.kpi.core.service.BaseIndexService;
import com.dm.data.show.service.DayHotelPriceService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("dayHotelPrices")
@Api(tags = {"每日酒店价格"})
public class DayHotelPriceController extends BaseIndexController<DayHotelPrice, DayHotelPriceDto> {

	@Autowired
	private DayHotelPriceConverter dayHotelPriceConverter;

	@Autowired
	private DayHotelPriceService dayHotelPriceService;

	@Override
	protected AbstractConverter<DayHotelPrice, DayHotelPriceDto> getConverter() {
		return dayHotelPriceConverter;
	}

	@Override
	protected BaseIndexService<DayHotelPrice, DayHotelPriceDto> getService() {
		return dayHotelPriceService;
	}

}