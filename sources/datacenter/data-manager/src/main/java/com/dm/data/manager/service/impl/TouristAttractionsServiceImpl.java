package com.dm.data.manager.service.impl;

import com.dm.data.manager.converter.TouristAttractionsConverter;
import com.dm.data.manager.dto.TouristAttractionsDto;
import com.dm.data.manager.entity.QTouristAttractions;
import com.dm.data.manager.entity.TouristAttractions;
import com.dm.data.manager.enums.NoEnums;
import com.dm.data.manager.repository.TouristAttractionsRepository;
import com.dm.data.manager.service.MediaService;
import com.dm.data.manager.service.TouristAttractionsService;
import com.querydsl.core.BooleanBuilder;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TouristAttractionsServiceImpl extends AbstractCurrencyServiceImpl<TouristAttractions>
        implements TouristAttractionsService {

    @Autowired
    private TouristAttractionsRepository touristAttractionsRepository;

    @Autowired
    private TouristAttractionsConverter touristAttractionsConverter;

    private final QTouristAttractions qTouristAttractions = QTouristAttractions.touristAttractions;
    @Autowired
    private MediaService mediaService;

    @Override
    public Optional<TouristAttractions> findById(Long id) {
        return touristAttractionsRepository.findById(id);
    }

    @Override
    @Transactional
    public TouristAttractions save(TouristAttractionsDto data) {
        TouristAttractions entity = new TouristAttractions();
        touristAttractionsConverter.copyProperties(entity, data);

        entity.setNoEnums(NoEnums.旅游景区);
        entity.setImages(mediaService.toImage(data.getImages()));
        entity.setVideos(mediaService.toVideo(data.getVideos()));
        entity.setVirtualMaterials(mediaService.toVirtualMatrial(data.getVirtualMaterials()));
        entity.setAudios(mediaService.toAudio(data.getAudios()));
        entity = touristAttractionsRepository.save(entity);
        if (!ObjectUtils.isEmpty(entity.getShow()) && entity.getShow().booleanValue()) {
            BooleanBuilder builder = new BooleanBuilder();
            builder.and(qTouristAttractions.show.isTrue()).and(qTouristAttractions.homeType.eq(entity.getHomeType()))
                    .and(qTouristAttractions.regionCode.eq(entity.getRegionCode()));
            Iterable<TouristAttractions> iterable = touristAttractionsRepository.findAll(builder);
            long id = entity.getId().longValue();
            iterable.forEach(ele -> {
                if (ele.getId().longValue() != id) {
                    ele.setShow(false);
                    ele.setHomeType(0);
                    touristAttractionsRepository.save(ele);
                }
            });
        }
        return entity;
    }

    @Override
    @Transactional
    public TouristAttractions update(Long id, TouristAttractionsDto data) {
        TouristAttractions entity = touristAttractionsRepository.getOne(id);
        touristAttractionsConverter.copyProperties(entity, data);
        entity.setImages(mediaService.toImage(data.getImages()));
        entity.setVideos(mediaService.toVideo(data.getVideos()));
        entity.setVirtualMaterials(mediaService.toVirtualMatrial(data.getVirtualMaterials()));
        entity.setAudios(mediaService.toAudio(data.getAudios()));
        return entity;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        touristAttractionsRepository.deleteById(id);
    }

    @Override
    public Page<TouristAttractions> find(TouristAttractionsDto condition, String regionCode, Pageable pageable) {
        BooleanBuilder builder = new BooleanBuilder();
        // 这段代码过滤可见区域
        if (StringUtils.isNotEmpty(regionCode)) {
            builder.and(qTouristAttractions.regionCode.startsWith(StringUtils.stripEnd(regionCode, "0")));
        }
        String fullName = condition.getChineseFullName();
        if (StringUtils.isNotBlank(fullName)) {
            builder.and(qTouristAttractions.chineseFullName.containsIgnoreCase(fullName))
                    .or(qTouristAttractions.address.containsIgnoreCase(fullName))
                    .or(qTouristAttractions.scenicSpotType.containsIgnoreCase(fullName))
                    .or(qTouristAttractions.areaLevel.containsIgnoreCase(fullName));
        }
        String areas = condition.getRegionCode();
        if (StringUtils.isNotEmpty(areas)) {
            builder.and(qTouristAttractions.regionCode.startsWith(StringUtils.stripEnd(areas, "0")));
        }
        return touristAttractionsRepository.findAll(builder, pageable);
    }

    @Override
    public List<TouristAttractions> findBySearch(String search) {
        return touristAttractionsRepository.findByChineseFullNameContains(search);
    }

}
