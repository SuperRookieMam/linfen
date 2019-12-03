package com.dm.linfen.root.repository;

import com.dm.linfen.root.entity.RecommendLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface RecommendLineRepository extends JpaRepository<RecommendLine, Long>, QuerydslPredicateExecutor<RecommendLine> {
}
