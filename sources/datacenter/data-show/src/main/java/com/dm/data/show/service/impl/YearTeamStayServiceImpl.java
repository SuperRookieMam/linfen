package com.dm.data.show.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Service;
  
import com.dm.common.converter.AbstractConverter;
import com.dm.data.show.converter.YearTeamStayConverter;
import com.dm.data.show.dto.YearTeamStayDto;
import com.dm.data.show.entity.QYearTeamStay;
import com.dm.data.show.entity.YearTeamStay;
import com.dm.data.show.repository.YearTeamStayRepository;
import com.dm.data.show.service.YearTeamStayService;
import com.dm.kpi.core.service.impl.BaseIndexServiceImpl;
import com.dm.security.core.userdetails.UserDetailsDto;
import com.querydsl.core.BooleanBuilder;

@Service
public class YearTeamStayServiceImpl extends BaseIndexServiceImpl<YearTeamStay, YearTeamStayDto> implements YearTeamStayService {

	@Autowired
	private YearTeamStayRepository yearTeamStayRepository;

	@Autowired
	private YearTeamStayConverter yearTeamStayConverter;
	
	private final QYearTeamStay qYearTeamStay = QYearTeamStay.yearTeamStay;

	@Override
	protected JpaRepository<YearTeamStay, Long> getRepository() {
		return yearTeamStayRepository;
	}

	@Override
	protected QuerydslPredicateExecutor<YearTeamStay> getQuerydsl() {
		return yearTeamStayRepository;
	}

	@Override
	protected AbstractConverter<YearTeamStay, YearTeamStayDto> getConverter() {
		return yearTeamStayConverter;
	}

	@Override
	protected YearTeamStay newModel() {
		return new YearTeamStay();
	}

	@Override
	protected BooleanBuilder searchCondition(UserDetailsDto user, String keywords, YearTeamStayDto dto) {
		BooleanBuilder booleanBuilder = new BooleanBuilder();
		if(dto.getYear() != null) {
			booleanBuilder.and(qYearTeamStay.year.eq(dto.getYear()));
		}
		return booleanBuilder;
	}

}
