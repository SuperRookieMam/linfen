package com.dm.data.show.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Service;
  
import com.dm.common.converter.AbstractConverter;
import com.dm.data.show.converter.YearTeamGenderAgeConverter;
import com.dm.data.show.dto.YearTeamGenderAgeDto;
import com.dm.data.show.entity.QYearTeamGenderAge;
import com.dm.data.show.entity.YearTeamGenderAge;
import com.dm.data.show.repository.YearTeamGenderAgeRepository;
import com.dm.data.show.service.YearTeamGenderAgeService;
import com.dm.kpi.core.service.impl.BaseIndexServiceImpl;
import com.dm.security.core.userdetails.UserDetailsDto;
import com.querydsl.core.BooleanBuilder;

@Service
public class YearTeamGenderAgeServiceImpl extends BaseIndexServiceImpl<YearTeamGenderAge, YearTeamGenderAgeDto> implements YearTeamGenderAgeService {

	@Autowired
	private YearTeamGenderAgeRepository yearTeamGenderAgeRepository;

	@Autowired
	private YearTeamGenderAgeConverter yearTeamGenderAgeConverter;
	
	private final QYearTeamGenderAge qYearTeamGenderAge = QYearTeamGenderAge.yearTeamGenderAge;

	@Override
	protected JpaRepository<YearTeamGenderAge, Long> getRepository() {
		return yearTeamGenderAgeRepository;
	}

	@Override
	protected QuerydslPredicateExecutor<YearTeamGenderAge> getQuerydsl() {
		return yearTeamGenderAgeRepository;
	}

	@Override
	protected AbstractConverter<YearTeamGenderAge, YearTeamGenderAgeDto> getConverter() {
		return yearTeamGenderAgeConverter;
	}

	@Override
	protected YearTeamGenderAge newModel() {
		return new YearTeamGenderAge();
	}

	@Override
	protected BooleanBuilder searchCondition(UserDetailsDto user, String keywords, YearTeamGenderAgeDto dto) {
		BooleanBuilder booleanBuilder = new BooleanBuilder();
		if(dto.getYear() != null) {
			booleanBuilder.and(qYearTeamGenderAge.year.eq(dto.getYear()));
		}
		return booleanBuilder;
	}

}
