package com.dm.data.show.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Service;
  
import com.dm.common.converter.AbstractConverter;
import com.dm.data.show.converter.YearMediaConverter;
import com.dm.data.show.dto.YearMediaDto;
import com.dm.data.show.entity.QYearMedia;
import com.dm.data.show.entity.YearMedia;
import com.dm.data.show.repository.YearMediaRepository;
import com.dm.data.show.service.YearMediaService;
import com.dm.kpi.core.service.impl.BaseIndexServiceImpl;
import com.dm.security.core.userdetails.UserDetailsDto;
import com.querydsl.core.BooleanBuilder;

@Service
public class YearMediaServiceImpl extends BaseIndexServiceImpl<YearMedia, YearMediaDto> implements YearMediaService {

	@Autowired
	private YearMediaRepository yearMediaRepository;

	@Autowired
	private YearMediaConverter yearMediaConverter;
	
	private final QYearMedia qYearMedia = QYearMedia.yearMedia;

	@Override
	protected JpaRepository<YearMedia, Long> getRepository() {
		return yearMediaRepository;
	}

	@Override
	protected QuerydslPredicateExecutor<YearMedia> getQuerydsl() {
		return yearMediaRepository;
	}

	@Override
	protected AbstractConverter<YearMedia, YearMediaDto> getConverter() {
		return yearMediaConverter;
	}

	@Override
	protected YearMedia newModel() {
		return new YearMedia();
	}

	@Override
	protected BooleanBuilder searchCondition(UserDetailsDto user, String keywords, YearMediaDto dto) {
		BooleanBuilder booleanBuilder = new BooleanBuilder();
		if(dto.getYear() != null) {
			booleanBuilder.and(qYearMedia.year.eq(dto.getYear()));
		}
		return booleanBuilder;
	}

}
