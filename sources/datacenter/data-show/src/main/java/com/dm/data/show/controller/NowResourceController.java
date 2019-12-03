package com.dm.data.show.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dm.common.converter.AbstractConverter;
import com.dm.data.show.converter.NowResourceConverter;
import com.dm.data.show.dto.NowResourceDto;
import com.dm.data.show.entity.NowResource;
import com.dm.kpi.core.controller.BaseIndexController;
import com.dm.kpi.core.service.BaseIndexService;
import com.dm.data.show.service.NowResourceService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("nowResources")
@Api(tags = {"当前全市旅游资源"})
public class NowResourceController extends BaseIndexController<NowResource, NowResourceDto> {

	@Autowired
	private NowResourceConverter nowResourceConverter;

	@Autowired
	private NowResourceService nowResourceService;

	@Override
	protected AbstractConverter<NowResource, NowResourceDto> getConverter() {
		return nowResourceConverter;
	}

	@Override
	protected BaseIndexService<NowResource, NowResourceDto> getService() {
		return nowResourceService;
	}

}