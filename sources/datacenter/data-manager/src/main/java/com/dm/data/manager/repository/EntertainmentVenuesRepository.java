package com.dm.data.manager.repository;

import com.dm.data.manager.entity.EntertainmentVenues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface EntertainmentVenuesRepository extends JpaRepository<EntertainmentVenues, Long>, QuerydslPredicateExecutor<EntertainmentVenues> {

}
