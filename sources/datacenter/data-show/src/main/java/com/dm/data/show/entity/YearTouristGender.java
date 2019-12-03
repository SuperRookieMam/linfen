package com.dm.data.show.entity;

import javax.persistence.Entity;

import com.dm.kpi.core.entity.AbstractYearData;

import lombok.Getter;
import lombok.Setter;

/**
 * 每年游客性别
 * @author Administrator
 *
 */
@Getter
@Setter
@Entity
public class YearTouristGender extends AbstractYearData<Long> {

	/**
	 * 性别名称
	 * 男、女、未知
	 */
	private String name;
}
