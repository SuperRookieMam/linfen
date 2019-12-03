package com.dm.data.manager.service.impl;

import com.dm.data.manager.converter.ScienceAndTechnologyCultureCenterConverter;
import com.dm.data.manager.dto.ScienceAndTechnologyCultureCenterDto;
import com.dm.data.manager.entity.QScienceAndTechnologyCultureCenter;
import com.dm.data.manager.entity.ScienceAndTechnologyCultureCenter;
import com.dm.data.manager.enums.NoEnums;
import com.dm.data.manager.repository.ScienceAndTechnologyCultureCenterRepository;
import com.dm.data.manager.service.MediaService;
import com.dm.data.manager.service.ScienceAndTechnologyCultureCenterService;
import com.querydsl.core.BooleanBuilder;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ScienceAndTechnologyCultureCenterServiceImpl
        extends AbstractCurrencyServiceImpl<ScienceAndTechnologyCultureCenter>
        implements ScienceAndTechnologyCultureCenterService {

    @Autowired
    private ScienceAndTechnologyCultureCenterRepository scienceAndTechnologyCultureCenterRepository;

    @Autowired
    private ScienceAndTechnologyCultureCenterConverter scienceAndTechnologyCultureCenterConverter;

    private final QScienceAndTechnologyCultureCenter qScienceAndTechnologyCultureCenter = QScienceAndTechnologyCultureCenter.scienceAndTechnologyCultureCenter;

    @Autowired
    private MediaService mediaService;

    @Override
    public Optional<ScienceAndTechnologyCultureCenter> findById(Long id) {
        return scienceAndTechnologyCultureCenterRepository.findById(id);
    }

    @Override
    @Transactional
    public ScienceAndTechnologyCultureCenter save(ScienceAndTechnologyCultureCenterDto data) {
        ScienceAndTechnologyCultureCenter entity = new ScienceAndTechnologyCultureCenter();
        scienceAndTechnologyCultureCenterConverter.copyProperties(entity, data);

        entity.setNoEnums(NoEnums.科技文化馆);
        entity.setImages(mediaService.toImage(data.getImages()));
        entity.setVideos(mediaService.toVideo(data.getVideos()));
        entity.setVirtualMaterials(mediaService.toVirtualMatrial(data.getVirtualMaterials()));
        entity.setAudios(mediaService.toAudio(data.getAudios()));
        return scienceAndTechnologyCultureCenterRepository.save(entity);
    }

    @Override
    @Transactional
    public ScienceAndTechnologyCultureCenter update(Long id, ScienceAndTechnologyCultureCenterDto data) {
        ScienceAndTechnologyCultureCenter entity = scienceAndTechnologyCultureCenterRepository.getOne(id);

        scienceAndTechnologyCultureCenterConverter.copyProperties(entity, data);
        entity.setImages(mediaService.toImage(data.getImages()));
        entity.setVideos(mediaService.toVideo(data.getVideos()));
        entity.setVirtualMaterials(mediaService.toVirtualMatrial(data.getVirtualMaterials()));
        entity.setAudios(mediaService.toAudio(data.getAudios()));
        return entity;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        scienceAndTechnologyCultureCenterRepository.deleteById(id);
    }

    @Override
    public Page<ScienceAndTechnologyCultureCenter> find(ScienceAndTechnologyCultureCenterDto condition,
            String regionCode, Pageable pageable) {

        BooleanBuilder builder = new BooleanBuilder();

        // 这段代码过滤可见区域
        if (StringUtils.isNotEmpty(regionCode)) {
            builder.and(
                    qScienceAndTechnologyCultureCenter.regionCode.startsWith(StringUtils.stripEnd(regionCode, "0")));
        }
        String fullName = condition.getChineseFullName();
        if (StringUtils.isNotBlank(fullName)) {
            builder.and(qScienceAndTechnologyCultureCenter.chineseFullName.containsIgnoreCase(fullName))
                    .or(qScienceAndTechnologyCultureCenter.address.containsIgnoreCase(fullName))
                    .or(qScienceAndTechnologyCultureCenter.venueType.containsIgnoreCase(fullName));
        }
        String areas = condition.getRegionCode();
        if (StringUtils.isNotEmpty(areas)) {
            builder.and(qScienceAndTechnologyCultureCenter.regionCode.startsWith(StringUtils.stripEnd(areas, "0")));
        }
        return scienceAndTechnologyCultureCenterRepository.findAll(builder, pageable);
    }

}
