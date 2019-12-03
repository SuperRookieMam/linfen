package com.dm.data.manager.service.impl;

import com.dm.data.manager.converter.AccommodationConverter;
import com.dm.data.manager.dto.AccommodationDto;
import com.dm.data.manager.entity.Accommodation;
import com.dm.data.manager.entity.QAccommodation;
import com.dm.data.manager.enums.NoEnums;
import com.dm.data.manager.repository.AccommodationRepository;
import com.dm.data.manager.service.AccommodationService;
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
public class AccommodationServiceImpl extends AbstractCurrencyServiceImpl<Accommodation>
        implements AccommodationService {

    @Autowired
    private AccommodationRepository accommodationRepository;

    @Autowired
    private AccommodationConverter accommodationConverter;

    private QAccommodation qAccommodation = QAccommodation.accommodation;

    @Override
    public Optional<Accommodation> findById(Long id) {
        return accommodationRepository.findById(id);
    }

    @Autowired
    private MediaService mediaService;

    @Override
    @Transactional
    public Accommodation save(AccommodationDto data) {
        Accommodation entity = new Accommodation();
        accommodationConverter.copyProperties(entity, data);
        entity.setNoEnums(NoEnums.住宿场所);
        entity.setImages(mediaService.toImage(data.getImages()));
        entity.setVideos(mediaService.toVideo(data.getVideos()));
        entity.setVirtualMaterials(mediaService.toVirtualMatrial(data.getVirtualMaterials()));
        entity.setAudios(mediaService.toAudio(data.getAudios()));
        return accommodationRepository.save(entity);
    }

    @Override
    @Transactional
    public Accommodation update(Long id, AccommodationDto data) {
        Accommodation entity = accommodationRepository.getOne(id);
        accommodationConverter.copyProperties(entity, data);

        entity.setImages(mediaService.toImage(data.getImages()));
        entity.setVideos(mediaService.toVideo(data.getVideos()));
        entity.setVirtualMaterials(mediaService.toVirtualMatrial(data.getVirtualMaterials()));
        entity.setAudios(mediaService.toAudio(data.getAudios()));
        return entity;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        accommodationRepository.deleteById(id);
    }

    @Override
    public Page<Accommodation> find(AccommodationDto condition, String regionCode, Pageable pageable) {
        BooleanBuilder builder = new BooleanBuilder();
        // 这段代码过滤可见区域
        if (StringUtils.isNotEmpty(regionCode)) {
            builder.and(qAccommodation.regionCode.startsWith(StringUtils.stripEnd(regionCode, "0")));
        }
        String fullName = condition.getChineseFullName();
        if (StringUtils.isNotBlank(fullName)) {
            builder.and(qAccommodation.chineseFullName.containsIgnoreCase(fullName))
                    .or(qAccommodation.address.containsIgnoreCase(fullName))
                    .or(qAccommodation.keywords.containsIgnoreCase(fullName))
                    .or(qAccommodation.type.containsIgnoreCase(fullName))
                    .or(qAccommodation.provideCuisines.containsIgnoreCase(fullName));
        }
        // 这段代码过滤查询区域
        String areas = condition.getRegionCode();
        if (StringUtils.isNotEmpty(areas)) {
            builder.and(qAccommodation.regionCode.startsWith(StringUtils.stripEnd(areas, "0")));
        }
        return accommodationRepository.findAll(builder, pageable);
    }

    @Override
    public List<Accommodation> findBySearch(String search) {
        return accommodationRepository.findByChineseFullNameContains(search);
    }

}
