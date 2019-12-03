package com.dm.data.show.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.dm.data.show.entity.YearTeamStay;

public interface YearTeamStayRepository extends JpaRepository<YearTeamStay, Long>, QuerydslPredicateExecutor<YearTeamStay> {

}
