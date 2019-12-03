package com.dm.data.show.entity;

import javax.persistence.Entity;

import com.dm.kpi.core.entity.AbstractDayData;

import lombok.Getter;
import lombok.Setter;

/**
 * 每日景区人数统计
 * @author Administrator
 *
 */
@Getter
@Setter
@Entity
public class DayScenic extends AbstractDayData<Long> {

	/**
	 * 景区名称
	 */
	private String name;
}
