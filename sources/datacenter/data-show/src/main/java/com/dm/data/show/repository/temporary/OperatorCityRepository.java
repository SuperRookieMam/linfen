package com.dm.data.show.repository.temporary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.dm.data.show.entity.temporary.OperatorCity;

public interface OperatorCityRepository extends JpaRepository<OperatorCity, Long>, QuerydslPredicateExecutor<OperatorCity> {

}
