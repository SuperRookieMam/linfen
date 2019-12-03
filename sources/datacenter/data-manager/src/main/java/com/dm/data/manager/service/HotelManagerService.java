package com.dm.data.manager.service;

import com.dm.data.manager.dto.HotelManagerDto;
import com.dm.data.manager.entity.HotelManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface HotelManagerService extends ApiService<HotelManager> {
    Optional<HotelManager> findById(Long id);

    HotelManager save(HotelManagerDto data);

    HotelManager update(Long id, HotelManagerDto data);

    void delete(Long id);

    Page<HotelManager> find(HotelManagerDto condition, String regionCode, Pageable pageable);

}
