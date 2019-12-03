package com.dm.data.manager.service.impl;

import com.dm.data.manager.converter.TravelAgencyConverter;
import com.dm.data.manager.dto.TravelAgencyDto;
import com.dm.data.manager.entity.QTravelAgentcy;
import com.dm.data.manager.entity.TravelAgentcy;
import com.dm.data.manager.enums.NoEnums;
import com.dm.data.manager.repository.TravelAgencyRepository;
import com.dm.data.manager.service.MediaService;
import com.dm.data.manager.service.TravelAgencyService;
import com.querydsl.core.BooleanBuilder;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class TravelAgencyServiceImpl extends AbstractCurrencyServiceImpl<TravelAgentcy> implements TravelAgencyService {

    @Autowired
    private TravelAgencyRepository travelAgentFieldRepository;

    @Autowired
    private TravelAgencyConverter travelAgentFieldConverter;

    private final QTravelAgentcy qTravelAgentcy = QTravelAgentcy.travelAgentcy;
    @Autowired
    private MediaService mediaService;

    @Override
    public Optional<TravelAgentcy> findById(Long id) {
        return travelAgentFieldRepository.findById(id);
    }

    @Override
    @Transactional
    public TravelAgentcy save(TravelAgencyDto data) {
        TravelAgentcy entity = new TravelAgentcy();
        travelAgentFieldConverter.copyProperties(entity, data);

        entity.setNoEnums(NoEnums.旅行社);
        entity.setImages(mediaService.toImage(data.getImages()));
        entity.setVideos(mediaService.toVideo(data.getVideos()));
        entity.setVirtualMaterials(mediaService.toVirtualMatrial(data.getVirtualMaterials()));
        entity.setAudios(mediaService.toAudio(data.getAudios()));
        return travelAgentFieldRepository.save(entity);
    }

    @Override
    @Transactional
    public TravelAgentcy update(Long id, TravelAgencyDto data) {
        TravelAgentcy entity = travelAgentFieldRepository.getOne(id);

        travelAgentFieldConverter.copyProperties(entity, data);
        entity.setImages(mediaService.toImage(data.getImages()));
        entity.setVideos(mediaService.toVideo(data.getVideos()));
        entity.setVirtualMaterials(mediaService.toVirtualMatrial(data.getVirtualMaterials()));
        entity.setAudios(mediaService.toAudio(data.getAudios()));
        return entity;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        travelAgentFieldRepository.deleteById(id);
    }

    @Override
    public Page<TravelAgentcy> find(TravelAgencyDto condition, String regionCode, Pageable pageable) {
        BooleanBuilder builder = new BooleanBuilder();
        // 这段代码过滤可见区域
        if (StringUtils.isNotEmpty(regionCode)) {
            builder.and(qTravelAgentcy.regionCode.startsWith(StringUtils.stripEnd(regionCode, "0")));
        }
        String fullName = condition.getChineseFullName();
        if (StringUtils.isNotBlank(fullName)) {
            builder.and(qTravelAgentcy.chineseFullName.containsIgnoreCase(fullName))
                    .or(qTravelAgentcy.address.containsIgnoreCase(fullName))
                    .or(qTravelAgentcy.type.containsIgnoreCase(fullName))
                    .or(qTravelAgentcy.level.containsIgnoreCase(fullName));
        }
        String areas = condition.getRegionCode();
        if (StringUtils.isNotEmpty(areas)) {
            builder.and(qTravelAgentcy.regionCode.startsWith(StringUtils.stripEnd(areas, "0")));
        }
        return travelAgentFieldRepository.findAll(builder, pageable);
    }

}
