package com.dm.data.show.converter;

import org.springframework.stereotype.Component;

import com.dm.kpi.core.converter.AbstractMonthDataConverter;
import com.dm.data.show.dto.MonthIncomeDto;
import com.dm.data.show.entity.MonthIncome;

@Component
public class MonthIncomeConverter extends AbstractMonthDataConverter<MonthIncome, MonthIncomeDto, Float> {

	@Override
	protected MonthIncomeDto getDto() {
		return new MonthIncomeDto();
	}





}