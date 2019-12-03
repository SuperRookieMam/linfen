package com.dm.data.manager.service.impl;

import com.dm.data.manager.converter.DiningPlaceConverter;
import com.dm.data.manager.dto.DiningPlaceDto;
import com.dm.data.manager.entity.DiningPlace;
import com.dm.data.manager.entity.QDiningPlace;
import com.dm.data.manager.enums.NoEnums;
import com.dm.data.manager.repository.DiningPlaceRepository;
import com.dm.data.manager.service.DiningPlaceService;
import com.dm.data.manager.service.MediaService;
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
public class DiningPlaceServiceImpl extends AbstractCurrencyServiceImpl<DiningPlace> implements DiningPlaceService {

    @Autowired
    private DiningPlaceRepository diningPlaceRepository;

    @Autowired
    private DiningPlaceConverter diningPlaceConverter;

    private final QDiningPlace qDiningPlace = QDiningPlace.diningPlace;
    @Autowired
    private MediaService mediaService;

    @Override
    public Optional<DiningPlace> findById(Long id) {
        return diningPlaceRepository.findById(id);
    }

    @Override
    @Transactional
    public DiningPlace save(DiningPlaceDto data) {
        DiningPlace entity = new DiningPlace();
        diningPlaceConverter.copyProperties(entity, data);

        entity.setNoEnums(NoEnums.餐饮场所);
        entity.setImages(mediaService.toImage(data.getImages()));
        entity.setVideos(mediaService.toVideo(data.getVideos()));
        entity.setVirtualMaterials(mediaService.toVirtualMatrial(data.getVirtualMaterials()));
        entity.setAudios(mediaService.toAudio(data.getAudios()));
        return diningPlaceRepository.save(entity);
    }

    @Override
    @Transactional
    public DiningPlace update(Long id, DiningPlaceDto data) {
        DiningPlace entity = diningPlaceRepository.getOne(id);

        diningPlaceConverter.copyProperties(entity, data);
        entity.setImages(mediaService.toImage(data.getImages()));
        entity.setVideos(mediaService.toVideo(data.getVideos()));
        entity.setVirtualMaterials(mediaService.toVirtualMatrial(data.getVirtualMaterials()));
        entity.setAudios(mediaService.toAudio(data.getAudios()));
        return entity;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        diningPlaceRepository.deleteById(id);
    }

    @Override
    public Page<DiningPlace> find(DiningPlaceDto condition, String regionCode, Pageable pageable) {
        BooleanBuilder builder = new BooleanBuilder();
        // 这段代码过滤可见区域
        if (StringUtils.isNotEmpty(regionCode)) {
            builder.and(qDiningPlace.regionCode.startsWith(StringUtils.stripEnd(regionCode, "0")));
        }
        String fullName = condition.getChineseFullName();
        if (StringUtils.isNotBlank(fullName)) {
            builder.and(qDiningPlace.chineseFullName.containsIgnoreCase(fullName))
                    .or(qDiningPlace.type.containsIgnoreCase(fullName))
                    .or(qDiningPlace.level.containsIgnoreCase(fullName))
                    .or(qDiningPlace.address.containsIgnoreCase(fullName));
        }
        String areas = condition.getRegionCode();
        if (StringUtils.isNotEmpty(areas)) {
            builder.and(qDiningPlace.regionCode.startsWith(StringUtils.stripEnd(areas, "0")));
        }
        return diningPlaceRepository.findAll(builder, pageable);
    }

    @Override
    public List<DiningPlace> findBySearch(String search) {
        return diningPlaceRepository.findByChineseFullNameContains(search);
    }
}
