package com.dm.data.show.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Service;
  
import com.dm.common.converter.AbstractConverter;
import com.dm.data.show.converter.YearCityConverter;
import com.dm.data.show.dto.YearCityDto;
import com.dm.data.show.entity.QYearCity;
import com.dm.data.show.entity.YearCity;
import com.dm.data.show.repository.YearCityRepository;
import com.dm.data.show.service.YearCityService;
import com.dm.kpi.core.service.impl.BaseIndexServiceImpl;
import com.dm.security.core.userdetails.UserDetailsDto;
import com.querydsl.core.BooleanBuilder;

@Service
public class YearCityServiceImpl extends BaseIndexServiceImpl<YearCity, YearCityDto> implements YearCityService {

	@Autowired
	private YearCityRepository yearCityRepository;

	@Autowired
	private YearCityConverter yearCityConverter;
	
	private final QYearCity qYearCity = QYearCity.yearCity;

	@Override
	protected JpaRepository<YearCity, Long> getRepository() {
		return yearCityRepository;
	}

	@Override
	protected QuerydslPredicateExecutor<YearCity> getQuerydsl() {
		return yearCityRepository;
	}

	@Override
	protected AbstractConverter<YearCity, YearCityDto> getConverter() {
		return yearCityConverter;
	}

	@Override
	protected YearCity newModel() {
		return new YearCity();
	}

	@Override
	protected BooleanBuilder searchCondition(UserDetailsDto user, String keywords, YearCityDto dto) {
		BooleanBuilder booleanBuilder = new BooleanBuilder();
		if(dto.getYear() != null) {
			booleanBuilder.and(qYearCity.year.eq(dto.getYear()));
		}
		return booleanBuilder;
	}

}
