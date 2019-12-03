package com.dm.data.show.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dm.common.converter.AbstractConverter;
import com.dm.data.show.converter.YearTouristHolidayTypeConverter;
import com.dm.data.show.dto.YearTouristHolidayTypeDto;
import com.dm.data.show.entity.YearTouristHolidayType;
import com.dm.kpi.core.controller.BaseIndexController;
import com.dm.kpi.core.service.BaseIndexService;
import com.dm.data.show.service.YearTouristHolidayTypeService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("yearTouristHolidayTypes")
@Api(tags = {"每年节假日游客接待人数 "})
public class YearTouristHolidayTypeController extends BaseIndexController<YearTouristHolidayType, YearTouristHolidayTypeDto> {

	@Autowired
	private YearTouristHolidayTypeConverter yearTouristHolidayTypeConverter;

	@Autowired
	private YearTouristHolidayTypeService yearTouristHolidayTypeService;

	@Override
	protected AbstractConverter<YearTouristHolidayType, YearTouristHolidayTypeDto> getConverter() {
		return yearTouristHolidayTypeConverter;
	}

	@Override
	protected BaseIndexService<YearTouristHolidayType, YearTouristHolidayTypeDto> getService() {
		return yearTouristHolidayTypeService;
	}

}