package com.dm.data.manager.repository;

import com.dm.data.manager.entity.CulturalRelicRent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface CulturalRelicRentRepository
        extends JpaRepository<CulturalRelicRent, Long>, QuerydslPredicateExecutor<CulturalRelicRent> {

    Integer countByRentStatus(Boolean rentStatus);
}
