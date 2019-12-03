package com.dm.data.show.entity.temporary;

import javax.persistence.Entity;

import com.dm.kpi.core.entity.AbstractDayData;

import lombok.Getter;
import lombok.Setter;

/**
 * Copyright (c) 2019 江苏云智网络科技股份有限公司版权所有
 * @author: 李轲
 * @Date: 2019-10-30 15:40:59
 * @Description: 运营商-来源省份
 * @History 
 */
@Getter
@Setter
@Entity
public class OperatorRegion extends AbstractDayData<Integer> {

	/**
	 * 景区名称
	 */
	private String name;
	
	/**
	 * 省份名称
	 */
	private String regionName;
	
}
