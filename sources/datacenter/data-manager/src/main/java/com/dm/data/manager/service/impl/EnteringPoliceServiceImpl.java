package com.dm.data.manager.service.impl;

import com.dm.data.manager.converter.EnteringPoliceConverter;
import com.dm.data.manager.dto.EnteringPoliceDto;
import com.dm.data.manager.entity.EnteringPolice;
import com.dm.data.manager.entity.QEnteringPolice;
import com.dm.data.manager.enums.NoEnums;
import com.dm.data.manager.repository.EnteringPoliceRepository;
import com.dm.data.manager.service.EnteringPoliceService;
import com.querydsl.core.BooleanBuilder;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class EnteringPoliceServiceImpl extends AbstractCurrencyServiceImpl<EnteringPolice>
        implements EnteringPoliceService {

    @Autowired
    private EnteringPoliceRepository enteringPoliceRepository;

    @Autowired
    private EnteringPoliceConverter enteringPoliceConverter;

    private QEnteringPolice qEnteringPolice = QEnteringPolice.enteringPolice;

    @Override
    public Optional<EnteringPolice> findById(Long id) {
        return enteringPoliceRepository.findById(id);
    }

    @Override
    @Transactional
    public EnteringPolice save(EnteringPoliceDto data) {
        EnteringPolice entity = new EnteringPolice();
        enteringPoliceConverter.copyProperties(entity, data);
        entity.setNoEnums(NoEnums.空气质量);
        return enteringPoliceRepository.save(entity);
    }

    @Override
    @Transactional
    public EnteringPolice update(Long id, EnteringPoliceDto data) {
        EnteringPolice entity = enteringPoliceRepository.getOne(id);
        enteringPoliceConverter.copyProperties(entity, data);
        return entity;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        enteringPoliceRepository.deleteById(id);
    }

    @Override
    public Page<EnteringPolice> find(EnteringPoliceDto condition, String regionCode, Pageable pageable) {
        BooleanBuilder builder = new BooleanBuilder();

        // 这段代码过滤可见区域
        if (StringUtils.isNotEmpty(regionCode)) {
            builder.and(qEnteringPolice.regionCode.startsWith(StringUtils.stripEnd(regionCode, "0")));
        }
        String fullName = condition.getArea();
        if (StringUtils.isNotBlank(fullName)) {
            if (fullName.matches("\\d{4}-\\d+-\\d+")) {
                String[] time = fullName.split("-");
                builder.and(qEnteringPolice.year.eq(Integer.valueOf(time[0])))
                        .and(qEnteringPolice.month.eq(Integer.valueOf(time[1])))
                        .and(qEnteringPolice.day.eq(Integer.valueOf(time[2])));
            } else {
                builder.and(qEnteringPolice.contry.containsIgnoreCase(fullName))
                        .or(qEnteringPolice.scenic.containsIgnoreCase(fullName))
                        .or(qEnteringPolice.number.like(fullName))
                        .or(qEnteringPolice.visitNumber.like(fullName))
                        .or(qEnteringPolice.sex.like(fullName))
                        .or(qEnteringPolice.age.like(fullName));
            }
        }
        // 这段代码过滤查询区域
        String areas = condition.getRegionCode();
        if (StringUtils.isNotEmpty(areas)) {
            builder.and(qEnteringPolice.regionCode.startsWith(StringUtils.stripEnd(areas, "0")));
        }
        return enteringPoliceRepository.findAll(builder, pageable);
    }
}
