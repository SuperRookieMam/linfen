package com.dm.data.show.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Service;
  
import com.dm.common.converter.AbstractConverter;
import com.dm.data.show.converter.YearTouristGenderConverter;
import com.dm.data.show.dto.YearTouristGenderDto;
import com.dm.data.show.entity.QYearTouristGender;
import com.dm.data.show.entity.YearTouristGender;
import com.dm.data.show.repository.YearTouristGenderRepository;
import com.dm.data.show.service.YearTouristGenderService;
import com.dm.kpi.core.service.impl.BaseIndexServiceImpl;
import com.dm.security.core.userdetails.UserDetailsDto;
import com.querydsl.core.BooleanBuilder;

@Service
public class YearTouristGenderServiceImpl extends BaseIndexServiceImpl<YearTouristGender, YearTouristGenderDto> implements YearTouristGenderService {

	@Autowired
	private YearTouristGenderRepository yearTouristGenderRepository;

	@Autowired
	private YearTouristGenderConverter yearTouristGenderConverter;
	
	private final QYearTouristGender qYearTouristGender = QYearTouristGender.yearTouristGender;

	@Override
	protected JpaRepository<YearTouristGender, Long> getRepository() {
		return yearTouristGenderRepository;
	}

	@Override
	protected QuerydslPredicateExecutor<YearTouristGender> getQuerydsl() {
		return yearTouristGenderRepository;
	}

	@Override
	protected AbstractConverter<YearTouristGender, YearTouristGenderDto> getConverter() {
		return yearTouristGenderConverter;
	}

	@Override
	protected YearTouristGender newModel() {
		return new YearTouristGender();
	}

	@Override
	protected BooleanBuilder searchCondition(UserDetailsDto user, String keywords, YearTouristGenderDto dto) {
		BooleanBuilder booleanBuilder = new BooleanBuilder();
		if(dto.getYear() != null) {
			booleanBuilder.and(qYearTouristGender.year.eq(dto.getYear()));
		}
		return booleanBuilder;
	}

}
