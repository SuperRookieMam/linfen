package com.dm.data.show.entity;

import javax.persistence.Entity;

import com.dm.kpi.core.entity.AbstractMonthData;

import lombok.Getter;
import lombok.Setter;

/**
 * 每月国内/入境游客住宿
 * @author Administrator
 *
 */
@Getter
@Setter
@Entity
public class MonthTourisHotelLocalIn extends AbstractMonthData<Long> {

	/**
	 * 游客类型
	 * 入境游客、国内游客
	 */
	private String name;
}
