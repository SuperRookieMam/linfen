package com.dm.data.show.controller.temporary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dm.common.converter.AbstractConverter;
import com.dm.data.show.converter.temporary.OperatorCityConverter;
import com.dm.data.show.dto.temporary.OperatorCityDto;
import com.dm.data.show.entity.temporary.OperatorCity;
import com.dm.data.show.service.temporary.OperatorCityService;
import com.dm.kpi.core.controller.BaseIndexController;
import com.dm.kpi.core.service.BaseIndexService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("operatorCitys")
@Api(tags = {"临时-运营商来源城市"})
public class OperatorCityController extends BaseIndexController<OperatorCity, OperatorCityDto> {

	@Autowired
	private OperatorCityConverter operatorCityConverter;

	@Autowired
	private OperatorCityService operatorCityService;

	@Override
	protected AbstractConverter<OperatorCity, OperatorCityDto> getConverter() {
		return operatorCityConverter;
	}

	@Override
	protected BaseIndexService<OperatorCity, OperatorCityDto> getService() {
		return operatorCityService;
	}

}