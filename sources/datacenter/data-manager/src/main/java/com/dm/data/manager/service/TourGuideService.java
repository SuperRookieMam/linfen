package com.dm.data.manager.service;

import com.dm.data.manager.dto.TourGuideDto;
import com.dm.data.manager.entity.TourGuide;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface TourGuideService extends ApiService<TourGuide> {

    public Optional<TourGuide> findById(Long id);

    public TourGuide save(TourGuideDto data);

    public TourGuide update(Long id, TourGuideDto data);

    public void delete(Long id);

    public Page<TourGuide> find(Pageable pageable);

    public Page<TourGuide> find(TourGuideDto condition, String regionCode, Pageable pageable);
}
