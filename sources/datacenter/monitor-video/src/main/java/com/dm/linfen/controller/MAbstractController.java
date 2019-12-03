package com.dm.linfen.controller;

import com.dm.common.dto.TableResult;
import com.dm.security.core.userdetails.UserDetailsDto;
import org.springframework.data.domain.Pageable;

public abstract class MAbstractController<T> {

	public abstract TableResult<T> search(Long draw, UserDetailsDto user, T condition, Pageable pageable);

	public abstract T save(T data);
}
