package com.dm.data.show.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Service;
  
import com.dm.common.converter.AbstractConverter;
import com.dm.data.show.converter.HourScenicConverter;
import com.dm.data.show.dto.HourScenicDto;
import com.dm.data.show.entity.HourScenic;
import com.dm.data.show.entity.QHourScenic;
import com.dm.data.show.repository.HourScenicRepository;
import com.dm.data.show.service.HourScenicService;
import com.dm.kpi.core.service.impl.BaseIndexServiceImpl;
import com.dm.security.core.userdetails.UserDetailsDto;
import com.querydsl.core.BooleanBuilder;

@Service
public class HourScenicServiceImpl extends BaseIndexServiceImpl<HourScenic, HourScenicDto> implements HourScenicService {

	@Autowired
	private HourScenicRepository hourScenicRepository;

	@Autowired
	private HourScenicConverter hourScenicConverter;
	
	private final QHourScenic qHourScenic = QHourScenic.hourScenic;

	@Override
	protected JpaRepository<HourScenic, Long> getRepository() {
		return hourScenicRepository;
	}

	@Override
	protected QuerydslPredicateExecutor<HourScenic> getQuerydsl() {
		return hourScenicRepository;
	}

	@Override
	protected AbstractConverter<HourScenic, HourScenicDto> getConverter() {
		return hourScenicConverter;
	}

	@Override
	protected HourScenic newModel() {
		return new HourScenic();
	}

	@Override
	protected BooleanBuilder searchCondition(UserDetailsDto user, String keywords, HourScenicDto dto) {
		BooleanBuilder booleanBuilder = new BooleanBuilder();
		if(dto.getCurrentDate() != null) {
			booleanBuilder.and(qHourScenic.currentDate.eq(dto.getCurrentDate()));
		}
		if(StringUtils.isNotBlank(dto.getName())) {
			booleanBuilder.and(qHourScenic.name.eq(dto.getName()));
		}
		return booleanBuilder;
	}

}
