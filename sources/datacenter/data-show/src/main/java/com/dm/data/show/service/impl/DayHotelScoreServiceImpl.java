package com.dm.data.show.service.impl;

import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Service;
  
import com.dm.common.converter.AbstractConverter;
import com.dm.data.show.converter.DayHotelScoreConverter;
import com.dm.data.show.dto.DayHotelScoreDto;
import com.dm.data.show.entity.DayHotelScore;
import com.dm.data.show.entity.QDayHotelScore;
import com.dm.data.show.repository.DayHotelScoreRepository;
import com.dm.data.show.service.DayHotelScoreService;
import com.dm.kpi.core.service.impl.BaseIndexServiceImpl;
import com.dm.security.core.userdetails.UserDetailsDto;
import com.querydsl.core.BooleanBuilder;

@Service
public class DayHotelScoreServiceImpl extends BaseIndexServiceImpl<DayHotelScore, DayHotelScoreDto> implements DayHotelScoreService {

	@Autowired
	private DayHotelScoreRepository dayHotelScoreRepository;

	@Autowired
	private DayHotelScoreConverter dayHotelScoreConverter;
	
	private final QDayHotelScore qDayHotelScore = QDayHotelScore.dayHotelScore;

	@Override
	protected JpaRepository<DayHotelScore, Long> getRepository() {
		return dayHotelScoreRepository;
	}

	@Override
	protected QuerydslPredicateExecutor<DayHotelScore> getQuerydsl() {
		return dayHotelScoreRepository;
	}

	@Override
	protected AbstractConverter<DayHotelScore, DayHotelScoreDto> getConverter() {
		return dayHotelScoreConverter;
	}

	@Override
	protected DayHotelScore newModel() {
		return new DayHotelScore();
	}

	@Override
	protected BooleanBuilder searchCondition(UserDetailsDto user, String keywords, DayHotelScoreDto dto) {
		BooleanBuilder booleanBuilder = new BooleanBuilder();
		if(dto.getCurrentDate() != null) {
			booleanBuilder.and(qDayHotelScore.currentDate.eq(dto.getCurrentDate().withZoneSameInstant(ZoneId.systemDefault()).toLocalDate()));
		}
		return booleanBuilder;
	}

}
