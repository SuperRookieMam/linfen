package com.dm.data.manager.service;

import com.dm.data.manager.dto.EnteringPoliceDto;
import com.dm.data.manager.entity.EnteringPolice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface EnteringPoliceService extends ApiService<EnteringPolice> {
    Optional<EnteringPolice> findById(Long id);

    EnteringPolice save(EnteringPoliceDto data);

    EnteringPolice update(Long id, EnteringPoliceDto data);

    void delete(Long id);

    Page<EnteringPolice> find(EnteringPoliceDto condition, String regionCode, Pageable pageable);

}
