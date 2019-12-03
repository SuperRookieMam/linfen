package com.dm.data.show.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dm.common.converter.AbstractConverter;
import com.dm.data.show.converter.YearCognitionAtlasConverter;
import com.dm.data.show.dto.YearCognitionAtlasDto;
import com.dm.data.show.entity.YearCognitionAtlas;
import com.dm.kpi.core.controller.BaseIndexController;
import com.dm.kpi.core.service.BaseIndexService;
import com.dm.data.show.service.YearCognitionAtlasService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("yearCognitionAtlass")
@Api(tags = {"每年游客认知图谱"})
public class YearCognitionAtlasController extends BaseIndexController<YearCognitionAtlas, YearCognitionAtlasDto> {

	@Autowired
	private YearCognitionAtlasConverter yearCognitionAtlasConverter;

	@Autowired
	private YearCognitionAtlasService yearCognitionAtlasService;

	@Override
	protected AbstractConverter<YearCognitionAtlas, YearCognitionAtlasDto> getConverter() {
		return yearCognitionAtlasConverter;
	}

	@Override
	protected BaseIndexService<YearCognitionAtlas, YearCognitionAtlasDto> getService() {
		return yearCognitionAtlasService;
	}

}