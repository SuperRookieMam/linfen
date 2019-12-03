package com.dm.data.manager.service.impl;

import com.dm.data.manager.converter.TouristGuideConverter;
import com.dm.data.manager.dto.TouristGuideDto;
import com.dm.data.manager.entity.QTouristGuide;
import com.dm.data.manager.entity.TouristGuide;
import com.dm.data.manager.repository.TouristGuideRepository;
import com.dm.data.manager.service.TouristGuideService;
import com.querydsl.core.BooleanBuilder;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class TouristGuideServiceImpl extends AbstractCurrencyServiceImpl<TouristGuide> implements TouristGuideService {

    @Autowired
    private TouristGuideRepository touristGuideRepository;

    @Autowired
    private TouristGuideConverter touristGuideConverter;

    private QTouristGuide qTouristGuide = QTouristGuide.touristGuide;

    @Override
    public Optional<TouristGuide> findById(Long id) {
        return touristGuideRepository.findById(id);
    }

    @Override
    @Transactional
    public TouristGuide save(TouristGuideDto data) {
        TouristGuide entity = new TouristGuide();
        touristGuideConverter.copyProperties(entity, data);

        return touristGuideRepository.save(entity);
    }

    @Override
    @Transactional
    public TouristGuide update(Long id, TouristGuideDto data) {
        TouristGuide entity = touristGuideRepository.getOne(id);

        touristGuideConverter.copyProperties(entity, data);
        return entity;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        touristGuideRepository.deleteById(id);
    }

    @Override
    public Page<TouristGuide> find(Pageable pageable) {
        return touristGuideRepository.findAll(pageable);
    }

    @Override
    public Page<TouristGuide> find(TouristGuideDto condition, String regionCode, Pageable pageable) {
        BooleanBuilder builder = new BooleanBuilder();
        // 这段代码过滤可见区域
        if (StringUtils.isNotEmpty(regionCode)) {
            builder.and(qTouristGuide.regionCode.startsWith(StringUtils.stripEnd(regionCode, "0")));
        }
        String fullName = condition.getChineseName();
        if (StringUtils.isNotBlank(fullName)) {
            builder.and(qTouristGuide.chineseName.containsIgnoreCase(fullName))
                    .or(qTouristGuide.gender.containsIgnoreCase(fullName))
                    .or(qTouristGuide.national.containsIgnoreCase(fullName))
                    .or(qTouristGuide.serviceLanguage.containsIgnoreCase(fullName))
                    .or(qTouristGuide.recordOfFormalSchooling.containsIgnoreCase(fullName));
        }

        String areas = condition.getRegionCode();
        if (StringUtils.isNotEmpty(areas)) {
            builder.and(qTouristGuide.regionCode.startsWith(StringUtils.stripEnd(areas, "0")));
        }
        return touristGuideRepository.findAll(builder, pageable);
    }
}
