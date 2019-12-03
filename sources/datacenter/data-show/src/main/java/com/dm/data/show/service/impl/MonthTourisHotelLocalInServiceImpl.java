package com.dm.data.show.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Service;
  
import com.dm.common.converter.AbstractConverter;
import com.dm.data.show.converter.MonthTourisHotelLocalInConverter;
import com.dm.data.show.dto.MonthTourisHotelLocalInDto;
import com.dm.data.show.entity.MonthTourisHotelLocalIn;
import com.dm.data.show.entity.QMonthTourisHotelLocalIn;
import com.dm.data.show.repository.MonthTourisHotelLocalInRepository;
import com.dm.data.show.service.MonthTourisHotelLocalInService;
import com.dm.kpi.core.service.impl.BaseIndexServiceImpl;
import com.dm.security.core.userdetails.UserDetailsDto;
import com.querydsl.core.BooleanBuilder;

@Service
public class MonthTourisHotelLocalInServiceImpl extends BaseIndexServiceImpl<MonthTourisHotelLocalIn, MonthTourisHotelLocalInDto> implements MonthTourisHotelLocalInService {

	@Autowired
	private MonthTourisHotelLocalInRepository monthTourisHotelLocalInRepository;

	@Autowired
	private MonthTourisHotelLocalInConverter monthTourisHotelLocalInConverter;
	
	private final QMonthTourisHotelLocalIn qMonthTourisHotelLocalIn = QMonthTourisHotelLocalIn.monthTourisHotelLocalIn;

	@Override
	protected JpaRepository<MonthTourisHotelLocalIn, Long> getRepository() {
		return monthTourisHotelLocalInRepository;
	}

	@Override
	protected QuerydslPredicateExecutor<MonthTourisHotelLocalIn> getQuerydsl() {
		return monthTourisHotelLocalInRepository;
	}

	@Override
	protected AbstractConverter<MonthTourisHotelLocalIn, MonthTourisHotelLocalInDto> getConverter() {
		return monthTourisHotelLocalInConverter;
	}

	@Override
	protected MonthTourisHotelLocalIn newModel() {
		return new MonthTourisHotelLocalIn();
	}

	@Override
	protected BooleanBuilder searchCondition(UserDetailsDto user, String keywords, MonthTourisHotelLocalInDto dto) {
		BooleanBuilder booleanBuilder = new BooleanBuilder();
		if(dto.getYear() != null) {
			booleanBuilder.and(qMonthTourisHotelLocalIn.year.eq(dto.getYear()));
		}
		if(dto.getMonth() != null) {
			booleanBuilder.and(qMonthTourisHotelLocalIn.month.eq(dto.getMonth()));
		}
		return booleanBuilder;
	}

}
