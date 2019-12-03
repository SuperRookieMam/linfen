package com.dm.data.manager.service;

import com.dm.data.manager.dto.TourBusDto;
import com.dm.data.manager.entity.TourBus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface TourBusService extends ApiService<TourBus> {

    public Optional<TourBus> findById(Long id);

    public TourBus save(TourBusDto data);

    public TourBus update(Long id, TourBusDto data);

    public void delete(Long id);

    public Page<TourBus> find(Pageable pageable);

    public Page<TourBus> find(TourBusDto condition, String regionCode, Pageable pageable);
}
