package com.dm.data.show.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dm.common.converter.AbstractConverter;
import com.dm.data.show.converter.MonthComplaintConverter;
import com.dm.data.show.dto.MonthComplaintDto;
import com.dm.data.show.entity.MonthComplaint;
import com.dm.kpi.core.controller.BaseIndexController;
import com.dm.kpi.core.service.BaseIndexService;
import com.dm.data.show.service.MonthComplaintService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("monthComplaints")
@Api(tags = {"每月游客投诉"})
public class MonthComplaintController extends BaseIndexController<MonthComplaint, MonthComplaintDto>{

	@Autowired
	private MonthComplaintConverter monthComplaintConverter;
	
	@Autowired
	private MonthComplaintService monthComplaintService;
	
	@Override
	protected AbstractConverter<MonthComplaint, MonthComplaintDto> getConverter() {
		return monthComplaintConverter;
	}

	@Override
	protected BaseIndexService<MonthComplaint, MonthComplaintDto> getService() {
		return monthComplaintService;
	}

}
