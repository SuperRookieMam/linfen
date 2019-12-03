package com.dm.data.manager.repository;

import com.dm.data.manager.entity.ReadNumber;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReadNumberRepository extends JpaRepository<ReadNumber, Long> {
    Optional<ReadNumber> findBySourceId(Long sourceId);
}
