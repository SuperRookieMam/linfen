package com.dm.data.manager.repository;

import com.dm.data.manager.entity.EnteringBusiness;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface EnteringBusinessRepository
        extends JpaRepository<EnteringBusiness, Long>, QuerydslPredicateExecutor<EnteringBusiness> {
}
