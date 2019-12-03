package com.dm.data.show.controller.temporary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dm.common.converter.AbstractConverter;
import com.dm.data.show.converter.temporary.AccessConverter;
import com.dm.data.show.dto.temporary.AccessDto;
import com.dm.data.show.entity.temporary.Access;
import com.dm.data.show.service.temporary.AccessService;
import com.dm.kpi.core.controller.BaseIndexController;
import com.dm.kpi.core.service.BaseIndexService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("accesss")
@Api(tags = {"临时-门禁"})
public class AccessController extends BaseIndexController<Access, AccessDto> {

	@Autowired
	private AccessConverter accessConverter;

	@Autowired
	private AccessService accessService;

	@Override
	protected AbstractConverter<Access, AccessDto> getConverter() {
		return accessConverter;
	}

	@Override
	protected BaseIndexService<Access, AccessDto> getService() {
		return accessService;
	}

}