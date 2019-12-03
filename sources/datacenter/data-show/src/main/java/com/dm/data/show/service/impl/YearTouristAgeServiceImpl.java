package com.dm.data.show.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Service;
  
import com.dm.common.converter.AbstractConverter;
import com.dm.data.show.converter.YearTouristAgeConverter;
import com.dm.data.show.dto.YearTouristAgeDto;
import com.dm.data.show.entity.QYearTouristAge;
import com.dm.data.show.entity.YearTouristAge;
import com.dm.data.show.repository.YearTouristAgeRepository;
import com.dm.data.show.service.YearTouristAgeService;
import com.dm.kpi.core.service.impl.BaseIndexServiceImpl;
import com.dm.security.core.userdetails.UserDetailsDto;
import com.querydsl.core.BooleanBuilder;

@Service
public class YearTouristAgeServiceImpl extends BaseIndexServiceImpl<YearTouristAge, YearTouristAgeDto> implements YearTouristAgeService {

	@Autowired
	private YearTouristAgeRepository yearTouristAgeRepository;

	@Autowired
	private YearTouristAgeConverter yearTouristAgeConverter;
	
	private final QYearTouristAge qYearTouristAge = QYearTouristAge.yearTouristAge;

	@Override
	protected JpaRepository<YearTouristAge, Long> getRepository() {
		return yearTouristAgeRepository;
	}

	@Override
	protected QuerydslPredicateExecutor<YearTouristAge> getQuerydsl() {
		return yearTouristAgeRepository;
	}

	@Override
	protected AbstractConverter<YearTouristAge, YearTouristAgeDto> getConverter() {
		return yearTouristAgeConverter;
	}

	@Override
	protected YearTouristAge newModel() {
		return new YearTouristAge();
	}

	@Override
	protected BooleanBuilder searchCondition(UserDetailsDto user, String keywords, YearTouristAgeDto dto) {
		BooleanBuilder booleanBuilder = new BooleanBuilder();
		if(dto.getYear() != null) {
			booleanBuilder.and(qYearTouristAge.year.eq(dto.getYear()));
		}
		return booleanBuilder;
	}

}
