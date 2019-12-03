package com.dm.data.show.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Service;
  
import com.dm.common.converter.AbstractConverter;
import com.dm.data.show.converter.YearTouristTrafficConverter;
import com.dm.data.show.dto.YearTouristTrafficDto;
import com.dm.data.show.entity.QYearTouristTraffic;
import com.dm.data.show.entity.YearTouristTraffic;
import com.dm.data.show.repository.YearTouristTrafficRepository;
import com.dm.data.show.service.YearTouristTrafficService;
import com.dm.kpi.core.service.impl.BaseIndexServiceImpl;
import com.dm.security.core.userdetails.UserDetailsDto;
import com.querydsl.core.BooleanBuilder;

@Service
public class YearTouristTrafficServiceImpl extends BaseIndexServiceImpl<YearTouristTraffic, YearTouristTrafficDto> implements YearTouristTrafficService {

	@Autowired
	private YearTouristTrafficRepository yearTouristTrafficRepository;

	@Autowired
	private YearTouristTrafficConverter yearTouristTrafficConverter;
	
	private final QYearTouristTraffic qYearTouristTraffic = QYearTouristTraffic.yearTouristTraffic;

	@Override
	protected JpaRepository<YearTouristTraffic, Long> getRepository() {
		return yearTouristTrafficRepository;
	}

	@Override
	protected QuerydslPredicateExecutor<YearTouristTraffic> getQuerydsl() {
		return yearTouristTrafficRepository;
	}

	@Override
	protected AbstractConverter<YearTouristTraffic, YearTouristTrafficDto> getConverter() {
		return yearTouristTrafficConverter;
	}

	@Override
	protected YearTouristTraffic newModel() {
		return new YearTouristTraffic();
	}

	@Override
	protected BooleanBuilder searchCondition(UserDetailsDto user, String keywords, YearTouristTrafficDto dto) {
		BooleanBuilder booleanBuilder = new BooleanBuilder();
		if(dto.getYear() != null) {
			booleanBuilder.and(qYearTouristTraffic.year.eq(dto.getYear()));
		}
		return booleanBuilder;
	}

}
