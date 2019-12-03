package com.dm.data.show.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dm.common.converter.AbstractConverter;
import com.dm.data.show.converter.MonthIncomeConverter;
import com.dm.data.show.dto.MonthIncomeDto;
import com.dm.data.show.entity.MonthIncome;
import com.dm.kpi.core.controller.BaseIndexController;
import com.dm.kpi.core.service.BaseIndexService;
import com.dm.data.show.service.MonthIncomeService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("monthIncomes")
@Api(tags = {"每月旅游收入"})
public class MonthIncomeController extends BaseIndexController<MonthIncome, MonthIncomeDto> {

	@Autowired
	private MonthIncomeConverter monthIncomeConverter;

	@Autowired
	private MonthIncomeService monthIncomeService;

	@Override
	protected AbstractConverter<MonthIncome, MonthIncomeDto> getConverter() {
		return monthIncomeConverter;
	}

	@Override
	protected BaseIndexService<MonthIncome, MonthIncomeDto> getService() {
		return monthIncomeService;
	}

}