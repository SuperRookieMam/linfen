package com.dm.data.show.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dm.common.converter.AbstractConverter;
import com.dm.data.show.converter.YearKeywordConverter;
import com.dm.data.show.dto.YearKeywordDto;
import com.dm.data.show.entity.YearKeyword;
import com.dm.kpi.core.controller.BaseIndexController;
import com.dm.kpi.core.service.BaseIndexService;
import com.dm.data.show.service.YearKeywordService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("yearKeywords")
@Api(tags = {"每年关键词"})
public class YearKeywordController extends BaseIndexController<YearKeyword, YearKeywordDto> {

	@Autowired
	private YearKeywordConverter yearKeywordConverter;

	@Autowired
	private YearKeywordService yearKeywordService;

	@Override
	protected AbstractConverter<YearKeyword, YearKeywordDto> getConverter() {
		return yearKeywordConverter;
	}

	@Override
	protected BaseIndexService<YearKeyword, YearKeywordDto> getService() {
		return yearKeywordService;
	}

}