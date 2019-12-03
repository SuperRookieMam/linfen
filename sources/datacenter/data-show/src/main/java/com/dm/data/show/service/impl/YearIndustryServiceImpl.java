package com.dm.data.show.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Service;
  
import com.dm.common.converter.AbstractConverter;
import com.dm.data.show.converter.YearIndustryConverter;
import com.dm.data.show.dto.YearIndustryDto;
import com.dm.data.show.entity.QYearIndustry;
import com.dm.data.show.entity.YearIndustry;
import com.dm.data.show.repository.YearIndustryRepository;
import com.dm.data.show.service.YearIndustryService;
import com.dm.kpi.core.service.impl.BaseIndexServiceImpl;
import com.dm.security.core.userdetails.UserDetailsDto;
import com.querydsl.core.BooleanBuilder;

@Service
public class YearIndustryServiceImpl extends BaseIndexServiceImpl<YearIndustry, YearIndustryDto> implements YearIndustryService {

	@Autowired
	private YearIndustryRepository yearIndustryRepository;

	@Autowired
	private YearIndustryConverter yearIndustryConverter;
	
	private final QYearIndustry qYearIndustry = QYearIndustry.yearIndustry;

	@Override
	protected JpaRepository<YearIndustry, Long> getRepository() {
		return yearIndustryRepository;
	}

	@Override
	protected QuerydslPredicateExecutor<YearIndustry> getQuerydsl() {
		return yearIndustryRepository;
	}

	@Override
	protected AbstractConverter<YearIndustry, YearIndustryDto> getConverter() {
		return yearIndustryConverter;
	}

	@Override
	protected YearIndustry newModel() {
		return new YearIndustry();
	}

	@Override
	protected BooleanBuilder searchCondition(UserDetailsDto user, String keywords, YearIndustryDto dto) {
		BooleanBuilder booleanBuilder = new BooleanBuilder();
		if(dto.getYear() != null) {
			booleanBuilder.and(qYearIndustry.year.eq(dto.getYear()));
		}
		return booleanBuilder;
	}

}
