package com.dm.data.manager.repository;

import com.dm.data.manager.entity.TouristConsult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface TouristConsultRepository
        extends JpaRepository<TouristConsult, Long>, QuerydslPredicateExecutor<TouristConsult> {
}
