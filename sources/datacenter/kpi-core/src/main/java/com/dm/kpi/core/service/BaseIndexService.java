package com.dm.kpi.core.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import com.dm.security.core.userdetails.UserDetailsDto;

public interface BaseIndexService<M, DTO> {

	@Transactional
	public M save(DTO data);
	
	@Transactional
	public List<M> saveAll(List<DTO> datas);

	public Optional<M> findById(Long id);

	@Transactional
	public void deleteById(Long id);

	@Transactional
	public M update(Long id, DTO data);

	public Page<M> search(Pageable pageable);

	public Page<M> search(UserDetailsDto user, String keywords, DTO dto, Pageable pageable);
}
