package com.dm.data.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dm.data.manager.entity.DiningPlace;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface DiningPlaceRepository
        extends JpaRepository<DiningPlace, Long>, QuerydslPredicateExecutor<DiningPlace> {
    List<DiningPlace> findByChineseFullNameContains(String chineseFullName);

}
