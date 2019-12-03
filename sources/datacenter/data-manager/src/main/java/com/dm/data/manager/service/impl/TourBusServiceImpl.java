package com.dm.data.manager.service.impl;

import com.dm.data.manager.converter.TourBusConverter;
import com.dm.data.manager.dto.TourBusDto;
import com.dm.data.manager.entity.QTourBus;
import com.dm.data.manager.entity.TourBus;
import com.dm.data.manager.enums.NoEnums;
import com.dm.data.manager.repository.TourBusRepository;
import com.dm.data.manager.service.TourBusService;
import com.querydsl.core.BooleanBuilder;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class TourBusServiceImpl extends AbstractCurrencyServiceImpl<TourBus> implements TourBusService {

    @Autowired
    private TourBusRepository tourBusRepository;

    @Autowired
    private TourBusConverter tourBusConverter;

    private final QTourBus qTourBus = QTourBus.tourBus;

    @Override
    public Optional<TourBus> findById(Long id) {
        return tourBusRepository.findById(id);
    }

    @Override
    @Transactional
    public TourBus save(TourBusDto data) {
        TourBus entity = new TourBus();
        tourBusConverter.copyProperties(entity, data);
        entity.setNoEnums(NoEnums.旅游大巴);

        return tourBusRepository.save(entity);
    }

    @Override
    @Transactional
    public TourBus update(Long id, TourBusDto data) {
        TourBus entity = tourBusRepository.getOne(id);
        tourBusConverter.copyProperties(entity, data);

        return entity;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        tourBusRepository.deleteById(id);
    }

    @Override
    public Page<TourBus> find(Pageable pageable) {
        return tourBusRepository.findAll(pageable);
    }

    @Override
    public Page<TourBus> find(TourBusDto condition, String regionCode, Pageable pageable) {
        BooleanBuilder builder = new BooleanBuilder();
        // 这段代码过滤可见区域
        if (StringUtils.isNotEmpty(regionCode)) {
            builder.and(qTourBus.regionCode.startsWith(StringUtils.stripEnd(regionCode, "0")));
        }
        String fullName = condition.getPlateNo();
        if (StringUtils.isNotBlank(fullName)) {
            builder.and(qTourBus.plateNo.containsIgnoreCase(fullName)).or(qTourBus.address.containsIgnoreCase(fullName))
                    .or(qTourBus.level.containsIgnoreCase(fullName)).or(qTourBus.carType.containsIgnoreCase(fullName));
        }
        String areas = condition.getRegionCode();
        if (StringUtils.isNotEmpty(areas)) {
            builder.and(qTourBus.regionCode.startsWith(StringUtils.stripEnd(areas, "0")));
        }
        return tourBusRepository.findAll(builder, pageable);
    }

}
