package com.dm.data.manager.service.impl;

import com.dm.data.manager.converter.TourismMonitoringCenterConverter;
import com.dm.data.manager.dto.TourismMonitoringCenterDto;
import com.dm.data.manager.entity.TourismMonitoringCenter;
import com.dm.data.manager.enums.NoEnums;
import com.dm.data.manager.repository.TourismMonitoringCenterRepository;
import com.dm.data.manager.service.TourismMonitoringCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class TourismMonitoringCenterServiceImpl extends AbstractCurrencyServiceImpl<TourismMonitoringCenter>
        implements TourismMonitoringCenterService {

    @Autowired
    private TourismMonitoringCenterRepository tourismMonitoringCenterRepository;

    @Autowired
    private TourismMonitoringCenterConverter tourismMonitoringCenterConverter;

    @Override
    public Optional<TourismMonitoringCenter> findById(Long id) {
        return tourismMonitoringCenterRepository.findById(id);
    }

    @Override
    @Transactional
    public TourismMonitoringCenter save(TourismMonitoringCenterDto data) {
        TourismMonitoringCenter entity = new TourismMonitoringCenter();
        tourismMonitoringCenterConverter.copyProperties(entity, data);
        entity.setNoEnums(NoEnums.旅游监控点);

        return tourismMonitoringCenterRepository.save(entity);
    }

    @Override
    @Transactional
    public TourismMonitoringCenter update(Long id, TourismMonitoringCenterDto data) {
        TourismMonitoringCenter entity = tourismMonitoringCenterRepository.getOne(id);

        tourismMonitoringCenterConverter.copyProperties(entity, data);
        return entity;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        tourismMonitoringCenterRepository.deleteById(id);
    }

    @Override
    public Page<TourismMonitoringCenter> find(Pageable pageable) {
        return tourismMonitoringCenterRepository.findAll(pageable);
    }

}
