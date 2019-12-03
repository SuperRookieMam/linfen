package com.dm.data.manager.repository;

import com.dm.data.manager.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface ImageRepository extends JpaRepository<Image, Long>, QuerydslPredicateExecutor<Image> {

}
