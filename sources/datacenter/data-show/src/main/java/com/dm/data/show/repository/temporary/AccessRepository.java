package com.dm.data.show.repository.temporary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.dm.data.show.entity.temporary.Access;

public interface AccessRepository extends JpaRepository<Access, Long>, QuerydslPredicateExecutor<Access> {

}
