package com.dm.linfen.emergency.repository.impl;

import com.dm.linfen.emergency.entity.EnvironmentHour;
import com.dm.linfen.emergency.entity.QEnvironmentHour;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Description: 辅助类
 * @Author: 温东山
 * @CreateDate: 2019/7/31 0031 11:08
 * @UpdateUser: 温东山
 * @UpdateDate: 2019/7/31 0031 11:08
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class EnvironmentHourRepositoryImpl {
	@Autowired
	private JPAQueryFactory f;

	private final QEnvironmentHour QENVIRONMENTHOUR = QEnvironmentHour.environmentHour;

	public List<EnvironmentHour> findByDistrictIdAndGoeDate(String date, String districtId) {
		return f.select(QENVIRONMENTHOUR).from(QENVIRONMENTHOUR).where(QENVIRONMENTHOUR.date.goe(date)
				.and(QENVIRONMENTHOUR.districtId.eq(districtId)).and(QENVIRONMENTHOUR.airQuality.isNotEmpty()))
				.orderBy(QENVIRONMENTHOUR.date.desc()).fetch();
	}
}
