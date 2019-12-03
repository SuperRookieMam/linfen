package com.dm.data.show.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Service;
  
import com.dm.common.converter.AbstractConverter;
import com.dm.data.show.converter.YearTouristConsumeConverter;
import com.dm.data.show.dto.YearTouristConsumeDto;
import com.dm.data.show.entity.QYearTouristConsume;
import com.dm.data.show.entity.YearTouristConsume;
import com.dm.data.show.repository.YearTouristConsumeRepository;
import com.dm.data.show.service.YearTouristConsumeService;
import com.dm.kpi.core.service.impl.BaseIndexServiceImpl;
import com.dm.security.core.userdetails.UserDetailsDto;
import com.querydsl.core.BooleanBuilder;

@Service
public class YearTouristConsumeServiceImpl extends BaseIndexServiceImpl<YearTouristConsume, YearTouristConsumeDto> implements YearTouristConsumeService {

	@Autowired
	private YearTouristConsumeRepository yearTouristConsumeRepository;

	@Autowired
	private YearTouristConsumeConverter yearTouristConsumeConverter;
	
	private final QYearTouristConsume qYearTouristConsume = QYearTouristConsume.yearTouristConsume;

	@Override
	protected JpaRepository<YearTouristConsume, Long> getRepository() {
		return yearTouristConsumeRepository;
	}

	@Override
	protected QuerydslPredicateExecutor<YearTouristConsume> getQuerydsl() {
		return yearTouristConsumeRepository;
	}

	@Override
	protected AbstractConverter<YearTouristConsume, YearTouristConsumeDto> getConverter() {
		return yearTouristConsumeConverter;
	}

	@Override
	protected YearTouristConsume newModel() {
		return new YearTouristConsume();
	}

	@Override
	protected BooleanBuilder searchCondition(UserDetailsDto user, String keywords, YearTouristConsumeDto dto) {
		BooleanBuilder booleanBuilder = new BooleanBuilder();
		if(dto.getYear() != null) {
			booleanBuilder.and(qYearTouristConsume.year.eq(dto.getYear()));
		}
		return booleanBuilder;
	}

}
