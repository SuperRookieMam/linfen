package com.dm.data.manager.repository;

import com.dm.data.manager.entity.ParkingTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface ParkingTimeRepository
        extends JpaRepository<ParkingTime, Long>, QuerydslPredicateExecutor<ParkingTime> {
}
