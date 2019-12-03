package com.dm.data.manager.service;

import com.dm.data.manager.dto.ShoppingPlaceDto;
import com.dm.data.manager.entity.ShoppingPlace;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ShoppingPlaceService extends ApiService<ShoppingPlace> {

    public Optional<ShoppingPlace> findById(Long id);

    public ShoppingPlace save(ShoppingPlaceDto data);

    public ShoppingPlace update(Long id, ShoppingPlaceDto data);

    public void delete(Long id);

    public Page<ShoppingPlace> find(ShoppingPlaceDto condition, String regionCode, Pageable pageable);
}
