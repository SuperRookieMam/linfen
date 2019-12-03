package com.dm.data.manager.service.impl;

import com.dm.data.manager.converter.EnteringBusinessConverter;
import com.dm.data.manager.dto.EnteringBusinessDto;
import com.dm.data.manager.entity.EnteringBusiness;
import com.dm.data.manager.entity.QEnteringBusiness;
import com.dm.data.manager.enums.NoEnums;
import com.dm.data.manager.repository.EnteringBusinessRepository;
import com.dm.data.manager.service.EnteringBusinessService;
import com.querydsl.core.BooleanBuilder;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class EnteringBusinessServiceImpl extends AbstractCurrencyServiceImpl<EnteringBusiness>
        implements EnteringBusinessService {

    @Autowired
    private EnteringBusinessRepository enteringBusinessRepository;

    @Autowired
    private EnteringBusinessConverter enteringBusinessConverter;

    private QEnteringBusiness qEnteringBusiness = QEnteringBusiness.enteringBusiness;

    @Override
    public Optional<EnteringBusiness> findById(Long id) {
        return enteringBusinessRepository.findById(id);
    }

    @Override
    @Transactional
    public EnteringBusiness save(EnteringBusinessDto data) {
        EnteringBusiness entity = new EnteringBusiness();
        enteringBusinessConverter.copyProperties(entity, data);
        entity.setNoEnums(NoEnums.空气质量);
        return enteringBusinessRepository.save(entity);
    }

    @Override
    @Transactional
    public EnteringBusiness update(Long id, EnteringBusinessDto data) {
        EnteringBusiness entity = enteringBusinessRepository.getOne(id);
        enteringBusinessConverter.copyProperties(entity, data);
        return entity;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        enteringBusinessRepository.deleteById(id);
    }

    @Override
    public Page<EnteringBusiness> find(EnteringBusinessDto condition, String regionCode, Pageable pageable) {
        BooleanBuilder builder = new BooleanBuilder();

        // 这段代码过滤可见区域
        if (StringUtils.isNotEmpty(regionCode)) {
            builder.and(qEnteringBusiness.regionCode.startsWith(StringUtils.stripEnd(regionCode, "0")));
        }
        String fullName = condition.getArea();
        if (StringUtils.isNotBlank(fullName)) {
            if (fullName.matches("\\d{4}-\\d+-\\d+")) {
                String[] time = fullName.split("-");
                builder.and(qEnteringBusiness.year.eq(Integer.valueOf(time[0])))
                        .and(qEnteringBusiness.month.eq(Integer.valueOf(time[1])))
                        .and(qEnteringBusiness.day.eq(Integer.valueOf(time[2])));
            } else {
                builder.and(qEnteringBusiness.contry.containsIgnoreCase(fullName))
                        .or(qEnteringBusiness.scenic.containsIgnoreCase(fullName))
                        .or(qEnteringBusiness.number.like(fullName))
                        .or(qEnteringBusiness.visitNumber.like(fullName))
                        .or(qEnteringBusiness.sex.like(fullName))
                        .or(qEnteringBusiness.age.like(fullName));
            }
        }
        // 这段代码过滤查询区域
        String areas = condition.getRegionCode();
        if (StringUtils.isNotEmpty(areas)) {
            builder.and(qEnteringBusiness.regionCode.startsWith(StringUtils.stripEnd(areas, "0")));
        }
        return enteringBusinessRepository.findAll(builder, pageable);
    }

}
