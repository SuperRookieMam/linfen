package com.dm.data.manager.service;

import com.dm.data.manager.dto.TouristCommodityDto;
import com.dm.data.manager.entity.TouristCommodity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface TouristCommodityService extends ApiService<TouristCommodity> {

    public Optional<TouristCommodity> findById(Long id);

    public TouristCommodity save(TouristCommodityDto data);

    public TouristCommodity update(Long id, TouristCommodityDto data);

    public void delete(Long id);

    public Page<TouristCommodity> find(Pageable pageable);

    public Page<TouristCommodity> find(TouristCommodityDto condition, Pageable pageable);
}
