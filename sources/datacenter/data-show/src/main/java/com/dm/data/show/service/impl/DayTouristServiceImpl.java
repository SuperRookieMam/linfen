package com.dm.data.show.service.impl;

import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Service;
  
import com.dm.common.converter.AbstractConverter;
import com.dm.data.show.converter.DayTouristConverter;
import com.dm.data.show.dto.DayTouristDto;
import com.dm.data.show.entity.DayTourist;
import com.dm.data.show.entity.QDayTourist;
import com.dm.data.show.repository.DayTouristRepository;
import com.dm.data.show.service.DayTouristService;
import com.dm.kpi.core.service.impl.BaseIndexServiceImpl;
import com.dm.security.core.userdetails.UserDetailsDto;
import com.querydsl.core.BooleanBuilder;

@Service
public class DayTouristServiceImpl extends BaseIndexServiceImpl<DayTourist, DayTouristDto> implements DayTouristService {

	@Autowired
	private DayTouristRepository dayTouristRepository;

	@Autowired
	private DayTouristConverter dayTouristConverter;
	
	private final QDayTourist qDayTourist = QDayTourist.dayTourist;

	@Override
	protected JpaRepository<DayTourist, Long> getRepository() {
		return dayTouristRepository;
	}

	@Override
	protected QuerydslPredicateExecutor<DayTourist> getQuerydsl() {
		return dayTouristRepository;
	}

	@Override
	protected AbstractConverter<DayTourist, DayTouristDto> getConverter() {
		return dayTouristConverter;
	}

	@Override
	protected DayTourist newModel() {
		return new DayTourist();
	}

	@Override
	protected BooleanBuilder searchCondition(UserDetailsDto user, String keywords, DayTouristDto dto) {
		BooleanBuilder booleanBuilder = new BooleanBuilder();
		if(dto.getCurrentDate() != null) {
			booleanBuilder.and(qDayTourist.currentDate.eq(dto.getCurrentDate().withZoneSameInstant(ZoneId.systemDefault()).toLocalDate()));
		}
		return booleanBuilder;
	}

}
