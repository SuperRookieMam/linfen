package com.dm.data.manager.service;

import com.dm.data.manager.dto.DiningPlaceDto;
import com.dm.data.manager.entity.DiningPlace;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface DiningPlaceService extends ApiService<DiningPlace> {

    public Optional<DiningPlace> findById(Long id);

    public DiningPlace save(DiningPlaceDto data);

    public DiningPlace update(Long id, DiningPlaceDto data);

    public void delete(Long id);

    public Page<DiningPlace> find(DiningPlaceDto condition, String regionCode, Pageable pageable);

    List<DiningPlace> findBySearch(String search);
}
