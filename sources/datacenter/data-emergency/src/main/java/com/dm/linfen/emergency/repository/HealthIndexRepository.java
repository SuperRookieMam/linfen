package com.dm.linfen.emergency.repository;

import com.dm.linfen.emergency.entity.HealthIndex;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.time.LocalDate;

/**
 * @author Administrator
 * @Title: DutyRepository
 * @ProjectName datacenter
 * @Description: TODO
 * @date 2019/7/24 002410:41
 */
public interface HealthIndexRepository
		extends JpaRepository<HealthIndex, Long>, QuerydslPredicateExecutor<HealthIndex> {
	/**
	 * 根据时间和区域id查询
	 * 
	 * @param localDate
	 * @param districtId
	 * @return
	 */
	HealthIndex findByCollectTimeAndDistrictId(LocalDate localDate, String districtId);
}
