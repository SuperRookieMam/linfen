package com.dm.data.show.dto;


import com.dm.kpi.core.dto.AbstractMonthDataDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 每月团散客走势
 * @author Administrator
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class MonthTouristTeamSingleDto extends AbstractMonthDataDto<Long> {

	private static final long serialVersionUID = -1293091376878448778L;
	/**
	 * 团队、散客
	 */
	private String name;
}
