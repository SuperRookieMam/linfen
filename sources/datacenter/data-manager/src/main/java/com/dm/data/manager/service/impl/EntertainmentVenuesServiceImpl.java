package com.dm.data.manager.service.impl;

import com.dm.data.manager.converter.EntertainmentVenuesConverter;
import com.dm.data.manager.dto.EntertainmentVenuesDto;
import com.dm.data.manager.entity.EntertainmentVenues;
import com.dm.data.manager.entity.QEntertainmentVenues;
import com.dm.data.manager.enums.NoEnums;
import com.dm.data.manager.repository.EntertainmentVenuesRepository;
import com.dm.data.manager.service.EntertainmentVenuesService;
import com.dm.data.manager.service.MediaService;
import com.querydsl.core.BooleanBuilder;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class EntertainmentVenuesServiceImpl extends AbstractCurrencyServiceImpl<EntertainmentVenues>
        implements EntertainmentVenuesService {

    @Autowired
    private EntertainmentVenuesRepository entertainmentVenuesRepository;

    @Autowired
    private EntertainmentVenuesConverter entertainmentVenuesConverter;

    private QEntertainmentVenues qEntertainmentVenues = QEntertainmentVenues.entertainmentVenues;

    @Override
    public Optional<EntertainmentVenues> findById(Long id) {
        return entertainmentVenuesRepository.findById(id);
    }

    @Autowired
    private MediaService mediaService;

    @Override
    @Transactional
    public EntertainmentVenues save(EntertainmentVenuesDto data) {
        EntertainmentVenues entity = new EntertainmentVenues();
        entertainmentVenuesConverter.copyProperties(entity, data);
        entity.setNoEnums(NoEnums.娱乐场所);
        entity.setImages(mediaService.toImage(data.getImages()));
        entity.setVideos(mediaService.toVideo(data.getVideos()));
        entity.setVirtualMaterials(mediaService.toVirtualMatrial(data.getVirtualMaterials()));
        entity.setAudios(mediaService.toAudio(data.getAudios()));
        return entertainmentVenuesRepository.save(entity);
    }

    @Override
    @Transactional
    public EntertainmentVenues update(Long id, EntertainmentVenuesDto data) {
        EntertainmentVenues entity = entertainmentVenuesRepository.getOne(id);
        entertainmentVenuesConverter.copyProperties(entity, data);
        entity.setImages(mediaService.toImage(data.getImages()));
        entity.setVideos(mediaService.toVideo(data.getVideos()));
        entity.setVirtualMaterials(mediaService.toVirtualMatrial(data.getVirtualMaterials()));
        entity.setAudios(mediaService.toAudio(data.getAudios()));
        return entity;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        entertainmentVenuesRepository.deleteById(id);
    }

    @Override
    public Page<EntertainmentVenues> find(Pageable pageable) {
        return entertainmentVenuesRepository.findAll(pageable);
    }

    @Override
    public Page<EntertainmentVenues> find(EntertainmentVenuesDto condition, String regionCode, Pageable pageable) {
        BooleanBuilder builder = new BooleanBuilder();
        // 这段代码过滤可见区域
        if (StringUtils.isNotEmpty(regionCode)) {
            builder.and(qEntertainmentVenues.regionCode.startsWith(StringUtils.stripEnd(regionCode, "0")));
        }
        String fullName = condition.getChineseFullName();
        if (StringUtils.isNotBlank(fullName)) {
            builder.and(qEntertainmentVenues.chineseFullName.containsIgnoreCase(fullName))
                    .or(qEntertainmentVenues.address.containsIgnoreCase(fullName))
                    .or(qEntertainmentVenues.keywords.containsIgnoreCase(fullName))
                    .or(qEntertainmentVenues.type.containsIgnoreCase(fullName));
        }
        // 这段代码过滤查询区域
        String areas = condition.getRegionCode();
        if (StringUtils.isNotEmpty(areas)) {
            builder.and(qEntertainmentVenues.regionCode.startsWith(StringUtils.stripEnd(areas, "0")));
        }

        return entertainmentVenuesRepository.findAll(builder, pageable);
    }
}
