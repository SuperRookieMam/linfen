package com.dm.data.show.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dm.common.converter.AbstractConverter;
import com.dm.data.show.converter.DayScenicConverter;
import com.dm.data.show.dto.DayScenicDto;
import com.dm.data.show.entity.DayScenic;
import com.dm.kpi.core.controller.BaseIndexController;
import com.dm.kpi.core.service.BaseIndexService;
import com.dm.data.show.service.DayScenicService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("dayScenics")
@Api(tags = {"每日景区人数统计"})
public class DayScenicController extends BaseIndexController<DayScenic, DayScenicDto> {

	@Autowired
	private DayScenicConverter dayScenicConverter;

	@Autowired
	private DayScenicService dayScenicService;

	@Override
	protected AbstractConverter<DayScenic, DayScenicDto> getConverter() {
		return dayScenicConverter;
	}

	@Override
	protected BaseIndexService<DayScenic, DayScenicDto> getService() {
		return dayScenicService;
	}

}