package com.dm.linfen.emergency.repository.impl;

import com.dm.linfen.emergency.entity.QDuty;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

/**
 * @Description: 实现类
 * @Author: 温东山
 * @CreateDate: 2019/8/6 0006 09:56
 * @UpdateUser: 温东山
 * @UpdateDate: 2019/8/6 0006 09:56
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class DutyRepositoryImpl {
	@Autowired
	private JPAQueryFactory f;

	private final QDuty qDuty = QDuty.duty;

	public void deleteByCreateTime(LocalDate createTime) {
		f.delete(qDuty).where(qDuty.createTime.eq(createTime)).execute();
	}
}
