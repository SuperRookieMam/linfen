package com.dm.data.show.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dm.common.converter.AbstractConverter;
import com.dm.data.show.converter.YearTouristGenderConverter;
import com.dm.data.show.dto.YearTouristGenderDto;
import com.dm.data.show.entity.YearTouristGender;
import com.dm.kpi.core.controller.BaseIndexController;
import com.dm.kpi.core.service.BaseIndexService;
import com.dm.data.show.service.YearTouristGenderService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("yearTouristGenders")
@Api(tags = {"每年游客性别"})
public class YearTouristGenderController extends BaseIndexController<YearTouristGender, YearTouristGenderDto> {

	@Autowired
	private YearTouristGenderConverter yearTouristGenderConverter;

	@Autowired
	private YearTouristGenderService yearTouristGenderService;

	@Override
	protected AbstractConverter<YearTouristGender, YearTouristGenderDto> getConverter() {
		return yearTouristGenderConverter;
	}

	@Override
	protected BaseIndexService<YearTouristGender, YearTouristGenderDto> getService() {
		return yearTouristGenderService;
	}

}