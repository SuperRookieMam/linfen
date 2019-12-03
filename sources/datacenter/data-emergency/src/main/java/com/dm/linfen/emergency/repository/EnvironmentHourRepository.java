package com.dm.linfen.emergency.repository;

import com.dm.linfen.emergency.entity.EnvironmentHour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

/**
 * @author Administrator
 * @Title: DutyRepository
 * @ProjectName datacenter
 * @Description: TODO
 * @date 2019/7/24 002410:41
 */
public interface EnvironmentHourRepository
		extends JpaRepository<EnvironmentHour, Long>, QuerydslPredicateExecutor<EnvironmentHour> {
	/**
	 * 根据时间和区域id
	 * 
	 * @param date
	 * @param districtId
	 * @return
	 */
	EnvironmentHour findByDateAndDistrictId(String date, String districtId);

	/**
	 * 根据区域id和时间范围返回数据
	 * 
	 * @param date
	 * @param districtId
	 * @return
	 */
	List<EnvironmentHour> findByDistrictIdAndGoeDate(String date, String districtId);

}
