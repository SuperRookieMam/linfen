package com.dm.data.show.dto;


import com.dm.kpi.core.dto.AbstractYearDataDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 每年各市旅游人数
 * @author Administrator
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class YearCityDto extends AbstractYearDataDto<Long> {

	private static final long serialVersionUID = 5800448138993285369L;
	/**
	 * 城市名称
	 */
	private String name;
}
