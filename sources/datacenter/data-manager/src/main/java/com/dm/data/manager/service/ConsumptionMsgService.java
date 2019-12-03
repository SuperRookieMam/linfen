package com.dm.data.manager.service;

import com.dm.data.manager.dto.ConsumptionMsgDto;
import com.dm.data.manager.entity.ConsumptionMsg;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ConsumptionMsgService extends ApiService<ConsumptionMsg> {
    Optional<ConsumptionMsg> findById(Long id);

    ConsumptionMsg save(ConsumptionMsgDto data);

    ConsumptionMsg update(Long id, ConsumptionMsgDto data);

    void delete(Long id);

    Page<ConsumptionMsg> find(ConsumptionMsgDto condition, String regionCode, Pageable pageable);
}
