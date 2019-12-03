package com.dm.data.manager.service.impl;

import com.dm.data.manager.converter.BusDriverConverter;
import com.dm.data.manager.dto.BusDriverDto;
import com.dm.data.manager.entity.BusDriver;
import com.dm.data.manager.entity.QBusDriver;
import com.dm.data.manager.repository.BusDriverRepository;
import com.dm.data.manager.service.BusDriverService;
import com.querydsl.core.BooleanBuilder;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class BusDriverServiceImpl extends AbstractCurrencyServiceImpl<BusDriver> implements BusDriverService {

    @Autowired
    private BusDriverRepository busDriverRepository;

    @Autowired
    private BusDriverConverter busDriverConverter;

    private QBusDriver qBusDriver = QBusDriver.busDriver;

    @Override
    public Optional<BusDriver> findById(Long id) {
        return busDriverRepository.findById(id);
    }

    @Override
    @Transactional
    public BusDriver save(BusDriverDto data) {
        BusDriver entity = new BusDriver();
        busDriverConverter.copyProperties(entity, data);

        return busDriverRepository.save(entity);
    }

    @Override
    @Transactional
    public BusDriver update(Long id, BusDriverDto data) {
        BusDriver entity = busDriverRepository.getOne(id);

        busDriverConverter.copyProperties(entity, data);
        return entity;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        busDriverRepository.deleteById(id);
    }

    @Override
    public Page<BusDriver> find(Pageable pageable) {
        return busDriverRepository.findAll(pageable);
    }

    @Override
    public Page<BusDriver> find(BusDriverDto condition, String regionCode, Pageable pageable) {
        BooleanBuilder builder = new BooleanBuilder();
        // 这段代码过滤可见区域
        if (StringUtils.isNotEmpty(regionCode)) {
            builder.and(qBusDriver.regionCode.startsWith(StringUtils.stripEnd(regionCode, "0")));
        }
        String fullName = condition.getChineseName();
        if (StringUtils.isNotBlank(fullName)) {
            builder.and(qBusDriver.chineseName.containsIgnoreCase(fullName))
                    .or(qBusDriver.gender.containsIgnoreCase(fullName))
                    .or(qBusDriver.national.containsIgnoreCase(fullName))
                    .or(qBusDriver.theTitle.containsIgnoreCase(fullName))
                    .or(qBusDriver.beenDriving.like(fullName));
        }

        String areas = condition.getRegionCode();
        if (StringUtils.isNotEmpty(areas)) {
            builder.and(qBusDriver.regionCode.startsWith(StringUtils.stripEnd(areas, "0")));
        }

        return busDriverRepository.findAll(builder, pageable);
    }
}
