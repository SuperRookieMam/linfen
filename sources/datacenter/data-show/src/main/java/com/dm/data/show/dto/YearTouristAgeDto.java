package com.dm.data.show.dto;


import com.dm.kpi.core.dto.AbstractYearDataDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 每年游客年龄
 * @author Administrator
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class YearTouristAgeDto extends AbstractYearDataDto<Long> {

	private static final long serialVersionUID = 963879401274436064L;
	/**
	 * 年龄段名称
	 */
	private String name;
}
