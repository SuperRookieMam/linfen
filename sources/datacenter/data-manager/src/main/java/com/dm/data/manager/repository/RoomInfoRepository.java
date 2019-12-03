package com.dm.data.manager.repository;

import com.dm.data.manager.entity.RoomInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface RoomInfoRepository extends JpaRepository<RoomInfo, Long>, QuerydslPredicateExecutor<RoomInfo> {
}
