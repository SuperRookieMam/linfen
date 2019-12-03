package com.dm.data.show.entity;

import javax.persistence.Entity;

import com.dm.kpi.core.entity.AbstractYearData;

import lombok.Getter;
import lombok.Setter;

/**
 * 每年旅游产业数量
 * @author Administrator
 *
 */
@Getter
@Setter
@Entity
public class YearIndustry extends AbstractYearData<Long> {

	/**
	 * 产业名称
	 * 吃、住、行、游、购、娱
	 */
	private String name;
}
