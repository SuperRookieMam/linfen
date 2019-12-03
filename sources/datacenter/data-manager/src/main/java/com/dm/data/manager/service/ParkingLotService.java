package com.dm.data.manager.service;

import com.dm.data.manager.dto.ParkingLotDto;
import com.dm.data.manager.entity.ParkingLot;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ParkingLotService extends ApiService<ParkingLot> {

    public Optional<ParkingLot> findById(Long id);

    public ParkingLot save(ParkingLotDto data);

    public ParkingLot update(Long id, ParkingLotDto data);

    public void delete(Long id);

    public Page<ParkingLot> find(Pageable pageable);

    public Page<ParkingLot> find(ParkingLotDto condition, String regionCode, Pageable pageable);
}
