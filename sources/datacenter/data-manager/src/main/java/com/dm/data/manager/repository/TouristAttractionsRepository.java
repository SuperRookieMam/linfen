package com.dm.data.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dm.data.manager.entity.TouristAttractions;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface TouristAttractionsRepository
        extends JpaRepository<TouristAttractions, Long>, QuerydslPredicateExecutor<TouristAttractions> {

    List<TouristAttractions> findByChineseFullNameContains(String chineseFullName);

}
