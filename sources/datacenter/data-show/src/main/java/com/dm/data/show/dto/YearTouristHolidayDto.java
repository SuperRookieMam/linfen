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
public class YearTouristHolidayDto extends AbstractYearDataDto<Long> {
	
	private static final long serialVersionUID = -8514460002968282878L;

}
