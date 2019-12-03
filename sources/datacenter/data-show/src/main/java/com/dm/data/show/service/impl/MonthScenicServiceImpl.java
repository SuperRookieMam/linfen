package com.dm.data.show.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Service;
  
import com.dm.common.converter.AbstractConverter;
import com.dm.data.show.converter.MonthScenicConverter;
import com.dm.data.show.dto.MonthScenicDto;
import com.dm.data.show.entity.MonthScenic;
import com.dm.data.show.entity.QMonthScenic;
import com.dm.data.show.repository.MonthScenicRepository;
import com.dm.data.show.service.MonthScenicService;
import com.dm.kpi.core.service.impl.BaseIndexServiceImpl;
import com.dm.security.core.userdetails.UserDetailsDto;
import com.querydsl.core.BooleanBuilder;

@Service
public class MonthScenicServiceImpl extends BaseIndexServiceImpl<MonthScenic, MonthScenicDto> implements MonthScenicService {

	@Autowired
	private MonthScenicRepository monthScenicRepository;

	@Autowired
	private MonthScenicConverter monthScenicConverter;
	
	private final QMonthScenic qMonthScenic = QMonthScenic.monthScenic;

	@Override
	protected JpaRepository<MonthScenic, Long> getRepository() {
		return monthScenicRepository;
	}

	@Override
	protected QuerydslPredicateExecutor<MonthScenic> getQuerydsl() {
		return monthScenicRepository;
	}

	@Override
	protected AbstractConverter<MonthScenic, MonthScenicDto> getConverter() {
		return monthScenicConverter;
	}

	@Override
	protected MonthScenic newModel() {
		return new MonthScenic();
	}

	@Override
	protected BooleanBuilder searchCondition(UserDetailsDto user, String keywords, MonthScenicDto dto) {
		BooleanBuilder booleanBuilder = new BooleanBuilder();
		if(dto.getYear() != null) {
			booleanBuilder.and(qMonthScenic.year.eq(dto.getYear()));
		}
		if(dto.getMonth() != null) {
			booleanBuilder.and(qMonthScenic.month.eq(dto.getMonth()));
		}
		if(StringUtils.isNotBlank(dto.getName())) {
			booleanBuilder.and(qMonthScenic.name.eq(dto.getName()));
		}
		return booleanBuilder;
	}

}
