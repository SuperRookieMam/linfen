package com.dm.data.manager.service;

import com.dm.data.manager.dto.TravelAgencyDto;
import com.dm.data.manager.entity.TravelAgentcy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface TravelAgencyService extends ApiService<TravelAgentcy> {

    public Optional<TravelAgentcy> findById(Long id);

    public TravelAgentcy save(TravelAgencyDto data);

    public TravelAgentcy update(Long id, TravelAgencyDto data);

    public void delete(Long id);

    public Page<TravelAgentcy> find(TravelAgencyDto condition, String regionCode, Pageable pageable);
}
