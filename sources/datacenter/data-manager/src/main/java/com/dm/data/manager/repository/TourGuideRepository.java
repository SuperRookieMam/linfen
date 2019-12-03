package com.dm.data.manager.repository;

import com.dm.data.manager.entity.TourGuide;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface TourGuideRepository extends JpaRepository<TourGuide, Long>, QuerydslPredicateExecutor<TourGuide> {

}
