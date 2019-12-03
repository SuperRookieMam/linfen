package com.dm.data.manager.service;

import com.dm.data.manager.dto.TouristRouteDto;
import com.dm.data.manager.entity.TouristRoute;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface TouristRouteService extends ApiService<TouristRoute> {

    public Optional<TouristRoute> findById(Long id);

    public TouristRoute save(TouristRouteDto data);

    public TouristRoute update(Long id, TouristRouteDto data);

    public void delete(Long id);

    public Page<TouristRoute> find(Pageable pageable);

    public Page<TouristRoute> find(TouristRouteDto condition, Pageable pageable);

    List<TouristRoute> randomThree();

    List<TouristRoute> findBySearch(String search);
}
