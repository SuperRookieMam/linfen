package com.dm.data.manager.service;

import com.dm.data.manager.dto.TourBusServiceDto;
import com.dm.data.manager.entity.TourBusService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface TourBusServiceService extends ApiService<TourBusService> {

    public Optional<TourBusService> findById(Long id);

    public TourBusService save(TourBusServiceDto data);

    public TourBusService update(Long id, TourBusServiceDto data);

    public void delete(Long id);

    public Page<TourBusService> find(Pageable pageable);

    public Page<TourBusService> find(Long busId, TourBusServiceDto condition, Pageable pageable);
}
