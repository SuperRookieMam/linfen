package com.dm.data.show.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.dm.data.show.entity.DayTourist;

public interface DayTouristRepository extends JpaRepository<DayTourist, Long>, QuerydslPredicateExecutor<DayTourist> {

}
