package com.dm.data.show.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dm.common.converter.AbstractConverter;
import com.dm.data.show.converter.NowDistrictResourceConverter;
import com.dm.data.show.dto.NowDistrictResourceDto;
import com.dm.data.show.entity.NowDistrictResource;
import com.dm.kpi.core.controller.BaseIndexController;
import com.dm.kpi.core.service.BaseIndexService;
import com.dm.data.show.service.NowDistrictResourceService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("nowDistrictResources")
@Api(tags = {"当前各区县旅游资源"})
public class NowDistrictResourceController extends BaseIndexController<NowDistrictResource, NowDistrictResourceDto> {

	@Autowired
	private NowDistrictResourceConverter nowDistrictResourceConverter;

	@Autowired
	private NowDistrictResourceService nowDistrictResourceService;

	@Override
	protected AbstractConverter<NowDistrictResource, NowDistrictResourceDto> getConverter() {
		return nowDistrictResourceConverter;
	}

	@Override
	protected BaseIndexService<NowDistrictResource, NowDistrictResourceDto> getService() {
		return nowDistrictResourceService;
	}

}