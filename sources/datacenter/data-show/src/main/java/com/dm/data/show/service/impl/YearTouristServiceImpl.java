package com.dm.data.show.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Service;
  
import com.dm.common.converter.AbstractConverter;
import com.dm.data.show.converter.YearTouristConverter;
import com.dm.data.show.dto.YearTouristDto;
import com.dm.data.show.entity.QYearTourist;
import com.dm.data.show.entity.YearTourist;
import com.dm.data.show.repository.YearTouristRepository;
import com.dm.data.show.service.YearTouristService;
import com.dm.kpi.core.service.impl.BaseIndexServiceImpl;
import com.dm.security.core.userdetails.UserDetailsDto;
import com.querydsl.core.BooleanBuilder;

@Service
public class YearTouristServiceImpl extends BaseIndexServiceImpl<YearTourist, YearTouristDto> implements YearTouristService {

	@Autowired
	private YearTouristRepository yearTouristRepository;

	@Autowired
	private YearTouristConverter yearTouristConverter;
	
	private final QYearTourist qYearTourist = QYearTourist.yearTourist;

	@Override
	protected JpaRepository<YearTourist, Long> getRepository() {
		return yearTouristRepository;
	}

	@Override
	protected QuerydslPredicateExecutor<YearTourist> getQuerydsl() {
		return yearTouristRepository;
	}

	@Override
	protected AbstractConverter<YearTourist, YearTouristDto> getConverter() {
		return yearTouristConverter;
	}

	@Override
	protected YearTourist newModel() {
		return new YearTourist();
	}

	@Override
	protected BooleanBuilder searchCondition(UserDetailsDto user, String keywords, YearTouristDto dto) {
		BooleanBuilder booleanBuilder = new BooleanBuilder();
		if(dto.getYear() != null) {
			booleanBuilder.and(qYearTourist.year.eq(dto.getYear()));
		}
		return booleanBuilder;
	}

}
