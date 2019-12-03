package com.dm.linfen.emergency.repository;

import com.dm.linfen.emergency.entity.Duty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.time.LocalDate;
import java.util.Optional;

/**
 * @author Administrator
 * @Title: DutyRepository
 * @ProjectName datacenter
 * @Description: TODO
 * @date 2019/7/24 002410:41
 */
public interface DutyRepository extends JpaRepository<Duty, Long>, QuerydslPredicateExecutor<Duty> {
	/**
	 * 根据时间查询数据
	 * 
	 * @param creatTime
	 * @return
	 */
	public Optional<Duty> findByCreateTime(LocalDate creatTime);

	/**
	 * 根据时间删除数据
	 * 
	 * @param createTime
	 */
	public void deleteByCreateTime(LocalDate createTime);
}
