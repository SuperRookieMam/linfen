package com.dm.data.show.dto.temporary;

import com.dm.kpi.core.dto.AbstractDayDataDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Copyright (c) 2019 江苏云智网络科技股份有限公司版权所有
 * @author: 李轲
 * @Date: 2019-10-30 15:48:55
 * @Description: 运营商-年龄
 * @History 
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class OperatorAgeDto extends AbstractDayDataDto<Integer>{

	private static final long serialVersionUID = -2789320640313518589L;

	/**
	 * 景区名称
	 */
	private String name;
	
	/**
	 * 年龄阶段
	 */
	private String type;
}


