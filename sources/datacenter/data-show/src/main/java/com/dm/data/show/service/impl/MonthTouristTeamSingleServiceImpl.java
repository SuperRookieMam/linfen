package com.dm.data.show.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Service;
  
import com.dm.common.converter.AbstractConverter;
import com.dm.data.show.converter.MonthTouristTeamSingleConverter;
import com.dm.data.show.dto.MonthTouristTeamSingleDto;
import com.dm.data.show.entity.MonthTouristTeamSingle;
import com.dm.data.show.entity.QMonthTouristTeamSingle;
import com.dm.data.show.repository.MonthTouristTeamSingleRepository;
import com.dm.data.show.service.MonthTouristTeamSingleService;
import com.dm.kpi.core.service.impl.BaseIndexServiceImpl;
import com.dm.security.core.userdetails.UserDetailsDto;
import com.querydsl.core.BooleanBuilder;

@Service
public class MonthTouristTeamSingleServiceImpl extends BaseIndexServiceImpl<MonthTouristTeamSingle, MonthTouristTeamSingleDto> implements MonthTouristTeamSingleService {

	@Autowired
	private MonthTouristTeamSingleRepository monthTouristTeamSingleRepository;

	@Autowired
	private MonthTouristTeamSingleConverter monthTouristTeamSingleConverter;
	
	private final QMonthTouristTeamSingle qMonthTouristTeamSingle = QMonthTouristTeamSingle.monthTouristTeamSingle;

	@Override
	protected JpaRepository<MonthTouristTeamSingle, Long> getRepository() {
		return monthTouristTeamSingleRepository;
	}

	@Override
	protected QuerydslPredicateExecutor<MonthTouristTeamSingle> getQuerydsl() {
		return monthTouristTeamSingleRepository;
	}

	@Override
	protected AbstractConverter<MonthTouristTeamSingle, MonthTouristTeamSingleDto> getConverter() {
		return monthTouristTeamSingleConverter;
	}

	@Override
	protected MonthTouristTeamSingle newModel() {
		return new MonthTouristTeamSingle();
	}

	@Override
	protected BooleanBuilder searchCondition(UserDetailsDto user, String keywords, MonthTouristTeamSingleDto dto) {
		BooleanBuilder booleanBuilder = new BooleanBuilder();
		if(dto.getYear() != null) {
			booleanBuilder.and(qMonthTouristTeamSingle.year.eq(dto.getYear()));
		}
		if(dto.getMonth() != null) {
			booleanBuilder.and(qMonthTouristTeamSingle.month.eq(dto.getMonth()));
		}
		return booleanBuilder;
	}

}
