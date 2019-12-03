package com.dm.data.show.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Service;
  
import com.dm.common.converter.AbstractConverter;
import com.dm.data.show.converter.YearScenicConverter;
import com.dm.data.show.dto.YearScenicDto;
import com.dm.data.show.entity.QYearScenic;
import com.dm.data.show.entity.YearScenic;
import com.dm.data.show.repository.YearScenicRepository;
import com.dm.data.show.service.YearScenicService;
import com.dm.kpi.core.service.impl.BaseIndexServiceImpl;
import com.dm.security.core.userdetails.UserDetailsDto;
import com.querydsl.core.BooleanBuilder;

@Service
public class YearScenicServiceImpl extends BaseIndexServiceImpl<YearScenic, YearScenicDto> implements YearScenicService {

	@Autowired
	private YearScenicRepository yearScenicRepository;

	@Autowired
	private YearScenicConverter yearScenicConverter;
	
	private final QYearScenic qYearScenic = QYearScenic.yearScenic;

	@Override
	protected JpaRepository<YearScenic, Long> getRepository() {
		return yearScenicRepository;
	}

	@Override
	protected QuerydslPredicateExecutor<YearScenic> getQuerydsl() {
		return yearScenicRepository;
	}

	@Override
	protected AbstractConverter<YearScenic, YearScenicDto> getConverter() {
		return yearScenicConverter;
	}

	@Override
	protected YearScenic newModel() {
		return new YearScenic();
	}

	@Override
	protected BooleanBuilder searchCondition(UserDetailsDto user, String keywords, YearScenicDto dto) {
		BooleanBuilder booleanBuilder = new BooleanBuilder();
		if(dto.getYear() != null) {
			booleanBuilder.and(qYearScenic.year.eq(dto.getYear()));
		}
		if(dto.getStartYear() != null && dto.getEndYear() != null) {
			booleanBuilder.and(qYearScenic.year.between(dto.getStartYear(), dto.getEndYear()));
		}
		return booleanBuilder;
	}

}
