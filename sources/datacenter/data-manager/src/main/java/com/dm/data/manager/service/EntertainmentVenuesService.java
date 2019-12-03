package com.dm.data.manager.service;

import com.dm.data.manager.dto.EntertainmentVenuesDto;
import com.dm.data.manager.entity.EntertainmentVenues;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface EntertainmentVenuesService extends ApiService<EntertainmentVenues> {

    public Optional<EntertainmentVenues> findById(Long id);

    public EntertainmentVenues save(EntertainmentVenuesDto data);

    public EntertainmentVenues update(Long id, EntertainmentVenuesDto data);

    public void delete(Long id);

    public Page<EntertainmentVenues> find(Pageable pageable);

    Page<EntertainmentVenues> find(EntertainmentVenuesDto condition, String regionCode, Pageable pageable);
}
