package com.dm.data.show.service.temporary.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Service;

import com.dm.common.converter.AbstractConverter;
import com.dm.data.show.converter.temporary.OperatorGenderConverter;
import com.dm.data.show.dto.temporary.OperatorGenderDto;
import com.dm.data.show.entity.temporary.OperatorGender;
import com.dm.data.show.entity.temporary.QOperatorGender;
import com.dm.data.show.repository.temporary.OperatorGenderRepository;
import com.dm.data.show.service.temporary.OperatorGenderService;
import com.dm.kpi.core.service.impl.BaseIndexServiceImpl;
import com.dm.security.core.userdetails.UserDetailsDto;
import com.querydsl.core.BooleanBuilder;

@Service
public class OperatorGenderServiceImpl extends BaseIndexServiceImpl<OperatorGender, OperatorGenderDto> implements OperatorGenderService {

	@Autowired
	private OperatorGenderRepository operatorGenderRepository;

	@Autowired
	private OperatorGenderConverter operatorGenderConverter;

	private final QOperatorGender qOperatorGender = QOperatorGender.operatorGender;

	@Override
	protected JpaRepository<OperatorGender, Long> getRepository() {
		return operatorGenderRepository;
	}

	@Override
	protected QuerydslPredicateExecutor<OperatorGender> getQuerydsl() {
		return operatorGenderRepository;
	}

	@Override
	protected AbstractConverter<OperatorGender, OperatorGenderDto> getConverter() {
		return operatorGenderConverter;
	} 

	@Override
	protected OperatorGender newModel() {
		return new OperatorGender();
	}

	@Override
	protected BooleanBuilder searchCondition(UserDetailsDto user, String keywords, OperatorGenderDto dto) {
		return null;
	}

}
