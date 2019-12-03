package com.dm.data.manager.service.impl;

import com.dm.data.manager.converter.TouristCommodityConverter;
import com.dm.data.manager.dto.TouristCommodityDto;
import com.dm.data.manager.entity.QTouristCommodity;
import com.dm.data.manager.entity.TouristCommodity;
import com.dm.data.manager.repository.TouristCommodityRepository;
import com.dm.data.manager.service.MediaService;
import com.dm.data.manager.service.TouristCommodityService;
import com.querydsl.core.BooleanBuilder;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class TouristCommodityServiceImpl extends AbstractCurrencyServiceImpl<TouristCommodity>
        implements TouristCommodityService {

    @Autowired
    private TouristCommodityRepository touristCommodityRepository;

    @Autowired
    private TouristCommodityConverter touristCommodityConverter;
    private QTouristCommodity qTouristCommodity = QTouristCommodity.touristCommodity;
    @Autowired
    private MediaService mediaService;

    @Override
    public Optional<TouristCommodity> findById(Long id) {
        return touristCommodityRepository.findById(id);
    }

    @Override
    @Transactional
    public TouristCommodity save(TouristCommodityDto data) {
        TouristCommodity entity = new TouristCommodity();
        touristCommodityConverter.copyProperties(entity, data);
        entity.setVideos(mediaService.toVideo(data.getVideos()));
        entity.setImages(mediaService.toImage(data.getImages()));
        entity.setVideos(mediaService.toVideo(data.getVideos()));
        return touristCommodityRepository.save(entity);
    }

    @Override
    @Transactional
    public TouristCommodity update(Long id, TouristCommodityDto data) {
        TouristCommodity entity = touristCommodityRepository.getOne(id);
        touristCommodityConverter.copyProperties(entity, data);
        entity.setImages(mediaService.toImage(data.getImages()));
        entity.setVideos(mediaService.toVideo(data.getVideos()));
        return entity;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        touristCommodityRepository.deleteById(id);
    }

    @Override
    public Page<TouristCommodity> find(Pageable pageable) {
        return touristCommodityRepository.findAll(pageable);
    }

    @Override
    public Page<TouristCommodity> find(TouristCommodityDto condition, Pageable pageable) {
        BooleanBuilder builder = new BooleanBuilder();
        String fullName = condition.getFullname();
        if (StringUtils.isNotBlank(fullName)) {
            builder.and(qTouristCommodity.fullname.containsIgnoreCase(fullName))
                    .or(qTouristCommodity.type.containsIgnoreCase(fullName))
                    .or(qTouristCommodity.propt.containsIgnoreCase(fullName))
                    .or(qTouristCommodity.recommendedShop.containsIgnoreCase(fullName))
                    .or(qTouristCommodity.recommendedBrand.containsIgnoreCase(fullName));
        }

        return touristCommodityRepository.findAll(builder, pageable);
    }
}
