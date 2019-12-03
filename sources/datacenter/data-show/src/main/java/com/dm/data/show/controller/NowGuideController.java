package com.dm.data.show.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dm.common.converter.AbstractConverter;
import com.dm.data.show.converter.NowGuideConverter;
import com.dm.data.show.dto.NowGuideDto;
import com.dm.data.show.entity.NowGuide;
import com.dm.kpi.core.controller.BaseIndexController;
import com.dm.kpi.core.service.BaseIndexService;
import com.dm.data.show.service.NowGuideService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("nowGuides")
@Api(tags = {"当前导游类别统计"})
public class NowGuideController extends BaseIndexController<NowGuide, NowGuideDto> {

	@Autowired
	private NowGuideConverter nowGuideConverter;

	@Autowired
	private NowGuideService nowGuideService;

	@Override
	protected AbstractConverter<NowGuide, NowGuideDto> getConverter() {
		return nowGuideConverter;
	}

	@Override
	protected BaseIndexService<NowGuide, NowGuideDto> getService() {
		return nowGuideService;
	}

}