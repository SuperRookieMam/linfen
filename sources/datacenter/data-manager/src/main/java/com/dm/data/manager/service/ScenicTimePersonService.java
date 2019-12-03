package com.dm.data.manager.service;

import com.dm.data.manager.dto.ScenicTimePersonDto;
import com.dm.data.manager.entity.ScenicTimePerson;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ScenicTimePersonService extends ApiService<ScenicTimePerson> {
    Optional<ScenicTimePerson> findById(Long id);

    ScenicTimePerson save(ScenicTimePersonDto data);

    ScenicTimePerson update(Long id, ScenicTimePersonDto data);

    void delete(Long id);

    Page<ScenicTimePerson> find(ScenicTimePersonDto condition, String regionCode, Pageable pageable);

}
