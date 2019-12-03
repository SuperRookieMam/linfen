package com.dm.data.show.entity;

import javax.persistence.Entity;

import com.dm.kpi.core.entity.AbstractDayData;

import lombok.Getter;
import lombok.Setter;

/**
 * 每日酒店分数
 * @author Administrator
 *
 */
@Getter
@Setter
@Entity
public class DayHotelScore extends AbstractDayData<Float> {

	/**
	 * 酒店名称
	 */
	private String name;
}
