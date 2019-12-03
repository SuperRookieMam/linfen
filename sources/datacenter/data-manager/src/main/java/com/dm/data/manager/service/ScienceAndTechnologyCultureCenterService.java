package com.dm.data.manager.service;

import com.dm.data.manager.dto.ScienceAndTechnologyCultureCenterDto;
import com.dm.data.manager.entity.ScienceAndTechnologyCultureCenter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ScienceAndTechnologyCultureCenterService extends ApiService<ScienceAndTechnologyCultureCenter> {

    public Optional<ScienceAndTechnologyCultureCenter> findById(Long id);

    public ScienceAndTechnologyCultureCenter save(ScienceAndTechnologyCultureCenterDto data);

    public ScienceAndTechnologyCultureCenter update(Long id, ScienceAndTechnologyCultureCenterDto data);

    public void delete(Long id);

    public Page<ScienceAndTechnologyCultureCenter> find(ScienceAndTechnologyCultureCenterDto condition,
            String regionCode, Pageable pageable);
}
