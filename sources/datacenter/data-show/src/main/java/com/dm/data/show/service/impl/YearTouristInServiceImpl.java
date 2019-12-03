package com.dm.data.show.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Service;
  
import com.dm.common.converter.AbstractConverter;
import com.dm.data.show.converter.YearTouristInConverter;
import com.dm.data.show.dto.YearTouristInDto;
import com.dm.data.show.entity.QYearTouristIn;
import com.dm.data.show.entity.YearTouristIn;
import com.dm.data.show.repository.YearTouristInRepository;
import com.dm.data.show.service.YearTouristInService;
import com.dm.kpi.core.service.impl.BaseIndexServiceImpl;
import com.dm.security.core.userdetails.UserDetailsDto;
import com.querydsl.core.BooleanBuilder;

@Service
public class YearTouristInServiceImpl extends BaseIndexServiceImpl<YearTouristIn, YearTouristInDto> implements YearTouristInService {

	@Autowired
	private YearTouristInRepository yearTouristInRepository;

	@Autowired
	private YearTouristInConverter yearTouristInConverter;
	
	private final QYearTouristIn qYearTouristIn = QYearTouristIn.yearTouristIn;

	@Override
	protected JpaRepository<YearTouristIn, Long> getRepository() {
		return yearTouristInRepository;
	}

	@Override
	protected QuerydslPredicateExecutor<YearTouristIn> getQuerydsl() {
		return yearTouristInRepository;
	}

	@Override
	protected AbstractConverter<YearTouristIn, YearTouristInDto> getConverter() {
		return yearTouristInConverter;
	}

	@Override
	protected YearTouristIn newModel() {
		return new YearTouristIn();
	}

	@Override
	protected BooleanBuilder searchCondition(UserDetailsDto user, String keywords, YearTouristInDto dto) {
		BooleanBuilder booleanBuilder = new BooleanBuilder();
		if(dto.getYear() != null) {
			booleanBuilder.and(qYearTouristIn.year.eq(dto.getYear()));
		}
		return booleanBuilder;
	}

}
