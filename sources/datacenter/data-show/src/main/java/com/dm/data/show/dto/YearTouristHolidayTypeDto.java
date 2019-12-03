package com.dm.data.show.dto;


import com.dm.kpi.core.dto.AbstractYearDataDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 每年节假日游客接待人数
 * @author Administrator
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class YearTouristHolidayTypeDto extends AbstractYearDataDto<Long> {

	private static final long serialVersionUID = -7293078577107664040L;
	/**
	 * 节假日名称
	 * 元旦节、春节、清明节、劳动节、端午节、中秋节、国庆节
	 */
	private String name;
}
