package com.dm.data.manager.service;

import com.dm.data.manager.dto.CulturalRelicRentDto;
import com.dm.data.manager.entity.CulturalRelicRent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * 文物租赁service
 * 
 * @author yinjie
 * @date 2019年8月2日14:01:53
 */
public interface CulturalRelicRentService {
    CulturalRelicRent save(CulturalRelicRentDto dto);

    void delete(Long id);

    CulturalRelicRent findById(Long id);

    CulturalRelicRent update(Long id, CulturalRelicRentDto dto);

    Page<CulturalRelicRent> find(Pageable pageable, String search, String status);

    Integer findCountByRentStatus(Boolean status);
}
