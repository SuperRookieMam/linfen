package com.dm.data.show.entity.temporary;

import javax.persistence.Entity;

import com.dm.kpi.core.entity.AbstractDayData;

import lombok.Getter;
import lombok.Setter;

/**
 * Copyright (c) 2019 江苏云智网络科技股份有限公司版权所有
 * @author: 李轲
 * @Date: 2019-10-30 15:48:55
 * @Description: 运营商-年龄
 * @History 
 */
@Getter
@Setter
@Entity
public class OperatorAge extends AbstractDayData<Integer>{

	/**
	 * 景区名称
	 */
	private String name;
	
	/**
	 * 年龄阶段
	 */
	private String type;
}


