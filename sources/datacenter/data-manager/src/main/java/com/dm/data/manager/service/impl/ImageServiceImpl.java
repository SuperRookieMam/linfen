package com.dm.data.manager.service.impl;

import com.dm.data.manager.converter.ImageConverter;
import com.dm.data.manager.dto.ImageDto;
import com.dm.data.manager.entity.Image;
import com.dm.data.manager.entity.QImage;
import com.dm.data.manager.repository.ImageRepository;
import com.dm.data.manager.service.ImageService;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ImageServiceImpl extends AbstractCurrencyServiceImpl<Image> implements ImageService {

    @Autowired
    private ImageRepository imageDatabaseRepository;

    @Autowired
    private ImageConverter imageDatabaseConverter;

    private QImage qImage = QImage.image;

    @Override
    public Optional<Image> findById(Long id) {
        return imageDatabaseRepository.findById(id);
    }

    @Override
    @Transactional
    public Image save(ImageDto data) {
        Image entity = new Image();
        imageDatabaseConverter.copyProperties(entity, data);
        return imageDatabaseRepository.save(entity);
    }

    @Override
    @Transactional
    public List<Image> save(List<ImageDto> datas) {
        if (CollectionUtils.isNotEmpty(datas)) {
            List<Image> images = datas.stream().map(data -> {
                Image entity = new Image();
                imageDatabaseConverter.copyProperties(entity, data);
                return entity;
            }).collect(Collectors.toList());
            return imageDatabaseRepository.saveAll(images);
        } else {
            return Collections.emptyList();
        }
    }

    @Override
    @Transactional
    public Image update(Long id, ImageDto data) {
        Image entity = imageDatabaseRepository.getOne(id);
        imageDatabaseConverter.copyProperties(entity, data);
        return entity;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        imageDatabaseRepository.deleteById(id);
    }

    @Override
    public Page<Image> find(Pageable pageable) {
        return imageDatabaseRepository.findAll(pageable);
    }

    @Override
    public Page<Image> find(ImageDto condition, String regionCode, Pageable pageable) {
        BooleanBuilder builder = new BooleanBuilder();
        // 这段代码过滤可见区域
//		if (StringUtils.isNotEmpty(regionCode)) {
//			builder.and(qVideo.regionCode.startsWith(StringUtils.stripEnd(regionCode, "0")));
//		}
        String fullName = condition.getName();
        if (StringUtils.isNotBlank(fullName)) {
            builder.and(qImage.pictureCaptions.containsIgnoreCase(fullName))
                    .or(qImage.type.containsIgnoreCase(fullName))
                    .or(qImage.imageFormat.containsIgnoreCase(fullName))
                    .or(qImage.theFileSize.containsIgnoreCase(fullName))
                    .or(qImage.shootingTime.containsIgnoreCase(fullName));
        }
//		// 这段代码过滤查询区域
//		String areas = condition.getRegionCode();
//		if (StringUtils.isNotEmpty(areas)) {
//			builder.and(qVideo.regionCode.startsWith(StringUtils.stripEnd(areas, "0")));
//		}
        QPageRequest qPageRequest = new QPageRequest(pageable.getPageNumber(),pageable.getPageSize(), new OrderSpecifier (Order.DESC,qImage.createDate));
        return imageDatabaseRepository.findAll(builder, qPageRequest);
    }
}
