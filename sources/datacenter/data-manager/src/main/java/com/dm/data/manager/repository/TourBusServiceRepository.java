package com.dm.data.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.dm.data.manager.entity.TourBusService;

public interface TourBusServiceRepository
        extends JpaRepository<TourBusService, Long>, QuerydslPredicateExecutor<TourBusService> {

}
