package com.dm.data.show.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dm.common.converter.AbstractConverter;
import com.dm.data.show.converter.HourScenicComfortConverter;
import com.dm.data.show.dto.HourScenicComfortDto;
import com.dm.data.show.entity.HourScenicComfort;
import com.dm.kpi.core.controller.BaseIndexController;
import com.dm.kpi.core.service.BaseIndexService;
import com.dm.data.show.service.HourScenicComfortService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("hourScenicComforts")
@Api(tags = {"每小时景区舒适度"})
public class HourScenicComfortController extends BaseIndexController<HourScenicComfort, HourScenicComfortDto> {

	@Autowired
	private HourScenicComfortConverter hourScenicComfortConverter;

	@Autowired
	private HourScenicComfortService hourScenicComfortService;

	@Override
	protected AbstractConverter<HourScenicComfort, HourScenicComfortDto> getConverter() {
		return hourScenicComfortConverter;
	}

	@Override
	protected BaseIndexService<HourScenicComfort, HourScenicComfortDto> getService() {
		return hourScenicComfortService;
	}

}