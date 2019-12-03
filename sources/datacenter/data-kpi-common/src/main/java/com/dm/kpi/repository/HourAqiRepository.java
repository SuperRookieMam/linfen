package com.dm.kpi.repository;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

import com.dm.kpi.entity.HourWeather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.dm.kpi.entity.HourAqi;

public interface HourAqiRepository extends JpaRepository<HourAqi, Long>, QuerydslPredicateExecutor<HourAqi> {

	public Optional<HourAqi> findByRegionCodeAndPointNameAndCurrentDate(String regionCode, String pointName,
			ZonedDateTime currentDate);

	/**
	 * 根据区域id和时间查询
	 * @param districtId
	 * @param currentDate
	 * @return
	 */
	public List<HourAqi> findByDistrictIdAndCurrentDate(String districtId,
															ZonedDateTime currentDate);
}
