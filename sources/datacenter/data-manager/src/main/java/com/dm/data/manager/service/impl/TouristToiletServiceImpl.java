package com.dm.data.manager.service.impl;

import com.dm.data.manager.converter.TouristToiletConverter;
import com.dm.data.manager.dto.TouristToiletDto;
import com.dm.data.manager.entity.QTouristToilet;
import com.dm.data.manager.entity.TouristToilet;
import com.dm.data.manager.enums.NoEnums;
import com.dm.data.manager.repository.TouristToiletRepository;
import com.dm.data.manager.service.TouristToiletService;
import com.querydsl.core.BooleanBuilder;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class TouristToiletServiceImpl extends AbstractCurrencyServiceImpl<TouristToilet>
        implements TouristToiletService {

    @Autowired
    private TouristToiletRepository touristToiletRepository;

    @Autowired
    private TouristToiletConverter touristToiletConverter;

    private QTouristToilet qTouristToilet = QTouristToilet.touristToilet;

    @Override
    public Optional<TouristToilet> findById(Long id) {
        return touristToiletRepository.findById(id);
    }

    @Override
    @Transactional
    public TouristToilet save(TouristToiletDto data) {
        TouristToilet entity = new TouristToilet();
        touristToiletConverter.copyProperties(entity, data);
        entity.setNoEnums(NoEnums.旅游厕所);

        return touristToiletRepository.save(entity);
    }

    @Override
    @Transactional
    public TouristToilet update(Long id, TouristToiletDto data) {
        TouristToilet entity = touristToiletRepository.getOne(id);

        touristToiletConverter.copyProperties(entity, data);
        return entity;
    }

    @Transactional
    @Override
    public void delete(Long id) {
        touristToiletRepository.deleteById(id);
    }

    @Override
    public Page<TouristToilet> find(Pageable pageable) {
        return touristToiletRepository.findAll(pageable);
    }

    @Override
    public Page<TouristToilet> find(TouristToiletDto condition, String regionCode, Pageable pageable) {
        BooleanBuilder builder = new BooleanBuilder();
        String fullName = condition.getFullname();
        if (StringUtils.isNotBlank(fullName)) {
            builder.and(qTouristToilet.fullname.containsIgnoreCase(fullName))
                    .or(qTouristToilet.location.containsIgnoreCase(fullName))
                    .or(qTouristToilet.address.containsIgnoreCase(fullName))
                    .or(qTouristToilet.touristToiletGrade.containsIgnoreCase(fullName));
        }
        // 这段代码过滤可见区域
        if (StringUtils.isNotEmpty(regionCode)) {
            builder.and(qTouristToilet.regionCode.startsWith(StringUtils.stripEnd(regionCode, "0")));
        }
        // 这段代码过滤查询区域
        String areas = condition.getRegionCode();
        if (StringUtils.isNotEmpty(areas)) {
            builder.and(qTouristToilet.regionCode.startsWith(StringUtils.stripEnd(areas, "0")));
        }
        return touristToiletRepository.findAll(builder, pageable);
    }
}
