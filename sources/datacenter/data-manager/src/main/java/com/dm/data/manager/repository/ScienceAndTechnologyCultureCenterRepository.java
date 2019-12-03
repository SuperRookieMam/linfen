package com.dm.data.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dm.data.manager.entity.ScienceAndTechnologyCultureCenter;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface ScienceAndTechnologyCultureCenterRepository
        extends JpaRepository<ScienceAndTechnologyCultureCenter, Long>,
        QuerydslPredicateExecutor<ScienceAndTechnologyCultureCenter> {

}
