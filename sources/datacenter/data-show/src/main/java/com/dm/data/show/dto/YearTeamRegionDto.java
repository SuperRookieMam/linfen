package com.dm.data.show.dto;


import com.dm.kpi.core.dto.AbstractYearDataDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 每年团队客源地
 * @author Administrator
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class YearTeamRegionDto extends AbstractYearDataDto<Long> {

	private static final long serialVersionUID = -2927561846115003356L;
	/**
	 * 省份名称
	 */
	private String name;
}
