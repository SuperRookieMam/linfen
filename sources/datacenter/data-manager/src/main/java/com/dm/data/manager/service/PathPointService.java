package com.dm.data.manager.service;

import com.dm.data.manager.dto.PathPointDto;
import com.dm.data.manager.entity.PathPoint;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface PathPointService extends ApiService<PathPoint> {

    Optional<PathPoint> findById(Long id);

    PathPoint save(PathPointDto data);

    PathPoint update(Long id, PathPointDto data);

    void delete(Long id);

    Page<PathPoint> find(PathPointDto condition, String regionCode, Pageable pageable);
}
