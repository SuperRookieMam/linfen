package com.dm.kpi.repository.impl;

import com.dm.kpi.entity.HourAqi;
import com.dm.kpi.entity.HourWeather;
import com.dm.kpi.entity.QHourAqi;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.ZonedDateTime;
import java.util.List;

/**
 * @Author: 温东山
 * @Description: 类作用描述
 * @CreateDate: 2019/9/6 0006$ 10:06$
 * @UpdateUser: 温东山
 * @UpdateDate: 2019/9/6 0006$ 10:06$
 * @history: 修改记录
 * @Version: 1.0
 */
public class HourAqiRepositoryImpl {
    @Autowired
    private JPAQueryFactory f;

    private final QHourAqi QHOURAQI = QHourAqi.hourAqi;

    public List<HourAqi> findByDistrictIdAndCurrentDate(String districtId,
                                                        ZonedDateTime currentDate) {
        return f.select(QHOURAQI).from(QHOURAQI).where(QHOURAQI.value.isNotNull().and(QHOURAQI.currentDate.goe(currentDate)).and(QHOURAQI.districtId.eq(districtId))).orderBy(QHOURAQI.currentDate.desc()).fetch();
    }
}
