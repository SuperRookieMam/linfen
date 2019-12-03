package com.dm.data.show.entity;

import javax.persistence.Entity;

import com.dm.kpi.core.entity.AbstractMonthData;

import lombok.Getter;
import lombok.Setter;

/**
 * 每月游客投诉
 * @author Administrator
 *
 */
@Getter
@Setter
@Entity
public class MonthComplaint extends AbstractMonthData<Long> {

	/**
	 * 投诉类型
	 */
	private String name;
}
