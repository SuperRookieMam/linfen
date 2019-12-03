package com.dm.data.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dm.data.manager.entity.RuralTourism;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface RuralTourismRepository
        extends JpaRepository<RuralTourism, Long>, QuerydslPredicateExecutor<RuralTourism> {

    List<RuralTourism> findByChineseFullNameContains(String chineseFullName);

}
