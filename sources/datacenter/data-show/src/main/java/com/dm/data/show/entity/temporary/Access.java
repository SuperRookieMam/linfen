package com.dm.data.show.entity.temporary;

import javax.persistence.Entity;

import com.dm.kpi.core.entity.AbstractHourData;

import lombok.Getter;
import lombok.Setter;

/**
 * Copyright (c) 2019 江苏云智网络科技股份有限公司版权所有
 * @author: 李轲
 * @Date: 2019-10-30 15:35:28
 * @Description: 门禁
 * @History 
 */
@Getter
@Setter
@Entity
public class Access extends AbstractHourData<Integer> {

	/**
	 * 景区名称
	 */
	private String name;
	
	/**
	 * 类型
	 */
	private String type;
	
	/**
	 * 今日累计
	 */
	private Integer dayValue;
}


