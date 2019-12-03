package com.dm.data.manager.repository;

import com.dm.data.manager.entity.BusDriver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface BusDriverRepository extends JpaRepository<BusDriver, Long>, QuerydslPredicateExecutor<BusDriver> {

}
