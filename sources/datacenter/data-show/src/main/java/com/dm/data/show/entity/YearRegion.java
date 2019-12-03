package com.dm.data.show.entity;

import javax.persistence.Entity;

import com.dm.kpi.core.entity.AbstractYearData;

import lombok.Getter;
import lombok.Setter;

/**
 * 每年各省旅游人数
 * @author Administrator
 *
 */
@Getter
@Setter
@Entity
public class YearRegion extends AbstractYearData<Long> {

	/**
	 * 省份名称
	 */
	private String name;
}
