package com.dm.data.manager.service;

import com.dm.data.manager.dto.TouristGuideDto;
import com.dm.data.manager.entity.TouristGuide;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface TouristGuideService extends ApiService<TouristGuide> {

    public Optional<TouristGuide> findById(Long id);

    public TouristGuide save(TouristGuideDto data);

    public TouristGuide update(Long id, TouristGuideDto data);

    public void delete(Long id);

    public Page<TouristGuide> find(Pageable pageable);

    public Page<TouristGuide> find(TouristGuideDto condition, String regionCode, Pageable pageable);
}
