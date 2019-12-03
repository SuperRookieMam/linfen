package com.dm.data.manager.repository;

import com.dm.data.manager.entity.EnteringPolice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface EnteringPoliceRepository
        extends JpaRepository<EnteringPolice, Long>, QuerydslPredicateExecutor<EnteringPolice> {
}
