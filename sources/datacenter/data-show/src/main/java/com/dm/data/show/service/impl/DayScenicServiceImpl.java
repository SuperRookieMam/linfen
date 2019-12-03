package com.dm.data.show.service.impl;

import java.time.ZoneId;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Service;
  
import com.dm.common.converter.AbstractConverter;
import com.dm.data.show.converter.DayScenicConverter;
import com.dm.data.show.dto.DayScenicDto;
import com.dm.data.show.entity.DayScenic;
import com.dm.data.show.entity.QDayScenic;
import com.dm.data.show.repository.DayScenicRepository;
import com.dm.data.show.service.DayScenicService;
import com.dm.kpi.core.service.impl.BaseIndexServiceImpl;
import com.dm.security.core.userdetails.UserDetailsDto;
import com.querydsl.core.BooleanBuilder;

@Service
public class DayScenicServiceImpl extends BaseIndexServiceImpl<DayScenic, DayScenicDto> implements DayScenicService {

	@Autowired
	private DayScenicRepository dayScenicRepository;

	@Autowired
	private DayScenicConverter dayScenicConverter;
	
	private final QDayScenic qDayScenic = QDayScenic.dayScenic;

	@Override
	protected JpaRepository<DayScenic, Long> getRepository() {
		return dayScenicRepository;
	}

	@Override
	protected QuerydslPredicateExecutor<DayScenic> getQuerydsl() {
		return dayScenicRepository;
	}

	@Override
	protected AbstractConverter<DayScenic, DayScenicDto> getConverter() {
		return dayScenicConverter;
	}

	@Override
	protected DayScenic newModel() {
		return new DayScenic();
	}

	@Override
	protected BooleanBuilder searchCondition(UserDetailsDto user, String keywords, DayScenicDto dto) {
		BooleanBuilder booleanBuilder = new BooleanBuilder();
		if(dto.getCurrentDate() != null) {
			booleanBuilder.and(qDayScenic.currentDate.eq(dto.getCurrentDate().withZoneSameInstant(ZoneId.systemDefault()).toLocalDate()));
		}
		if(StringUtils.isNotBlank(dto.getName())) {
			booleanBuilder.and(qDayScenic.name.eq(dto.getName()));
		}
		return booleanBuilder;
	}

}
