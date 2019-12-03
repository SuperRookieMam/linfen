package com.dm.data.show.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dm.common.converter.AbstractConverter;
import com.dm.data.show.converter.YearScenicCityCarConverter;
import com.dm.data.show.dto.YearScenicCityCarDto;
import com.dm.data.show.entity.YearScenicCityCar;
import com.dm.kpi.core.controller.BaseIndexController;
import com.dm.kpi.core.service.BaseIndexService;
import com.dm.data.show.service.YearScenicCityCarService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("yearScenicCityCars")
@Api(tags = {"每年景区车辆来源"})
public class YearScenicCityCarController extends BaseIndexController<YearScenicCityCar, YearScenicCityCarDto> {

	@Autowired
	private YearScenicCityCarConverter yearScenicCityCarConverter;

	@Autowired
	private YearScenicCityCarService yearScenicCityCarService;

	@Override
	protected AbstractConverter<YearScenicCityCar, YearScenicCityCarDto> getConverter() {
		return yearScenicCityCarConverter;
	}

	@Override
	protected BaseIndexService<YearScenicCityCar, YearScenicCityCarDto> getService() {
		return yearScenicCityCarService;
	}

}