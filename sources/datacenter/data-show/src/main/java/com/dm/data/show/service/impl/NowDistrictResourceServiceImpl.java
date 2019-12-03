package com.dm.data.show.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Service;
  
import com.dm.common.converter.AbstractConverter;
import com.dm.data.show.converter.NowDistrictResourceConverter;
import com.dm.data.show.dto.NowDistrictResourceDto;
import com.dm.data.show.entity.NowDistrictResource;
import com.dm.data.show.repository.NowDistrictResourceRepository;
import com.dm.data.show.service.NowDistrictResourceService;
import com.dm.kpi.core.service.impl.BaseIndexServiceImpl;
import com.dm.security.core.userdetails.UserDetailsDto;
import com.querydsl.core.BooleanBuilder;

@Service
public class NowDistrictResourceServiceImpl extends BaseIndexServiceImpl<NowDistrictResource, NowDistrictResourceDto> implements NowDistrictResourceService {

	@Autowired
	private NowDistrictResourceRepository nowDistrictResourceRepository;

	@Autowired
	private NowDistrictResourceConverter nowDistrictResourceConverter;

	@Override
	protected JpaRepository<NowDistrictResource, Long> getRepository() {
		return nowDistrictResourceRepository;
	}

	@Override
	protected QuerydslPredicateExecutor<NowDistrictResource> getQuerydsl() {
		return nowDistrictResourceRepository;
	}

	@Override
	protected AbstractConverter<NowDistrictResource, NowDistrictResourceDto> getConverter() {
		return nowDistrictResourceConverter;
	}

	@Override
	protected NowDistrictResource newModel() {
		return new NowDistrictResource();
	}

	@Override
	protected BooleanBuilder searchCondition(UserDetailsDto user, String keywords, NowDistrictResourceDto dto) {
		return null;
	}

}
