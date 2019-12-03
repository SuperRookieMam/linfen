package com.dm.data.manager.repository;

import com.dm.data.manager.entity.SenicReception;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface SenicReceptionRepository
        extends JpaRepository<SenicReception, Long>, QuerydslPredicateExecutor<SenicReception> {
}
