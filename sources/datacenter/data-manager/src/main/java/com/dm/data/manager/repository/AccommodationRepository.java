package com.dm.data.manager.repository;

import com.dm.data.manager.entity.Accommodation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface AccommodationRepository
        extends JpaRepository<Accommodation, Long>, QuerydslPredicateExecutor<Accommodation> {

    List<Accommodation> findByChineseFullNameContains(String chineseFullName);

}
