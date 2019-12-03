package com.dm.data.manager.service;

import com.dm.data.manager.dto.TouristToiletDto;
import com.dm.data.manager.entity.TouristToilet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface TouristToiletService extends ApiService<TouristToilet> {

    public Optional<TouristToilet> findById(Long id);

    public TouristToilet save(TouristToiletDto data);

    public TouristToilet update(Long id, TouristToiletDto data);

    public void delete(Long id);

    public Page<TouristToilet> find(Pageable pageable);

    public Page<TouristToilet> find(TouristToiletDto condition, String regionCode, Pageable pageable);
}
