package com.dm.data.show.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dm.common.converter.AbstractConverter;
import com.dm.data.show.converter.YearScenicConverter;
import com.dm.data.show.dto.YearScenicDto;
import com.dm.data.show.entity.YearScenic;
import com.dm.kpi.core.controller.BaseIndexController;
import com.dm.kpi.core.service.BaseIndexService;
import com.dm.data.show.service.YearScenicService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("yearScenics")
@Api(tags = {"每年景区人数统计"})
public class YearScenicController extends BaseIndexController<YearScenic, YearScenicDto> {

	@Autowired
	private YearScenicConverter yearScenicConverter;

	@Autowired
	private YearScenicService yearScenicService;

	@Override
	protected AbstractConverter<YearScenic, YearScenicDto> getConverter() {
		return yearScenicConverter;
	}

	@Override
	protected BaseIndexService<YearScenic, YearScenicDto> getService() {
		return yearScenicService;
	}

}