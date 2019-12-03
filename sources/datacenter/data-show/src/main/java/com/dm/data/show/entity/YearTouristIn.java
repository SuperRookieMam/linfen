package com.dm.data.show.entity;

import javax.persistence.Entity;

import com.dm.kpi.core.entity.AbstractYearData;

import lombok.Getter;
import lombok.Setter;

/**
 * 每年国外游客人数
 * @author Administrator
 *
 */
@Getter
@Setter
@Entity
public class YearTouristIn extends AbstractYearData<Long> {

	/**
	 * 国家名称
	 */
	private String name;
}
