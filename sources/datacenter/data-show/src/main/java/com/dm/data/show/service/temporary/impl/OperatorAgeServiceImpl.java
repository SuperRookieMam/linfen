package com.dm.data.show.service.temporary.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Service;

import com.dm.common.converter.AbstractConverter;
import com.dm.data.show.converter.temporary.OperatorAgeConverter;
import com.dm.data.show.dto.temporary.OperatorAgeDto;
import com.dm.data.show.entity.temporary.OperatorAge;
import com.dm.data.show.entity.temporary.QOperatorAge;
import com.dm.data.show.repository.temporary.OperatorAgeRepository;
import com.dm.data.show.service.temporary.OperatorAgeService;
import com.dm.kpi.core.service.impl.BaseIndexServiceImpl;
import com.dm.security.core.userdetails.UserDetailsDto;
import com.querydsl.core.BooleanBuilder;

@Service
public class OperatorAgeServiceImpl extends BaseIndexServiceImpl<OperatorAge, OperatorAgeDto> implements OperatorAgeService {

	@Autowired
	private OperatorAgeRepository operatorAgeRepository;

	@Autowired
	private OperatorAgeConverter operatorAgeConverter;

	private final QOperatorAge qOperatorAge = QOperatorAge.operatorAge;

	@Override
	protected JpaRepository<OperatorAge, Long> getRepository() {
		return operatorAgeRepository;
	}

	@Override
	protected QuerydslPredicateExecutor<OperatorAge> getQuerydsl() {
		return operatorAgeRepository;
	}

	@Override
	protected AbstractConverter<OperatorAge, OperatorAgeDto> getConverter() {
		return operatorAgeConverter;
	} 

	@Override
	protected OperatorAge newModel() {
		return new OperatorAge();
	}

	@Override
	protected BooleanBuilder searchCondition(UserDetailsDto user, String keywords, OperatorAgeDto dto) {
		return null;
	}

}
