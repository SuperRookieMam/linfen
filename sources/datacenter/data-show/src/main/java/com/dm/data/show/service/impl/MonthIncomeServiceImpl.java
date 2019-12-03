package com.dm.data.show.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Service;
  
import com.dm.common.converter.AbstractConverter;
import com.dm.data.show.converter.MonthIncomeConverter;
import com.dm.data.show.dto.MonthIncomeDto;
import com.dm.data.show.entity.MonthIncome;
import com.dm.data.show.entity.QMonthIncome;
import com.dm.data.show.repository.MonthIncomeRepository;
import com.dm.data.show.service.MonthIncomeService;
import com.dm.kpi.core.service.impl.BaseIndexServiceImpl;
import com.dm.security.core.userdetails.UserDetailsDto;
import com.querydsl.core.BooleanBuilder;

@Service
public class MonthIncomeServiceImpl extends BaseIndexServiceImpl<MonthIncome, MonthIncomeDto> implements MonthIncomeService {

	@Autowired
	private MonthIncomeRepository monthIncomeRepository;

	@Autowired
	private MonthIncomeConverter monthIncomeConverter;
	
	private final QMonthIncome qMonthIncome = QMonthIncome.monthIncome;

	@Override
	protected JpaRepository<MonthIncome, Long> getRepository() {
		return monthIncomeRepository;
	}

	@Override
	protected QuerydslPredicateExecutor<MonthIncome> getQuerydsl() {
		return monthIncomeRepository;
	}

	@Override
	protected AbstractConverter<MonthIncome, MonthIncomeDto> getConverter() {
		return monthIncomeConverter;
	}

	@Override
	protected MonthIncome newModel() {
		return new MonthIncome();
	}

	@Override
	protected BooleanBuilder searchCondition(UserDetailsDto user, String keywords, MonthIncomeDto dto) {
		BooleanBuilder booleanBuilder = new BooleanBuilder();
		if(dto.getYear() != null) {
			booleanBuilder.and(qMonthIncome.year.eq(dto.getYear()));
		}
		if(dto.getMonth() != null) {
			booleanBuilder.and(qMonthIncome.month.eq(dto.getMonth()));
		}
		return booleanBuilder;
	}

}
