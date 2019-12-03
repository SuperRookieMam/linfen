package com.dm.data.show.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Service;
  
import com.dm.common.converter.AbstractConverter;
import com.dm.data.show.converter.MonthTouristConverter;
import com.dm.data.show.dto.MonthTouristDto;
import com.dm.data.show.entity.MonthTourist;
import com.dm.data.show.entity.QMonthTourist;
import com.dm.data.show.repository.MonthTouristRepository;
import com.dm.data.show.service.MonthTouristService;
import com.dm.kpi.core.service.impl.BaseIndexServiceImpl;
import com.dm.security.core.userdetails.UserDetailsDto;
import com.querydsl.core.BooleanBuilder;

@Service
public class MonthTouristServiceImpl extends BaseIndexServiceImpl<MonthTourist, MonthTouristDto> implements MonthTouristService {

	@Autowired
	private MonthTouristRepository monthTouristRepository;

	@Autowired
	private MonthTouristConverter monthTouristConverter;
	
	private QMonthTourist qMonthTourist = QMonthTourist.monthTourist;

	@Override
	protected JpaRepository<MonthTourist, Long> getRepository() {
		return monthTouristRepository;
	}

	@Override
	protected QuerydslPredicateExecutor<MonthTourist> getQuerydsl() {
		return monthTouristRepository;
	}

	@Override
	protected AbstractConverter<MonthTourist, MonthTouristDto> getConverter() {
		return monthTouristConverter;
	}

	@Override
	protected MonthTourist newModel() {
		return new MonthTourist();
	}

	@Override
	protected BooleanBuilder searchCondition(UserDetailsDto user, String keywords, MonthTouristDto dto) {
		BooleanBuilder booleanBuilder = new BooleanBuilder();
		if(dto.getYear() != null) {
			booleanBuilder.and(qMonthTourist.year.eq(dto.getYear()));
		}
		if(dto.getMonth() != null) {
			booleanBuilder.and(qMonthTourist.month.eq(dto.getMonth()));
		}
		return booleanBuilder;
	}

}
