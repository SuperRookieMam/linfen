package com.dm.data.show.service.impl;

import java.time.ZoneId;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Service;
  
import com.dm.common.converter.AbstractConverter;
import com.dm.data.show.converter.HourScenicComfortConverter;
import com.dm.data.show.dto.HourScenicComfortDto;
import com.dm.data.show.entity.HourScenicComfort;
import com.dm.data.show.entity.QHourScenicComfort;
import com.dm.data.show.repository.HourScenicComfortRepository;
import com.dm.data.show.service.HourScenicComfortService;
import com.dm.kpi.core.service.impl.BaseIndexServiceImpl;
import com.dm.security.core.userdetails.UserDetailsDto;
import com.querydsl.core.BooleanBuilder;

@Service
public class HourScenicComfortServiceImpl extends BaseIndexServiceImpl<HourScenicComfort, HourScenicComfortDto> implements HourScenicComfortService {

	@Autowired
	private HourScenicComfortRepository hourScenicComfortRepository;

	@Autowired
	private HourScenicComfortConverter hourScenicComfortConverter;
	
	private final QHourScenicComfort qHourScenicComfort = QHourScenicComfort.hourScenicComfort;

	@Override
	protected JpaRepository<HourScenicComfort, Long> getRepository() {
		return hourScenicComfortRepository;
	}

	@Override
	protected QuerydslPredicateExecutor<HourScenicComfort> getQuerydsl() {
		return hourScenicComfortRepository;
	}

	@Override
	protected AbstractConverter<HourScenicComfort, HourScenicComfortDto> getConverter() {
		return hourScenicComfortConverter;
	}

	@Override
	protected HourScenicComfort newModel() {
		return new HourScenicComfort();
	}

	@Override
	protected BooleanBuilder searchCondition(UserDetailsDto user, String keywords, HourScenicComfortDto dto) {
		BooleanBuilder booleanBuilder = new BooleanBuilder();
		if(dto.getCurrentDate() != null) {
			booleanBuilder.and(qHourScenicComfort.currentDate.eq(dto.getCurrentDate()));
		}
		if(StringUtils.isNotBlank(dto.getName())) {
			booleanBuilder.and(qHourScenicComfort.name.eq(dto.getName()));
		}
		return booleanBuilder;
	}

}
