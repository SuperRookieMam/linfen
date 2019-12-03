package com.dm.data.show.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.dm.kpi.core.entity.AbstractYearData;

import lombok.Getter;
import lombok.Setter;

/**
 * 每年节假日游客接待人数
 * @author Administrator
 *
 */
@Getter
@Setter
@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"name_","year_"})})
public class YearTouristHolidayType extends AbstractYearData<Long> {

	/**
	 * 节假日名称
	 * 元旦节、春节、清明节、劳动节、端午节、中秋节、国庆节
	 */
	@Column(name = "name_" , length = 32)
	private String name;
}
