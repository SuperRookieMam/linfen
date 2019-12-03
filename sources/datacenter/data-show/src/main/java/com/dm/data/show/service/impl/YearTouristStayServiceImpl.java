package com.dm.data.show.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Service;
  
import com.dm.common.converter.AbstractConverter;
import com.dm.data.show.converter.YearTouristStayConverter;
import com.dm.data.show.dto.YearTouristStayDto;
import com.dm.data.show.entity.QYearTouristStay;
import com.dm.data.show.entity.YearTouristStay;
import com.dm.data.show.repository.YearTouristStayRepository;
import com.dm.data.show.service.YearTouristStayService;
import com.dm.kpi.core.service.impl.BaseIndexServiceImpl;
import com.dm.security.core.userdetails.UserDetailsDto;
import com.querydsl.core.BooleanBuilder;

@Service
public class YearTouristStayServiceImpl extends BaseIndexServiceImpl<YearTouristStay, YearTouristStayDto> implements YearTouristStayService {

	@Autowired
	private YearTouristStayRepository yearTouristStayRepository;

	@Autowired
	private YearTouristStayConverter yearTouristStayConverter;
	
	private final QYearTouristStay qYearTouristStay = QYearTouristStay.yearTouristStay;

	@Override
	protected JpaRepository<YearTouristStay, Long> getRepository() {
		return yearTouristStayRepository;
	}

	@Override
	protected QuerydslPredicateExecutor<YearTouristStay> getQuerydsl() {
		return yearTouristStayRepository;
	}

	@Override
	protected AbstractConverter<YearTouristStay, YearTouristStayDto> getConverter() {
		return yearTouristStayConverter;
	}

	@Override
	protected YearTouristStay newModel() {
		return new YearTouristStay();
	}

	@Override
	protected BooleanBuilder searchCondition(UserDetailsDto user, String keywords, YearTouristStayDto dto) {
		BooleanBuilder booleanBuilder = new BooleanBuilder();
		if(dto.getYear() != null) {
			booleanBuilder.and(qYearTouristStay.year.eq(dto.getYear()));
		}
		return booleanBuilder;
	}

}
