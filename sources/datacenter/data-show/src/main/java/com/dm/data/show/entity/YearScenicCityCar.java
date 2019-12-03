package com.dm.data.show.entity;

import javax.persistence.Entity;

import com.dm.kpi.core.entity.AbstractYearData;

import lombok.Getter;
import lombok.Setter;

/**
 * 每年景区车辆来源
 * @author Administrator
 *
 */
@Getter
@Setter
@Entity
public class YearScenicCityCar extends AbstractYearData<Long> {
	
	/**
	 * 景区名称
	 */
	private String name;

	/**
	 * 城市名称
	 */
	private String cityName;
}
