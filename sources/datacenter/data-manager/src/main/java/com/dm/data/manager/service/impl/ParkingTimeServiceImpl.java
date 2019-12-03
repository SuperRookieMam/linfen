package com.dm.data.manager.service.impl;

import com.dm.data.manager.converter.ParkingTimeConverter;
import com.dm.data.manager.dto.ParkingTimeDto;
import com.dm.data.manager.entity.ParkingTime;
import com.dm.data.manager.entity.QParkingTime;
import com.dm.data.manager.enums.NoEnums;
import com.dm.data.manager.repository.ParkingTimeRepository;
import com.dm.data.manager.service.ParkingTimeService;
import com.querydsl.core.BooleanBuilder;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ParkingTimeServiceImpl extends AbstractCurrencyServiceImpl<ParkingTime> implements ParkingTimeService {

    @Autowired
    private ParkingTimeRepository parkingTimeRepository;

    @Autowired
    private ParkingTimeConverter parkingTimeConverter;

    private QParkingTime qParkingTime = QParkingTime.parkingTime;

    @Override
    public Optional<ParkingTime> findById(Long id) {
        return parkingTimeRepository.findById(id);
    }

    @Override
    @Transactional
    public ParkingTime save(ParkingTimeDto data) {
        ParkingTime entity = new ParkingTime();
        parkingTimeConverter.copyProperties(entity, data);
        entity.setNoEnums(NoEnums.空气质量);
        return parkingTimeRepository.save(entity);
    }

    @Override
    @Transactional
    public ParkingTime update(Long id, ParkingTimeDto data) {
        ParkingTime entity = parkingTimeRepository.getOne(id);
        parkingTimeConverter.copyProperties(entity, data);
        return entity;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        parkingTimeRepository.deleteById(id);
    }

    @Override
    public Page<ParkingTime> find(ParkingTimeDto condition, String regionCode, Pageable pageable) {
        BooleanBuilder builder = new BooleanBuilder();

        // 这段代码过滤可见区域
        if (StringUtils.isNotEmpty(regionCode)) {
            builder.and(qParkingTime.regionCode.startsWith(StringUtils.stripEnd(regionCode, "0")));
        }
        String fullName = condition.getArea();
        if (StringUtils.isNotBlank(fullName)) {
            builder.and(qParkingTime.province.containsIgnoreCase(fullName))
                    .or(qParkingTime.scenic.containsIgnoreCase(fullName))
                    .or(qParkingTime.day.like(fullName))
                    .or(qParkingTime.month.like(fullName));
        }
        // 这段代码过滤查询区域
        String areas = condition.getRegionCode();
        if (StringUtils.isNotEmpty(areas)) {
            builder.and(qParkingTime.regionCode.startsWith(StringUtils.stripEnd(areas, "0")));
        }
        return parkingTimeRepository.findAll(builder, pageable);
    }
}
