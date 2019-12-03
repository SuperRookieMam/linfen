package com.dm.data.show.entity;

import javax.persistence.Entity;

import com.dm.kpi.core.entity.AbstractMonthData;

import lombok.Getter;
import lombok.Setter;

/**
 * 每月景区人数统计
 * @author Administrator
 *
 */
@Getter
@Setter
@Entity
public class MonthScenic extends AbstractMonthData<Long> {

	/**
	 * 景区名称
	 */
	private String name;
}
