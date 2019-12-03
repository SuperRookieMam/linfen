package com.dm.data.manager.service.impl;

import com.dm.data.manager.converter.TouristConsultConverter;
import com.dm.data.manager.dto.TouristConsultDto;
import com.dm.data.manager.entity.QTouristConsult;
import com.dm.data.manager.entity.TouristConsult;
import com.dm.data.manager.enums.NoEnums;
import com.dm.data.manager.repository.TouristConsultRepository;
import com.dm.data.manager.service.TouristConsultService;
import com.dm.file.dto.FileInfoDto;
import com.dm.file.entity.FileInfo;
import com.dm.file.repository.FileInfoRepository;
import com.querydsl.core.BooleanBuilder;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TouristConsultServiceImpl extends AbstractCurrencyServiceImpl<TouristConsult>
        implements TouristConsultService {

    @Autowired
    private TouristConsultRepository touristConsultRepository;

    @Autowired
    private TouristConsultConverter touristConsultConverter;

    private QTouristConsult qTouristConsult = QTouristConsult.touristConsult;

    @Autowired
    private FileInfoRepository fileInfoRepository;

    @Override
    public Optional<TouristConsult> findById(Long id) {
        return touristConsultRepository.findById(id);
    }

    @Override
    @Transactional
    public TouristConsult save(TouristConsultDto data) {
        TouristConsult entity = new TouristConsult();
        touristConsultConverter.copyProperties(entity, data);
        entity.setNoEnums(NoEnums.空气质量);
        // 图片
        if (CollectionUtils.isNotEmpty(data.getImgs())) {
            List<FileInfo> fileInfos = data.getImgs().stream().map(FileInfoDto::getId).map(fileInfoRepository::getOne)
                    .collect(Collectors.toList());
            entity.setImgs(fileInfos);
        }
        entity.setCreatTime(LocalDate.now());
        return touristConsultRepository.save(entity);
    }

    @Override
    @Transactional
    public TouristConsult update(Long id, TouristConsultDto data) {
        TouristConsult entity = touristConsultRepository.getOne(id);
        touristConsultConverter.copyProperties(entity, data);
        // 图片
        if (CollectionUtils.isNotEmpty(data.getImgs())) {
            List<FileInfo> fileInfos = data.getImgs().stream().map(FileInfoDto::getId).map(fileInfoRepository::getOne)
                    .collect(Collectors.toList());
            entity.setImgs(fileInfos);
        }
        return entity;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        touristConsultRepository.deleteById(id);
    }

    @Override
    public Page<TouristConsult> find(TouristConsultDto condition, String regionCode, Pageable pageable) {
        BooleanBuilder builder = new BooleanBuilder();

        // 这段代码过滤可见区域
        if (StringUtils.isNotEmpty(regionCode)) {
            builder.and(qTouristConsult.regionCode.startsWith(StringUtils.stripEnd(regionCode, "0")));
        }
        String fullName = condition.getDescription();
        String type = condition.getType();
        if (!ObjectUtils.isEmpty(type)) {
            builder.and(qTouristConsult.type.eq(type));
        }
        if (StringUtils.isNotBlank(fullName)) {
            builder.and(qTouristConsult.titile.containsIgnoreCase(fullName))
                    .or(qTouristConsult.description.containsIgnoreCase(fullName))
                    .or(qTouristConsult.type.containsIgnoreCase(fullName))
                    .or(qTouristConsult.creatUser.containsIgnoreCase(fullName))
                    .or(qTouristConsult.source.containsIgnoreCase(fullName));
        }
        // 这段代码过滤查询区域
        String areas = condition.getRegionCode();
        if (StringUtils.isNotEmpty(areas)) {
            builder.and(qTouristConsult.regionCode.startsWith(StringUtils.stripEnd(areas, "0")));
        }
        return touristConsultRepository.findAll(builder, pageable);
    }
}
