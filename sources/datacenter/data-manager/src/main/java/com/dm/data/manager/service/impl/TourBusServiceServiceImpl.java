package com.dm.data.manager.service.impl;

import com.dm.data.manager.converter.TourBusServiceConverter;
import com.dm.data.manager.dto.TourBusServiceDto;
import com.dm.data.manager.entity.QTourBusService;
import com.dm.data.manager.entity.TourBusService;
import com.dm.data.manager.repository.TourBusRepository;
import com.dm.data.manager.repository.TourBusServiceRepository;
import com.dm.data.manager.service.TourBusServiceService;
import com.querydsl.core.BooleanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class TourBusServiceServiceImpl extends AbstractCurrencyServiceImpl<TourBusService>
        implements TourBusServiceService {

    @Autowired
    private TourBusServiceRepository tourBusServiceRepository;

    @Autowired
    private TourBusServiceConverter tourBusServiceConverter;

    @Autowired
    private TourBusRepository tourBusRepository;

    private QTourBusService qBusService = QTourBusService.tourBusService;

    @Override
    public Optional<TourBusService> findById(Long id) {
        return tourBusServiceRepository.findById(id);
    }

    @Override
    @Transactional
    public TourBusService save(TourBusServiceDto data) {
        TourBusService entity = new TourBusService();
        tourBusServiceConverter.copyProperties(entity, data);
        return tourBusServiceRepository.save(entity);
    }

    @Override
    @Transactional
    public TourBusService update(Long id, TourBusServiceDto data) {
        TourBusService entity = tourBusServiceRepository.getOne(id);
        tourBusServiceConverter.copyProperties(entity, data);
        return entity;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        tourBusServiceRepository.deleteById(id);
    }

    @Override
    public Page<TourBusService> find(Pageable pageable) {
        return tourBusServiceRepository.findAll(pageable);
    }

    @Override
    public Page<TourBusService> find(Long busId, TourBusServiceDto condition, Pageable pageable) {
        BooleanBuilder builder = new BooleanBuilder();
        builder.and(qBusService.buses.any().id.eq(busId));
        return tourBusServiceRepository.findAll(builder, pageable);
    }

}
