package com.dm.data.show.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dm.common.converter.AbstractConverter;
import com.dm.data.show.converter.YearTeamGenderAgeConverter;
import com.dm.data.show.dto.YearTeamGenderAgeDto;
import com.dm.data.show.entity.YearTeamGenderAge;
import com.dm.kpi.core.controller.BaseIndexController;
import com.dm.kpi.core.service.BaseIndexService;
import com.dm.data.show.service.YearTeamGenderAgeService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("yearTeamGenderAges")
@Api(tags = {"每年团队性别及年龄"})
public class YearTeamGenderAgeController extends BaseIndexController<YearTeamGenderAge, YearTeamGenderAgeDto> {

	@Autowired
	private YearTeamGenderAgeConverter yearTeamGenderAgeConverter;

	@Autowired
	private YearTeamGenderAgeService yearTeamGenderAgeService;

	@Override
	protected AbstractConverter<YearTeamGenderAge, YearTeamGenderAgeDto> getConverter() {
		return yearTeamGenderAgeConverter;
	}

	@Override
	protected BaseIndexService<YearTeamGenderAge, YearTeamGenderAgeDto> getService() {
		return yearTeamGenderAgeService;
	}

}