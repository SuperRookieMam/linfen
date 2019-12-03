package com.dm.data.manager.repository;

import com.dm.data.manager.entity.HotelManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface HotelManagerRepository
        extends JpaRepository<HotelManager, Long>, QuerydslPredicateExecutor<HotelManager> {
}
