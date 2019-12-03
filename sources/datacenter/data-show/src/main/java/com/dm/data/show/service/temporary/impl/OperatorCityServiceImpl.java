package com.dm.data.show.service.temporary.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Service;

import com.dm.common.converter.AbstractConverter;
import com.dm.data.show.converter.temporary.OperatorCityConverter;
import com.dm.data.show.dto.temporary.OperatorCityDto;
import com.dm.data.show.entity.temporary.OperatorCity;
import com.dm.data.show.entity.temporary.QOperatorCity;
import com.dm.data.show.repository.temporary.OperatorCityRepository;
import com.dm.data.show.service.temporary.OperatorCityService;
import com.dm.kpi.core.service.impl.BaseIndexServiceImpl;
import com.dm.security.core.userdetails.UserDetailsDto;
import com.querydsl.core.BooleanBuilder;

@Service
public class OperatorCityServiceImpl extends BaseIndexServiceImpl<OperatorCity, OperatorCityDto> implements OperatorCityService {

	@Autowired
	private OperatorCityRepository operatorCityRepository;

	@Autowired
	private OperatorCityConverter operatorCityConverter;

	private final QOperatorCity qOperatorCity = QOperatorCity.operatorCity;

	@Override
	protected JpaRepository<OperatorCity, Long> getRepository() {
		return operatorCityRepository;
	}

	@Override
	protected QuerydslPredicateExecutor<OperatorCity> getQuerydsl() {
		return operatorCityRepository;
	}

	@Override
	protected AbstractConverter<OperatorCity, OperatorCityDto> getConverter() {
		return operatorCityConverter;
	} 

	@Override
	protected OperatorCity newModel() {
		return new OperatorCity();
	}

	@Override
	protected BooleanBuilder searchCondition(UserDetailsDto user, String keywords, OperatorCityDto dto) {
		return null;
	}

}
