package com.dm.linfen.emergency.repository;

import com.dm.linfen.emergency.entity.Sentiment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

/**
 * @Description: 舆情操作类 * @Author: 温东山 * @CreateDate: 2019/7/22 0022 15:59
 *               * @UpdateUser: 温东山 * @UpdateDate: 2019/7/22 0022 15:59
 *               * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public interface SentimentRepository extends JpaRepository<Sentiment, Long>, QuerydslPredicateExecutor<Sentiment> {

}
