package com.dm.data.show.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Service;
  
import com.dm.common.converter.AbstractConverter;
import com.dm.data.show.converter.YearFeelingConverter;
import com.dm.data.show.dto.YearFeelingDto;
import com.dm.data.show.entity.QYearFeeling;
import com.dm.data.show.entity.YearFeeling;
import com.dm.data.show.repository.YearFeelingRepository;
import com.dm.data.show.service.YearFeelingService;
import com.dm.kpi.core.service.impl.BaseIndexServiceImpl;
import com.dm.security.core.userdetails.UserDetailsDto;
import com.querydsl.core.BooleanBuilder;

@Service
public class YearFeelingServiceImpl extends BaseIndexServiceImpl<YearFeeling, YearFeelingDto> implements YearFeelingService {

	@Autowired
	private YearFeelingRepository yearFeelingRepository;

	@Autowired
	private YearFeelingConverter yearFeelingConverter;
	
	private final QYearFeeling qYearFeeling = QYearFeeling.yearFeeling;

	@Override
	protected JpaRepository<YearFeeling, Long> getRepository() {
		return yearFeelingRepository;
	}

	@Override
	protected QuerydslPredicateExecutor<YearFeeling> getQuerydsl() {
		return yearFeelingRepository;
	}

	@Override
	protected AbstractConverter<YearFeeling, YearFeelingDto> getConverter() {
		return yearFeelingConverter;
	}

	@Override
	protected YearFeeling newModel() {
		return new YearFeeling();
	}

	@Override
	protected BooleanBuilder searchCondition(UserDetailsDto user, String keywords, YearFeelingDto dto) {
		BooleanBuilder booleanBuilder = new BooleanBuilder();
		if(dto.getYear() != null) {
			booleanBuilder.and(qYearFeeling.year.eq(dto.getYear()));
		}
		return booleanBuilder;
	}

}
