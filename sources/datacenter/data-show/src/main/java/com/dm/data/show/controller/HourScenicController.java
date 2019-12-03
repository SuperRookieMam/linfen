package com.dm.data.show.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dm.common.converter.AbstractConverter;
import com.dm.data.show.converter.HourScenicConverter;
import com.dm.data.show.dto.HourScenicDto;
import com.dm.data.show.entity.HourScenic;
import com.dm.kpi.core.controller.BaseIndexController;
import com.dm.kpi.core.service.BaseIndexService;
import com.dm.data.show.service.HourScenicService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("hourScenics")
@Api(tags = {"每小时景区人数"})
public class HourScenicController extends BaseIndexController<HourScenic, HourScenicDto> {

	@Autowired
	private HourScenicConverter hourScenicConverter;

	@Autowired
	private HourScenicService hourScenicService;

	@Override
	protected AbstractConverter<HourScenic, HourScenicDto> getConverter() {
		return hourScenicConverter;
	}

	@Override
	protected BaseIndexService<HourScenic, HourScenicDto> getService() {
		return hourScenicService;
	}

}