package com.dm.data.show.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Service;
  
import com.dm.common.converter.AbstractConverter;
import com.dm.data.show.converter.YearTouristHolidayTypeConverter;
import com.dm.data.show.dto.YearTouristHolidayTypeDto;
import com.dm.data.show.entity.QYearTouristHolidayType;
import com.dm.data.show.entity.YearTouristHolidayType;
import com.dm.data.show.repository.YearTouristHolidayTypeRepository;
import com.dm.data.show.service.YearTouristHolidayTypeService;
import com.dm.kpi.core.service.impl.BaseIndexServiceImpl;
import com.dm.security.core.userdetails.UserDetailsDto;
import com.querydsl.core.BooleanBuilder;

@Service
public class YearTouristHolidayTypeServiceImpl extends BaseIndexServiceImpl<YearTouristHolidayType, YearTouristHolidayTypeDto> implements YearTouristHolidayTypeService {

	@Autowired
	private YearTouristHolidayTypeRepository yearTouristHolidayTypeRepository;

	@Autowired
	private YearTouristHolidayTypeConverter yearTouristHolidayTypeConverter;
	
	private final QYearTouristHolidayType qYearTouristHolidayType = QYearTouristHolidayType.yearTouristHolidayType;

	@Override
	protected JpaRepository<YearTouristHolidayType, Long> getRepository() {
		return yearTouristHolidayTypeRepository;
	}

	@Override
	protected QuerydslPredicateExecutor<YearTouristHolidayType> getQuerydsl() {
		return yearTouristHolidayTypeRepository;
	}

	@Override
	protected AbstractConverter<YearTouristHolidayType, YearTouristHolidayTypeDto> getConverter() {
		return yearTouristHolidayTypeConverter;
	}

	@Override
	protected YearTouristHolidayType newModel() {
		return new YearTouristHolidayType();
	}

	@Override
	protected BooleanBuilder searchCondition(UserDetailsDto user, String keywords, YearTouristHolidayTypeDto dto) {
		BooleanBuilder booleanBuilder = new BooleanBuilder();
		if(dto.getYear() != null) {
			booleanBuilder.and(qYearTouristHolidayType.year.eq(dto.getYear()));
		}
		return booleanBuilder;
	}

}
