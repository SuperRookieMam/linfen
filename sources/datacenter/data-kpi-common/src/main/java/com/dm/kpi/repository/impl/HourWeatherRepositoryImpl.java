package com.dm.kpi.repository.impl;

import com.dm.kpi.entity.HourWeather;
import com.dm.kpi.entity.QHourWeather;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.ZonedDateTime;
import java.util.List;

/**
 * @Author: 温东山
 * @Description: 实现类
 * @CreateDate: 2019/9/6 0006 09:06
 * @UpdateUser: 温东山
 * @UpdateDate: 2019/9/6 0006 09:06
 * @history: 修改记录
 * @Version: 1.0
 */
public class HourWeatherRepositoryImpl {

    @Autowired
    private JPAQueryFactory f;

    private final QHourWeather QHOURWEATHER = QHourWeather.hourWeather;

    public List<HourWeather> findByDistrictIdAndCurrentDate(String districtId,
                                                            ZonedDateTime currentDate) {
        return f.select(QHOURWEATHER).from(QHOURWEATHER).where(QHOURWEATHER.value.isNotNull().and(QHOURWEATHER.currentDate.goe(currentDate)).and(QHOURWEATHER.districtId.eq(districtId))).orderBy(QHOURWEATHER.currentDate.desc()).fetch();
    }


}
