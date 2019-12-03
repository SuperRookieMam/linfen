package com.dm.data.app.repository;

import com.dm.data.app.entity.TravelBus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface TravelBusRepository extends JpaRepository<TravelBus, Long>, QuerydslPredicateExecutor<TravelBus> {

    Optional<TravelBus> findByTeamIdAndDayTime(Long teamId, LocalDate dayTime);

    List<TravelBus> findByTeamId(Long teamId);
}
