package com.dm.data.manager.service.impl;

import com.dm.data.manager.converter.SenicReceptionConverter;
import com.dm.data.manager.dto.SenicReceptionDto;
import com.dm.data.manager.entity.QSenicReception;
import com.dm.data.manager.entity.SenicReception;
import com.dm.data.manager.enums.NoEnums;
import com.dm.data.manager.repository.SenicReceptionRepository;
import com.dm.data.manager.service.SenicReceptionService;
import com.querydsl.core.BooleanBuilder;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class SenicReceptionServiceImpl extends AbstractCurrencyServiceImpl<SenicReception>
        implements SenicReceptionService {

    @Autowired
    private SenicReceptionRepository senicReceptionRepository;

    @Autowired
    private SenicReceptionConverter senicReceptionConverter;

    private QSenicReception qSenicReception = QSenicReception.senicReception;

    @Override
    public Optional<SenicReception> findById(Long id) {
        return senicReceptionRepository.findById(id);
    }

    @Override
    @Transactional
    public SenicReception save(SenicReceptionDto data) {
        SenicReception entity = new SenicReception();
        senicReceptionConverter.copyProperties(entity, data);
        entity.setNoEnums(NoEnums.空气质量);
        return senicReceptionRepository.save(entity);
    }

    @Override
    @Transactional
    public SenicReception update(Long id, SenicReceptionDto data) {
        SenicReception entity = senicReceptionRepository.getOne(id);
        senicReceptionConverter.copyProperties(entity, data);
        return entity;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        senicReceptionRepository.deleteById(id);
    }

    @Override
    public Page<SenicReception> find(SenicReceptionDto condition, String regionCode, Pageable pageable) {
        BooleanBuilder builder = new BooleanBuilder();

        // 这段代码过滤可见区域
        if (StringUtils.isNotEmpty(regionCode)) {
            builder.and(qSenicReception.regionCode.startsWith(StringUtils.stripEnd(regionCode, "0")));
        }
        String fullName = condition.getArea();
        if (StringUtils.isNotBlank(fullName)) {
            if (fullName.matches("\\d{4}-\\d+-\\d+")) {
                String[] time = fullName.split("-");
                builder.and(qSenicReception.year.eq(Integer.valueOf(time[0])))
                        .and(qSenicReception.month.eq(Integer.valueOf(time[1])))
                        .and(qSenicReception.day.eq(Integer.valueOf(time[2])));
            } else {
                builder.and(qSenicReception.houre.like(fullName))
                        .or(qSenicReception.scenic.containsIgnoreCase(fullName))
                        .or(qSenicReception.number.like(fullName));
            }
        }
        // 这段代码过滤查询区域
        String areas = condition.getRegionCode();
        if (StringUtils.isNotEmpty(areas)) {
            builder.and(qSenicReception.regionCode.startsWith(StringUtils.stripEnd(areas, "0")));
        }
        return senicReceptionRepository.findAll(builder, pageable);
    }
}
