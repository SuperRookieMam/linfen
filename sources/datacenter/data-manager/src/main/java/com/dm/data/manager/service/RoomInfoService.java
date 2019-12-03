package com.dm.data.manager.service;

import com.dm.data.manager.dto.RoomInfoDto;
import com.dm.data.manager.entity.RoomInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface RoomInfoService extends ApiService<RoomInfo> {

    Optional<RoomInfo> findById(Long id);

    RoomInfo save(RoomInfoDto data);

    RoomInfo update(Long id, RoomInfoDto data);

    void delete(Long id);

    Page<RoomInfo> find(Pageable pageable);

    Page<RoomInfo> find(RoomInfoDto condition, String regionCode, Pageable pageable);
}
