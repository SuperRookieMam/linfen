package com.dm.kpi.core.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.transaction.annotation.Transactional;

import com.dm.common.converter.AbstractConverter;
import com.dm.kpi.core.service.BaseIndexService;
import com.dm.security.core.userdetails.UserDetailsDto;
import com.querydsl.core.BooleanBuilder;

public abstract class BaseIndexServiceImpl<M, DTO> implements BaseIndexService<M, DTO> {

	@Override
	@Transactional
	public M save(DTO data) {
		M model = newModel();
		getConverter().copyProperties(model, data);
		return getRepository().save(model);
	}
	
	@Override
	@Transactional
	public List<M> saveAll(List<DTO> datas){
		List<M> models = datas.stream().map(data->{
			M model=newModel();
			return	getConverter().copyProperties(model, data);
		}).collect(Collectors.toList());
		return getRepository().saveAll(models);
	}

	@Override
	@Transactional
	public Optional<M> findById(Long id) {
		return getRepository().findById(id);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		getRepository().deleteById(id);
	}

	@Override
	public M update(Long id, DTO data) {
		M model = getRepository().getOne(id);
		getConverter().copyProperties(model, data);
		return getRepository().save(model);
	}

	@Override
	public Page<M> search(Pageable pageable) {
		return getRepository().findAll(pageable);
	}

	@Override
	public Page<M> search(UserDetailsDto user, String keywords, DTO dto, Pageable pageable) {
		BooleanBuilder booleanBuilder = this.searchCondition(user, keywords, dto);
		if(booleanBuilder == null) {
			return this.getRepository().findAll(pageable);
		}
		return this.getQuerydsl().findAll(booleanBuilder, pageable);
	}

	protected abstract JpaRepository<M, Long> getRepository();
	
	protected abstract QuerydslPredicateExecutor<M> getQuerydsl();
	
	protected abstract AbstractConverter<M, DTO> getConverter();

	protected abstract M newModel();
	
	protected abstract BooleanBuilder searchCondition(UserDetailsDto user, String keywords, DTO dto);
	
}
