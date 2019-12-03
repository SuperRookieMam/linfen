package com.dm.data.show.controller.temporary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dm.common.converter.AbstractConverter;
import com.dm.data.show.converter.temporary.OperatorAgeConverter;
import com.dm.data.show.dto.temporary.OperatorAgeDto;
import com.dm.data.show.entity.temporary.OperatorAge;
import com.dm.data.show.service.temporary.OperatorAgeService;
import com.dm.kpi.core.controller.BaseIndexController;
import com.dm.kpi.core.service.BaseIndexService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("operatorAges")
@Api(tags = {"临时-运营商年龄"})
public class OperatorAgeController extends BaseIndexController<OperatorAge, OperatorAgeDto> {

	@Autowired
	private OperatorAgeConverter operatorAgeConverter;

	@Autowired
	private OperatorAgeService operatorAgeService;

	@Override
	protected AbstractConverter<OperatorAge, OperatorAgeDto> getConverter() {
		return operatorAgeConverter;
	}

	@Override
	protected BaseIndexService<OperatorAge, OperatorAgeDto> getService() {
		return operatorAgeService;
	}

}