package com.dm.data.show.controller.temporary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dm.common.converter.AbstractConverter;
import com.dm.data.show.converter.temporary.OperatorGenderConverter;
import com.dm.data.show.dto.temporary.OperatorGenderDto;
import com.dm.data.show.entity.temporary.OperatorGender;
import com.dm.data.show.service.temporary.OperatorGenderService;
import com.dm.kpi.core.controller.BaseIndexController;
import com.dm.kpi.core.service.BaseIndexService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("operatorGenders")
@Api(tags = {"临时-运营商性别"})
public class OperatorGenderController extends BaseIndexController<OperatorGender, OperatorGenderDto> {

	@Autowired
	private OperatorGenderConverter operatorGenderConverter;

	@Autowired
	private OperatorGenderService operatorGenderService;

	@Override
	protected AbstractConverter<OperatorGender, OperatorGenderDto> getConverter() {
		return operatorGenderConverter;
	}

	@Override
	protected BaseIndexService<OperatorGender, OperatorGenderDto> getService() {
		return operatorGenderService;
	}

}