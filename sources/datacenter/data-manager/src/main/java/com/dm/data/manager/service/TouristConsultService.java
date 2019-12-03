package com.dm.data.manager.service;

import com.dm.data.manager.dto.TouristConsultDto;
import com.dm.data.manager.entity.TouristConsult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface TouristConsultService extends ApiService<TouristConsult> {
    Optional<TouristConsult> findById(Long id);

    TouristConsult save(TouristConsultDto data);

    TouristConsult update(Long id, TouristConsultDto data);

    void delete(Long id);

    Page<TouristConsult> find(TouristConsultDto condition, String regionCode, Pageable pageable);

}
