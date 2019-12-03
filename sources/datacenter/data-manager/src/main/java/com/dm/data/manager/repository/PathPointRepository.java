package com.dm.data.manager.repository;

import com.dm.data.manager.entity.PathPoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface PathPointRepository extends JpaRepository<PathPoint, Long>, QuerydslPredicateExecutor<PathPoint> {
}
