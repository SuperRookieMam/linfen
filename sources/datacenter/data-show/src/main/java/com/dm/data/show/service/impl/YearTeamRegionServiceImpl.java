package com.dm.data.show.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Service;
  
import com.dm.common.converter.AbstractConverter;
import com.dm.data.show.converter.YearTeamRegionConverter;
import com.dm.data.show.dto.YearTeamRegionDto;
import com.dm.data.show.entity.QYearTeamRegion;
import com.dm.data.show.entity.YearTeamRegion;
import com.dm.data.show.repository.YearTeamRegionRepository;
import com.dm.data.show.service.YearTeamRegionService;
import com.dm.kpi.core.service.impl.BaseIndexServiceImpl;
import com.dm.security.core.userdetails.UserDetailsDto;
import com.querydsl.core.BooleanBuilder;

@Service
public class YearTeamRegionServiceImpl extends BaseIndexServiceImpl<YearTeamRegion, YearTeamRegionDto> implements YearTeamRegionService {

	@Autowired
	private YearTeamRegionRepository yearTeamRegionRepository;

	@Autowired
	private YearTeamRegionConverter yearTeamRegionConverter;
	
	private final QYearTeamRegion qYearTeamRegion = QYearTeamRegion.yearTeamRegion;

	@Override
	protected JpaRepository<YearTeamRegion, Long> getRepository() {
		return yearTeamRegionRepository;
	}

	@Override
	protected QuerydslPredicateExecutor<YearTeamRegion> getQuerydsl() {
		return yearTeamRegionRepository;
	}

	@Override
	protected AbstractConverter<YearTeamRegion, YearTeamRegionDto> getConverter() {
		return yearTeamRegionConverter;
	}

	@Override
	protected YearTeamRegion newModel() {
		return new YearTeamRegion();
	}

	@Override
	protected BooleanBuilder searchCondition(UserDetailsDto user, String keywords, YearTeamRegionDto dto) {
		BooleanBuilder booleanBuilder = new BooleanBuilder();
		if(dto.getYear() != null) {
			booleanBuilder.and(qYearTeamRegion.year.eq(dto.getYear()));
		}
		return booleanBuilder;
	}

}
