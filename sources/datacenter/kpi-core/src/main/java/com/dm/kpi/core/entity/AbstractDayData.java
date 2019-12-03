package com.dm.kpi.core.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

/**
 * 日指标数据抽象类
 * 
 * @author LiDong
 *
 * @param <V>
 */
@MappedSuperclass
@Getter
@Setter
public abstract class AbstractDayData<V extends Number> extends AbstractIndex<V> {

	/**
	 * 数据日期
	 */

	@Column(name = "current_date_")
	private LocalDate currentDate;

}
