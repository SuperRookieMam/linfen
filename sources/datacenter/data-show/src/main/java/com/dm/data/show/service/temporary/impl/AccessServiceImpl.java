package com.dm.data.show.service.temporary.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Service;

import com.dm.common.converter.AbstractConverter;
import com.dm.data.show.converter.temporary.AccessConverter;
import com.dm.data.show.dto.temporary.AccessDto;
import com.dm.data.show.entity.temporary.Access;
import com.dm.data.show.entity.temporary.QAccess;
import com.dm.data.show.repository.temporary.AccessRepository;
import com.dm.data.show.service.temporary.AccessService;
import com.dm.kpi.core.service.impl.BaseIndexServiceImpl;
import com.dm.security.core.userdetails.UserDetailsDto;
import com.querydsl.core.BooleanBuilder;

@Service
public class AccessServiceImpl extends BaseIndexServiceImpl<Access, AccessDto> implements AccessService {

	@Autowired
	private AccessRepository accessRepository;

	@Autowired
	private AccessConverter accessConverter;

	private final QAccess qAccess = QAccess.access;

	@Override
	protected JpaRepository<Access, Long> getRepository() {
		return accessRepository;
	}

	@Override
	protected QuerydslPredicateExecutor<Access> getQuerydsl() {
		return accessRepository;
	}

	@Override
	protected AbstractConverter<Access, AccessDto> getConverter() {
		return accessConverter;
	} 

	@Override
	protected Access newModel() {
		return new Access();
	}

	@Override
	protected BooleanBuilder searchCondition(UserDetailsDto user, String keywords, AccessDto dto) {
		return null;
	}

}
