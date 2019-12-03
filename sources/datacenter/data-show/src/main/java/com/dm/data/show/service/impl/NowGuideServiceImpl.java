package com.dm.data.show.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Service;
  
import com.dm.common.converter.AbstractConverter;
import com.dm.data.show.converter.NowGuideConverter;
import com.dm.data.show.dto.NowGuideDto;
import com.dm.data.show.entity.NowGuide;
import com.dm.data.show.repository.NowGuideRepository;
import com.dm.data.show.service.NowGuideService;
import com.dm.kpi.core.service.impl.BaseIndexServiceImpl;
import com.dm.security.core.userdetails.UserDetailsDto;
import com.querydsl.core.BooleanBuilder;

@Service
public class NowGuideServiceImpl extends BaseIndexServiceImpl<NowGuide, NowGuideDto> implements NowGuideService {

	@Autowired
	private NowGuideRepository nowGuideRepository;

	@Autowired
	private NowGuideConverter nowGuideConverter;

	@Override
	protected JpaRepository<NowGuide, Long> getRepository() {
		return nowGuideRepository;
	}

	@Override
	protected QuerydslPredicateExecutor<NowGuide> getQuerydsl() {
		return nowGuideRepository;
	}

	@Override
	protected AbstractConverter<NowGuide, NowGuideDto> getConverter() {
		return nowGuideConverter;
	}

	@Override
	protected NowGuide newModel() {
		return new NowGuide();
	}

	@Override
	protected BooleanBuilder searchCondition(UserDetailsDto user, String keywords, NowGuideDto dto) {
		return null;
	}

}
