package com.dm.data.show.dto.temporary;

import com.dm.kpi.core.dto.AbstractDayDataDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Copyright (c) 2019 江苏云智网络科技股份有限公司版权所有
 * @author: 李轲
 * @Date: 2019-10-30 15:51:45
 * @Description: 运营商-性别
 * @History 
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class OperatorGenderDto extends AbstractDayDataDto<Integer> {
	
	private static final long serialVersionUID = -6532828233710416715L;

	/**
	 * 景区名称
	 */
	private String name;
	
	/**
	 * 性别
	 */
	private String type;
}


