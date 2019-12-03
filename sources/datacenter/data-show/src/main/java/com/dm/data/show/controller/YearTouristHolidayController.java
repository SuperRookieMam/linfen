package com.dm.data.show.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dm.common.converter.AbstractConverter;
import com.dm.data.show.converter.YearTouristHolidayConverter;
import com.dm.data.show.dto.YearTouristHolidayDto;
import com.dm.data.show.entity.YearTouristHoliday;
import com.dm.kpi.core.controller.BaseIndexController;
import com.dm.kpi.core.service.BaseIndexService;
import com.dm.data.show.service.YearTouristHolidayService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("yearTouristHolidays")
@Api(tags = {"每年节假日累计接待人数 "})
public class YearTouristHolidayController extends BaseIndexController<YearTouristHoliday, YearTouristHolidayDto> {

	@Autowired
	private YearTouristHolidayConverter yearTouristHolidayConverter;

	@Autowired
	private YearTouristHolidayService yearTouristHolidayService;

	@Override
	protected AbstractConverter<YearTouristHoliday, YearTouristHolidayDto> getConverter() {
		return yearTouristHolidayConverter;
	}

	@Override
	protected BaseIndexService<YearTouristHoliday, YearTouristHolidayDto> getService() {
		return yearTouristHolidayService;
	}

}