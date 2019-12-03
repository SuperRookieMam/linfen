package com.dm.data.manager.repository;

import com.dm.data.manager.entity.TourismMonitoringCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface TourismMonitoringCenterRepository
        extends JpaRepository<TourismMonitoringCenter, Long>, QuerydslPredicateExecutor<TourismMonitoringCenter> {

}
