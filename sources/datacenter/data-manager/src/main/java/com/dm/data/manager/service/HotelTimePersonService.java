package com.dm.data.manager.service;

import com.dm.data.manager.dto.HotelTimePersonDto;
import com.dm.data.manager.entity.HotelTimePerson;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface HotelTimePersonService extends ApiService<HotelTimePerson> {
    Optional<HotelTimePerson> findById(Long id);

    HotelTimePerson save(HotelTimePersonDto data);

    HotelTimePerson update(Long id, HotelTimePersonDto data);

    void delete(Long id);

    Page<HotelTimePerson> find(HotelTimePersonDto condition, String regionCode, Pageable pageable);

}
