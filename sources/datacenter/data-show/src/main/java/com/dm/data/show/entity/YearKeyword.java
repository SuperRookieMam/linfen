package com.dm.data.show.entity;

import javax.persistence.Entity;

import com.dm.kpi.core.entity.AbstractYearData;

import lombok.Getter;
import lombok.Setter;


/**
 * 每年关键词
 * @author Administrator
 *
 */
@Getter
@Setter
@Entity
public class YearKeyword extends AbstractYearData<Long> {

	/**
	 * 关键词
	 */
	private String name;
	
	/**
	 * 是否负面词汇
	 */
	private Boolean isBad;
}
