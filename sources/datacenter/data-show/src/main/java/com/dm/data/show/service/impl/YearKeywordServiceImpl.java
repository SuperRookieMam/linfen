package com.dm.data.show.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Service;
  
import com.dm.common.converter.AbstractConverter;
import com.dm.data.show.converter.YearKeywordConverter;
import com.dm.data.show.dto.YearKeywordDto;
import com.dm.data.show.entity.QYearKeyword;
import com.dm.data.show.entity.YearKeyword;
import com.dm.data.show.repository.YearKeywordRepository;
import com.dm.data.show.service.YearKeywordService;
import com.dm.kpi.core.service.impl.BaseIndexServiceImpl;
import com.dm.security.core.userdetails.UserDetailsDto;
import com.querydsl.core.BooleanBuilder;

@Service
public class YearKeywordServiceImpl extends BaseIndexServiceImpl<YearKeyword, YearKeywordDto> implements YearKeywordService {

	@Autowired
	private YearKeywordRepository yearKeywordRepository;

	@Autowired
	private YearKeywordConverter yearKeywordConverter;
	
	private final QYearKeyword qYearKeyword = QYearKeyword.yearKeyword;

	@Override
	protected JpaRepository<YearKeyword, Long> getRepository() {
		return yearKeywordRepository;
	}

	@Override
	protected QuerydslPredicateExecutor<YearKeyword> getQuerydsl() {
		return yearKeywordRepository;
	}

	@Override
	protected AbstractConverter<YearKeyword, YearKeywordDto> getConverter() {
		return yearKeywordConverter;
	}

	@Override
	protected YearKeyword newModel() {
		return new YearKeyword();
	}

	@Override
	protected BooleanBuilder searchCondition(UserDetailsDto user, String keywords, YearKeywordDto dto) {
		BooleanBuilder booleanBuilder = new BooleanBuilder();
		if(dto.getYear() != null) {
			booleanBuilder.and(qYearKeyword.year.eq(dto.getYear()));
		}
		return booleanBuilder;
	}

}
