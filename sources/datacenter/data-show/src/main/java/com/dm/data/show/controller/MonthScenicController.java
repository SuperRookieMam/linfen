package com.dm.data.show.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dm.common.converter.AbstractConverter;
import com.dm.data.show.converter.MonthScenicConverter;
import com.dm.data.show.dto.MonthScenicDto;
import com.dm.data.show.entity.MonthScenic;
import com.dm.kpi.core.controller.BaseIndexController;
import com.dm.kpi.core.service.BaseIndexService;
import com.dm.data.show.service.MonthScenicService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("monthScenics")
@Api(tags = {"每月景区人数统计"})
public class MonthScenicController extends BaseIndexController<MonthScenic, MonthScenicDto> {

	@Autowired
	private MonthScenicConverter monthScenicConverter;

	@Autowired
	private MonthScenicService monthScenicService;

	@Override
	protected AbstractConverter<MonthScenic, MonthScenicDto> getConverter() {
		return monthScenicConverter;
	}

	@Override
	protected BaseIndexService<MonthScenic, MonthScenicDto> getService() {
		return monthScenicService;
	}

}