package com.dm.data.manager.service;

import com.dm.data.manager.dto.TourismMonitoringCenterDto;
import com.dm.data.manager.entity.TourismMonitoringCenter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface TourismMonitoringCenterService extends ApiService<TourismMonitoringCenter> {

    public Optional<TourismMonitoringCenter> findById(Long id);

    public TourismMonitoringCenter save(TourismMonitoringCenterDto data);

    public TourismMonitoringCenter update(Long id, TourismMonitoringCenterDto data);

    public void delete(Long id);

    public Page<TourismMonitoringCenter> find(Pageable pageable);
}
