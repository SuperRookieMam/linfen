package com.dm.data.manager.service.impl;

import com.dm.data.manager.converter.VideoConverter;
import com.dm.data.manager.dto.VideoDto;
import com.dm.data.manager.entity.QVideo;
import com.dm.data.manager.entity.Video;
import com.dm.data.manager.repository.VideoRepository;
import com.dm.data.manager.service.VideoService;
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
public class VideoImpl extends AbstractCurrencyServiceImpl<Video> implements VideoService {

    @Autowired
    private VideoRepository videoDatabaseRepository;

    @Autowired
    private VideoConverter videoDatabaseConverter;

    private QVideo qVideo = QVideo.video;

    @Override
    public Optional<Video> findById(Long id) {
        return videoDatabaseRepository.findById(id);
    }

    @Override
    @Transactional
    public Video save(VideoDto data) {
        Video entity = new Video();
        videoDatabaseConverter.copyProperties(entity, data);
        return videoDatabaseRepository.save(entity);
    }

    @Override
    @Transactional
    public List<Video> save(List<VideoDto> datas) {
        if (CollectionUtils.isNotEmpty(datas)) {
            List<Video> videos = datas.stream().map(data -> {
                Video video = new Video();
                videoDatabaseConverter.copyProperties(video, data);
                return video;
            }).collect(Collectors.toList());
            return videoDatabaseRepository.saveAll(videos);
        } else {
            return Collections.emptyList();
        }
    }

    @Override
    @Transactional
    public Video update(Long id, VideoDto data) {
        Video entity = videoDatabaseRepository.getOne(id);
        videoDatabaseConverter.copyProperties(entity, data);
        return entity;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        videoDatabaseRepository.deleteById(id);
    }

    @Override
    public Page<Video> find(Pageable pageable) {
        return videoDatabaseRepository.findAll(pageable);
    }

    @Override
    public Page<Video> find(VideoDto condition, String regionCode, Pageable pageable) {
        BooleanBuilder builder = new BooleanBuilder();
        // 这段代码过滤可见区域
//		if (StringUtils.isNotEmpty(regionCode)) {
//			builder.and(qVideo.regionCode.startsWith(StringUtils.stripEnd(regionCode, "0")));
//		}
        String fullName = condition.getName();
        if (StringUtils.isNotBlank(fullName)) {
            builder.and(qVideo.name.containsIgnoreCase(fullName))
                    .or(qVideo.type.containsIgnoreCase(fullName))
                    .or(qVideo.videoSpecifications.containsIgnoreCase(fullName))
                    .or(qVideo.videoFormat.containsIgnoreCase(fullName))
                    .or(qVideo.theFileSize.containsIgnoreCase(fullName))
                    .or(qVideo.theVideoTime.containsIgnoreCase(fullName));
        }
//		// 这段代码过滤查询区域
//		String areas = condition.getRegionCode();
//		if (StringUtils.isNotEmpty(areas)) {
//			builder.and(qVideo.regionCode.startsWith(StringUtils.stripEnd(areas, "0")));
//		}
        QPageRequest qPageRequest = new QPageRequest(pageable.getPageNumber(),pageable.getPageSize(), new OrderSpecifier(Order.DESC,qVideo.createDate));
        return videoDatabaseRepository.findAll(builder, qPageRequest);
    }
}
