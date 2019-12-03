package com.dm.kpi.dto;

import com.dm.kpi.core.dto.AbstractDayDataDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Copyright (c) 2019 江苏云智网络科技股份有限公司版权所有
 * @author: 李轲
 * @Date: 2019-09-09 09:36:13
 * @Description: 
 * @History 
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DayHealthIndexDto extends AbstractDayDataDto<Integer> {
	
	private static final long serialVersionUID = -8828471766887091346L;
	
	private String districtId;
	
	private String info;

}


