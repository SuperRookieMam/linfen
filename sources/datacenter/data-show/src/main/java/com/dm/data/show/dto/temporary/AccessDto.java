package com.dm.data.show.dto.temporary;

import com.dm.kpi.core.dto.AbstractHourDataDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Copyright (c) 2019 江苏云智网络科技股份有限公司版权所有
 * @author: 李轲
 * @Date: 2019-10-30 15:35:28
 * @Description: 门禁
 * @History 
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class AccessDto extends AbstractHourDataDto<Integer> {

	private static final long serialVersionUID = -5518831257603092523L;

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


