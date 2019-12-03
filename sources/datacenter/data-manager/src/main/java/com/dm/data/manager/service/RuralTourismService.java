package com.dm.data.manager.service;

import com.dm.data.manager.dto.RuralTourismDto;
import com.dm.data.manager.entity.RuralTourism;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface RuralTourismService extends ApiService<RuralTourism> {

    public Optional<RuralTourism> findById(Long id);

    public RuralTourism save(RuralTourismDto data);

    public RuralTourism update(Long id, RuralTourismDto data);

    public void delete(Long id);

    public Page<RuralTourism> find(RuralTourismDto condition, String regionCode, Pageable pageable);

    List<RuralTourism> findBySearch(String search);
}
