package com.dm.data.show.dto;


import com.dm.kpi.core.dto.AbstractYearDataDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 每年景区车辆来源
 * @author Administrator
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class YearScenicCityCarDto extends AbstractYearDataDto<Long> {
	
	private static final long serialVersionUID = 4237515788369179404L;

	/**
	 * 景区名称
	 */
	private String name;

	/**
	 * 城市名称
	 */
	private String cityName;
}
