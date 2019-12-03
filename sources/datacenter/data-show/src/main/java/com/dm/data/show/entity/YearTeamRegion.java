package com.dm.data.show.entity;

import javax.persistence.Entity;

import com.dm.kpi.core.entity.AbstractYearData;

import lombok.Getter;
import lombok.Setter;

/**
 * 每年团队客源地
 * @author Administrator
 *
 */
@Getter
@Setter
@Entity
public class YearTeamRegion extends AbstractYearData<Long> {

	/**
	 * 省份名称
	 */
	private String name;
}
