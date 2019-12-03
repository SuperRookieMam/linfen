package com.dm.data.manager.service;

import com.dm.data.manager.dto.SenicReceptionDto;
import com.dm.data.manager.entity.SenicReception;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface SenicReceptionService extends ApiService<SenicReception> {
    Optional<SenicReception> findById(Long id);

    SenicReception save(SenicReceptionDto data);

    SenicReception update(Long id, SenicReceptionDto data);

    void delete(Long id);

    Page<SenicReception> find(SenicReceptionDto condition, String regionCode, Pageable pageable);

}
