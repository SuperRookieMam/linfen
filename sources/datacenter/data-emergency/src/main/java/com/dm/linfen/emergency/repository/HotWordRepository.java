package com.dm.linfen.emergency.repository;

import com.dm.linfen.emergency.entity.HotWord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

/**
 * @author 温东山
 * @create 2019-07-22 17:17
 **/
public interface HotWordRepository extends JpaRepository<HotWord, Long>, QuerydslPredicateExecutor<HotWord> {
}
