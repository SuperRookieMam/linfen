package com.dm.data.show.dto;


import com.dm.kpi.core.dto.AbstractMonthDataDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 每月游客数量
 * @author Administrator
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class MonthTouristDto extends AbstractMonthDataDto<Long> {
	
	private static final long serialVersionUID = 2803055403126974317L;

}
