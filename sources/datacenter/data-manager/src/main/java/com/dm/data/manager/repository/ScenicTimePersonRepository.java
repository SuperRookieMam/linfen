package com.dm.data.manager.repository;

import com.dm.data.manager.entity.ScenicTimePerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface ScenicTimePersonRepository
        extends JpaRepository<ScenicTimePerson, Long>, QuerydslPredicateExecutor<ScenicTimePerson> {
}
