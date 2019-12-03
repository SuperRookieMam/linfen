package com.dm.data.show.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Service;
  
import com.dm.common.converter.AbstractConverter;
import com.dm.data.show.converter.YearRegionConverter;
import com.dm.data.show.dto.YearRegionDto;
import com.dm.data.show.entity.QYearRegion;
import com.dm.data.show.entity.YearRegion;
import com.dm.data.show.repository.YearRegionRepository;
import com.dm.data.show.service.YearRegionService;
import com.dm.kpi.core.service.impl.BaseIndexServiceImpl;
import com.dm.security.core.userdetails.UserDetailsDto;
import com.querydsl.core.BooleanBuilder;

@Service
public class YearRegionServiceImpl extends BaseIndexServiceImpl<YearRegion, YearRegionDto> implements YearRegionService {

	@Autowired
	private YearRegionRepository yearRegionRepository;

	@Autowired
	private YearRegionConverter yearRegionConverter;
	
	private final QYearRegion qYearRegion = QYearRegion.yearRegion;

	@Override
	protected JpaRepository<YearRegion, Long> getRepository() {
		return yearRegionRepository;
	}

	@Override
	protected QuerydslPredicateExecutor<YearRegion> getQuerydsl() {
		return yearRegionRepository;
	}

	@Override
	protected AbstractConverter<YearRegion, YearRegionDto> getConverter() {
		return yearRegionConverter;
	}

	@Override
	protected YearRegion newModel() {
		return new YearRegion();
	}

	@Override
	protected BooleanBuilder searchCondition(UserDetailsDto user, String keywords, YearRegionDto dto) {
		BooleanBuilder booleanBuilder = new BooleanBuilder();
		if(dto.getYear() != null) {
			booleanBuilder.and(qYearRegion.year.eq(dto.getYear()));
		}
		return booleanBuilder;
	}

}
