package com.dm.data.show.entity;

import javax.persistence.Entity;

import com.dm.kpi.core.entity.AbstractYearData;

import lombok.Getter;
import lombok.Setter;

/**
 * 每年游客浏览景区数量
 * @author Administrator
 *
 */
@Getter
@Setter
@Entity
public class YearTouristScenic extends AbstractYearData<Long> {

	/**
	 * 数量类型
	 * 1个景区、2个景区、3个景区以上
	 */
	private String name;
}
