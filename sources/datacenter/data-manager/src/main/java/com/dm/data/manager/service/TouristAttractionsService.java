package com.dm.data.manager.service;

import com.dm.data.manager.dto.TouristAttractionsDto;
import com.dm.data.manager.entity.TouristAttractions;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface TouristAttractionsService extends ApiService<TouristAttractions> {

    public Optional<TouristAttractions> findById(Long id);

    public TouristAttractions save(TouristAttractionsDto data);

    public TouristAttractions update(Long id, TouristAttractionsDto data);

    public void delete(Long id);

    public Page<TouristAttractions> find(TouristAttractionsDto condition, String regionCode, Pageable pageable);

    List<TouristAttractions> findBySearch(String search);
}
