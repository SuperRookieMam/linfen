package com.dm.data.show.dto.temporary;

import com.dm.kpi.core.dto.AbstractDayDataDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Copyright (c) 2019 江苏云智网络科技股份有限公司版权所有
 * @author: 李轲
 * @Date: 2019-10-30 15:40:59
 * @Description: 运营商-来源城市
 * @History 
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class OperatorCityDto extends AbstractDayDataDto<Integer> {

	private static final long serialVersionUID = 4778531404394652539L;

	/**
	 * 景区名称
	 */
	private String name;
	
	/**
	 * 城市名称
	 */
	private String cityName;
	
}
