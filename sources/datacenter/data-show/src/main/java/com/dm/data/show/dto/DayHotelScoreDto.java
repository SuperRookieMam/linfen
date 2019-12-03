package com.dm.data.show.dto;


import com.dm.kpi.core.dto.AbstractDayDataDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 每日酒店分数
 * @author Administrator
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DayHotelScoreDto extends AbstractDayDataDto<Float> {

	private static final long serialVersionUID = -6864644578720146504L;
	
	/**
	 * 酒店名称
	 */
	private String name;
}
