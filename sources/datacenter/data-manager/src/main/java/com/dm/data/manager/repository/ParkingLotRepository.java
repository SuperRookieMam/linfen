package com.dm.data.manager.repository;

import com.dm.data.manager.entity.ParkingLot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface ParkingLotRepository extends JpaRepository<ParkingLot, Long>, QuerydslPredicateExecutor<ParkingLot> {

}
