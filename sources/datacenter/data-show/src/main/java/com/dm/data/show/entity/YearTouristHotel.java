package com.dm.data.show.entity;

import javax.persistence.Entity;

import com.dm.kpi.core.entity.AbstractYearData;

import lombok.Getter;
import lombok.Setter;

/**
 * 每年游客住宿天数
 * @author Administrator
 *
 */
@Getter
@Setter
@Entity
public class YearTouristHotel extends AbstractYearData<Long> {

	/**
	 * 住宿天数类型
	 */
	private String name;
}
