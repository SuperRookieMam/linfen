package com.dm.data.manager.repository;

import com.dm.data.manager.entity.TouristCommodity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface TouristCommodityRepository
        extends JpaRepository<TouristCommodity, Long>, QuerydslPredicateExecutor<TouristCommodity> {

}
