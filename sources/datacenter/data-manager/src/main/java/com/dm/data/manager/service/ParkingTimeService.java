package com.dm.data.manager.service;

import com.dm.data.manager.dto.ParkingTimeDto;
import com.dm.data.manager.entity.ParkingTime;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ParkingTimeService extends ApiService<ParkingTime> {
    Optional<ParkingTime> findById(Long id);

    ParkingTime save(ParkingTimeDto data);

    ParkingTime update(Long id, ParkingTimeDto data);

    void delete(Long id);

    Page<ParkingTime> find(ParkingTimeDto condition, String regionCode, Pageable pageable);

}
