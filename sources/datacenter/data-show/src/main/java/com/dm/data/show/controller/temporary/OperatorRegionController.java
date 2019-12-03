package com.dm.data.show.controller.temporary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dm.common.converter.AbstractConverter;
import com.dm.data.show.converter.temporary.OperatorRegionConverter;
import com.dm.data.show.dto.temporary.OperatorRegionDto;
import com.dm.data.show.entity.temporary.OperatorRegion;
import com.dm.data.show.service.temporary.OperatorRegionService;
import com.dm.kpi.core.controller.BaseIndexController;
import com.dm.kpi.core.service.BaseIndexService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("operatorRegions")
@Api(tags = {"临时-运营商来源省份"})
public class OperatorRegionController extends BaseIndexController<OperatorRegion, OperatorRegionDto> {

	@Autowired
	private OperatorRegionConverter operatorRegionConverter;

	@Autowired
	private OperatorRegionService operatorRegionService;

	@Override
	protected AbstractConverter<OperatorRegion, OperatorRegionDto> getConverter() {
		return operatorRegionConverter;
	}

	@Override
	protected BaseIndexService<OperatorRegion, OperatorRegionDto> getService() {
		return operatorRegionService;
	}

}