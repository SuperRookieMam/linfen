package com.dm.data.manager.repository;

import com.dm.data.manager.entity.TouristRoute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface TouristRouteRepository
        extends JpaRepository<TouristRoute, Long>, QuerydslPredicateExecutor<TouristRoute> {
    @Query(value = "select tt.* from tourist_route_ tt ORDER BY rand() desc LIMIT 3", nativeQuery = true)
    List<TouristRoute> randomThree();

    List<TouristRoute> findByNameContains(String name);

}
