package com.dm.data.show.entity;

import javax.persistence.Entity;

import com.dm.kpi.core.entity.AbstractYearData;

import lombok.Getter;
import lombok.Setter;

/**
 * 每年游客交通工具
 * @author Administrator
 *
 */
@Getter
@Setter
@Entity
public class YearTouristTraffic extends AbstractYearData<Long> {

	/**
	 * 交通工具名称
	 */
	private String name;
}
