package com.dm.data.app.service;

import com.dm.data.app.dto.LocalPointDto;
import com.dm.data.app.entity.LocalPoint;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LocalPointService {
    LocalPoint save(LocalPointDto dto);

    LocalPoint update(Long id,LocalPointDto dto);

    LocalPoint findById(Long id);

    void delete(Long id);

    Page<LocalPoint> search(Pageable pageable, String search);
}
