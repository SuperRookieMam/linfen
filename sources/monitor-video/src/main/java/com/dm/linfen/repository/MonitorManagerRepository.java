package com.dm.linfen.repository;

import com.dm.linfen.entity.MonitorManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MonitorManagerRepository
		extends JpaRepository<MonitorManager, Long>, QuerydslPredicateExecutor<MonitorManager> {
	MonitorManager findByRoomNumber (String roomNumber );

	List<MonitorManager> findByRun (Boolean run);

	Page<MonitorManager> findTop10ByRoomNumberLikeOrMonitorNameLike (String name, String name1,Pageable pageable);
}
