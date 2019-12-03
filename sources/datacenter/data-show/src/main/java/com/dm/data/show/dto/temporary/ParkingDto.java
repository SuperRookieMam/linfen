package com.dm.data.show.dto.temporary;

import com.dm.kpi.core.dto.AbstractHourDataDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Copyright (c) 2019 江苏云智网络科技股份有限公司版权所有
 * @author: 李轲
 * @Date: 2019-10-30 15:37:41
 * @Description: 停车场
 * @History 
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ParkingDto extends AbstractHourDataDto<Integer> {

	private static final long serialVersionUID = -6549489279669362880L;

	/**
	 * 停车场名称
	 */
	private String name;
	
	/**
	 * 景区名称
	 */
	private String scenicName;
	
	/**
	 * 类型
	 */
	private String type;
	
	/**
	 * 今日累计
	 */
	private Integer dayValue;
}


