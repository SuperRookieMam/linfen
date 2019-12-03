package com.dm.data.show.entity;

import javax.persistence.Entity;

import com.dm.kpi.core.entity.AbstractYearData;

import lombok.Getter;
import lombok.Setter;

/**
 * 每年各市旅游人数
 * @author Administrator
 *
 */
@Getter
@Setter
@Entity
public class YearCity extends AbstractYearData<Long> {

	/**
	 * 城市名称
	 */
	private String name;
}
