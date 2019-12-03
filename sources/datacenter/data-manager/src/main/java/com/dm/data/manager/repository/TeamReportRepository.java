package com.dm.data.manager.repository;

import com.dm.data.manager.entity.TeamReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamReportRepository extends JpaRepository<TeamReport, Long>, QuerydslPredicateExecutor<TeamReport> {
    List<TeamReport> findByTeamNameContains(String teamName);
}
