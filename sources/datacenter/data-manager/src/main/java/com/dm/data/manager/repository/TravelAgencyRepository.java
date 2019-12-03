package com.dm.data.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dm.data.manager.entity.TravelAgentcy;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface TravelAgencyRepository
        extends JpaRepository<TravelAgentcy, Long>, QuerydslPredicateExecutor<TravelAgentcy> {

}
