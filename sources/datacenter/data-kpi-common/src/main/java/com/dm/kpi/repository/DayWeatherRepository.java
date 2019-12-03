package com.dm.kpi.repository;

import com.dm.kpi.entity.DayWeather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.time.LocalDate;
import java.util.List;

/**
    * @Author:         温东山
    * @Description:    类作用描述
    * @CreateDate:     2019/9/5 0005 15:09
    * @UpdateUser:     温东山
    * @UpdateDate:     2019/9/5 0005 15:09
    * @history:   修改记录
    * @Version:        1.0
*/
public interface DayWeatherRepository
		extends JpaRepository<DayWeather, Long>, QuerydslPredicateExecutor<DayWeather> {

	/**
	 * 根据采集时间,未来时间,区域id查询
	 * @param localDate
	 * @param FutureDate
	 * @param districtId
	 * @return
	 */
	void deleteByDistrictIdAndCurrentDate(String districtId, LocalDate date);
	
	List<DayWeather> findByDistrictIdAndCurrentDate(String districtId,LocalDate localDate);
	
}
