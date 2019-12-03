package com.dm.data.manager.service;

import com.dm.data.manager.dto.AccommodationDto;
import com.dm.data.manager.entity.Accommodation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface AccommodationService extends ApiService<Accommodation> {

    public Optional<Accommodation> findById(Long id);

    public Accommodation save(AccommodationDto data);

    public Accommodation update(Long id, AccommodationDto data);

    public void delete(Long id);

    public Page<Accommodation> find(AccommodationDto condition, String regionCode, Pageable pageable);

    List<Accommodation> findBySearch(String search);
}
