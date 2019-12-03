package com.dm.data.show.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Service;
  
import com.dm.common.converter.AbstractConverter;
import com.dm.data.show.converter.MonthSentimentTypeConverter;
import com.dm.data.show.dto.MonthSentimentTypeDto;
import com.dm.data.show.entity.MonthSentimentType;
import com.dm.data.show.entity.QMonthSentimentType;
import com.dm.data.show.repository.MonthSentimentTypeRepository;
import com.dm.data.show.service.MonthSentimentTypeService;
import com.dm.kpi.core.service.impl.BaseIndexServiceImpl;
import com.dm.security.core.userdetails.UserDetailsDto;
import com.querydsl.core.BooleanBuilder;

@Service
public class MonthSentimentTypeServiceImpl extends BaseIndexServiceImpl<MonthSentimentType, MonthSentimentTypeDto> implements MonthSentimentTypeService {

	@Autowired
	private MonthSentimentTypeRepository monthSentimentTypeRepository;

	@Autowired
	private MonthSentimentTypeConverter monthSentimentTypeConverter;
	
	private final QMonthSentimentType qMonthSentimentType = QMonthSentimentType.monthSentimentType;

	@Override
	protected JpaRepository<MonthSentimentType, Long> getRepository() {
		return monthSentimentTypeRepository;
	}

	@Override
	protected QuerydslPredicateExecutor<MonthSentimentType> getQuerydsl() {
		return monthSentimentTypeRepository;
	}

	@Override
	protected AbstractConverter<MonthSentimentType, MonthSentimentTypeDto> getConverter() {
		return monthSentimentTypeConverter;
	}

	@Override
	protected MonthSentimentType newModel() {
		return new MonthSentimentType();
	}

	@Override
	protected BooleanBuilder searchCondition(UserDetailsDto user, String keywords, MonthSentimentTypeDto dto) {
		BooleanBuilder booleanBuilder = new BooleanBuilder();
		if(dto.getYear() != null) {
			booleanBuilder.and(qMonthSentimentType.year.eq(dto.getYear()));
		}
		if(dto.getMonth() != null) {
			booleanBuilder.and(qMonthSentimentType.month.eq(dto.getMonth()));
		}
		return booleanBuilder;
	}

}
