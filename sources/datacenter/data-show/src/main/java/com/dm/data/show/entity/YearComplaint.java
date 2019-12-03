package com.dm.data.show.entity;

import javax.persistence.Entity;

import com.dm.kpi.core.entity.AbstractYearData;

import lombok.Getter;
import lombok.Setter;

/**
 * 每年游客投诉
 * @author Administrator
 *
 */
@Getter
@Setter
@Entity
public class YearComplaint extends AbstractYearData<Long> {

	/**
	 * 投诉类型
	 */
	private String name;
}
