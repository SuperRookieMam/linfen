package com.dm.data.manager.repository;

import com.dm.data.manager.entity.ConsumptionMsg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface ConsumptionMsgRepository
        extends JpaRepository<ConsumptionMsg, Long>, QuerydslPredicateExecutor<ConsumptionMsg> {
}
