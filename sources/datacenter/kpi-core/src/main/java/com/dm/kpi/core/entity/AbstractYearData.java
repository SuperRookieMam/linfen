package com.dm.kpi.core.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class AbstractYearData<T extends Number> extends AbstractIndex<T> {

	/**
	 * 年
	 */
	@Column(name = "year_")
	private Integer year;
}
