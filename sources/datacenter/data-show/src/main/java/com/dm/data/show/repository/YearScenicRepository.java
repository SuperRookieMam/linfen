package com.dm.data.show.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.dm.data.show.entity.YearScenic;

public interface YearScenicRepository extends JpaRepository<YearScenic, Long>, QuerydslPredicateExecutor<YearScenic> {

}
