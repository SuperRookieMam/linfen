package com.dm.data.manager.service.impl;

import com.dm.data.manager.converter.PathPointConverter;
import com.dm.data.manager.dto.PathPointDto;
import com.dm.data.manager.entity.PathPoint;
import com.dm.data.manager.entity.QPathPoint;
import com.dm.data.manager.repository.PathPointRepository;
import com.dm.data.manager.service.PathPointService;
import com.querydsl.core.BooleanBuilder;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class PathPointServiceImpl extends AbstractCurrencyServiceImpl<PathPoint> implements PathPointService {
    @Autowired
    private PathPointRepository pathPointRepository;

    @Autowired
    private PathPointConverter pathPointConverter;

    private QPathPoint qPathPoint = QPathPoint.pathPoint;

    @Override
    public Optional<PathPoint> findById(Long id) {
        return pathPointRepository.findById(id);
    }

    @Override
    @Transactional
    public PathPoint save(PathPointDto data) {
        PathPoint entity = new PathPoint();
        pathPointConverter.copyProperties(entity, data);
        return pathPointRepository.save(entity);
    }

    @Override
    @Transactional
    public PathPoint update(Long id, PathPointDto data) {
        PathPoint entity = pathPointRepository.getOne(id);
        pathPointConverter.copyProperties(entity, data);
        return entity;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        pathPointRepository.deleteById(id);
    }

    @Override
    public Page<PathPoint> find(PathPointDto condition, String regionCode, Pageable pageable) {
        BooleanBuilder builder = new BooleanBuilder();
        // 这段代码过滤可见区域
        if (StringUtils.isNotEmpty(regionCode)) {
            builder.and(qPathPoint.regionCode.startsWith(StringUtils.stripEnd(regionCode, "0")));
        }
        String fullName = condition.getName();
        if (StringUtils.isNotBlank(fullName)) {
            builder.and(qPathPoint.name.containsIgnoreCase(fullName));
        }
        // 这段代码过滤查询区域
        String areas = condition.getRegionCode();
        if (StringUtils.isNotEmpty(areas)) {
            builder.and(qPathPoint.regionCode.startsWith(StringUtils.stripEnd(areas, "0")));
        }
        return pathPointRepository.findAll(builder, pageable);
    }

}
