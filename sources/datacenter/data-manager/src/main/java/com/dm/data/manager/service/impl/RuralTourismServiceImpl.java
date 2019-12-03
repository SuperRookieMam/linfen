package com.dm.data.manager.service.impl;

import com.dm.data.manager.converter.RuralTourismConverter;
import com.dm.data.manager.dto.RuralTourismDto;
import com.dm.data.manager.entity.QRuralTourism;
import com.dm.data.manager.entity.RuralTourism;
import com.dm.data.manager.enums.NoEnums;
import com.dm.data.manager.repository.RuralTourismRepository;
import com.dm.data.manager.service.MediaService;
import com.dm.data.manager.service.RuralTourismService;
import com.querydsl.core.BooleanBuilder;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class RuralTourismServiceImpl extends AbstractCurrencyServiceImpl<RuralTourism> implements RuralTourismService {

    @Autowired
    private RuralTourismRepository ruralTourismRepository;

    @Autowired
    private RuralTourismConverter ruralTourismConverter;

    private final QRuralTourism qRuralTourism = QRuralTourism.ruralTourism;
    @Autowired
    private MediaService mediaService;

    @Override
    public Optional<RuralTourism> findById(Long id) {
        return ruralTourismRepository.findById(id);
    }

    @Override
    @Transactional
    public RuralTourism save(RuralTourismDto data) {
        RuralTourism entity = new RuralTourism();
        ruralTourismConverter.copyProperties(entity, data);

        entity.setNoEnums(NoEnums.乡村旅游);
        entity.setImages(mediaService.toImage(data.getImages()));
        entity.setVideos(mediaService.toVideo(data.getVideos()));
        entity.setVirtualMaterials(mediaService.toVirtualMatrial(data.getVirtualMaterials()));
        entity.setAudios(mediaService.toAudio(data.getAudios()));
        return ruralTourismRepository.save(entity);
    }

    @Override
    @Transactional
    public RuralTourism update(Long id, RuralTourismDto data) {
        RuralTourism entity = ruralTourismRepository.getOne(id);

        ruralTourismConverter.copyProperties(entity, data);
        entity.setImages(mediaService.toImage(data.getImages()));
        entity.setVideos(mediaService.toVideo(data.getVideos()));
        entity.setVirtualMaterials(mediaService.toVirtualMatrial(data.getVirtualMaterials()));
        entity.setAudios(mediaService.toAudio(data.getAudios()));
        return entity;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        ruralTourismRepository.deleteById(id);
    }

    @Override
    public Page<RuralTourism> find(RuralTourismDto condition, String regionCode, Pageable pageable) {
        BooleanBuilder builder = new BooleanBuilder();
        // 这段代码过滤可见区域
        if (StringUtils.isNotEmpty(regionCode)) {
            builder.and(qRuralTourism.regionCode.startsWith(StringUtils.stripEnd(regionCode, "0")));
        }
        String fullName = condition.getChineseFullName();
        if (StringUtils.isNotBlank(fullName)) {
            builder.and(qRuralTourism.chineseFullName.containsIgnoreCase(fullName))
                    .or(qRuralTourism.address.containsIgnoreCase(fullName))
                    .or(qRuralTourism.type.containsIgnoreCase(fullName))
                    .or(qRuralTourism.level.containsIgnoreCase(fullName));
        }
        String areas = condition.getRegionCode();
        if (StringUtils.isNotEmpty(areas)) {
            builder.and(qRuralTourism.regionCode.startsWith(StringUtils.stripEnd(areas, "0")));
        }
        return ruralTourismRepository.findAll(builder, pageable);
    }

    @Override
    public List<RuralTourism> findBySearch(String search) {
        return ruralTourismRepository.findByChineseFullNameContains(search);
    }
}
