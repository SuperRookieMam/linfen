package com.dm.linfen.emergency.repository;

import com.dm.linfen.emergency.entity.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

/**
 * @author 温东山
 * @create 2019-07-25 15:31
 **/
public interface PlanRepository extends JpaRepository<Plan, Long>, QuerydslPredicateExecutor<Plan> {
}
