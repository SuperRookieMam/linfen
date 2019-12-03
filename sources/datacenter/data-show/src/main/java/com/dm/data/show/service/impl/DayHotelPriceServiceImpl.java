package com.dm.data.show.service.impl;

import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Service;
  
import com.dm.common.converter.AbstractConverter;
import com.dm.data.show.converter.DayHotelPriceConverter;
import com.dm.data.show.dto.DayHotelPriceDto;
import com.dm.data.show.entity.DayHotelPrice;
import com.dm.data.show.entity.QDayHotelPrice;
import com.dm.data.show.repository.DayHotelPriceRepository;
import com.dm.data.show.service.DayHotelPriceService;
import com.dm.kpi.core.service.impl.BaseIndexServiceImpl;
import com.dm.security.core.userdetails.UserDetailsDto;
import com.querydsl.core.BooleanBuilder;

@Service
public class DayHotelPriceServiceImpl extends BaseIndexServiceImpl<DayHotelPrice, DayHotelPriceDto> implements DayHotelPriceService {

	@Autowired
	private DayHotelPriceRepository dayHotelPriceRepository;

	@Autowired
	private DayHotelPriceConverter dayHotelPriceConverter;
	
	private final QDayHotelPrice qDayHotelPrice = QDayHotelPrice.dayHotelPrice;

	@Override
	protected JpaRepository<DayHotelPrice, Long> getRepository() {
		return dayHotelPriceRepository;
	}

	@Override
	protected QuerydslPredicateExecutor<DayHotelPrice> getQuerydsl() {
		return dayHotelPriceRepository;
	}

	@Override
	protected AbstractConverter<DayHotelPrice, DayHotelPriceDto> getConverter() {
		return dayHotelPriceConverter;
	}

	@Override
	protected DayHotelPrice newModel() {
		return new DayHotelPrice();
	}

	@Override
	protected BooleanBuilder searchCondition(UserDetailsDto user, String keywords, DayHotelPriceDto dto) {
		BooleanBuilder booleanBuilder = new BooleanBuilder();
		if(dto.getCurrentDate() != null) {
			booleanBuilder.and(qDayHotelPrice.currentDate.eq(dto.getCurrentDate().withZoneSameInstant(ZoneId.systemDefault()).toLocalDate()));
		}
		return booleanBuilder;
	}

}
