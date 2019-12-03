package com.dm.data.manager.controller;

import com.dm.common.dto.TableResult;
import com.dm.security.core.userdetails.UserDetailsDto;
import org.springframework.data.domain.Pageable;

public abstract class AbstractController<T> {

    public abstract TableResult<T> search(Long draw, UserDetailsDto user, T condition, Pageable pageable);

    public abstract T save(T data);

    public abstract Object getApiList(UserDetailsDto user, String jsonStr);
}
