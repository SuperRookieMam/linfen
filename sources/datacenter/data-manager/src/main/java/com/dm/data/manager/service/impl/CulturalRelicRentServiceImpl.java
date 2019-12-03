package com.dm.data.manager.service.impl;

import com.dm.data.manager.converter.CulturalRelicRentConverter;
import com.dm.data.manager.dto.CulturalRelicRentDto;
import com.dm.data.manager.entity.CulturalRelicRent;
import com.dm.data.manager.entity.QCulturalRelicRent;
import com.dm.data.manager.repository.CulturalRelicRentRepository;
import com.dm.data.manager.service.CulturalRelicRentService;
import com.dm.file.converter.FileInfoConverter;
import com.dm.file.dto.FileInfoDto;
import com.dm.file.entity.FileInfo;
import com.dm.file.repository.FileInfoRepository;
import com.querydsl.core.BooleanBuilder;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @文化租赁实现
 * @author yinjie
 * @date 2019年8月2日14:15:00
 */
@Service
public class CulturalRelicRentServiceImpl extends AbstractCurrencyServiceImpl<CulturalRelicRent>
        implements CulturalRelicRentService {
    @Autowired
    private CulturalRelicRentRepository culturalRelicRentRepository;
    @Autowired
    private CulturalRelicRentConverter culturalRelicRentConverter;
    @Autowired
    private FileInfoConverter fileInfoConverter;
    @Autowired
    private FileInfoRepository fileInfoRepository;

    private final QCulturalRelicRent qCulturalRelicRent = QCulturalRelicRent.culturalRelicRent;

    @Override
    @Transactional
    public CulturalRelicRent save(CulturalRelicRentDto dto) {
        CulturalRelicRent culturalRelicRent = new CulturalRelicRent();
        culturalRelicRent = culturalRelicRentConverter.copyProperties(culturalRelicRent, dto);
        // 图片
        if (CollectionUtils.isNotEmpty(dto.getImgs())) {
            List<FileInfo> fileInfos = dto.getImgs().stream().map(FileInfoDto::getId).map(fileInfoRepository::getOne)
                    .collect(Collectors.toList());
            culturalRelicRent.setImgs(fileInfos);
        }

        return culturalRelicRentRepository.save(culturalRelicRent);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        culturalRelicRentRepository.deleteById(id);
    }

    @Override
    public CulturalRelicRent findById(Long id) {
        Optional<CulturalRelicRent> culturalRelicRent = culturalRelicRentRepository.findById(id);
        if (culturalRelicRent.isPresent()) {
            return culturalRelicRent.get();
        } else {
            return null;
        }
    }

    @Override
    @Transactional
    public CulturalRelicRent update(Long id, CulturalRelicRentDto dto) {
        Optional<CulturalRelicRent> culturalRelicRentOp = culturalRelicRentRepository.findById(id);
        if (culturalRelicRentOp.isPresent()) {
            CulturalRelicRent culturalRelicRent = culturalRelicRentOp.get();
            culturalRelicRent = culturalRelicRentConverter.copyProperties(culturalRelicRent, dto);
            // 图片
            if (CollectionUtils.isNotEmpty(dto.getImgs())) {
                List<FileInfo> fileInfos = dto.getImgs().stream().map(FileInfoDto::getId)
                        .map(fileInfoRepository::getOne).collect(Collectors.toList());
                culturalRelicRent.setImgs(fileInfos);
            }
            return culturalRelicRentRepository.saveAndFlush(culturalRelicRent);
        } else {
            throw new IllegalArgumentException("无此id对应对象");
        }
    }

    @Override
    public Page<CulturalRelicRent> find(Pageable pageable, String search, String status) {
        BooleanBuilder builder = new BooleanBuilder();
        if (!Objects.isNull(search)) {
            builder.and(qCulturalRelicRent.name.containsIgnoreCase(search)
                    .or(qCulturalRelicRent.lendingUnit.containsIgnoreCase(search))
                    .or(qCulturalRelicRent.rentalUnit.containsIgnoreCase(search)));
        }
        if (!Objects.isNull(status)) {
            builder.and(qCulturalRelicRent.rentStatus.eq(status));
        }
        return culturalRelicRentRepository.findAll(pageable);
    }

    @Override
    public Integer findCountByRentStatus(Boolean status) {
        return culturalRelicRentRepository.countByRentStatus(status);
    }
}
