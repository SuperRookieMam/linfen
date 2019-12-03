package com.dm.data.manager.service.impl;

import com.dm.data.manager.converter.TourGuideConverter;
import com.dm.data.manager.dto.TourGuideDto;
import com.dm.data.manager.entity.QTourGuide;
import com.dm.data.manager.entity.TourGuide;
import com.dm.data.manager.repository.TourGuideRepository;
import com.dm.data.manager.service.TourGuideService;
import com.dm.file.dto.FileInfoDto;
import com.dm.file.entity.FileInfo;
import com.dm.file.repository.FileInfoRepository;
import com.querydsl.core.BooleanBuilder;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TourGuideServiceImpl extends AbstractCurrencyServiceImpl<TourGuide> implements TourGuideService {

    @Autowired
    private TourGuideRepository tourGuideRepository;

    @Autowired
    private TourGuideConverter tourGuideConverter;

    private QTourGuide qTourGuide = QTourGuide.tourGuide;
    @Autowired
    private FileInfoRepository fileInfoRepository;

    @Override
    public Optional<TourGuide> findById(Long id) {
        return tourGuideRepository.findById(id);
    }

    @Override
    @Transactional
    public TourGuide save(TourGuideDto data) {
        TourGuide entity = new TourGuide();
        tourGuideConverter.copyProperties(entity, data);
        if (CollectionUtils.isNotEmpty(data.getHeadImgs())) {
            List<FileInfo> fileInfos = data.getHeadImgs().stream().map(FileInfoDto::getId).map(fileInfoRepository::getOne)
                    .collect(Collectors.toList());
            entity.setHeadImgs(fileInfos);
        }
        return tourGuideRepository.save(entity);
    }

    @Override
    @Transactional
    public TourGuide update(Long id, TourGuideDto data) {
        TourGuide entity = tourGuideRepository.getOne(id);
        tourGuideConverter.copyProperties(entity, data);
        if (CollectionUtils.isNotEmpty(data.getHeadImgs())) {
            List<FileInfo> fileInfos = data.getHeadImgs().stream().map(FileInfoDto::getId).map(fileInfoRepository::getOne)
                    .collect(Collectors.toList());
            entity.setHeadImgs(fileInfos);
        }
        return entity;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        tourGuideRepository.deleteById(id);
    }

    @Override
    public Page<TourGuide> find(Pageable pageable) {
        return tourGuideRepository.findAll(pageable);
    }

    @Override
    public Page<TourGuide> find(TourGuideDto condition, String regionCode, Pageable pageable) {
        BooleanBuilder builder = new BooleanBuilder();
        // 这段代码过滤可见区域
        if (StringUtils.isNotEmpty(regionCode)) {
            builder.and(qTourGuide.regionCode.startsWith(StringUtils.stripEnd(regionCode, "0")));
        }
        String fullName = condition.getChineseName();
        if (StringUtils.isNotBlank(fullName)) {
            builder.and(qTourGuide.chineseName.containsIgnoreCase(fullName))
                    .or(qTourGuide.gender.containsIgnoreCase(fullName))
                    .or(qTourGuide.national.containsIgnoreCase(fullName))
                    .or(qTourGuide.contact.containsIgnoreCase(fullName))
                    .or(qTourGuide.theGuideType.containsIgnoreCase(fullName))
                    .or(qTourGuide.theGuideRanks.containsIgnoreCase(fullName));
        }
        String areas = condition.getRegionCode();
        if (StringUtils.isNotEmpty(areas)) {
            builder.and(qTourGuide.regionCode.startsWith(StringUtils.stripEnd(areas, "0")));
        }
        return tourGuideRepository.findAll(builder, pageable);
    }
}
