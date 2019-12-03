package com.dm.linfen.emergency.repository;

import com.dm.linfen.emergency.entity.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

/**
 * @author Administrator
 * @Title: DutyRepository
 * @ProjectName datacenter
 * @Description: TODO
 * @date 2019/7/24 002410:41
 */
public interface DistinctRepository extends JpaRepository<District, Long>, QuerydslPredicateExecutor<District> {

}
