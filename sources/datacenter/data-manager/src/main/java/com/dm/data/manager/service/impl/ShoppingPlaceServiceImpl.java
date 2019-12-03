package com.dm.data.manager.service.impl;

import com.dm.data.manager.converter.ShoppingPlaceConverter;
import com.dm.data.manager.dto.ShoppingPlaceDto;
import com.dm.data.manager.entity.QShoppingPlace;
import com.dm.data.manager.entity.ShoppingPlace;
import com.dm.data.manager.enums.NoEnums;
import com.dm.data.manager.repository.ShoppingPlaceRepository;
import com.dm.data.manager.service.MediaService;
import com.dm.data.manager.service.ShoppingPlaceService;
import com.querydsl.core.BooleanBuilder;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ShoppingPlaceServiceImpl extends AbstractCurrencyServiceImpl<ShoppingPlace>
        implements ShoppingPlaceService {

    @Autowired
    private ShoppingPlaceRepository shoppingPlaceWordRepository;

    @Autowired
    private ShoppingPlaceConverter shoppingPlaceWordConverter;
    private final QShoppingPlace qShoppingPlace = QShoppingPlace.shoppingPlace;
    @Autowired
    private MediaService mediaService;

    @Override
    public Optional<ShoppingPlace> findById(Long id) {
        return shoppingPlaceWordRepository.findById(id);
    }

    @Override
    @Transactional
    public ShoppingPlace save(ShoppingPlaceDto data) {
        ShoppingPlace entity = new ShoppingPlace();
        shoppingPlaceWordConverter.copyProperties(entity, data);

        entity.setNoEnums(NoEnums.购物场所);
        entity.setImages(mediaService.toImage(data.getImages()));
        entity.setVideos(mediaService.toVideo(data.getVideos()));
        entity.setVirtualMaterials(mediaService.toVirtualMatrial(data.getVirtualMaterials()));
        entity.setAudios(mediaService.toAudio(data.getAudios()));
        return shoppingPlaceWordRepository.save(entity);
    }

    @Override
    @Transactional
    public ShoppingPlace update(Long id, ShoppingPlaceDto data) {
        ShoppingPlace entity = shoppingPlaceWordRepository.getOne(id);

        shoppingPlaceWordConverter.copyProperties(entity, data);
        entity.setImages(mediaService.toImage(data.getImages()));
        entity.setVideos(mediaService.toVideo(data.getVideos()));
        entity.setVirtualMaterials(mediaService.toVirtualMatrial(data.getVirtualMaterials()));
        entity.setAudios(mediaService.toAudio(data.getAudios()));
        return entity;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        shoppingPlaceWordRepository.deleteById(id);
    }

    @Override
    public Page<ShoppingPlace> find(ShoppingPlaceDto condition, String regionCode, Pageable pageable) {
        BooleanBuilder builder = new BooleanBuilder();
        // 这段代码过滤可见区域
        if (StringUtils.isNotEmpty(regionCode)) {
            builder.and(qShoppingPlace.regionCode.startsWith(StringUtils.stripEnd(regionCode, "0")));
        }
        String fullName = condition.getChineseFullName();
        if (StringUtils.isNotBlank(fullName)) {
            builder.and(qShoppingPlace.chineseFullName.containsIgnoreCase(fullName))
                    .or(qShoppingPlace.address.containsIgnoreCase(fullName))
                    .or(qShoppingPlace.type.containsIgnoreCase(fullName));
        }

        String areas = condition.getRegionCode();
        if (StringUtils.isNotEmpty(areas)) {
            builder.and(qShoppingPlace.regionCode.startsWith(StringUtils.stripEnd(areas, "0")));
        }
        return shoppingPlaceWordRepository.findAll(builder, pageable);
    }

}
