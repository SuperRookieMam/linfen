package com.dm.data.manager.service;

import com.dm.data.manager.dto.BusDriverDto;
import com.dm.data.manager.entity.BusDriver;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface BusDriverService extends ApiService<BusDriver> {

    public Optional<BusDriver> findById(Long id);

    public BusDriver save(BusDriverDto data);

    public BusDriver update(Long id, BusDriverDto data);

    public void delete(Long id);

    public Page<BusDriver> find(Pageable pageable);

    public Page<BusDriver> find(BusDriverDto condition, String regionCode, Pageable pageable);
}
