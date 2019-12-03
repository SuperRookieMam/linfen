package com.dm.data.show.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dm.common.converter.AbstractConverter;
import com.dm.data.show.converter.YearMediaConverter;
import com.dm.data.show.dto.YearMediaDto;
import com.dm.data.show.entity.YearMedia;
import com.dm.kpi.core.controller.BaseIndexController;
import com.dm.kpi.core.service.BaseIndexService;
import com.dm.data.show.service.YearMediaService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("yearMedias")
@Api(tags = {"每年媒体来源数量"})
public class YearMediaController extends BaseIndexController<YearMedia, YearMediaDto> {

	@Autowired
	private YearMediaConverter yearMediaConverter;

	@Autowired
	private YearMediaService yearMediaService;

	@Override
	protected AbstractConverter<YearMedia, YearMediaDto> getConverter() {
		return yearMediaConverter;
	}

	@Override
	protected BaseIndexService<YearMedia, YearMediaDto> getService() {
		return yearMediaService;
	}

}