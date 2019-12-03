package com.dm.data.show.service.temporary.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Service;

import com.dm.common.converter.AbstractConverter;
import com.dm.data.show.converter.temporary.OperatorRegionConverter;
import com.dm.data.show.dto.temporary.OperatorRegionDto;
import com.dm.data.show.entity.temporary.OperatorRegion;
import com.dm.data.show.entity.temporary.QOperatorRegion;
import com.dm.data.show.repository.temporary.OperatorRegionRepository;
import com.dm.data.show.service.temporary.OperatorRegionService;
import com.dm.kpi.core.service.impl.BaseIndexServiceImpl;
import com.dm.security.core.userdetails.UserDetailsDto;
import com.querydsl.core.BooleanBuilder;

@Service
public class OperatorRegionServiceImpl extends BaseIndexServiceImpl<OperatorRegion, OperatorRegionDto> implements OperatorRegionService {

	@Autowired
	private OperatorRegionRepository operatorRegionRepository;

	@Autowired
	private OperatorRegionConverter operatorRegionConverter;

	private final QOperatorRegion qOperatorRegion = QOperatorRegion.operatorRegion;

	@Override
	protected JpaRepository<OperatorRegion, Long> getRepository() {
		return operatorRegionRepository;
	}

	@Override
	protected QuerydslPredicateExecutor<OperatorRegion> getQuerydsl() {
		return operatorRegionRepository;
	}

	@Override
	protected AbstractConverter<OperatorRegion, OperatorRegionDto> getConverter() {
		return operatorRegionConverter;
	} 

	@Override
	protected OperatorRegion newModel() {
		return new OperatorRegion();
	}

	@Override
	protected BooleanBuilder searchCondition(UserDetailsDto user, String keywords, OperatorRegionDto dto) {
		return null;
	}

}
