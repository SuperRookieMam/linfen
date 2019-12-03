package com.dm.data.app.service;

import com.dm.data.app.dto.TripDto;
import com.dm.data.app.entity.Trip;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TripService {
    Trip save(TripDto dto);

    Trip update(Long id,TripDto dto);

    Trip findById(Long id);

    void delete(Long id);

    Page<Trip> search(Pageable pageable, String search);
}
