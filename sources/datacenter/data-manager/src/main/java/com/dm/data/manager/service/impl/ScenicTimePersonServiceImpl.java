package com.dm.data.manager.service.impl;

import com.dm.data.manager.converter.ScenicTimePersonConverter;
import com.dm.data.manager.dto.ScenicTimePersonDto;
import com.dm.data.manager.entity.ScenicTimePerson;
import com.dm.data.manager.entity.QScenicTimePerson;
import com.dm.data.manager.enums.NoEnums;
import com.dm.data.manager.repository.ScenicTimePersonRepository;
import com.dm.data.manager.service.ScenicTimePersonService;
import com.querydsl.core.BooleanBuilder;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ScenicTimePersonServiceImpl extends AbstractCurrencyServiceImpl<ScenicTimePerson>
        implements ScenicTimePersonService {

    @Autowired
    private ScenicTimePersonRepository scenicTimePersonRepository;

    @Autowired
    private ScenicTimePersonConverter scenicTimePersonConverter;

    private QScenicTimePerson qScenicTimePerson = QScenicTimePerson.scenicTimePerson;

    @Override
    public Optional<ScenicTimePerson> findById(Long id) {
        return scenicTimePersonRepository.findById(id);
    }

    @Override
    @Transactional
    public ScenicTimePerson save(ScenicTimePersonDto data) {
        ScenicTimePerson entity = new ScenicTimePerson();
        scenicTimePersonConverter.copyProperties(entity, data);
        entity.setNoEnums(NoEnums.空气质量);
        return scenicTimePersonRepository.save(entity);
    }

    @Override
    @Transactional
    public ScenicTimePerson update(Long id, ScenicTimePersonDto data) {
        ScenicTimePerson entity = scenicTimePersonRepository.getOne(id);
        scenicTimePersonConverter.copyProperties(entity, data);
        return entity;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        scenicTimePersonRepository.deleteById(id);
    }

    @Override
    public Page<ScenicTimePerson> find(ScenicTimePersonDto condition, String regionCode, Pageable pageable) {
        BooleanBuilder builder = new BooleanBuilder();

        // 这段代码过滤可见区域
        if (StringUtils.isNotEmpty(regionCode)) {
            builder.and(qScenicTimePerson.regionCode.startsWith(StringUtils.stripEnd(regionCode, "0")));
        }
        String fullName = condition.getArea();
        if (StringUtils.isNotBlank(fullName)) {
            if (fullName.matches("\\d{4}-\\d+-\\d+")) {
                String[] time = fullName.split("-");
                builder.and(qScenicTimePerson.year.eq(Integer.valueOf(time[0])))
                        .and(qScenicTimePerson.month.eq(Integer.valueOf(time[1])))
                        .and(qScenicTimePerson.day.eq(Integer.valueOf(time[2])));
            } else {
                builder.and(qScenicTimePerson.sex.containsIgnoreCase(fullName))
                        .or(qScenicTimePerson.scenic.containsIgnoreCase(fullName))
                        .or(qScenicTimePerson.number.like(fullName))
                        .or(qScenicTimePerson.nowPeopleNum.like(fullName))
                        .or(qScenicTimePerson.receiveNum.like(fullName))
                        .or(qScenicTimePerson.houre.like(fullName));
            }
        }
        // 这段代码过滤查询区域
        String areas = condition.getRegionCode();
        if (StringUtils.isNotEmpty(areas)) {
            builder.and(qScenicTimePerson.regionCode.startsWith(StringUtils.stripEnd(areas, "0")));
        }
        return scenicTimePersonRepository.findAll(builder, pageable);
    }

}
