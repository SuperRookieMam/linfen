package com.dm.data.show.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Service;
  
import com.dm.common.converter.AbstractConverter;
import com.dm.data.show.converter.YearTouristHotelConverter;
import com.dm.data.show.dto.YearTouristHotelDto;
import com.dm.data.show.entity.QYearTouristHotel;
import com.dm.data.show.entity.YearTouristHotel;
import com.dm.data.show.repository.YearTouristHotelRepository;
import com.dm.data.show.service.YearTouristHotelService;
import com.dm.kpi.core.service.impl.BaseIndexServiceImpl;
import com.dm.security.core.userdetails.UserDetailsDto;
import com.querydsl.core.BooleanBuilder;

@Service
public class YearTouristHotelServiceImpl extends BaseIndexServiceImpl<YearTouristHotel, YearTouristHotelDto> implements YearTouristHotelService {

	@Autowired
	private YearTouristHotelRepository yearTouristHotelRepository;

	@Autowired
	private YearTouristHotelConverter yearTouristHotelConverter;
	
	private final QYearTouristHotel qYearTouristHotel = QYearTouristHotel.yearTouristHotel;

	@Override
	protected JpaRepository<YearTouristHotel, Long> getRepository() {
		return yearTouristHotelRepository;
	}

	@Override
	protected QuerydslPredicateExecutor<YearTouristHotel> getQuerydsl() {
		return yearTouristHotelRepository;
	}

	@Override
	protected AbstractConverter<YearTouristHotel, YearTouristHotelDto> getConverter() {
		return yearTouristHotelConverter;
	}

	@Override
	protected YearTouristHotel newModel() {
		return new YearTouristHotel();
	}

	@Override
	protected BooleanBuilder searchCondition(UserDetailsDto user, String keywords, YearTouristHotelDto dto) {
		BooleanBuilder booleanBuilder = new BooleanBuilder();
		if(dto.getYear() != null) {
			booleanBuilder.and(qYearTouristHotel.year.eq(dto.getYear()));
		}
		return booleanBuilder;
	}

}
