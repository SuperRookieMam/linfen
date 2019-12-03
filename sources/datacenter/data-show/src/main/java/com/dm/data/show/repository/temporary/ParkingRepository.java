package com.dm.data.show.repository.temporary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.dm.data.show.entity.temporary.Parking;

public interface ParkingRepository extends JpaRepository<Parking, Long>, QuerydslPredicateExecutor<Parking> {

}
