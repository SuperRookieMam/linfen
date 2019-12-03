package com.dm.data.show.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Service;
  
import com.dm.common.converter.AbstractConverter;
import com.dm.data.show.converter.YearTouristScenicConverter;
import com.dm.data.show.dto.YearTouristScenicDto;
import com.dm.data.show.entity.QYearTouristScenic;
import com.dm.data.show.entity.YearTouristScenic;
import com.dm.data.show.repository.YearTouristScenicRepository;
import com.dm.data.show.service.YearTouristScenicService;
import com.dm.kpi.core.service.impl.BaseIndexServiceImpl;
import com.dm.security.core.userdetails.UserDetailsDto;
import com.querydsl.core.BooleanBuilder;

@Service
public class YearTouristScenicServiceImpl extends BaseIndexServiceImpl<YearTouristScenic, YearTouristScenicDto> implements YearTouristScenicService {

	@Autowired
	private YearTouristScenicRepository yearTouristScenicRepository;

	@Autowired
	private YearTouristScenicConverter yearTouristScenicConverter;
	
	private final QYearTouristScenic qYearTouristScenic = QYearTouristScenic.yearTouristScenic;

	@Override
	protected JpaRepository<YearTouristScenic, Long> getRepository() {
		return yearTouristScenicRepository;
	}

	@Override
	protected QuerydslPredicateExecutor<YearTouristScenic> getQuerydsl() {
		return yearTouristScenicRepository;
	}

	@Override
	protected AbstractConverter<YearTouristScenic, YearTouristScenicDto> getConverter() {
		return yearTouristScenicConverter;
	}

	@Override
	protected YearTouristScenic newModel() {
		return new YearTouristScenic();
	}

	@Override
	protected BooleanBuilder searchCondition(UserDetailsDto user, String keywords, YearTouristScenicDto dto) {
		BooleanBuilder booleanBuilder = new BooleanBuilder();
		if(dto.getYear() != null) {
			booleanBuilder.and(qYearTouristScenic.year.eq(dto.getYear()));
		}
		return booleanBuilder;
	}

}
