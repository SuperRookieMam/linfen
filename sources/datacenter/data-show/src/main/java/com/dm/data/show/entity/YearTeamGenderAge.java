package com.dm.data.show.entity;

import javax.persistence.Entity;

import com.dm.kpi.core.entity.AbstractYearData;

import lombok.Getter;
import lombok.Setter;

/**
 * 每年团队性别及年龄
 * @author Administrator
 *
 */
@Getter
@Setter
@Entity
public class YearTeamGenderAge extends AbstractYearData<Long> {

	/**
	 * 性别
	 */
	private String gender;
	
	/**
	 * 年龄类别
	 */
	private String age;
}
