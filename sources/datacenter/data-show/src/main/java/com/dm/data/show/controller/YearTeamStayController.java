package com.dm.data.show.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dm.common.converter.AbstractConverter;
import com.dm.data.show.converter.YearTeamStayConverter;
import com.dm.data.show.dto.YearTeamStayDto;
import com.dm.data.show.entity.YearTeamStay;
import com.dm.kpi.core.controller.BaseIndexController;
import com.dm.kpi.core.service.BaseIndexService;
import com.dm.data.show.service.YearTeamStayService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("yearTeamStays")
@Api(tags = {"每年团队停留时长"})
public class YearTeamStayController extends BaseIndexController<YearTeamStay, YearTeamStayDto> {

	@Autowired
	private YearTeamStayConverter yearTeamStayConverter;

	@Autowired
	private YearTeamStayService yearTeamStayService;

	@Override
	protected AbstractConverter<YearTeamStay, YearTeamStayDto> getConverter() {
		return yearTeamStayConverter;
	}

	@Override
	protected BaseIndexService<YearTeamStay, YearTeamStayDto> getService() {
		return yearTeamStayService;
	}

}