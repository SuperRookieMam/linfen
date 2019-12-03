package com.dm.kpi.core.entity;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

/**
 * 小时数据抽象类
 * 
 * @author LiDong
 *
 * @param <V>
 */
@MappedSuperclass
@Getter
@Setter
public class AbstractHourData<V extends Number> extends AbstractIndex<V> {

	/**
	 * 数据时间
	 */
	@Column(name = "current_date_")
	private ZonedDateTime currentDate;
}
