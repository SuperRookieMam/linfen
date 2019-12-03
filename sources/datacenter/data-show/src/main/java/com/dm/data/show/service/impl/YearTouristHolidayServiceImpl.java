package com.dm.data.show.service.impl;

import com.dm.common.converter.AbstractConverter;
import com.dm.data.show.converter.YearTouristHolidayConverter;
import com.dm.data.show.dto.YearTouristHolidayDto;
import com.dm.data.show.entity.QYearTouristHoliday;
import com.dm.data.show.entity.YearTouristHoliday;
import com.dm.data.show.repository.YearTouristHolidayRepository;
import com.dm.data.show.service.YearTouristHolidayService;
import com.dm.kpi.core.service.impl.BaseIndexServiceImpl;
import com.dm.security.core.userdetails.UserDetailsDto;
import com.querydsl.core.BooleanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Service;

@Service
public class YearTouristHolidayServiceImpl extends BaseIndexServiceImpl<YearTouristHoliday, YearTouristHolidayDto> implements YearTouristHolidayService {

	@Autowired
	private YearTouristHolidayRepository yearTouristHolidayRepository;

	@Autowired
	private YearTouristHolidayConverter yearTouristHolidayConverter;

	private final QYearTouristHoliday qYearTouristHoliday = QYearTouristHoliday.yearTouristHoliday;

	@Override
	protected JpaRepository<YearTouristHoliday, Long> getRepository() {
		return yearTouristHolidayRepository;
	}

	@Override
	protected QuerydslPredicateExecutor<YearTouristHoliday> getQuerydsl() {
		return yearTouristHolidayRepository;
	}

	@Override
	protected AbstractConverter<YearTouristHoliday, YearTouristHolidayDto> getConverter() {
		return yearTouristHolidayConverter;
	}

	@Override
	protected YearTouristHoliday newModel() {
		return new YearTouristHoliday();
	}

	@Override
	protected BooleanBuilder searchCondition(UserDetailsDto user, String keywords, YearTouristHolidayDto dto) {
		BooleanBuilder booleanBuilder = new BooleanBuilder();
		if(dto.getYear() != null) {
			booleanBuilder.and(qYearTouristHoliday.year.eq(dto.getYear()));
		}
		return booleanBuilder;
	}

}
