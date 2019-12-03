package com.dm.data.manager.repository;

import com.dm.data.manager.entity.TeamMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamMemberRepository extends JpaRepository<TeamMember, Long>, QuerydslPredicateExecutor<TeamMember> {
}
