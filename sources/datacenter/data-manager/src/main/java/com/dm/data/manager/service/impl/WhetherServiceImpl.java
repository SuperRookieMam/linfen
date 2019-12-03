package com.dm.data.manager.service.impl;

import com.dm.data.manager.converter.WhetherConverter;
import com.dm.data.manager.dto.WhetherDto;
import com.dm.data.manager.entity.QWhether;
import com.dm.data.manager.entity.Whether;
import com.dm.data.manager.enums.NoEnums;
import com.dm.data.manager.repository.WhetherRepository;
import com.dm.data.manager.service.WhetherService;
import com.querydsl.core.BooleanBuilder;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class WhetherServiceImpl extends AbstractCurrencyServiceImpl<Whether> implements WhetherService {

    @Autowired
    private WhetherRepository whetherRepository;

    @Autowired
    private WhetherConverter whetherConverter;
    private QWhether qWhether = QWhether.whether1;

    @Override
    public Optional<Whether> findById(Long id) {
        return whetherRepository.findById(id);
    }

    @Override
    @Transactional
    public Whether save(WhetherDto data) {
        Whether entity = new Whether();
        whetherConverter.copyProperties(entity, data);
        entity.setNoEnums(NoEnums.空气质量);
        return whetherRepository.save(entity);
    }

    @Override
    @Transactional
    public Whether update(Long id, WhetherDto data) {
        Whether entity = whetherRepository.getOne(id);
        whetherConverter.copyProperties(entity, data);
        return entity;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        whetherRepository.deleteById(id);
    }

    @Override
    public Page<Whether> find(WhetherDto condition, String regionCode, Pageable pageable) {
        BooleanBuilder builder = new BooleanBuilder();

        // 这段代码过滤可见区域
        if (StringUtils.isNotEmpty(regionCode)) {
            builder.and(qWhether.regionCode.startsWith(StringUtils.stripEnd(regionCode, "0")));
        }
        String fullName = condition.getArea();
        if (StringUtils.isNotBlank(fullName)) {
            builder.and(qWhether.year.like(fullName)).or(qWhether.month.like(fullName)).or(qWhether.day.like(fullName))
                    .or(qWhether.houre.like(fullName)).or(qWhether.scenic.like(fullName))
                    .or(qWhether.whether.like(fullName)).or(qWhether.windPower.like(fullName))
                    .or(qWhether.airQuality.like(fullName));
        }
        // 这段代码过滤查询区域
        String areas = condition.getRegionCode();
        if (StringUtils.isNotEmpty(areas)) {
            builder.and(qWhether.regionCode.startsWith(StringUtils.stripEnd(areas, "0")));
        }
        return whetherRepository.findAll(builder, pageable);
    }
}
