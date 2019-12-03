package com.dm.data.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dm.data.manager.entity.ShoppingPlace;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface ShoppingPlaceRepository
        extends JpaRepository<ShoppingPlace, Long>, QuerydslPredicateExecutor<ShoppingPlace> {

}
