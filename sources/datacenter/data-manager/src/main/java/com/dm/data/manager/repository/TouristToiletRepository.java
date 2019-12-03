package com.dm.data.manager.repository;

import com.dm.data.manager.entity.TouristToilet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface TouristToiletRepository
        extends JpaRepository<TouristToilet, Long>, QuerydslPredicateExecutor<TouristToilet> {

}
