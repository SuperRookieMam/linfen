package com.dm.kpi.core.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.Setter;

import lombok.Getter;

/**
 * 月指标数据抽象类
 * 
 * @author LiDong
 *
 * @param <T>
 */
@Getter
@Setter
@MappedSuperclass
public class AbstractMonthData<T extends Number> extends AbstractIndex<T> {

	/**
	 * 年
	 */
	@Column(name = "year_")
	public Integer year;

	/**
	 * 月
	 */
	@Column(name = "month_")
	public Integer month;
}
