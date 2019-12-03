package com.dm.data.manager.repository;

import com.dm.data.manager.entity.HotelTimePerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface HotelTimePersonRepository
        extends JpaRepository<HotelTimePerson, Long>, QuerydslPredicateExecutor<HotelTimePerson> {
}
