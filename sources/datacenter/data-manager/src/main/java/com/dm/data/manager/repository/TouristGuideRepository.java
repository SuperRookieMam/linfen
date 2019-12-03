package com.dm.data.manager.repository;

import com.dm.data.manager.entity.TouristGuide;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface TouristGuideRepository
        extends JpaRepository<TouristGuide, Long>, QuerydslPredicateExecutor<TouristGuide> {

}
