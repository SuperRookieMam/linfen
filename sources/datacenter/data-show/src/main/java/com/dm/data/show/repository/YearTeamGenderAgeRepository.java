package com.dm.data.show.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.dm.data.show.entity.YearTeamGenderAge;

public interface YearTeamGenderAgeRepository extends JpaRepository<YearTeamGenderAge, Long>, QuerydslPredicateExecutor<YearTeamGenderAge> {

}
