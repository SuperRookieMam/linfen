package com.dm.data.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dm.data.manager.entity.Audio;

public interface AudioRepository extends JpaRepository<Audio, Long> {

}
