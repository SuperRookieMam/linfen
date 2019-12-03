package com.dm.data.show.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Service;
  
import com.dm.common.converter.AbstractConverter;
import com.dm.data.show.converter.YearCognitionAtlasConverter;
import com.dm.data.show.dto.YearCognitionAtlasDto;
import com.dm.data.show.entity.QYearCognitionAtlas;
import com.dm.data.show.entity.YearCognitionAtlas;
import com.dm.data.show.repository.YearCognitionAtlasRepository;
import com.dm.data.show.service.YearCognitionAtlasService;
import com.dm.kpi.core.service.impl.BaseIndexServiceImpl;
import com.dm.security.core.userdetails.UserDetailsDto;
import com.querydsl.core.BooleanBuilder;

@Service
public class YearCognitionAtlasServiceImpl extends BaseIndexServiceImpl<YearCognitionAtlas, YearCognitionAtlasDto> implements YearCognitionAtlasService {

	@Autowired
	private YearCognitionAtlasRepository yearCognitionAtlasRepository;

	@Autowired
	private YearCognitionAtlasConverter yearCognitionAtlasConverter;
	
	private final QYearCognitionAtlas qYearCognitionAtlas = QYearCognitionAtlas.yearCognitionAtlas;
	
	@Override
	protected JpaRepository<YearCognitionAtlas, Long> getRepository() {
		return yearCognitionAtlasRepository;
	}

	@Override
	protected QuerydslPredicateExecutor<YearCognitionAtlas> getQuerydsl() {
		return yearCognitionAtlasRepository;
	}

	@Override
	protected AbstractConverter<YearCognitionAtlas, YearCognitionAtlasDto> getConverter() {
		return yearCognitionAtlasConverter;
	}

	@Override
	protected YearCognitionAtlas newModel() {
		return new YearCognitionAtlas();
	}

	@Override
	protected BooleanBuilder searchCondition(UserDetailsDto user, String keywords, YearCognitionAtlasDto dto) {
		BooleanBuilder booleanBuilder = new BooleanBuilder();
		if(dto.getYear() != null) {
			booleanBuilder.and(qYearCognitionAtlas.year.eq(dto.getYear()));
		}
		return booleanBuilder;
	}

}
