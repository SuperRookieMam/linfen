package com.dm.kpi.repository;

import com.dm.kpi.entity.DayHealthIndex;
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
public interface DayHealthIndexRepository
		extends JpaRepository<DayHealthIndex, Long>, QuerydslPredicateExecutor<DayHealthIndex> {
	/**
	 * 根据时间和区域id查询
	 * 
	 * @param localDate
	 * @param districtId
	 * @return
	 */
	DayHealthIndex findByCurrentDateAndDistrictId(LocalDate currentDate, String districtId);
}
