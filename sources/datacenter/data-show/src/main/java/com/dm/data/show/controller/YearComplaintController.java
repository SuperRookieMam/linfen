package com.dm.data.show.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dm.common.converter.AbstractConverter;
import com.dm.data.show.converter.YearComplaintConverter;
import com.dm.data.show.dto.YearComplaintDto;
import com.dm.data.show.entity.YearComplaint;
import com.dm.kpi.core.controller.BaseIndexController;
import com.dm.kpi.core.service.BaseIndexService;
import com.dm.data.show.service.YearComplaintService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("yearComplaints")
@Api(tags = {"每年游客投诉"})
public class YearComplaintController extends BaseIndexController<YearComplaint, YearComplaintDto> {

	@Autowired
	private YearComplaintConverter yearComplaintConverter;

	@Autowired
	private YearComplaintService yearComplaintService;

	@Override
	protected AbstractConverter<YearComplaint, YearComplaintDto> getConverter() {
		return yearComplaintConverter;
	}

	@Override
	protected BaseIndexService<YearComplaint, YearComplaintDto> getService() {
		return yearComplaintService;
	}

}