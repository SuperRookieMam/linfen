package com.dm.linfen.emergency.repository;

import com.dm.linfen.emergency.entity.Emergency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

/**
 * @author Administrator
 * @Title: EmergencyRepository
 * @ProjectName datacenter
 * @Description: TODO
 * @date 2019/7/26 002609:51
 */
public interface EmergencyRepository extends JpaRepository<Emergency, Long>, QuerydslPredicateExecutor<Emergency> {
}
