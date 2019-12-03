package com.dm.data.show.entity;

import javax.persistence.Entity;

import com.dm.kpi.core.entity.AbstractDayData;

import lombok.Getter;
import lombok.Setter;

/**
 * Copyright (c) 2019 江苏云智网络科技股份有限公司版权所有
 * @author: 李轲
 * @Date: 2019-09-05 16:17:58
 * @Description: 每日酒店价格
 * @History 
 */
@Getter
@Setter
@Entity
public class DayHotelPrice extends AbstractDayData<Float> {

	
	/**
	 * 酒店名称
	 */
	private String name;
}
