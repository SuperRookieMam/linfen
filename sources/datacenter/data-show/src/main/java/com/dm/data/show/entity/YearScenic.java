package com.dm.data.show.entity;

import javax.persistence.Entity;

import com.dm.kpi.core.entity.AbstractYearData;

import lombok.Getter;
import lombok.Setter;

/**
 * 每年景区人数统计
 * @author Administrator
 *
 */
@Getter
@Setter
@Entity
public class YearScenic extends AbstractYearData<Long> {

	/**
	 * 景区名称
	 */
	private String name;
}
