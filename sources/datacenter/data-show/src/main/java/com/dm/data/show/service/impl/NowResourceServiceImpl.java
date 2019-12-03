package com.dm.data.show.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Service;
  
import com.dm.common.converter.AbstractConverter;
import com.dm.data.show.converter.NowResourceConverter;
import com.dm.data.show.dto.NowResourceDto;
import com.dm.data.show.entity.NowResource;
import com.dm.data.show.repository.NowResourceRepository;
import com.dm.data.show.service.NowResourceService;
import com.dm.kpi.core.service.impl.BaseIndexServiceImpl;
import com.dm.security.core.userdetails.UserDetailsDto;
import com.querydsl.core.BooleanBuilder;

@Service
public class NowResourceServiceImpl extends BaseIndexServiceImpl<NowResource, NowResourceDto> implements NowResourceService {

	@Autowired
	private NowResourceRepository nowResourceRepository;

	@Autowired
	private NowResourceConverter nowResourceConverter;

	@Override
	protected JpaRepository<NowResource, Long> getRepository() {
		return nowResourceRepository;
	}

	@Override
	protected QuerydslPredicateExecutor<NowResource> getQuerydsl() {
		return nowResourceRepository;
	}

	@Override
	protected AbstractConverter<NowResource, NowResourceDto> getConverter() {
		return nowResourceConverter;
	}

	@Override
	protected NowResource newModel() {
		return new NowResource();
	}

	@Override
	protected BooleanBuilder searchCondition(UserDetailsDto user, String keywords, NowResourceDto dto) {
		return null;
	}

}
