package com.dm.data.show.entity;

import javax.persistence.Entity;

import com.dm.kpi.core.entity.AbstractYearData;

import lombok.Getter;
import lombok.Setter;

/**
 * 每年游客停留时长
 * @author Administrator
 *
 */
@Getter
@Setter
@Entity
public class YearTouristStay extends AbstractYearData<Long> {

	/**
	 * 停留类型
	 */
	private String name;
}
