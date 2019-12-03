package com.dm.data.app.repository;

import com.dm.data.app.entity.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long>, QuerydslPredicateExecutor<Trip> {
}
