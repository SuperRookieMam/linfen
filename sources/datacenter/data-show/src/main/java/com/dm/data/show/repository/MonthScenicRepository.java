package com.dm.data.show.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.dm.data.show.entity.MonthScenic;

public interface MonthScenicRepository extends JpaRepository<MonthScenic, Long>, QuerydslPredicateExecutor<MonthScenic> {

}
