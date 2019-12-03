package com.dm.data.manager.repository;

import com.dm.data.manager.entity.Tickets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface TicketsRepository extends JpaRepository<Tickets, Long>, QuerydslPredicateExecutor<Tickets> {
}
