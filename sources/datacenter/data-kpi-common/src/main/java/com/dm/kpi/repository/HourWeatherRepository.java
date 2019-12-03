package com.dm.kpi.repository;

import com.dm.kpi.entity.HourWeather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

public interface HourWeatherRepository
        extends JpaRepository<HourWeather, Long>, QuerydslPredicateExecutor<HourWeather> {

    public Optional<HourWeather> findByRegionCodeAndPointNameAndCurrentDate(String regionCode, String pointName,
                                                                            ZonedDateTime currentDate);

    /**
     * 根据区域和时间范围查询,并且去掉value等于null的值
     * @param districtId
     * @param currentDate
     * @return
     */
    public List<HourWeather> findByDistrictIdAndCurrentDate(String districtId,
                                                            ZonedDateTime currentDate);

}
