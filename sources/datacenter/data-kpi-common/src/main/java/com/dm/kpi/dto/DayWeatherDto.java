package com.dm.kpi.dto;

import java.time.LocalDate;

import com.dm.kpi.core.dto.AbstractDayDataDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Copyright (c) 2019 江苏云智网络科技股份有限公司版权所有
 * @author: 李轲
 * @Date: 2019-09-05 17:36:34
 * @Description: 
 * @History 
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DayWeatherDto extends AbstractDayDataDto<Integer>{
	
	private static final long serialVersionUID = 3491662702662459359L;

	/**
	 * 地区id
	 */
	private String districtId;

	/**
	 * 未来时间
	 */
	private LocalDate futureDate;

	/**
	 * 多云转小雨
	 */
	private String weather;

	/**
	 * 气温高
	 */
	private String tempMax;

	/**
	 * 气温低
	 */
	private String tempMin;
	/**
	 * 白天风向
	 */
	private String dayWindDirection;

	/**
	 * 晚间风向
	 */
	private String nightWindDirection;

	/**
	 * 风力
	 */
	private String windScale;
	
	
}


