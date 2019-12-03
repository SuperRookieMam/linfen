package com.dm.data.manager.service;

import com.dm.data.manager.dto.WhetherDto;
import com.dm.data.manager.entity.Whether;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface WhetherService extends ApiService<Whether> {
    Optional<Whether> findById(Long id);

    Whether save(WhetherDto data);

    Whether update(Long id, WhetherDto data);

    void delete(Long id);

    Page<Whether> find(WhetherDto condition, String regionCode, Pageable pageable);

}
