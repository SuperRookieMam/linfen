package com.dm.data.manager.repository;

import com.dm.data.manager.entity.Whether;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface WhetherRepository extends JpaRepository<Whether, Long>, QuerydslPredicateExecutor<Whether> {
}
