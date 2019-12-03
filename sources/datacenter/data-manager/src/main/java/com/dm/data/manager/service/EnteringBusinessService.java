package com.dm.data.manager.service;

import com.dm.data.manager.dto.EnteringBusinessDto;
import com.dm.data.manager.entity.EnteringBusiness;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface EnteringBusinessService extends ApiService<EnteringBusiness> {
    Optional<EnteringBusiness> findById(Long id);

    EnteringBusiness save(EnteringBusinessDto data);

    EnteringBusiness update(Long id, EnteringBusinessDto data);

    void delete(Long id);

    Page<EnteringBusiness> find(EnteringBusinessDto condition, String regionCode, Pageable pageable);

}
